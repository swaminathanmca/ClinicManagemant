/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('getPatient',function($scope,$http,$window){

    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;


    $http.get("trackSessionBranch/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_id=response.data.clinic_id;
            $scope.branch_id=response.data.branch_id;
            $scope.clinic_name=$scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;


        });



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