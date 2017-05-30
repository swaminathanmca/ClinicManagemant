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
    $scope.patient_info="";



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

            $http.get("GetInfoId/"+$scope.patientcomplaint.patient_pid+"/"+$scope.patientcomplaint.created_at)
                .then(function(response){
                    $scope.info=response.data;
                    $window.sessionStorage.patient_info=$scope.info.patient_info_id;

                })

            $http.get("GetPrescription/"+$window.sessionStorage.patient_info)
                .then(function(response){
                    $scope.selectedmaster=response.data.prescription;
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
                            $http.get("GetPrescription/"+$window.sessionStorage.patient_info)
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
                    $scope.x=response.data;
                    $scope.types=$scope.x.type.toString();
                    $scope.frequencys=$scope.x.frequency.toString();

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
    $http.get("MedicineDetails/"+$scope.x.medicine_id).
        then(function(response,status,headers,config){
            $scope.medicine=response.data;
            $scope.medicine_name= $scope.medicine.medicine_name;
            $scope.mg=$scope.medicine.mg;
            var prescripe={
                prescription_id:id,
                type:$scope.types,
                medicine_id:$scope.x.medicine_id,
                frequency:$scope.frequencys,
                days:$scope.x.days,
                medicine_name:$scope.medicine_name,
                mg:$scope.mg,
                mrg_qty:$scope.x.mrg_qty,
                aft_qty:$scope.x.aft_qty,
                nig_qty:$scope.x.ngt_qty,
                days1:$scope.x.day1,
                days2:$scope.x.day2,
                days3:$scope.x.day3,
                days4:$scope.x.day4,
                days5:$scope.x.day5,
                days6:$scope.x.day6,
                days7:$scope.x.day7,
                remarks:$scope.x.remarks
            }

        $http.post("EditPrescription",prescripe).
            then(function(response){
                $scope.editstatus=response.data.status;
                location.href="AddPrescription";
            })


        });
}

$scope.prescriptionAdd=function(){

    location.href="AddInvestigation";
}

$scope.back=function(){
    location.href="EditpatientComplaint";
}


});




















