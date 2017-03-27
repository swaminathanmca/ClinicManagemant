/**
 * Created by Admin on 3/8/2017.
 */
app.controller('branchController',function($scope,$http,$window){
    $scope.authError="The Email Already Taken";
    $scope.authErrorEmail="The Email Already Take";
    $scope.chiefError="The Phone No Already Taken";
    $scope.chiefEmail="Email taken";
    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.data = response.data;
            $window.sessionStorage.clinic_id=$scope.data.clinic_id;
            $scope.clinic_id=$window.sessionStorage.clinic_id;
            $window.sessionStorage.branch_id=$scope.data.branch_id;
        });


    $scope.validate = function () {
        $http.get("validate/" + $scope.contact_no).
            then(function (response, status, headers, config) {

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
        $http.get("validateEmail/"+$scope.branch_admin_email_id).
            then(function(response,status,headers,config){
                $scope.err_chief_email=response.data.status;

                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }

            })
    }
    $scope.submit=function(id){
      $scope.clinic_id=id;

         var ClinicUser={
             clinic_id:$scope.clinic_id,
             branch_name:$scope.branch_name,
             register_no:$scope.reg_no,
             address1:$scope.address1,
             address2:$scope.address2,
             city:$scope.city,
             state:$scope.state,
             country:$scope.country,
             pin_code:$scope.pincode,
             email_id:$scope.email_id,
             contact_no:$scope.contact_no,
             password:$scope.password,
             description:$scope.desc,
             chief_name:$scope.branch_admin_name,
             gender:$scope.chief_gender,
             chief_address1:$scope.admin_address1,
             chief_address2:$scope.admin_address2,
             chief_city:$scope.admin_city,
             chief_state:$scope.chief_state,
             chief_country:$scope.chief_country,
             chief_pin_code:$scope.chef_pin,
             chief_contact_no:$scope.chief_contact_no,
             chief_email_id:$scope.branch_admin_email_id,


         }

         $http.post("AddBranch", ClinicUser).
             then(function (response, status, headers, config) {
                 $scope.data = response.data;
                 console.log("Added",$scope.data.status);
                 if($scope.data.status){
                     location.href="GetBranch";
                 }
             });


     }


})