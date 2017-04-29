/**
 * Created by Admin on 4/18/2017.
 */
app.controller('patientComplaint',function($scope,$http,$window){
    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;

    $http.get("GetComplaint")
        .then(function (response) {
            $scope.complaint = response.data.complaint;
        });

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })

    $scope.submit=function(){
        var PatientInfo={
            patient_pid:$scope.patientcomplaint.patient_pid,
            branch_id:$scope.branch_id,
            doctor_id:$scope.doctor_id,
            first_name:$scope.patientcomplaint.first_name,
            last_name:$scope.patientcomplaint.last_name,
            height:$scope.patientcomplaint.height,
            weight:$scope.patientcomplaint.weight,
            pressure:$scope.patientcomplaint.pressure,
            refereal_details:$scope.patientcomplaint.refereal_details,
            complaint_id:$scope.complaint_id,
            procedures:$scope.procedures,
        }

       /* $http.post('patientInfo',PatientInfo)
            .then (function (response,status,headers,config) {
            $scope.result=response.data;

            location.href="AddPrescription";
        });*/
        location.href="AddPrescription";
    }

})