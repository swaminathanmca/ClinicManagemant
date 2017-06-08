/**
 * Created by Lissomsoft on 3/22/2017.
 */

app.controller('Frontdesk',function($scope,$http,$window){

    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $scope.chiefError="The Phone No Already Taken";
    $scope.chiefEmail="Taken";

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;

            $scope.data = response.data;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });

    $scope.validatecontact=function(){

        $http.get("validateChief/"+$scope.phone_no).
            then(function (response,status,header,config){
                $scope.err=response.data.status;

                if($scope.err==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }


    $scope.validateEmail=function(){
        $http.get("validateEmail/"+$scope.email_id).
            then(function(response,status,headers,config){
                $scope.err_chief_email=response.data.status;

                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }

            })
    }

    $scope.submit=function(){
        var Frontdesk={

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
            qualification:$scope.qualification

        }

        $http.post('AddFrontDesk',Frontdesk).
            then(function (response,status,headers,config){
               $scope.data=response.data;
                location.href="ViewFrontDesk";
            });




    }
$scope.cancel=function(){
    location.href="ViewFrontDesk";
}


})