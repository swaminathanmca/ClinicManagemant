/**
 * Created by Lissomsoft on 06/14/17.
 */

app.controller('forgotPassword',function($scope,$http,$window){


    $scope.submit=function(){
        $http.get("fPassword/"+$scope.email).
            then(function(response){
                $scope.status=response.data.status;
                if($scope.status==true){
                    $("#myModal").modal();
                }
            })
    }


    $scope.submitModel=function(){
        location.href="Login";
    }

});