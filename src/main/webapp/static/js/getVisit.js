/**
 * Created by Lissomsoft on 12-Apr-17.
 */
app.controller('getVisit',function($scope,$http,$window){


    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;
    $scope.doctor_id="ALL"

    $http.get("trackSessionBranch/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_id=response.data.clinic_id;
            $scope.branch_id=response.data.branch_id;
            $scope.clinic_name=$scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;


        });


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