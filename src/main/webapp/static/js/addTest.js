/**
 * Created by Lissomsoft on 05/26/17.
 */
app.controller('LaboratoryTest',function($scope,$http,$window,$timeout) {

    $scope.visit_id = $window.sessionStorage.visit_id;
    $scope.branch_id = $window.sessionStorage.branch_id;
    $scope.doctor_id = $window.sessionStorage.doctor_id;
    $scope.selectedmaster=[];

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response) {
            $scope.patientcomplaint = response.data.patientcomplaint;

            $http.get("GetInfoId/" + $scope.patientcomplaint.patient_pid + "/" + $scope.patientcomplaint.created_at)
                .then(function (response) {
                    $scope.info = response.data;
                    $window.sessionStorage.patient_info = $scope.info.patient_info_id;

                })
            $http.get("GetLabInvest/"+ $window.sessionStorage.patient_info).
                then(function(response){
                    $scope.selectedmaster=response.data.labinvest;
                })

        });
    $http.get("LabType")
        .then(function(response){
            $scope.type=response.data.laboratory;
            })

$scope.typelab=function(test_type){
    $scope.test_type=test_type;

    $http.get("LaboratoryType/"+$scope.test_type).
     then(function(response){
            $scope.lab=response.data.laboratory;
     })
}




    $scope.submit=function(id){

        var labInvestigation={
            patient_info_id:id,
            test_name:$scope.test_name,
            remarks:$scope.remarks
        }
        console.log($scope.test_name);
        $http.post("AddLabReferences",labInvestigation).
            then(function(response){
                $scope.status=response.data.status;
                if($scope.status){
                    $http.get("GetLabInvest/"+ $window.sessionStorage.patient_info).
                        then(function(response){
                            $scope.selectedmaster=response.data.labinvest;
                        })
                }
            })
    }




});