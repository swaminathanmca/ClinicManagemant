/**
 * Created by Lissomsoft on 12-Apr-17.
 */
app.controller('getVisit',function($scope,$http,$window){


    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;
    $scope.doctor_id="ALL"

    $http.get("ViewPatientVisit/"+$scope.branch_id+"/"+$scope.doctor_id)
        .then(function (response){
            $scope.data = response.data.patient;
        })

    $http.get("ViewDoctorBranch/"+$scope.branch_id)
        .then(function (response){
            $scope.doctor = response.data.user;
            var branchInfo = {doctor_id: "ALL", profile_name: "All"}
            $scope.doctor.push(branchInfo);

        })

$scope.visit=function(id){

    $http.get("ViewPatientVisit/"+$scope.branch_id+"/"+id)
        .then(function (response){
            $scope.data = response.data.patient;
        })

}

})