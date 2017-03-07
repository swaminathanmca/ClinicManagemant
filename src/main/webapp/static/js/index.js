/**
 * Created by Admin on 2/16/2017.
 */

var app = angular.module('myApp', ['ui.mask','angularUtils.directives.dirPagination']);
/*
    .directive('loading', function () {
        return {
            restrict: 'E',
            replace:true,
            template: '<div class="loading"><img src="./static/img/loader3.gif" style="text-align: center;margin-left: 45%;margin-top: 200px"></div>',
            link: function (scope, element, attr) {
                scope.$watch('loading', function (val) {
                    if (val)
                        $(element).show();
                    else
                        $(element).hide();
                });
            }
        }
    })
*/




app.controller('myCtrl', function ($scope, $http, $window) {




    $scope.submit = function () {

        var user = {

            email_id: $scope.email,
            password: $scope.password

        }
        if ($scope.email != null && $scope.password != null) {
            $http.post("SignIn", user)
                .then(function (response, status, headers, config) {

                    $scope.details = response.data;

                    if ($scope.details.status) {
                        $window.sessionStorage.role_name = $scope.details.data.role_name;
                        $window.sessionStorage.email=$scope.details.data.email_id;
                        if($window.sessionStorage.role_name=="SuperAdmin"){
                            location.href = "Dashboard";
                        }else if($window.sessionStorage.role_name=="Admin"){
                            location.href="AddUser";
                        }

                    } else {
                        $scope.message = response.data.message;
                    }

                });
        }
    }
});