/**
 * Created by Admin on 2/22/2017.
 */
app.controller('getClinic', function ($scope, $http, $window) {
    $scope.contact_no = "";
    $scope.email_id = "";
    $scope.error = true;
    $scope.data = "";
    $scope.clinic_name = "";
    $scope.address = "";
    $scope.city = "";
    $scope.state = "";
    $scope.pincode = "";
    $scope.desc = "";
    $scope.authError = "The Email Already Taken";
    $scope.authErrorEmail = "The Email Already Take";

    $http.get("ViewClinic")
        .then(function (response) {
            $scope.data = response.data;
            $scope.clinic = $scope.data.clinic;
        });
    $scope.editClinic = function (id) {

        $scope.id = id;
        $http.get("GetDetails/" + $scope.id).
            then(function (response, status, headers, config) {
                $scope.data = response.data;


                console.log($scope.data);

            });
    }

    $scope.validate = function (id) {
        $scope.clinicID = id;
        $scope.contact_no = $scope.data.phone_no;
        $http.get("validate/" + $scope.contact_no + "/" + $scope.clinicID).
            then(function (response, status, headers, config) {

                $scope.error = response.data.status;
                if ($scope.error == false) {

                    $scope.authError = "";
                    console.log(!$scope.authError);

                } else {
                    $scope.authError = "The Email Already Taken";
                }
            });
    }

    $scope.emailvalidate = function (id) {
        $scope.clinicID = id;
        console.log($scope.clinicID);
        $scope.email_id = $scope.data.email_id;
        $http.get("emailvalidate/" + $scope.email_id + "/" + $scope.clinicID).
            then(function (response, status, headers, config) {

                $scope.error_email = response.data.status;
                if ($scope.error_email == false) {
                    $scope.authErrorEmail = "";
                } else {
                    $scope.authErrorEmail = "The Email Already Taken";
                }


            });
    }

    $scope.submit = function (id) {
        $scope.clinicID = id;
        $scope.clinic_name = $scope.data.clinicName;
        $scope.contact_no = $scope.data.phone_no;
        $scope.email_id = $scope.data.email_id;
        $scope.address = $scope.data.address;
        $scope.city = $scope.data.city;
        $scope.state = $scope.data.state;
        $scope.pincode = $scope.data.pincode;
        $scope.desc = $scope.data.description;
        var clinic = {
            clinic_id: $scope.clinicID,
            clinic_name: $scope.clinic_name,
            contact_no: $scope.contact_no,
            email_id: $scope.email_id,
            address: $scope.address,
            city: $scope.city,
            state: $scope.state,
            pincode: $scope.pincode,
            description: $scope.desc
        }
        $http.post("EditClinic", clinic).
            then(function (response, status, headers, config) {
                $scope.data = response.data;
                console.log("Updated", $scope.data.status);
                if ($scope.data.status) {
                    location.href = "GetClinic";
                }
            });

    }
    $scope.delete=function(id){
        $scope.clinicID=id;

        $http.delete("DeleteClinic/"+$scope.clinicID).
            then(function(response, status, headers, config){
                $scope.data = response.data;
                console.log("Updated", $scope.data.status);
                if ($scope.data.status) {
                    location.href = "GetClinic";
                }
        });
    }


});