/**
 * Created by Lissomsoft on 05-Apr-17.
 */

app.controller('patientVisit',function($scope,$window,$http){

    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.chiefError="The Phone No Already Taken";


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

    $scope.entryNew=function(type){
        $scope.type=type;
        $http.get("GetEntryNew/"+$scope.patient_pid+"/"+$scope.type+"/"+$scope.doctor_id).
            then(function(response){
                $scope.entry=response.data.status;
                if($scope.entry==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }

    $scope.submit=function(){

        $http.get("GetEntryNew/"+$scope.patient_pid+"/"+$scope.type+"/"+$scope.doctor_id).
            then(function(response){
                $scope.entry=response.data.status;
                if($scope.entry==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
        var visit={
            patient_pid:$scope.patient_pid,
            branch_id:$scope.branch_id,
            height:$scope.type,
            weight:$scope.weight,
            type:$scope.vtype,
            time:$scope.time,
            pressure:$scope.pressure,
            doctor_id:$scope.doctor_id,
            referal_details:$scope.rdetails
        }

        if(!$scope.entry){
            $http.post("PatientVisit",visit).
                then(function (response,status,headers,config)
                {
                    $scope.x = response.data;
                    location.href="ViewPatientVisit";
                });
        }


    }






});