/**
 * Created by Lissomsoft on 04/27/17.
 */


app.controller('GetMedicine',function($scope,$http,$window){

    $http.get("ViewMedicine").
        then(function (response, status, headers, config) {
            $scope.data = response.data.medicines;
        });

$scope.addMedicine=function(){
    location.href="AddMedicine";
}

    $scope.Edit=function(id){

        $http.get("MedicineDetails/"+id).
            then(function(response,status,headers,config){
               $scope.medicine=response.data;
            });


    }
});