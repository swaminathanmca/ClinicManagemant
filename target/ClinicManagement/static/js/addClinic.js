/**
 * Created by Admin on 2/18/2017.
 */

app.controller('dashboard', function ($scope, $http, $window) {
    $scope.authError="The Email Already Taken";
    $scope.authErrorEmail="The Email Already Take";
    $scope.chiefError="The Phone No Already Taken";
    $scope.chiefEmail="Email taken";
    $scope.name="name";
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $('#loader').append(' ');
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

    $scope.validatecontact=function(){

        $http.get("validateChief/"+$scope.chief_contact_no).
            then(function (response,status,header,config){
                $scope.err=response.data.status;

                if($scope.err==false){
                        $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }




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

    $scope.validateEmail=function(){
        $http.get("validateEmail/"+$scope.cheif_email_id).
            then(function(response,status,headers,config){
                $scope.err_chief_email=response.data.status;
                console.log($scope.err_chief_email);
                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }

            })
    }

$scope.valName=function(){
    $http.get("valName/"+$scope.clinic_name).
        then(function(response,status,headers,config){
            $scope.err_name=response.data.status;
            if($scope.err_name==false){
                $scope.name="";
            }else{
                $scope.name="name";
            }
        })
}
        $scope.submit = function () {


        var ClinicUser={
            clinic_name: $scope.clinic_name,
            register_no:$scope.reg_no,
            chief:$scope.chief_name,
            branch_name:$scope.clinic_name,
            address1: $scope.address1,
            address2:$scope.address2,
            city: $scope.city,
            state: $scope.state,
            country:$scope.country,
            pin_code: $scope.pincode,
            contact_no: $scope.contact_no,
            email_id: $scope.email_id,
            description: $scope.desc,
            password:$scope.password,
            chief_name:$scope.chief_name,
            chief_address1:$scope.chief_address1,
            chief_address2:$scope.chief_address2,
            chief_city:$scope.chief_city,
            chief_state:$scope.chief_state,
            chief_country:$scope.chief_country,
            chief_contact_no:$scope.chief_contact_no,
            chief_email_id:$scope.cheif_email_id,
            chief_pin_code:$scope.chef_pin,
            gender:$scope.chief_gender
        }

            $http.post("AddClinic", ClinicUser).
                then(function (response, status, headers, config) {
                    $scope.data = response.data;
                    console.log("Added",$scope.data.status);
                    if($scope.data.status){
                        location.href="GetClinic";
                    }
                });

                }


    $scope.cancel=function(){
        location.href="GetClinic";
    }


});