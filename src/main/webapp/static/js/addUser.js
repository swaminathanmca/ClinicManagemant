/**
 * Created by Admin on 3/7/2017.
 */

app.controller('User',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            //console.log(response.data.status);
            $scope.data = response.data;
        });

$scope.submit=function(){
    var User={

        name:$scope.firstname,
        address1:$scope.address1,
        address2:$scope.address2,
        city:$scope.city,
        state:$scope.state,
        country:$scope.country,
        pincode:$scope.pincode,
        email:$scope.email_id,
        user_type:$scope.user_type,
        phone_no:$scope.phone_no,
        gender:$scope.gender,
        password:$scope.password,
        reg_no:$scope.reg_no
}

    $http.post('',User).
        then(function (response,status,headers,config){

            console.log(response.data);
        });
}


})