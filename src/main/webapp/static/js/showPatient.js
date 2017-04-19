app.controller('showpatient',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;



    $http.get("trackSessionBranch/" + $scope.email).
        then(function (response, status, headers, config,data) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.doctor_id=response.data.doctor_id;
            $scope.clinic_id=response.data.clinic_id;
            $scope.data = response.data;
            console.log(response.status);

            if(response.status=200){
                $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
                    .then(function (response){
                        $scope.branchDetails=response.data.branch;
                    });
            }
        });




    $scope.doctor=function(id){
        $scope.branch_id=id;
        $http.get("ShowPatient/"+$scope.branch_id+"/"+$window.sessionStorage.doctor_id)

            .then(function(response){
                $scope.patientDetails=response.data.patient;
            })
    }

    $scope.editPatient=function(id){

        $window.sessionStorage.patient_pid=id;
        location.href="patientComplaints";
    }

})
