/**
 * Created by Lissomsoft on 04/26/17.
 */
app.controller('Medicine',function($scope,$http,$window){
    $scope.date = new Date();
    $scope.role=$window.sessionStorage.role_name;
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

    $scope.submit=function(){
        var satDate = new Date($scope.from_date);
        var endDate = new Date($scope.to_date);

        var medicine={
            medicine_name:$scope.medicine_name,
            mg:$scope.mg,
            type:$scope.type,
            vendor:$scope.vendor
        }

        $http.post('AddMedicine',medicine).
            then(function (response,status,headers,config){
                    location.href="GetMedicine";
            });

    }




})