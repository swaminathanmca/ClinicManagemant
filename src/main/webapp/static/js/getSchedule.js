/**
 * Created by Lissomsoft on 07/08/17.
 */
app.controller('getSchedule',function($scope,$http,$window){
    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;
    $scope.branch_id=$window.sessionStorage.branch_id;

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


    $http.get("trackSession/" + $scope.email).
        then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $window.sessionStorage.clinic_id=response.data.clinic_id;
            $window.sessionStorage.branch_id=response.data.branch_id;
            $scope.clinic_name= $scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;
        });

    $http.get("ViewBranch/"+ $window.sessionStorage.clinic_id)
        .then(function (response){
            $scope.branchDetails=response.data.branch;

        });

$scope.getDoctor=function(id){
    $http.get("ViewDoctorBranch/"+id)
        .then(function(response){
            $scope.profile=response.data.user;
            $scope.schedule="";
        })
}

  $scope.getSchedule=function(id){
    $http.get("GetSchedule/"+id+"/"+$scope.branch_id).then
    (function(response){
        $scope.schedule=response.data.schedule;
    })
}

      $scope.edit=function(id){
                $scope.schedule_id=id;
           $http.get("GetScheduleById/"+id).then
             (function(response){
                   $scope.scheduledetails=response.data;
                 var dat3=new Date($scope.scheduledetails.start_date)

               if(dat3 >= new Date()){
                   $scope.myform.exp_date.$untouched=false;
               }else{
                   $scope.myform.exp_date.$untouched=true;
               }


             })
      }

    $('.timer').timepicker({
        template: false,
        showInputs: false,
        minuteStep: 5
    });
    $scope.changes=function(){
        $scope.adays="";
    }

    $scope.timeValidation = function ()
    {
        $scope.con_status=true;
        var now = new Date();
        var startTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.scheduledetails.start_time;
        var toTime = (now.getMonth()+1) + "/" + now.getDate() + "/" + now.getFullYear() + " " + $scope.scheduledetails.end_time;
        var startDate = new Date(startTime);
        var toDate = new Date(toTime);
        var res = (toDate > startDate);
        if (res)
        {$scope.toTimeFlag = false;} else
        {$scope.toTimeFlag = true;}
    };

$scope.change=function(){
    $scope.myform.exp_date.$untouched=false;
}






});
