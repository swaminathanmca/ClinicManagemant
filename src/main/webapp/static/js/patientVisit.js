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

   /* $http.get("ViewDoctor/"+ $scope.branch_id +"/"+$scope.clinic_id)
        .then(function (response){
            $scope.doctor = response.data.user;
        })*/


    $http.get("GetSpeciality")
        .then(function(response){
            $scope.specialitydetails=response.data.speciality;
        })

    $scope.doctor=function(id){

        $http.get("Doctorname"+"/"+id+"/"+$scope.branch_id)
            .then(function(response){
                $scope.profile=response.data.profile;
            })

    }
    var date = new Date();
    $scope.time= date.toLocaleTimeString();
    $scope.submit=function(){

        var visit={

            patient_pid:$scope.patient_pid,
            branch_id:$scope.branch_id,
            height:$scope.height,
            weight:$scope.weight,
            type:$scope.vtype,
            time:$scope.time,
            pressure:$scope.pressure,
            doctor_id:$scope.doctor_id,
            referal_details:$scope.rdetails

        }

        $http.post("PatientVisit",visit).
            then(function (response,status,headers,config){
                $scope.x = response.data;
                location.href="patientDetail";


            });
    }
});