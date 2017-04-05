/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('patientDetails',function($scope,$window,$http){



    $( function() {
        $( "#datepicker" ).datepicker(
            {
                maxDate: '0',
                dateFormat: 'dd-mm-yy'

            });
    } );

$http.get("patientDetails/"+$window.sessionStorage.patient_id).
    then(function(response,status,headers,config){

        $scope.data=response.data;

        $('#countries1').bfhcountries({country: $scope.data.country})
        $('#countries2').bfhcountries({country: $scope.data.emr_country})
    });



$scope.editUser=function(){

    $http.get("patientDetails/"+$window.sessionStorage.patient_id).
        then(function(response,status,headers,config){
            $scope.x=response.data;
            $('#countries3').bfhcountries({country: $scope.x.country});
            $('#countries4').bfhcountries({country: $scope.x.country});
            $scope.blood_iid=response.data.blood_group;
            $scope.gender=response.data.gender.toString();


        });
    $http.get("BloodGroup")
        .then(function(response,status,headers,config){
            $scope.blood=response.data.blood;

        });

}

    $scope.submit=function(id){
        $scope.id=id;
        $scope.country=$('#countries3').val();
        $scope.chief_country=$('#countries4').val();
        console.log(id);
        var patient={
            fullName:$scope.x.first_name,
            lastName:$scope.x.last_name,
            patient_pId:$scope.id,
            gender:$scope.gender,
            mStatus:$scope.x.mstatus,
            bloodGroup:$scope.blood_iid,
            dob:$scope.x.dob,
            email:$scope.x.email,
            contact_no:$scope.x.contact_no,
            residental_no:$scope.x.mobile_no,
            address1:$scope.x.address1,
            address2:$scope.x.address2,
            city:$scope.x.city,
            state:$scope.x.state,
            country:$scope.country,
            pincode:$scope.x.pincode,
            emergency_name:$scope.x.name,
            relation:$scope.x.relation,
            emergency_address1:$scope.x.emr_address1,
            emergency_address2:$scope.x.emr_address2,
            emergency_city:$scope.x.emr_city,
            emergency_state:$scope.x.emr_state,
            emergency_country:$scope.chief_country,
            emergency_pincode:$scope.x.emr_pincode,
            emergency_contact_no:$scope.x.emr_contact_no,
            emergency_residental_no:$scope.x.emr_mobile_no,
            emergency_email:$scope.x.email_id
        }

        $http.post("EditPatient",patient).
            then(function (response,status,headers,config){
                $scope.data = response.data;
                location.href="patientDetail";


            });

    }


$scope.proceed=function(){
    location.href="PatientVisit";
}


});