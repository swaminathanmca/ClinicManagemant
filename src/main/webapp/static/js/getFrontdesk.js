/**
 * Created by Lissomsoft on 3/22/2017.
 */


app.controller('getFrontdesk',function($scope,$http,$window){
    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.branch_iid=response.data.branch_id;

        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });

    $http.get("ViewFrontdesk/"+$scope.branch_id)
        .then(function (response){
            $scope.data = response.data.user;

        })
    $scope.frontDesk=function(id){

        $http.get("ViewFrontdesk/"+id)
            .then(function (response){
                $scope.data = response.data.user;

            })
}

    $scope.addFrontDesk=function(){

        location.href="AddFrontDesk";
    }

    $scope.editFrontDesk=function(id){
        $scope.profile_id=id;
        $window.sessionStorage.profile_id=$scope.profile_id;
        location.href="FrontDeskDetail";
    }
})