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


    $('#timepicker1').timepicker({
        minuteStep: 1,
        showInputs: false,
        disableFocus: true
    });

    $http.get("ViewDoctorBranch/" + $scope.branch_id)
        .then(function(respone){
            $scope.doctors=respone.data.user;
        });

    $scope.submit=function() {

        $scope.to_date = moment($scope.exp_date).format("MM/DD/YYYY");

       var appointment = {
            name:$scope.name,
            doctor_id:$scope.doctor_id,
           dov:$scope.to_date
       }

        $http.post('AddAppointment',appointment).
            then(function (response, status, headers, config) {
                $scope.data = response.data;
            });
    }
});
