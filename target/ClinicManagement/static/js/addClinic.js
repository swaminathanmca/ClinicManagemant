/**
 * Created by Admin on 2/18/2017.
 */

app.controller('dashboard', function ($scope, $http, $window) {
    $scope.authError="The Email Already Taken";
    $scope.authErrorEmail="The Email Already Take";
    console.log($window.sessionStorage.role_name);
    $scope.validate = function () {



        $http.get("validate/" + $scope.contact_no).
            then(function (response, status, headers, config) {
                //console.log(response.data.status);
                $scope.error = response.data.status;
                if($scope.error==false){
                    $scope.authError="";
                    console.log(!$scope.authError);

                }else{
                    $scope.authError="The Email Already Taken";
                }
            });
    }
    console.log(!$scope.authError);
    $scope.emailvalidate=function(){
        $http.get("emailvalidate/" + $scope.email_id).
            then(function (response, status, headers, config) {
                //console.log(response.data.status);
                $scope.error_email = response.data.status;
                if($scope.error_email==false){
                    $scope.authErrorEmail="";
                }else{
                    $scope.authErrorEmail="The Email Already Take";
                }


            });
    }


        $scope.submit = function () {
            if ($scope.error == true && $scope.error_email == true) {
            var clinic = {

                clinic_name: $scope.clinic_name,
                contact_no: $scope.contact_no,
                email_id: $scope.email_id,
                address: $scope.address,
                location:$scope.location,
                country:$scope.country,
                city: $scope.city,
                state: $scope.state,
                pincode: $scope.pincode,
                description: $scope.desc
            }

            $http.post("AddClinic", clinic).
                then(function (response, status, headers, config) {
                    $scope.data = response.data;
                    console.log("Added",$scope.data.status);
                    if($scope.data.status){
                        location.href="GetClinic";
                    }
                });
        }
                }





});