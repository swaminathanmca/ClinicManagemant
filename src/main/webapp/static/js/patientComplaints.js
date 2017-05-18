/**
 * Created by Admin on 4/18/2017.
 */
app.controller('patientComplaint',function($scope,$http,$window){
    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selectedlist=[];
    var obj;

    $http.get("GetComplaint")
        .then(function (response) {
            $scope.complaint = response.data.complaint;
        });

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })




    $scope.afterSelectItem = function(item){
        obj = {
            complaint_id: item.complaint_id,
            complaint_name:item.complaint_name,
            complaint_description:item.complaint_description
        };

        $scope.selectedlist.push(obj)

    }

    $scope.afterRemoveItem = function(item){
        var index = $scope.selectedlist.indexOf(item);
        $scope.selectedlist.splice(index,1);

    }

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
            complaint:$scope.selectedlist,
            procedures:$scope.procedures,
            diagnosis:$scope.diagnosis
        }

        $http.post('patientInfo',PatientInfo)
            .then (function (response,status,headers,config) {
            $scope.result=response.data;
            location.href="AddPrescription";
        });

    }

})