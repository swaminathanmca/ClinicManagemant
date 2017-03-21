/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('getDoctor',function($scope,$http,$window){
    $scope.branch_id=$window.sessionStorage.branch_id;

    $http.get("ViewDoctor/"+$scope.branch_id)
        .then(function (response){
            $scope.data = response.data.user;

        })
        $scope.addDoctor=function(){

            location.href="AddDoctor";
        }

    $scope.editDoctor=function(id){
        $scope.profile_id=id;
        $window.sessionStorage.profile_id=$scope.profile_id;
        location.href="doctorDetail";
    }


})