app.controller('appointment',function($scope,$window,$http){

    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;

    $scope.date = new Date();
    $scope.clear = function () {
        $scope.dt = null;
    };
    // Disable weekend selection
    $scope.disabled = function(date, mode) {

        return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
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

    $scope.open2 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened2 = true;
        $scope.opened1 = false;
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

    $scope.exp_date = moment().format("MM-DD-YYYY");

    $scope.my_date = moment();

    $scope.to_date = moment().add(7, 'days').format("MM-DD-YYYY");

    $http.get("ViewDoctorBranch/" + $scope.branch_id)
        .then(function(respone){
            $scope.doctors=respone.data.user;
        });

    $scope.fromSubmit=function(){
        $scope.dob = moment($scope.dob).format("MM-DD-YYYY");

        $http.get("PatientAppointmentInfo/"+$scope.dob+"/"+$scope.contact_no+"/"+$scope.branch_id)
            .then(function (response){
                $scope.data=response.data.patient;
            });
    };

    $scope.submit=function() {

        $scope.app_date = moment($scope.app_date).format("MM/DD/YYYY");

        var appointment = {
            name:$scope.y.first_name,
            branch_id:$scope.branch_id,
            doctor_id:$scope.doctor_id,
            dov:$scope.app_date
        };

        $http.post('AddAppointment',appointment).
            then(function (response, status, headers, config) {
                $scope.data = response.data;
            });
    };

    $scope.addAppointment=function(id){
        $scope.patient_pid=id;
        $http.get("patientDetailsById/"+$scope.patient_pid)
    .then(function (response) {
        $scope.y=response.data;

    })
    };

    $scope.submitt=function(){
        $scope.datee = moment($scope.datee).format("MM/DD/YYYY");

        var newappointment = {
            new_appointment_pid:$scope.new_appointment_pid,
            branch_id:$scope.branch_id,
            first_name:$scope.first_name,
            last_name:$scope.last_name,
            doctor_id:$scope.doctor_id,
            dob:$scope.datee,
            mobile_no:$scope.mobile_no,
            res_no:$scope.res_no,
            email:$scope.email,
            address1:$scope.address1,
            address2:$scope.address2,
            city:$scope.city,
            state:$scope.state,
            country:$scope.country,
            pin_code:$scope.pin_code
        };

        $http.post("AddNewAppointment",newappointment).
            then(function (response,status,header){
                $scope.data=response.data;
            });
    };


});
