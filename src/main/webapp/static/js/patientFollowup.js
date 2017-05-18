/**
 * Created by Lissomsoft on 05/17/17.
 */
app.controller('patientFollowup',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    var obj1;
    var obj2;

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

            $http.get("GetPatientInfo/"+$scope.patientcomplaint.patient_pid+"/"+$scope.doctor_id+"/"+$scope.branch_id)
                .then(function(response){
                    $scope.info=response.data;
                    $scope.selectSpecialization= $scope.info.complaints;

                    $http.get("GetComplaint")
                        .then(function (response) {
                            $scope.complaint = response.data.complaint;
                        });

                })

        })
    $scope.afterRemoveItem = function(item){
        obj1 = {
            complaint_id: item.complaint_id,
            complaint_name:item.complaint_name
        };
    }

    $scope.afterSelectItem = function(item){
        obj2 = {
            complaint_id: item.complaint_id,
            complaint_name:item.complaint_name
        };
        if ($scope.selectSpecialization.indexOf(item) == -1) {
            $scope.selectSpecialization.push(obj2);
        }
    }

$scope.submit=function(){
    var PatientInfo={
        complaint:$scope.selectSpecialization,
        procedures:$scope.info.procedures,
        diagnosis:$scope.info.diagonics,
        patient_info_id:$scope.info.patient_info_id
    }
    $http.post('EditPatientInfo',PatientInfo)
        .then (function (response,status,headers,config) {
        $scope.result=response.data;
        location.href="AddPrescription";
    });

}


});