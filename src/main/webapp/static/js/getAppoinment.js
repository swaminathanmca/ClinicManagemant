/**
 * Created by Lissomsoft on 07/05/17.
 */
app.controller('getAppoinment',function($scope,$window,$http,$interval) {
    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.date = new Date();
    $scope.date=moment($scope.date).format("MM-DD-YYYY");

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
    $scope.doctors=[];
    $scope.dob = moment().format("MM/DD/YYYY");

    $scope.my_date = moment();


    /*$http.get("ViewAppoinment/"+$scope.branch_id+"/"+$scope.date).then
    (function(response){
        $scope.details=response.data.appoinments;
        $scope.details.sort(compare);

    })*/

    $http.get("ViewDoctorBranch/" + $scope.branch_id)
        .then(function(respone){
            var user={doctor_id:"ALL",profile_name:"ALL"}
            $scope.doctors=respone.data.user;
            $scope.doctors.push(user);

        });

$scope.doctorschedule=function(id){

    if(id=="ALL"){
        $("#datepicker").datepicker("destroy");
        $("#datepicker").datepicker({

        }).attr('readonly','readonly');

    }else{
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
                if ($.inArray(dmy, unavailableDates) != -1) {
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


}

    var getDate=function(){
        $http.get("ViewAppoinment/"+$scope.branch_id+"/"+$scope.date+"/"+$scope.doctor_id).then
        (function(response){
            $scope.details=response.data.appoinments;
            $scope.details.sort(compare);

        })
    }
    $('#datepicker').change(function() {
        $scope.dt_date=$('#datepicker').val();
        $scope.dt_date=new Date($scope.dt_date);
        $scope.dt_date=moment($scope.dt_date).format("MM-DD-YYYY");

        $http.get("ViewAppoinmentDoctor/"+$scope.branch_id+"/"+$scope.dt_date+"/"+$scope.doctor_id).then
        (function(response){
            $scope.details=response.data.appoinments;
            $scope.details.sort(compare);

        })

    });
   /* $interval(getDate, 5000);*/

    function compare(a,b) {
        var now = new Date();
        var time1 = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " "+ a.time;
        var time2 = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " "+ b.time;
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

    $scope.showarrival=function(id,patient_pid,type,doctor_id,doctor_name){
        $scope.apoinment_id=id;
        $window.sessionStorage.patient_id=patient_pid;
        $window.sessionStorage.doctor_id=doctor_id;
        $window.sessionStorage.doctor_name=doctor_name;
        $scope.st_status=2;
        $http.post("UpdateScheduleStatus/"+$scope.st_status+"/"+$scope.apoinment_id).then
           (function(response){
               $scope.st=response.data.status;
               if($scope.st){
                  if(type==0){
                            location.href="AppoinmentVisit"
                  }else{
                      location.href="AddPatient";
                  }
               }

           })

    }

    $scope.deletearrival=function(id,patient_pid){
        $scope.apoinment_id=id;
        $scope.patient_pid=patient_pid;
        $scope.st_status=1;
        console.log($scope.adate);
        $http.post("UpdateScheduleStatus/"+$scope.st_status+"/"+$scope.apoinment_id).then
        (function(response){
            $scope.st=response.data;
            if(response.data.status){
                $http.get("ViewAppoinmentDoctor/"+$scope.branch_id+"/"+$scope.adate+"/"+$scope.doctor_id).then
                (function(response){
                    $scope.details=response.data.appoinments;
                    $scope.details.sort(compare);
                })
            }

        })
    }

    $scope.getDoctor=function(adate){
        $scope.adate=moment(adate).format("MM-DD-YYYY");
        $http.get("ViewAppoinmentDoctor/"+$scope.branch_id+"/"+$scope.adate+"/"+$scope.doctor_id).then
        (function(response){
            $scope.details=response.data.appoinments;
            $scope.details.sort(compare);
        })
    }


});