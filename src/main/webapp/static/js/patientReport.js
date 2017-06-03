/**
 * Created by Lissomsoft on 05/19/17.
 */

app.controller('patientReport',function($scope,$http,$window){
    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.patient_pid=$window.sessionStorage.patient_pid;
    $scope.type=$window.sessionStorage.type;


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

    $scope.from_date = moment().format("MM-DD-YYYY");

    $scope.my_date = moment();

    $scope.to_date = moment().add(7, 'days').format("MM-DD-YYYY");
    $scope.back=function(){
        /*if($scope.type==0){
            location.href="patientComplaints";
        }else{
            location.href="PatientFollowup";
        }*/
        location.href="patientComplaints";
    }


    $scope.fromSubmit=function(){
        $scope.from_date = moment($scope.from_date).format("YYYY-MMM-DD");
        $scope.to_date = moment($scope.to_date).format("YYYY-MMM-DD");


        $http.get("GetPatientInfoReport/"+$scope.patient_pid+"/"+$scope.from_date+"/"+$scope.to_date+"/"+$scope.doctor_id+"/"+$scope.branch_id)
            .then(function(response){
                $scope.report=response.data.report;
            })

    }

    $scope.submit=function(pmonths){
        if(pmonths==1){
            $scope.date1 = new Date();
            $scope.date1.setMonth($scope.date1.getMonth()-3);
            $scope.date1=moment($scope.date1).format("YYYY-MM-DD");
        }else if(pmonths==2){
            $scope.date1 = new Date();
            $scope.date1.setMonth($scope.date1.getMonth()-6);
            $scope.date1=moment($scope.date1).format("YYYY-MM-DD");
        }else if(pmonths==3){
            $scope.date1 = new Date();
            $scope.date1.setMonth($scope.date1.getMonth()-12);
            $scope.date1=moment($scope.date1).format("YYYY-MM-DD");
        }

        $http.get("GetPatientReportByMonths/"+$scope.patient_pid+"/"+$scope.date1+"/"+$scope.doctor_id+"/"+$scope.branch_id)
            .then(function(response){
                $scope.report=response.data.report;

            })
    }

$scope.editInfo=function(id){
    $window.sessionStorage.patient_info_id=id;
    location.href="DetailsReport";

}



});