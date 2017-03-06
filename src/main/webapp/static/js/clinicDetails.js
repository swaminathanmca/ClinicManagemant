/**
 * Created by Admin on 3/2/2017.
 */

app.controller('clinicDetails',function($scope,$window,$http){

    $scope.name="name";
    $scope.authErrorEmail="The Email Already Take";
    $scope.authError="The Email Already Taken";
    $scope.chiefEmail="Taken";
    $scope.chiefError="Already Taken";

    $http.get("ViewDetails/"+$window.sessionStorage.clinic_id).
        then(function(response,status,error,headers, config){

            $scope.clinic=response.data.clinic;

            $('#countries1').bfhcountries({country:$scope.clinic.country});

            $('#countries2').bfhcountries({country:$scope.clinic.chief_country});

        })

    $scope.editUser=function(id){
        $scope.clinic_id=id;
        console.log($scope.clinic_id);
    $http.get("ViewDetails/"+$scope.clinic_id).
        then(function(response,status){
            $scope.x=response.data.clinic;
            $('#countries3').bfhcountries({country:$scope.clinic.country});
            $('#countries4').bfhcountries({country:$scope.clinic.chief_country});
        })

    }

    $scope.EditName=function(id,name){
        $scope.clinic_id=id;
        $scope.clinic_name=name;
       $http.get("EditName/"+$scope.clinic_id+"/"+$scope.clinic_name).
           then(function(response,status,error,headers,config){
               $scope.err_name=response.data.status;
               if($scope.err_name==false){
                   $scope.name="";
               }else{
                   $scope.name="name";
               }
           })
    }

        $scope.editEmail=function(id,email){
            $scope.clinic_id=id;
            $scope.clinic_email=email;
            $http.get("EditEmail/"+$scope.clinic_id+"/"+$scope.clinic_email).
                then(function (response,status,error,headers,config){
                    $scope.error_email=response.data.status;

                    if($scope.error_email==false){
                        $scope.authErrorEmail="";
                    }else{
                        $scope.authErrorEmail="The Email Already Take";
                    }
                })

        }
    $scope.editContact=function(id,contact_no){
        $scope.clinic_id=id;
        $scope.contact_no=contact_no;
        $http.get("EditContact/"+$scope.clinic_id+"/"+$scope.contact_no).
            then(function(response,status,error){
                $scope.error = response.data.status;
                if($scope.error==false){
                    $scope.authError="";
                    console.log(!$scope.authError);

                }else{
                    $scope.authError="The Email Already Taken";
                }
            })
    }
    $scope.EditCemail=function(id,email_id){
        $scope.chief_id=id;
        $scope.email_id=email_id;
        $http.get("EditChiefEmail/"+$scope.chief_id+"/"+$scope.email_id).
            then(function(response,status,error){
                $scope.err_chief_email=response.data.status;
                console.log($scope.err_chief_email);
                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }
            })
    }

    $scope.EditChiefContact=function(id,contact_no){
        $scope.chief_id=id;
        $scope.cihef_contactno=contact_no;
        $http.get("EditChiefContact/"+$scope.chief_id+"/"+$scope.cihef_contactno).
            then(function(response,status,error){
                $scope.err=response.data.status;

                if($scope.err==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }

    $scope.submit=function(id){

        $scope.country=$('#countries3').val();
        $scope.chief_country=$('#countries4').val();
        var ClinicUser={

            clinic_id:$scope.x.clinicId,
            chief_id:$scope.x.Chief_id,
            clinic_name:$scope.x.clinicName,
            address1:$scope.x.address1,
            address2:$scope.x.address2,
            city:$scope.x.city,
            state:$scope.x.state,
            country:$scope.country,
            pin_code:$scope.x.pin_code,
            contact_no:$scope.x.contact_no,
            email_id:$scope.x.email_id,
            register_no:$scope.x.reg_no,
            description:$scope.x.description,
            chief_name:$scope.x.Chief,
            chief_address1:$scope.x.Chief_address1,
            chief_address2:$scope.x.Chief_address2,
            chief_city:$scope.x.Chief_city,
            chief_state:$scope.x.Chief_state,
            chief_country:$scope.chief_country,
            chief_contact_no:$scope.x.Chief_conatct_no,
            chief_email_id:$scope.x.Chief_email_id,
            chief_pin_code:$scope.x.Chief_pincode,
            gender:$scope.x.Chief_gender
        }
        $http.post("EditClinic", ClinicUser).
            then(function (response, status, headers, config) {
                $scope.data = response.data;
                console.log("Updated", $scope.data.status);
                if ($scope.data.status) {
                    location.href = "clinicDetails";
                }
            });

    }

});