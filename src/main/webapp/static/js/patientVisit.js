/**
 * Created by Lissomsoft on 05-Apr-17.
 */

app.controller('patientVisit',function($scope,$window,$http){

$scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;


    $http.get("patientDetails/"+$scope.patient_pid).
        then(function(response,status,headers,config){
            $scope.data=response.data;
        });

    $http.get("ViewDoctor/"+ $scope.branch_id +"/"+$scope.clinic_id)
        .then(function (response){
            $scope.doctor = response.data.user;
        })

});