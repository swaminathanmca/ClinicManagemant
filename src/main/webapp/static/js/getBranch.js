/**
 * Created by Lissomsoft on 3/15/2017.
 */

app.controller('getBranch',function($scope,$window,$http){

    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;

    $http.get("trackSession/" + $scope.email)
        .then(function (response, status, headers, config) {
            $scope.data = response.data;
          console.log($window.sessionStorage.clinic_id);
            $scope.clinic_name=$scope.data.clinic_name;


        });


    $http.get("ViewBranchAdmin/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branch=response.data.branch;


        });


  $scope.EditBranch=function(id){
      $window.sessionStorage.branch_id=id;
      location.href="EditBranch"
  }


$scope.addBranch=function(){

    location.href = "AddBranch";
}


});