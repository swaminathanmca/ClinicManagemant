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


    $scope.submit=function(id){
        console.log(id);
        var patient={

            first_name:$scope.first_name,
            last_name:$scope.last_name,
            gender:$scope.gender,
            mStatus:$scope.maritalstatus,
            bloodGroup:$scope.bloodgroup,
            factor:$scope.rhdfactor,
            dob:$('#dob').val(),
            category:$scope.category,
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

       $http.post('AddPatient'+id,patient).
           then(function (response,status,headers,config){

           });
    }

})