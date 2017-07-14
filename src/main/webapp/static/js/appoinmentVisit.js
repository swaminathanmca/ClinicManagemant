/**
 * Created by Lissomsoft on 07/13/17.
 */

app.controller('AppoinmentVisit',function($scope,$window,$http){


    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.doctor_name=$window.sessionStorage.doctor_name;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    var date = new Date();
    $scope.time= date.toLocaleTimeString();

    $http.get("patientDetails/"+$scope.patient_pid).
        then(function(response,status,headers,config){
            $scope.data=response.data;
            $scope.dob=$scope.data.dob;

        });
    $scope.submit=function(){
        var visit={
            patient_pid:$scope.patient_pid,
            branch_id:$scope.branch_id,
            weight:$scope.weight,
            height:$scope.height,
            visit_type:$scope.vtype,
            time:$scope.time,
            pressure:$scope.pressure,
            doctor_id:$scope.doctor_id,
            referal_details:$scope.rdetails
        }
console.log(visit);

        $http.post("PatientVisit",visit).
            then(function (response,status,headers,config)
            {
                $scope.x = response.data;
                location.href="ViewPatientVisit";
            });



    }

})