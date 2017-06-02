/**
 * Created by Lissomsoft on 3/24/2017.
 */
app.controller('Patient',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $scope.date = new Date();
    $scope.clear = function () {
        $scope.dt = null;
    };

    $scope.toggleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();
    $scope.open1 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened1 = true;
        $scope.opened2 = false;
    };

    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 6,
        showWeeks:'false',
        class: 'datepicker'
    };
    $scope.toChange= function(){
    }
    $scope.initDate = new Date('2016-15-20');
    $scope.formats = ['MM/dd/yyyy','MMMM-dd-yyyy','yyyy-MMMM-dd', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];

    $scope.dob = moment().format("MM-DD-YYYY");

    $scope.my_date = moment();

    $scope.to_date = moment().add(7, 'days').format("MM-DD-YYYY");



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


    $scope.cadd=function(id){
      if(id){
            $scope.emr_address1=$scope.address1;
          $scope.emr_address2=$scope.address2;
          $scope.emr_city=$scope.city;
          $scope.emr_state=$scope.state;
          $scope.emr_pincode=$scope.pincode;
          $('#countries3').bfhcountries({country: $scope.country});

      }else
      {
          $scope.emr_address1="";
          $scope.emr_address2="";
          $scope.emr_city="";
          $scope.emr_state="";
          $scope.emr_pincode="";
      }
    }

    $scope.submit=function(id){
       $scope.branch_id=id;
        var satDate = new Date($scope.dob);
        $scope.to_date = moment(satDate).format("MM-DD-YYYY");

        $scope.ecountry=$('#countries3').val();
        var patient={

            fullName:$scope.first_name,
            lastName:$scope.last_name,
            gender:$scope.gender,
            mStatus:$scope.maritalstatus,
            bloodGroup:$scope.blood_id,
            dob:$scope.to_date ,
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
            emergency_state:$scope.emr_state,
            emergency_country:$scope.ecountry,
            emergency_pincode:$scope.emr_pincode,
            emergency_contact_no:$scope.emr_mobile_no,
            emergency_residental_no:$scope.emr_res_no,
            emergency_email:$scope.emr_email,
            referred_by:$scope.referred,
            allergy_food:$scope.allergy_food,
            allergy_others:$scope.allergy_others
        }

       $http.post('AddPatient/'+$scope.branch_id,patient).
               then(function (response,status,headers,config){
               location.href="GetPatient";
         });
}

})