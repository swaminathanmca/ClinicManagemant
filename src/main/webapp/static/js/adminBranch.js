/**
 * Created by Lissomsoft on 3/17/2017.
 */
app.controller('adminBranch',function($scope,$window,$http){

    $http.get("ViewClinic").
        then(function(response,status,headers,config){
            $scope.clinic=response.data.clinic;


        });

     $scope.branch=function(id){
       $scope.id=id;
    $http.get("ViewBranch/"+ $scope.id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
        });

}
    $scope.EditBranch=function(id){
        $window.sessionStorage.branch_id=id;
        location.href="EditBranch"
    }

});