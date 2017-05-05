/**
 * Created by Lissomsoft on 04/28/17.
 */
app.controller('Prescription',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selected=[];
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
                    patient_id:id,
                    type:$scope.type,
                    medicine_id:$scope.medicine_id,
                    mg:$scope.mg,
                    medicine_name:$scope.medicine_name,
                    frequency:$scope.myform.frequency,
                    days:$scope.myform.dayscount,
                    morning:$scope.myform.mrng,
                    aftn:$scope.myform.aftn,
                    nght:$scope.myform.nght
                }

                var seprescription={
                    patient_info_id:id,
                    medicine_id:$scope.medicine_id,
                    frequency:$scope.myform.frequency,
                    days:$scope.myform.dayscount,
                    mrg_qty:$scope.myform.mrng,
                    aft_qty:$scope.myform.aftn,
                    nig_qty:$scope.myform.nght
                }

                $scope.selected.push(prescription);
                $scope.addprescriptions.push(seprescription);
                console.log($scope.addprescriptions);
                $scope.day =  $scope.selected.length>0 ? 0 :1;
                if($scope.day == 0) {
                    $scope.myform=angular.copy($scope.master);
                }
            });


    }
   $scope.prescriptionAdd=function(){
   $http.post("AddPatientPrescription",{prescriptions:$scope.addprescriptions}).
       then(function(response,config,status){
           $scope.status=response.data;
           location.href="AddInvestigation";
       })

}



});