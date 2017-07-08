/**
 * Created by Admin on 3/7/2017.
 */

app.controller('User',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $scope.chiefError="The Phone No Already Taken";
    $scope.chiefEmail="Taken";
    $scope.selectedList=[];
    $scope.selectedlist=[];
    var obj;
    var spec;
    $scope.branches=[];
    $scope.speciality=[];
    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $window.sessionStorage.branch_name=response.data.branch_name;
            $scope.clinic_name= $scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });
$http.get("GetSpeciality")
    .then(function(response){
        $scope.specialitydetails=response.data.speciality;
    })


    $scope.onLoad = function (e, reader, file, fileList,fileObj ) {

        $scope.user=fileObj.base64;

    };

    $scope.afterSelectItem = function(item){
         obj = {
             branch_id: item.branch_id,
             branch_name:item.branch_name
        };

        $scope.selectedList.push(obj)

    }

    $scope.afterRemoveItem = function(item){
        var index = $scope.selectedList.indexOf(item);
        $scope.selectedList.splice(index,1);

    }

    $scope.afterselectItem = function(item){
        spec = {
            speciallity_id : item.speciallity_id,
            speciality_name: item.speciality_name,
            description:item.description
        };
        $scope.selectedlist.push(spec)

    }

    $scope.afterremoveItem = function(item){
        var index1 = $scope.selectedlist.indexOf(item);
        $scope.selectedlist.splice(index1,1);
    }


    $scope.validatecontact=function(){

        $http.get("validateChief/"+$scope.phone_no).
            then(function (response,status,header,config){
                $scope.err=response.data.status;

                if($scope.err==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }


    $scope.validateEmail=function(){
        $http.get("validateEmail/"+$scope.email_id).
            then(function(response,status,headers,config){
                $scope.err_chief_email=response.data.status;

                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }

            })
    }
    $scope.submit=function(){
if($scope.selectedList==""){
  var obj1={
      branch_id:  $window.sessionStorage.branch_id,
      branch_name: $window.sessionStorage.branch_name
  }
    $scope.selectedList.push(obj1)
}
        var Doctor={
        firstname:$scope.firstname,
        address1:$scope.address1,
        address2:$scope.address2,
        clinic_id:$window.sessionStorage.clinic_id,
        branch:$scope.selectedList,
        city:$scope.city,
        state:$scope.state,
        country:$scope.country,
        pincode:$scope.pincode,
        email_id:$scope.email_id,
        contact_no:$scope.phone_no,
        gender:$scope.gender,
        password:$scope.password,
        reg_no:$scope.reg_no,
        qualification:$scope.qualification,
        specialization:$scope.selectedlist,
        charge:$scope.fees
    }
        $http.post('AddDoctor',Doctor).
        then(function (response,status,headers,config){
            location.href="ViewDoctor";
    });




}

    $scope.cancel=function(){
        location.href="ViewDoctor";
    }

})