/**
 * Created by Admin on 4/19/2017.
 */
app.controller('PatientHistory',function($scope,$http,$window){

    $scope.patient_pid=$window.sessionStorage.patient_pid;

    $scope.patientHistory=function(id){
        $scope.patient_pid=id;
        $http.get("patientHistory/"+$scope.patient_pid+"/"+$window.sessionStorage.doctor_id)

            .then(function(response){
                $scope.patienthistory=response.data;
            })
    }

})