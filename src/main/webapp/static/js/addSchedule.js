/**
 * Created by Lissomsoft on 06/20/17.
 */

app.controller('Schedule',function($scope, $http, $window){
    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;
    $scope.branch_id=$window.sessionStorage.branch_id;
    $scope.day_flag=[];
    $scope.con_status=true;

    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_name= $scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;

        });


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

    $scope.from_date = moment().format("MM-DD-YYYY");

    $scope.my_date = moment();
    $scope.dtmax=moment().add(1, 'M').format('MM-DD-YYYY');

    $scope.to_date = moment().add(7, 'days').format("MM-DD-YYYY");
    $scope.toTimeFlag = false;

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;
        });
$scope.getDoctor=function(id){
    $scope.con_status=true;
    $scope.selected="";
    $http.get("ViewDoctorBranch/"+id)
        .then(function(response){
            $scope.profile=response.data.user;
        })
}


    $('.timer').timepicker({
        template: false,
        showInputs: false,
        minuteStep: 5
    });

    $scope.timeValidation = function ()
    {
        $scope.con_status=true;
        var now = new Date();
        var startTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.start_time;
        var toTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.end_time;
        var startDate = new Date(startTime);
        var toDate = new Date(toTime);
        var res = (toDate > startDate);
        if (res)
        {$scope.toTimeFlag = false;} else
        {$scope.toTimeFlag = true;}
    };
    $scope.validate=function(){
        $scope.con_status=true;
            if(typeof $scope.selected.doctor_id === 'number'){
                $scope.validateDoctor = 0;
            }else{
                $scope.validateDoctor = 1;
            }}

    $scope.changes=function(){
        $scope.adays="";
    }




   $scope.submit=function(){
       var now = new Date();
       var startTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.start_time;
       var toTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.end_time;
       var startDate = new Date(startTime);
       var toDate = new Date(toTime);
       var res=(toDate-startDate);
       $scope.duration = moment.duration(res);
       $scope.duration=$scope.duration.hours()+"."+$scope.duration.minutes();


       if($scope.time==0){
           $scope.scount=Math.ceil($scope.duration*4);
       }else if($scope.time==1){
           $scope.scount=Math.ceil($scope.duration*2);
       }else if($scope.time==2){
           $scope.scount=Math.ceil($scope.duration*1);
       }

      var  day_flag={
                day1:$scope.day1,
                day2:$scope.day2,
                day3:$scope.day3,
                day4:$scope.day4,
                day5:$scope.day5,
                day6:$scope.day6,
                day7:$scope.day7
       }

      /* $scope.day_flag.push(day_flag);*/
       var schedule=
       {
           doctor_id:$scope.selected.doctor_id,
           start_date:moment($scope.from_date).format("MM/DD/YYYY"),
           end_date:$scope.end_date,
           start_time:$scope.start_time,
           end_time:$scope.end_time,
           branch_id:$scope.branch_idd,
           day_flag:day_flag,
           end_type:$scope.type,
           no_of_occurenes:$scope.adays,
           time:$scope.time,
           scount:$scope.scount
       }


      $http.post("ValidateSchedule",schedule).
           then(function(response){
          $scope.data=response.data;
              $scope.con_status=$scope.data.status;
              if($scope.data.status==false){
                  $scope.conflict=$scope.data.conflict;
              }else{
                  $http.post("AddSchedule",schedule).
                      then(function(response){
                          $scope.data=response.data;
                          if(response.data.status){
                              location.href="ViewSchedule";
                          }
                      })
              }

          })


   }


});