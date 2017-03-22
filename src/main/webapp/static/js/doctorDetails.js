/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('doctorDetails',function($scope,$window,$http){


    $http.get("doctorDetails/"+$window.sessionStorage.profile_id)
        .then(function(response){
            $scope.data=response.data.branch;
            $('#countries1').bfhcountries({country: $scope.data.country})
        })

    $scope.editUser=function(id){
        $scope.profile_id=id;
        $http.get("doctorDetails/"+$scope.profile_id)
            .then(function(response,status){
                $scope.x=response.data.branch;
                $('#countries2').bfhcountries({country: $scope.data.country})

                $http.get("ViewBranch/"+$scope.x.clinic_id)
                        .then(function(response){
                            $scope.branch=response.data.branch;

                        })

            })


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
           doctor_id:$scope.x.doctor_id
       }

        $http.post("EditDoctor",doctor).
            then(function(response,status,header,config){
                $scope.status=response.data;
                location.href="doctorDetail";
            })

    }
})