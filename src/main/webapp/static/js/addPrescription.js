/**
 * Created by Lissomsoft on 04/28/17.
 */
app.controller('Prescription',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selectedmaster=[];
    $scope.master={};
    $scope.addprescriptions=[];
    $scope.day=1;

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;
            console.log($scope.patientcomplaint.patient_pid);
            $http.get("GetInfoId/"+$scope.patientcomplaint.patient_pid+"/"+$scope.patientcomplaint.created_at)
                .then(function(response){
                    $scope.info=response.data;
                    $window.sessionStorage.patient_info_id=$scope.info.patient_info_id;
                })

            $http.get("GetPrescription/"+$window.sessionStorage.patient_info_id)
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
                 if ($('.check:checked').length<1) {
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
                            $http.get("GetPrescription/"+$window.sessionStorage.patient_info_id)
                                .then(function(response){
                                    $scope.selectedmaster=response.data.prescription;
                                })
                        }


                })



            };

              $scope.edit=function(id){
                  if ($('.check:checked').length<=1) {
                     $('#sub').removeAttr('disabled');
                    } else {
                      $('#sub').attr('disabled', 'disabled');
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
                console.log($scope.prescription_id);



            }

        })




    $scope.typepres=function(id){
        $scope.type=id;
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
                    days:$scope.myform.dayscount,
                    mrg_qty:$scope.myform.mrng,
                    aft_qty:$scope.myform.aftn,
                    nig_qty:$scope.myform.nght
                }

               /* var seprescription={
                    patient_info_id:id,
                    medicine_id:$scope.medicine_id,
                    frequency:$scope.myform.frequency,
                    days:$scope.myform.dayscount,
                    mrg_qty:$scope.myform.mrng,
                    aft_qty:$scope.myform.aftn,
                    nig_qty:$scope.myform.nght
                }
                $scope.selectedmaster.push(prescription);*/
                $scope.addprescriptions.push(prescription);
                $http.post("AddPatientPrescription",{prescriptions:$scope.addprescriptions}).
                    then(function(response,config,status){
                        $scope.status=response.data;
                        location.href="AddPrescription";
                    })



            });
    }






});











              /*  $scope.edit=function(){

                    if ($('.check:checked').length<=1) {
                        $('#sub').removeAttr('disabled');
                    } else {
                        $('#sub').attr('disabled', 'disabled');
                    }
                }*/







              /*  $scope.day =  $scope.selectedmaster.length>0 ? 0 :1;
                if($scope.day == 0) {
                    $scope.myform=angular.copy($scope.master);
                }*/

               /* $scope.editPres=function(){
                    var newDataList=[];
                    $scope.selectedAll = false;

                    angular.forEach($scope.selectedmaster, function(selected,index){
                        if(!selected.selected){
                            newDataList.push(selected);
                        }
                        console.log(selected.patient_id);

                    });
                }*/




   /*$scope.prescriptionAdd=function(){
   $http.post("AddPatientPrescription",{prescriptions:$scope.addprescriptions}).
       then(function(response,config,status){
           $scope.status=response.data;
           location.href="AddInvestigation";
       })

}*/








