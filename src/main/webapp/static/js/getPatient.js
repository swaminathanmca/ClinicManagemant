/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('getPatient',function($scope,$http,$window){

    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;

    $http.get("ViewPatient/"+$scope.branch_id+"/"+$scope.clinic_id)
        .then(function (response){
            $scope.data = response.data.patient;
        })


    $scope.addPatient=function(){
        location.href="AddPatient";
    }

    $scope.editPatient=function(id){
        $scope.patient_id=id;
        $window.sessionStorage.patient_id=$scope.patient_id;
        location.href="patientDetail";
    }



})