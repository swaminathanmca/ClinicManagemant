/**
 * Created by Admin on 3/7/2017.
 */

app.controller('User',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;


    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;

            $scope.data = response.data;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
            console.log($scope.branchDetails);
        });

    $scope.onLoad = function (e, reader, file, fileList,fileObj ) {

        $scope.user=fileObj.base64;

    };



$scope.submit=function(){
    var Doctor={

        firstname:$scope.firstname,
        address1:$scope.address1,
        address2:$scope.address2,
        clinic_id:$window.sessionStorage.clinic_id,
        branch_id:$scope.data.branch_id,
        city:$scope.city,
        state:$scope.state,
        country:$scope.country,
        pincode:$scope.pincode,
        email_id:$scope.email_id,
        contact_no:$scope.phone_no,
        gender:$scope.gender,
        password:$scope.password,
        reg_no:$scope.reg_no,
        qualification:$scope.qualification,
        specialization:$scope.specialization
}


    $http.post('AddDoctor',Doctor).
        then(function (response,status,headers,config){
            location.href="ViewDoctor";
        });




}


})