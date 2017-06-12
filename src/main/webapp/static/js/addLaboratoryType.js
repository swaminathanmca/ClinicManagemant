/**
 * Created by Lissomsoft on 05/22/17.
 */
app.controller('AddLaboratoryType',function($scope,$http,$window,$timeout){



    $scope.submit=function(){
        var laboratory={
            test_type:$scope.test_type,
            test_name:$scope.test_name,
            description:$scope.description
        }
        $http.post("AddLaboratory",laboratory).
            then(function(response,status,headers,config){
                $scope.data = response.data;
                console.log(status);
                location.href="ViewLaboratory";
            })
    }


    $scope.back=function(){
        location.href="ViewLaboratory";
    }
});