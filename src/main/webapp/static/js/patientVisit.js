/**
 * Created by Lissomsoft on 05-Apr-17.
 */

app.controller('patientVisit',function($scope,$window,$http){

    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.chiefError="The Phone No Already Taken";
    $scope.cfollow="The Value";
    $scope.wfollow="The value";
    $scope.entry=true;
    $scope.followup=true;
    $scope.date1 = new Date();
    $scope.date1.setDate($scope.date1.getDate()-8);
    $scope.date1=moment($scope.date1).format("YYYY-MM-DD");


    $http.get("patientDetails/"+$scope.patient_pid).
        then(function(response,status,headers,config){
            $scope.data=response.data;
            $scope.dob=$scope.data.dob;

        });

   /* $http.get("ViewDoctor/"+ $scope.branch_id +"/"+$scope.clinic_id)
        .then(function (response){
            $scope.doctor = response.data.user;
        })*/


   /* $http.get("GetSpeciality")
        .then(function(response){
            $scope.specialitydetails=response.data.speciality;
        })

    $scope.doctor=function(id){

        $http.get("Doctorname"+"/"+id+"/"+$scope.branch_id)
            .then(function(response){
                $scope.profile=response.data.profile;
            })

    }*/

    $http.get("ViewDoctorBranch/"+$scope.branch_id)
        .then(function(response){
            $scope.profile=response.data.user;
        })


    var date = new Date();
    $scope.time= date.toLocaleTimeString();



    $scope.change=function(id){
        $scope.doctor_id=id;

        $scope.type="";
        $http.get("GetAllEntry/"+$scope.patient_pid+"/"+$scope.doctor_id).
            then(function(response){
                $scope.entryall=response.data.status;
            })

    }

    $scope.entryNew=function(type){
        $scope.type=type;
        if($scope.type==0){
            $http.get("GetEntryNew/"+$scope.patient_pid+"/"+$scope.type+"/"+$scope.doctor_id).
                then(function(response){
                    $scope.entry=response.data.status;
                    $scope.followup=true;
                    $scope.followWeek=true;
                    $scope.cfollow="Already Taken";
                    $scope.wfollow="Already Taken";
                    if($scope.entry==false){
                        $scope.chiefError="";
                    }else{
                        $scope.chiefError="Already Taken";
                    }
                })
        }else{
            $http.get("GetFollowUp/"+$scope.patient_pid+"/"+$scope.type+"/"+$scope.doctor_id).
                then(function(response){
                    $scope.followup=response.data.status;
                    $scope.entry=true;
                    $scope.chiefError="Already Taken";
                    if($scope.followup==false){
                        $scope.cfollow="";
                    }else{
                        $scope.cfollow="Already Taken";
                    }

                })


            $http.get("GetFollowUpWeek/"+$scope.patient_pid+"/"+$scope.type+"/"+$scope.doctor_id+"/"+$scope.date1).
                then(function(response){
                    $scope.followWeek=response.data.status;
                    if($scope.followWeek==false){
                        $scope.wfollow="";
                    }else{
                        $scope.wfollow="Already Taken";

                    }
                })


        }

    }

    $scope.submit=function(){


        var visit={
            patient_pid:$scope.patient_pid,
            branch_id:$scope.branch_id,
            type:$scope.type,
            weight:$scope.weight,
            height:$scope.height,
            visit_type:$scope.vtype,
            time:$scope.time,
            pressure:$scope.pressure,
            doctor_id:$scope.doctor_id,
            referal_details:$scope.rdetails
        }


        $http.post("PatientVisit",visit).
            then(function (response,status,headers,config)
            {
                $scope.x = response.data;
                location.href="ViewPatientVisit";
            });



    }


$scope.cancel=function(){
    location.href="patientDetail";
}



});