/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('getDoctor',function($scope,$http,$window){
    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.email= $window.sessionStorage.email;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.branch_iid=response.data.branch_id;


        });


    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
            var branchInfo = {branch_id: "ALL", branch_name: "All"}
            $scope.branchDetails.push(branchInfo);

        });

    $scope.doctor=function(id){
        $scope.branch_id=id;

        $http.get("ViewDoctor/"+ $scope.branch_id +"/"+$scope.clinic_id)
            .then(function (response){
                $scope.data = response.data.user;
            })

    }

    $http.get("ViewDoctor/"+$scope.branch_id+"/"+$scope.clinic_id)
        .then(function (response){
            $scope.data = response.data.user;
        })


        $scope.addDoctor=function(){
            location.href="AddDoctor";
        }

    $scope.editDoctor=function(id){
        $scope.profile_id=id;
        $window.sessionStorage.profile_id=$scope.profile_id;
        location.href="doctorDetail";
    }


})