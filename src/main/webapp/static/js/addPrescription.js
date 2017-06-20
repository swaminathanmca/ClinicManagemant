/**
 * Created by Lissomsoft on 04/28/17.
 */
app.controller('Prescription',function($scope,$http,$window,$timeout){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selectedmaster=[];
    $scope.master={};
    $scope.addprescriptions=[];
    $scope.day=1;
    $scope.patient_info_id="";
    $scope.laboratory = $window.sessionStorage.lab;
    $scope.prescription = $window.sessionStorage.prescription;
    $scope.none = $window.sessionStorage.none;


    $scope.freAll=function(all){
    $scope.stm=all;

        if($scope.stm==1){
            $scope.myform.mrng=1;
            $scope.myform.aftn=1;
            $scope.myform.nght=1;

        }else{
            $scope.myform.mrng=0;
            $scope.myform.aftn=0;
            $scope.myform.nght=0;


        }
    }

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

            $http.get("GetInfoId/"+$scope.patientcomplaint.patient_pid+"/"+$scope.patientcomplaint.created_at+"/"+$scope.patientcomplaint.type+"/"+$scope.patientcomplaint.doctor_id)
                .then(function(response){
                    $scope.info=response.data;
                    $scope.patient_info_id=$scope.info.patient_info_id;
                    $http.get("GetPrescription/"+$scope.info.patient_info_id)
                        .then(function(response){
                            $scope.selectedmaster=response.data.prescription;
                        })

                })



            $scope.checkAll = function () {

                if (!$scope.selectedAll) {
                    $scope.selectedAll = true;
                } else {
                    $scope.selectedAll = false;
                }
                angular.forEach($scope.selectedmaster, function(x) {
                    x.selected = $scope.selectedAll;
                });

                if ($('.check:checked').length<0) {
                 $('#sub').removeAttr('disabled');

                } else {
                 $('#sub').attr('disabled', 'disabled');

                 }
            };

            $scope.remove = function(){
                var removeDataList=[];
                $scope.selectedAll = false;
                angular.forEach($scope.selectedmaster, function(selected){
                    if(selected.selected){
                        removeDataList.push(selected);
                    }
                });
                $http.post("RemovePrescription/",{prescriptions:removeDataList}).
                    then(function(response,status,config){
                    $scope.status=response.data.status;
                        if($scope.status){
                           /* $http.get("GetPrescription/"+$window.sessionStorage.patient_info_data)
                                .then(function(response){
                                    $scope.selectedmaster=response.data.prescription;

                                })*/
                            $http.get("GetPrescription/"+$scope.patient_info_id)
                                .then(function(response){
                                    $scope.selectedmaster=response.data.prescription;
                                })
                        }


                })

                if ($('.check:checked').length<0) {
                    $('#sub').removeAttr('disabled');
                } else {
                    $('#sub').attr('disabled', 'disabled');
                }


            };

            $scope.edit=function(id){
                   if(id){

                       if ($('.check:checked').length<=1) {

                           $('#sub').removeAttr('disabled');
                       } else {
                           $('#sub').attr('disabled', 'disabled');
                       }
                   }else{

                           if($('.check:checked').length==1){
                               $('#sub').removeAttr('disabled');
                           }else{
                               $('#sub').attr('disabled', 'disabled');
                           }


                   }

             }

            $scope.editPres=function(){

                $scope.prescription_id="";
                $scope.selectedAll = false;
                angular.forEach($scope.selectedmaster, function(selected){
                    if(selected.selected){
                        $scope.prescription_id=selected.prescription_id;
                    }
                });
                $http.get("GetPrescriptionbyId/"+ $scope.prescription_id)
                    .then (function(response) {
                    $scope.xt=response.data;
                    $scope.types=$scope.xt.type.toString();
                    $scope.frequencys=$scope.xt.frequency.toString();

                    $http.get("PrescriptionType/"+$scope.types).
                        then(function (response, status, headers, config) {
                            $scope.medicines=response.data.medicines;
                        })
                });
            }
        })




    $scope.typepres=function(id){
        $scope.type=id;
        $scope.medicine_id="";
      $http.get("PrescriptionType/"+$scope.type).
          then(function (response, status, headers, config) {
              $scope.medicines=response.data.medicines;
          })

    }

    $scope.submit=function(id){
        $http.get("MedicineDetails/"+$scope.medicine_id).
            then(function(response,status,headers,config){
                $scope.medicine=response.data;
                $scope.medicine_name= $scope.medicine.medicine_name;
                $scope.mg=$scope.medicine.mg;
                var prescription={
                    patient_info_id:id,
                    patient_id:id,
                    type:$scope.type,
                    medicine_id:$scope.medicine_id,
                    mg:$scope.mg,
                    medicine_name:$scope.medicine_name,
                    frequency:$scope.myform.frequency,
                    days:$scope.myform.count,
                    mrg_qty:$scope.myform.mrng,
                    aft_qty:$scope.myform.aftn,
                    nig_qty:$scope.myform.nght,
                    remarks:$scope.myform.remarks,
                    days1:$scope.myform.day1,
                    days2:$scope.myform.day2,
                    days3:$scope.myform.day3,
                    days4:$scope.myform.day4,
                    days5:$scope.myform.day5,
                    days6:$scope.myform.day6,
                    days7:$scope.myform.day7
                }

                $scope.addprescriptions.push(prescription);
                $http.post("AddPatientPrescription",{prescriptions:$scope.addprescriptions}).
                    then(function(response,config,status){
                        $scope.status=response.data;
                        location.href="AddPrescription";
                    })
            });
    }


$scope.editsubmit=function(id){
    $http.get("MedicineDetails/"+$scope.xt.medicine_id).
        then(function(response,status,headers,config){
            $scope.medicine=response.data;
            $scope.medicine_name= $scope.medicine.medicine_name;
            $scope.mg=$scope.medicine.mg;
            var prescripe={
                prescription_id:id,
                type:$scope.types,
                medicine_id:$scope.xt.medicine_id,
                frequency:$scope.frequencys,
                days:$scope.xt.days,
                medicine_name:$scope.medicine_name,
                mg:$scope.mg,
                mrg_qty:$scope.xt.mrg_qty,
                aft_qty:$scope.xt.aft_qty,
                nig_qty:$scope.xt.ngt_qty,
                days1:$scope.xt.day1,
                days2:$scope.xt.day2,
                days3:$scope.xt.day3,
                days4:$scope.xt.day4,
                days5:$scope.xt.day5,
                days6:$scope.xt.day6,
                days7:$scope.xt.day7,
                remarks:$scope.xt.remarks
            }

        $http.post("EditPrescription",prescripe).
            then(function(response){
                $scope.editstatus=response.data.status;
                if($scope.editstatus){
                    location.href="AddPrescription";
                }

            })


        });
}

$scope.prescriptionAdd=function(){

    location.href="AddInvestigation";
}

$scope.back=function(){
   if($scope.laboratory==1){
       location.href="PatientTest";
   }else{
       location.href="EditpatientComplaint";
   }

}


});




















