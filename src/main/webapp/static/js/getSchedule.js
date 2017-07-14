/**
 * Created by Lissomsoft on 07/08/17.
 */
app.controller('getSchedule',function($scope,$http,$window){
    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;
    $scope.branch_id=$window.sessionStorage.branch_id;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_name= $scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });

$scope.getDoctor=function(id){
    $http.get("ViewDoctorBranch/"+id)
        .then(function(response){
            $scope.profile=response.data.user;
            $scope.schedule="";
        })
}

  $scope.getSchedule=function(id){
    $http.get("GetSchedule/"+id+"/"+$scope.branch_id).then
    (function(response){
        $scope.schedule=response.data.schedule;
    })
}

$scope.edit=function(id){
    $scope.schedule_id=id;
$http.get("GetScheduleById/"+$scope.schedule_id).then
(function(response){
    $scope.scheduledetails=response.data;
})

}




});
