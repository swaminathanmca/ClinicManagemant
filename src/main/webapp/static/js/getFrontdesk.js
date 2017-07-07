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
            $scope.trackdata=response.data;
            $scope.branch_iid=response.data.branch_id;
            $scope.clinic_name= $scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
            var branchInfo = {branch_id: "ALL", branch_name: "All"}
            $scope.branchDetails.push(branchInfo);

        });

    $http.get("ViewFrontdesk/"+$scope.branch_id+"/"+$window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.data = response.data.user;

        })
    $scope.frontDesk=function(id){

        $http.get("ViewFrontdesk/"+id+"/"+$window.sessionStorage.clinic_id)
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