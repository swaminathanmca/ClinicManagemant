/**
 * Created by Lissomsoft on 05/15/17.
 */
app.controller('Invoice',function($scope,$http,$window,$timeout){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.selectedList=[];

    $http.get("BranchDetails/"+$scope.branch_id).
        then(function(response,status,headers,config){
            $scope.branch=response.data.branch;
            $scope.email=$scope.branch.email_id;

            $http.get("trackSession/" + $scope.email).
                then(function (response, status, headers, config) {
                    $scope.details = response.data;
                });

            $http.get("GetDoctorProfile/"+$scope.doctor_id)
                .then(function(response,status,headers,config){
                    $scope.doctors=response.data;
                });
        });


    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response) {
            $scope.patientcomplaint = response.data.patientcomplaint;

                $http.get("patientDetails/"+$scope.patientcomplaint.patient_id)
                    .then(function(response){
                        $scope.pdetails=response.data;
                        $http.get("GetInfoId/"+$scope.patientcomplaint.patient_pid+"/"+$scope.patientcomplaint.created_at)
                            .then(function(response){
                                $scope.info=response.data;
                                $window.sessionStorage.patient_info_id=$scope.info.patient_info_id;

                                $http.get("GetPrescription/"+$window.sessionStorage.patient_info_id)
                                    .then(function(response){
                                        $scope.selectedmaster=response.data.prescription;
                                    })
                            })


                    })


        });

$http.get("GetInvestigation/"+$scope.visit_id)
    .then(function(response){
        $scope.invest=response.data;
        var sr=$scope.invest.services;

        for(var j in sr){
            $scope.damount=(sr[j].discount/100)*sr[j].charges;
            $scope.tamount=sr[j].charges-$scope.damount;
           var obj={
               service_name:sr[j].service_name,
               charges:sr[j].charges,
               discount:sr[j].discount,
               tamount:$scope.tamount
           }
            $scope.selectedList.push(obj);
        }


    })

    $scope.submit=function(){
        window.print();
    }
    $scope.submited=function(){
        window.print();
    }

});