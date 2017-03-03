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
            $scope.x=response.data.clinic;
            $scope.clinic=response.data.clinic;

            $('#countries1').bfhcountries({country:$scope.clinic.country});
            $('#countries3').bfhcountries({country:$scope.clinic.country})
            $('#countries2').bfhcountries({country:$scope.clinic.chief_country});
            $('#countries4').bfhcountries({country:$scope.clinic.chief_country});
        })



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

});