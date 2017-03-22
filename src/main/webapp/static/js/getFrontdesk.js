/**
 * Created by Lissomsoft on 3/22/2017.
 */


app.controller('getFrontdesk',function($scope,$http,$window){
    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;

    $http.get("ViewFrontdesk/"+$scope.branch_id)
        .then(function (response){
            $scope.data = response.data.user;

        })
    $scope.addDoctor=function(){

        location.href="AddFrontDesk";
    }

    $scope.editDoctor=function(id){
        $scope.profile_id=id;
        $window.sessionStorage.profile_id=$scope.profile_id;

    }


})