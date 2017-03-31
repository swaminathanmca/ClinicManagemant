/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('doctorDetails',function($scope,$window,$http){
    $scope.branch_name=[];
    $scope.branchList=[];
    var obj;
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $http.get("doctorDetails/"+$window.sessionStorage.profile_id)
        .then(function(response){
            $scope.data=response.data.branch;
            $('#countries1').bfhcountries({country: $scope.data.country})
            $scope.branches=$scope.data.branches;


        })

    $scope.editUser=function(id){
        $scope.profile_id=id;
        $http.get("doctorDetails/"+$scope.profile_id)
            .then(function(response,status){
                $scope.x=response.data.branch;
                $scope.selectedList=$scope.x.branches;
                var result=$scope.selectedList;

                $('#countries2').bfhcountries({country: $scope.data.country})

                $http.get("ViewBranch/"+$scope.x.clinic_id)
                        .then(function(response){
                        $scope.branch=response.data.branch;
                        /* for(var i=0;i<result.length;i++){
                            var obj={
                                branch_id: result[i].branch_id,
                                branch_name:result[i].branch_name,
                                address1:result[i].address1,
                                address2:result[i].address2,
                                contact_no:result[i].contact_no,
                                description:result[i].description
                            }

                            var index = $scope.selectedList.indexOf(obj);

                            $scope.branch.splice(index,1);
                            console.log("dfsafdsa",$scope.branch);
                        }*/
                    })
            })
    }

    $scope.afterRemoveItem = function(item){
        obj1 = {
            branch_id: item.branch_id,
            branch_name:item.branch_name,
            address1:item.address1,
            address2:item.address2,
            contact_no:item.contact_no,
            description:item.description
        };


    }
    $scope.afterSelectItem = function(item){

        obj2 = {
            branch_id: item.branch_id,
            branch_name:item.branch_name,
            address1:item.address1,
            address2:item.address2,
            contact_no:item.contact_no,
            description:item.description
        };
        if ($scope.selectedList.indexOf(item) == -1) {
            $scope.selectedList.push(obj2);}
    }


    $scope.submit=function(){
        $scope.country=$('#countries2').val();
       var doctor={
           firstname:$scope.x.name,
           gender:$scope.x.gender,
           reg_no:$scope.x.reg_id,
           qualification:$scope.x.qualification,
           specialization:$scope.x.specialization,
           address1:$scope.x.address1,
           address2:$scope.x.address2,
           city:$scope.x.city,
           state:$scope.x.state,
           country:$scope.country,
           pincode:$scope.x.pincode,
           contact_no:$scope.x.phone,
           email_id:$scope.x.email,
           password:$scope.x.password,
           clinic_id:$scope.x.clinic_id,
           profile_id:$scope.x.profile_id,
           branch_id:$scope.x.branch_id,
           branch:$scope.selectedList,
           doctor_id:$scope.x.doctor_id
       }
        $http.post("EditDoctor",doctor).
            then(function(response,status,header,config){
                $scope.status=response.data;
                location.href="doctorDetail";
            })

    }
})