/**
 * Created by Lissomsoft on 05/30/17.
 */

app.controller('editComplaints',function($scope,$window,$http){
    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.patient_info_id="";
    var obj;

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response) {
            $scope.patientcomplaint = response.data.patientcomplaint;

            $http.get("GetInfoId/" + $scope.patientcomplaint.patient_pid + "/" + $scope.patientcomplaint.created_at+"/"+$scope.patientcomplaint.type+"/"+$scope.doctor_id)
                .then(function (response) {
                    $scope.info = response.data;
                    $scope.patient_info_id = $scope.info.patient_info_id;

                    $http.get("GetInfoDetails/"+$scope.patient_info_id)
                        .then(function(response){
                            $scope.details=response.data;

                        })
                })
        });

    $http.get("GetComplaint")
        .then(function (response) {
            $scope.complaint = response.data.complaint;

        });



   $scope.editInfo=function(){
       $http.get("GetInfoDetails/"+$scope.patient_info_id)
           .then(function(response){
               $scope.detailsInfo=response.data;
               $scope.selectSpecialization=$scope.detailsInfo.complaints;
           })
   }


    $scope.afterremoveItem = function(item){
        obj={
            complaint_id : item.complaint_id,
            complaint_name: item.complaint_name,
            complaint_description:item.complaint_description
        };


    }

    $scope.afterselectItem=function(item){

        obj={
            complaint_id : item.complaint_id,
            complaint_name: item.complaint_name,
            complaint_description:item.complaint_description
        };

        if($scope.selectSpecialization.indexOf(item)== -1){
            $scope.selectSpecialization.push(obj);
        }

    }

    $scope.submit=function(id){
        var PatientInfo={
            patient_info_id:id,
            diagnosis:$scope.detailsInfo.diagonics,
            complaint:$scope.selectSpecialization,
            observation:$scope.detailsInfo.observation,
            investigation:$scope.detailsInfo.investigation,
            procedures:$scope.detailsInfo.procedures,
            pressure:$scope.detailsInfo.bp
        }

        $http.post("EditPatientInfo",PatientInfo).
            then(function(response){
                $scope.status=response.data.status;
                location.href="EditpatientComplaint";
            })
    }
    $scope.submited=function(){
        location.href="AddPrescription";
    }

})