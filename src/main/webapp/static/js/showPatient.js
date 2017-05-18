app.controller('showpatient',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;


    $http.get("trackSessionBranch/" + $scope.email).
        then(function (response, status, headers, config,data) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.doctor_id=response.data.doctor_id;
            $scope.clinic_id=response.data.clinic_id;
            $scope.data = response.data;

            $scope.branch_id= $window.sessionStorage.branch_id;
            $scope.branch_iid=parseInt($scope.branch_id);


            $http.get("ShowPatient/"+ $scope.branch_id+"/"+$window.sessionStorage.doctor_id)

                .then(function(response){
                    $scope.patientDetails=response.data.patient;
                })
            if(response.status=200){
                $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
                    .then(function (response){
                        $scope.branchDetails=response.data.branch;
                    });
            }
        });






    $scope.doctor=function(id){
        $window.sessionStorage.branch_id=id;
        $http.get("ShowPatient/"+ $window.sessionStorage.branch_id+"/"+$window.sessionStorage.doctor_id)

            .then(function(response){
                $scope.patientDetails=response.data.patient;
            })
    }

    $scope.editPatient=function(id,type){
        $scope.type=type;
        $window.sessionStorage.visit_id=id;
        if($scope.type==0){
            location.href="patientComplaints";
        }else{
            location.href="PatientFollowup";
        }



    }

})
