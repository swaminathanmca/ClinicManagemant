/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('patientDetails',function($scope,$window,$http){

$http.get("patientDetails/"+$window.sessionStorage.patient_id).
    then(function(response,status,headers,config){
       /* $('#countries1').bfhcountries({country: $scope.data.country})
        $('#countries2').bfhcountries({country:$scope.data.emr_country})*/
        $scope.data=response.data;

        $('#countries1').bfhcountries({country: $scope.data.country})
        $('#countries2').bfhcountries({country: $scope.data.emr_country})
    });


});