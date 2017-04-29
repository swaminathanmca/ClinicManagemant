/**
 * Created by Admin on 4/19/2017.
 */
app.controller('PatientHistory',function($scope,$http,$window){

   /* $scope.patient_pid=$window.sessionStorage.patient_pid;*/
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.branch_iid=parseInt($scope.branch_id);

    $http.get("patientHistory/"+$scope.doctor_id+"/"+$scope.branch_id)

        .then(function(response){
            $scope.patienthistory=response.data.patientinfo;

        })


    $http.get("ViewBranch/"+ $scope.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
        });


    $scope.doctor=function(id){
        $scope.branch_id=id;
        $http.get("patientHistory/"+$scope.doctor_id+"/"+$scope.branch_id)

            .then(function(response){
                $scope.patienthistory=response.data.patientinfo;

            })
    }



})