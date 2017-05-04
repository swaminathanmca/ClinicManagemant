/**
 * Created by Lissomsoft on 04/28/17.
 */
app.controller('Prescription',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selected=[];
    $scope.master={};
    $scope.day=1;

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })


    $scope.typepres=function(id){
        $scope.type=id;
      $http.get("PrescriptionType/"+$scope.type).
          then(function (response, status, headers, config) {
              $scope.medicines=response.data.medicines;

          })
    }




    $scope.submit=function(){

        $http.get("MedicineDetails/"+$scope.medicine_id).
            then(function(response,status,headers,config){
                $scope.medicine=response.data;
                $scope.medicine_name= $scope.medicine.medicine_name;
                $scope.mg=$scope.medicine.mg;
                var prescription={
                    patient_id:$scope.patientcomplaint.patient_pid,
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
                $scope.selected.push(prescription);
                $scope.day =  $scope.selected.length>0 ? 0 :1;
                if($scope.day == 0) {
                    $scope.myform=angular.copy($scope.master);
                }
            });


    }
   $scope.prescriptionAdd=function(){
   $http.get("/AddPrescription",$scope.selected).
       then(function(response,config,status){
           $scope.status=response.data;
       })

}



});