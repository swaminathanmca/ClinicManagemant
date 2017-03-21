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
})