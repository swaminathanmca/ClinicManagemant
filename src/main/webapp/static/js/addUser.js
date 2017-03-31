/**
 * Created by Admin on 3/7/2017.
 */

app.controller('User',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $scope.chiefError="The Phone No Already Taken";
    $scope.chiefEmail="Taken";
    $scope.selectedList=[];
    var obj;
    $scope.branches=[];
    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;

            $scope.data = response.data;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });

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
        specialization:$scope.specialization
    }



         $http.post('AddDoctor',Doctor).
        then(function (response,status,headers,config){
            location.href="ViewDoctor";
    });




}


})