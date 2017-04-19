/**
 * Created by Admin on 4/19/2017.
 */
app.controller('GetComplaint',function($scope,$http,$window){
    $scope.role = $window.sessionStorage.role_name;
    $scope.email = $window.sessionStorage.email;
    $scope.submit=function(){
        var getcomplaint={
            patient_id:$scope.patient_pid,
            first_name:$scope.first_name,
            last_name:$scope.last_name,
            height:$scope.height,
            weight:$scope.weight,
            pressur:$scope.pressure,
            refereal_details:$scope.refereal_details,
            complaint:$scope.complaint_id,
            procedures:$scope.procedures
        }

        $http.post('patientInfo',getcomplaint)
            .then (function (response,status,headers,config) {
            $scope.result=response.data;

        });
    }
})