/**
 * Created by Admin on 2/16/2017.
 */

var app = angular.module('myApp', ['ui.mask','angularUtils.directives.dirPagination','naif.base64','AxelSoft', 'multipleSelect', 'ui.bootstrap']);





app.controller('myCtrl', function ($scope, $http, $window) {


    $window.sessionStorage.clear();

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
                        $window.sessionStorage.clinic_id=$scope.details.data.clinic_id;
                        if($window.sessionStorage.role_name=="SuperAdmin"){
                            location.href = "Dashboard";
                        }else if($window.sessionStorage.role_name=="Admin"){
                            location.href="AddBranch";
                        }else if($window.sessionStorage.role_name=="BranchAdmin"){
                            location.href="AddDoctor";
                        }else if($window.sessionStorage.role_name=="FrontDesk"){
                            location.href="AddPatient";
                        }else if($window.sessionStorage.role_name=="Doctor"){
                            location.href="DoctorDashboard";
                        }
                    } else {
                        $scope.message = response.data.message;
                    }

                });
        }
    }
});