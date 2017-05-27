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



    $scope.remove = function(){
        var removeDataList=[];
        $scope.selectedAll = false;
        angular.forEach($scope.selectedmaster, function(selected){
            if(selected.selected){
                removeDataList.push(selected);
            }
        });

        for(var j in removeDataList){
            $scope.investigation_id=removeDataList[j].investigation_id;
            console.log($scope.investigation_id);
            $http.get("RemoveLabInvest/"+$scope.investigation_id).
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



    $scope.submit=function(id){

        var labInvestigation={
            patient_info_id:id,
            test_type:$scope.x.test_type,
            test_name:$scope.test_name,
            remarks:$scope.remarks
        }

        $http.post("AddLabReferences",labInvestigation).
            then(function(response){
                $scope.status=response.data.status;
                if($scope.status){
                    $http.get("GetLabInvest/"+ $window.sessionStorage.patient_info).
                        then(function(response){
                            $scope.selectedmaster=response.data.labinvest;
                            $scope.x.test_type="";
                            $scope.test_name="";
                            $scope.remarks="";
                        })
                }
            })
    }




    $scope.editPres=function(){

        $scope.prescription_id="";
        $scope.selectedAll = false;
        angular.forEach($scope.selectedmaster, function(selected){
            if(selected.selected){
              $scope.investigation_id=selected.investigation_id;
            }
        });

        $http.get("LabType")
            .then(function(response){
                $scope.invtype=response.data.laboratory;
            })
        $http.get("GetLabInvestigationId/"+ $scope.investigation_id)
            .then (function(response) {
               $scope.data=response.data;

            $http.get("LaboratoryType/"+$scope.data.test_type).
                then(function(response){
                    $scope.labinst=response.data.laboratory;
                })

        });
    }

    $scope.typelabModel=function(test_type){
        $http.get("LaboratoryType/"+test_type).
            then(function(response){
                $scope.labinst=response.data.laboratory;
            })
    }


    $scope.editsubmit=function(id){
        var labInvestigation={
            labinvestigation_id:id,
            test_type:$scope.data.test_type,
            test_name:$scope.data.test_name,
            remarks:$scope.data.remarks
        }

        $http.post("EditLabInvestigation",labInvestigation).
            then(function(response){
                $scope.st=response.data.status;
                location.href="PatientTest";
            })


    }
    $scope.prescriptionAdd=function(){
        location.href="AddPrescription";
    }


});