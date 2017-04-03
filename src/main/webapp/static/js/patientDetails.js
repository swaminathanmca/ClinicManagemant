/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('patientDetails',function($scope,$window,$http){

$http.get("patientDetails/"+$window.sessionStorage.patient_id).
    then(function(response,status,headers,config){

        $scope.data=response.data;
    });


});