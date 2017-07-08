/**
 * Created by Lissomsoft on 3/15/2017.
 */
app.controller('branchdetails',function($scope,$window,$http){


    $scope.authErrorEmail="The Email Already Take";
    $scope.authError="The Email Already Taken";
    $scope.chiefEmail="Taken";
    $scope.chiefError="Already Taken";
    $scope.role=$window.sessionStorage.role_name;
    $scope.clinic_name=$window.sessionStorage.clinic_name;

$http.get("BranchDetails/"+$window.sessionStorage.branch_id).
    then(function(response,status,headers,config){
        $scope.branch=response.data.branch;
        $('#countries1').bfhcountries({country:$scope.branch.country});

        $('#countries2').bfhcountries({country:$scope.branch.chief_country});
    });


    $scope.editUser=function(id){

        $scope.branch_id=$window.sessionStorage.branch_id;

        $http.get("BranchDetails/"+ $scope.branch_id).
            then(function(response,status,headers,config){
                $scope.x=response.data.branch;
                $('#countries3').bfhcountries({country:$scope.branch.country});

                $('#countries4').bfhcountries({country:$scope.branch.chief_country});
            });
    }

    $scope.editEmail=function(id,email){
        $scope.branch_id=id;
        $scope.clinic_email=email;
        $http.get("EditEmail/"+$scope.branch_id+"/"+$scope.clinic_email).
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
        $scope.branch_id=id;
        $scope.contact_no=contact_no;
        $http.get("EditContact/"+$scope.branch_id+"/"+$scope.contact_no).
            then(function(response,status,error){
                $scope.error = response.data.status;
                if($scope.error==false){
                    $scope.authError="";

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
        $scope.branch_id=id;
        $scope.country=$('#countries3').val();
        $scope.chief_country=$('#countries4').val();

        var ClinicUser={
            branch_id:$scope.x.branch_id,
            branch_name:$scope.x.branch_name,
            address1:$scope.x.address1,
            address2:$scope.x.address2,
            city:$scope.x.city,
            state:$scope.x.state,
            country:$scope.country,
            pin_code:$scope.x.pin_code,
            email_id:$scope.x.email_id,
            contact_no:$scope.x.contact_no,
            password:$scope.x.password,
            description:$scope.x.description,
            chief_id:$scope.x.Chief_id,
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

        $http.post("EditBranch",ClinicUser).
            then(function (response,status,headers,config){
                $scope.data = response.data;
                location.href="EditBranch";


        });



    }

    $scope.back=function(){
        if($scope.role=='SuperAdmin'){
            location.href="AdminBranch";
        }else{
            location.href="GetBranch";
        }

    }

});