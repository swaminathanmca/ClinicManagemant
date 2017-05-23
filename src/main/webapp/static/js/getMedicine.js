/**
 * Created by Lissomsoft on 04/27/17.
 */


app.controller('GetMedicine',function($scope,$http,$window){
    $scope.role=$window.sessionStorage.role_name;
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



    $http.get("ViewMedicine").
        then(function (response, status, headers, config) {
            $scope.data = response.data.medicines;
        });

$scope.addMedicine=function(){
    location.href="AddMedicine";
}

    $scope.Edit=function(id){
        $scope.medicine_id=id;
        $http.get("MedicineDetails/"+$scope.medicine_id).
            then(function(response,status,headers,config){
               $scope.medicine=response.data;
                $scope.mtype=$scope.medicine.type.toString();
            });


    }

    $scope.submit=function(id){
        $scope.medicine_id=id;
        var satDate = new Date($scope.medicine.mfg_date);
        var endDate = new Date($scope.medicine.exp_date);

        var medicine={
            medicine_id:$scope.medicine_id,
            medicine_name:$scope.medicine.medicine_name,
            mfg_date: satDate.getFullYear() + '-' + (satDate.getMonth() + 1) + '-' + satDate.getDate(),
            exp_date:endDate.getFullYear() + '-' + (endDate.getMonth() + 1) + '-' + endDate.getDate(),
            type:$scope.mtype,
            vendor:$scope.medicine.vendor
        }
        $http.post('EditMedicine',medicine).
            then(function (response,status,headers,config){
                location.href="GetMedicine";
            });
    }
});