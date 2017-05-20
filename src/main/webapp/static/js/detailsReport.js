/**
 * Created by Lissomsoft on 05/19/17.
 */

app.controller('DetailsReport',function($scope,$http,$window,$timeout){

    $scope.patient_info_id=$window.sessionStorage.patient_info_id;

    $http.get("GetInfoDetails/"+$scope.patient_info_id)
        .then(function(response){
            $scope.details=response.data;
        })


    $http.get("GetPrescription/"+$scope.patient_info_id)
        .then(function(response){
            $scope.selectedmaster=response.data.prescription;
        })
    $scope.back=function(){
        location.href="PatientReport";
    }

});