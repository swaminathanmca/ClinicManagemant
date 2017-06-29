/**
 * Created by Lissomsoft on 05/06/17.
 */

app.controller('services',function($scope, $http, $window){
    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;
    $scope.branch_id=$window.sessionStorage.branch_id;

$scope.submit=function(){

    var service={
        service_name:$scope.name,
        description:$scope.description,
        charges:$scope.charage
    }

    $http.post("AddService/"+$scope.branch_id,service).
        then(function (response,status,headers,config){
            $scope.data = response.data;
            location.href="ViewService";
        });
}
    $scope.cancel=function(){
         location.href="ViewService";
    }

});