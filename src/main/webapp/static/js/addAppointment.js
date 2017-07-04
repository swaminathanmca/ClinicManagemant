app.controller('appointment',function($scope,$window,$http,$timeout){

    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;

    $scope.date = new Date();
    $scope.clear = function () {
        $scope.dt = null;
    };

    $scope.initDate = new Date('2016-15-20');
    $scope.formats = ['MM/dd/yyyy','MMMM-dd-yyyy','yyyy-MMMM-dd', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];


    $scope.dtmax=moment().add(1, 'M').format('MM-DD-YYYY');
    $scope.my_date = moment();

    $scope.to_date = moment().add(7, 'days').format("MM-DD-YYYY");

    $http.get("ViewDoctorBranch/" + $scope.branch_id)
        .then(function(respone){
            $scope.doctors=respone.data.user;
        });




$scope.schedule=function(time,flag){

    $scope.time=time;
    if(flag){
        $('#myModal').modal()
    }else{
        $('#myModal1').modal()
    }



}

$scope.doctorschedule=function(id){

    $http.get("GetDoctorSchedule/"+id+"/"+$scope.branch_id).then
    (function(response,status,error,headers, config){
        $scope.schedule_details=response.data;
        $scope.status=response.data.status;
        $scope.disable_dates=response.data.disable_dates;
        $scope.flag=response.data.flags;
        $scope.times="";
        var unavailableDates=$scope.disable_dates;

        function unavailable(date) {
            dmy = moment(date).format("MM/DD/YYYY");
            if ($.inArray(dmy, unavailableDates) == -1) {
                return [true, "Highlighted"];
            } else {
                return [false, "", "Unavailable"];
            }
        }

        $("#datepicker").datepicker("destroy");
        $( "#datepicker" ).datepicker({
            dateFormat: 'mm/dd/yy',
            minDate:new Date(),
            maxDate:moment().add(1, 'M').format('MM/DD/YYYY'),
            beforeShowDay: unavailable
            }).attr('readonly','readonly');
    });
}
    $scope.select = function(date) {
        $scope.dt_date=moment(date).format("MM-DD-YYYY");
    };
    $('#datepicker').change(function() {
        $scope.dt_date=$('#datepicker').val();
        $scope.dt_date=new Date($scope.dt_date);
        $scope.dt_date=moment($scope.dt_date).format("MM-DD-YYYY");

        $http.get("GetScheduleTime/"+$scope.dt_date+"/"+$scope.doctor_id+"/"+$scope.branch_id).then
        (function(response){
            $scope.schedule_time=response.data;
            $scope.times=response.data.schedule;
            $scope.times.sort(compare);


        });
    });




    $scope.fromSubmit=function(){


        $http.get("PatientAppointmentInfo/"+$scope.dt_date+"/"+$scope.contact_no+"/"+$scope.branch_id).then
        (function(response){
            $scope.inform=response.data.patient;
        })

    }

    $scope.valueGetId=function(patient_pId,first_name,last_name,contact_no){
        $scope.patient_id=patient_pId;
        $scope.first_name=first_name;
        $scope.last_name=last_name;
        $scope.mobile_no=contact_no;
    }

    function compare(a,b) {
        var now = new Date();
        var time1 = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " "+ a.interval;
        var time2 = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " "+ b.interval;
        var startDate = new Date(time1);
        var toDate = new Date(time2);
        var res = (toDate > startDate);
        if(res){
            return -1
        }else{
            return 1
        }

        return 0;
    }

    $scope.submitt=function(){
        var appoinment={
              name:$scope.first_name+""+$scope.last_name,
              patient_pid:$scope.patient_id,
              branch_id:$scope.branch_id,
              doctor_id:$scope.doctor_id,
              time:$scope.time,
              contact_no:$scope.mobile_no,
              dov:$scope.dt_date
        }
        $http.post("AddAppointment",appoinment).then
        (function(response){
            $scope.ap_status=response.data.status;
            if($scope.ap_status){
                location.href="AddAppointment";
            }
        })
    }

});
