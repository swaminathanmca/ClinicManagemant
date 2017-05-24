/**
 * Created by Lissomsoft on 05/24/17.
 */

app.controller('getLaboratory',function($scope,$window,$http){

    $http.get("GetLaboratory")
        .then(function(response){
            $scope.laboratory=response.data.laboratory;
        })
    $scope.addlab=function(){
        location.href="AddLaboratory";
    }
});