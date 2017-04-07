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


    $scope.submit=function(){

        var visit={

            patient_pid:$scope.patient_pid,
            first_name:$scope.data.first_name,
            last_name:$scope.data.last_name,
            profile_id:$scope.profile_id,
            type:$scope.vtype,
            height:$scope.height,
            weight:$scope.weight,
            refereal_details:$scope.rdetails

        }

        $http.post("PatientVisit",visit).
            then(function (response,status,headers,config){
                $scope.x = response.data;
                /*location.href="patientDetail";*/


            });


    }
});