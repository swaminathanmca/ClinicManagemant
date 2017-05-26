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
    $scope.Edit=function(id){
        $scope.test_id=id;
        $http.get("GetLaboratoryId/"+$scope.test_id)
            .then(function(response){
                $scope.data=response.data;
            })
    }

    $scope.submit=function(id){
        $scope.test_id=id;
        var laboratory={
            test_id:$scope.test_id,
            test_type:$scope.data.test_type,
            test_name:$scope.data.test_name,
            description:$scope.data.description
        }


        $http.post("EditLaboratoryId",laboratory).
            then(function(response){
                $scope.status=response.data.status;
                if
                ($scope.status){
                    location.href="ViewLaboratory";
                }

            })
    }
});