/**
 * Created by Lissomsoft on 3/24/2017.
 */
app.controller('Patient',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;


    $http.get("trackSessionBranch/" + $scope.email).
        then(function (response, status, headers, config) {

            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_id=response.data.clinic_id;
            $scope.branch_id=response.data.branch_id;
            $scope.data = response.data;
        });

    $http.get("BloodGroup")
        .then(function(response,status,headers,config){
            $scope.blood=response.data.blood;

        })
$scope.validate=function(){
    $scope.no=$scope.mobile_no;
    console.log($scope.no);
    $http.get("ValidatePatient/"+$scope.no)
        .then(function(response,status,config){
            $scope.validatePatient=response.data;
        })

}

    $scope.submit=function(id){
       $scope.branch_id=id;
        var patient={

            fullName:$scope.first_name,
            lastName:$scope.last_name,
            gender:$scope.gender,
            mStatus:$scope.maritalstatus,
            bloodGroup:$scope.blood_id,
            dob:$('#dob').val(),
            email:$scope.email_id,
            contact_no:$scope.mobile_no,
            residental_no:$scope.res_no,
            address1:$scope.address1,
            address2:$scope.address2,
            city:$scope.city,
            state:$scope.state,
            country:$scope.country,
            pincode:$scope.pincode,
            emergency_name:$scope.emr_name,
            relation:$scope.relation,
            emergency_address1:$scope.emr_address1,
            emergency_address2:$scope.emr_address2,
            emergency_city:$scope.emr_city,
            emergency_state:$scope.state,
            emergency_country:$scope.country,
            emergency_pincode:$scope.emr_pincode,
            emergency_contact_no:$scope.emr_mobile_no,
            emergency_residental_no:$scope.emr_res_no,
            emergency_email:$scope.emr_email
        }

       $http.post('AddPatient/'+$scope.branch_id,patient).
           then(function (response,status,headers,config){

           });
    }

})