/**
 * Created by Admin on 4/18/2017.
 */
app.controller('patientComplaint',function($scope,$http,$window){
    $scope.pid=$window.sessionStorage.patient_pid;
    $http.get("GetComplaint")
        .then(function (response) {
            $scope.complaint = response.data.complaint;
            console.log($scope.complaint);

        });

    $http.get("GetComplaint/"+$window.sessionStorage.patient_pid)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })

    $scope.submit=function(){
        var PatientInfo={
            patient_pid:$scope.patientcomplaint.patient_pid,
            first_name:$scope.patientcomplaint.first_name,
            last_name:$scope.patientcomplaint.last_name,
            height:$scope.patientcomplaint.height,
            weight:$scope.patientcomplaint.weight,
            pressure:$scope.patientcomplaint.pressure,
            refereal_details:$scope.patientcomplaint.refereal_details,
            complaint_id:$scope.complaint_id,
            procedures:$scope.procedures
        }
    console.log(PatientInfo);
        $http.post('patientInfo',PatientInfo)
            .then (function (response,status,headers,config) {
            $scope.result=response.data;

        });
    }

})