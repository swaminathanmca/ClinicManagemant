/**
 * Created by Admin on 4/19/2017.
 */
app.controller('GetComplaint',function($scope,$http,$window){
    $scope.role = $window.sessionStorage.role_name;
    $scope.email = $window.sessionStorage.email;

})