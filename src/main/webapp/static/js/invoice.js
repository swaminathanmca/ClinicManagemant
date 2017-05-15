/**
 * Created by Lissomsoft on 05/15/17.
 */
app.controller('Invoice',function($scope,$http,$window,$timeout){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;

    $http.get("BranchDetails/"+$scope.branch_id).
        then(function(response,status,headers,config){
            $scope.branch=response.data.branch;
            $scope.email=$scope.branch.email_id;

            $http.get("trackSession/" + $scope.email).
                then(function (response, status, headers, config) {
                    $scope.details = response.data;
                });

            $http.get("GetDoctorProfile/"+$scope.doctor_id)
                .then(function(response,status,headers,config){
                    $scope.doctors=response.data;
                });
        });


    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response) {
            $scope.patientcomplaint = response.data.patientcomplaint;

                $http.get("patientDetails/"+$scope.patientcomplaint.patient_id)
                    .then(function(response){
                        $scope.pdetails=response.data;
                    })


        });


});