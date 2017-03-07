/**
 * Created by Admin on 3/7/2017.
 */

app.controller('User',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
        console.log($scope.email);



    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            //console.log(response.data.status);
            $scope.data = response.data;



        });


})