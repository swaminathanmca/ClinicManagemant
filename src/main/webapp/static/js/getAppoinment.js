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

    var getDate=function(){
        $http.get("ViewAppoinment/"+$scope.branch_id+"/"+$scope.date).then
        (function(response){
            $scope.details=response.data.appoinments;
            $scope.details.sort(compare);

        })
    }

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

    $scope.showarrival=function(id,patient_pid){
        $scope.apoinment_id=id;
        $window.sessionStorage.patient_id=patient_pid;
        $scope.st_status=2;
       if($scope.patient_pid==null){
           $http.post("UpdateScheduleStatus/"+$scope.st_status+"/"+$scope.apoinment_id).then
           (function(response){
               $scope.st=response.data.status;
               if($scope.st){
                   location.href="PatientVisit";
               }

           })
       }else{
           $http.post("UpdateScheduleStatus/"+$scope.st_status+"/"+$scope.apoinment_id).then
           (function(response){
               $scope.st=response.data.status;
               if($scope.st){
                   location.href="PatientVisit";
               }

           })}

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