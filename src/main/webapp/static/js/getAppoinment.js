/**
 * Created by Lissomsoft on 07/05/17.
 */
app.controller('getAppoinment',function($scope,$window,$http,$interval) {
    $scope.patient_pid=$window.sessionStorage.patient_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.clinic_id=$window.sessionStorage.clinic_id;
    $scope.date = new Date();
    $scope.date=moment($scope.date).format("MM-DD-YYYY");

    $http.get("ViewAppoinment/"+$scope.branch_id+"/"+$scope.date).then
    (function(response){
        $scope.details=response.data.appoinments;
        $scope.details.sort(compare);

    })
    var getDate=function(){
        $http.get("ViewAppoinment/"+$scope.branch_id+"/"+$scope.date).then
        (function(response){
            $scope.details=response.data.appoinments;
            $scope.details.sort(compare);

        })
    }
    $interval(getDate, 5000);

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
        $http.get("UpdateScheduleStatus/"+$scope.st_status+"/"+$scope.apoinment_id).then
        (function(response){
            $scope.st=response.data;
        })
    }

});