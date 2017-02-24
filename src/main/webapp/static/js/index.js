/**
 * Created by Admin on 2/16/2017.
 */

var app = angular.module('myApp', ['ui.mask']);
app.controller('myCtrl', function ($scope, $http, $window) {

    $http.get("GetPatient")
        .then(function (response) {
            $scope.user = response.data;
            console.log($scope.user.Patient);
        });


    $scope.submit = function () {

        var user = {

            username: $scope.email,
            password: $scope.password

        }
        if ($scope.email != null && $scope.password != null) {
            $http.post("SignIn", user)
                .then(function (response, status, headers, config) {
                    $scope.details = response.data;
                    if ($scope.details.status) {
                        $window.sessionStorage.role_name = $scope.details.data.role_name;
                        location.href = "Dashboard";
                    } else {
                        $scope.message = response.data.message;
                    }

                });
        }
    }
});