/**
 * Created by Lissomsoft on 05/06/17.
 */

app.controller('getServices',function($scope,$http,$window){

    $scope.email= $window.sessionStorage.email;
    $scope.role=$window.sessionStorage.role_name;

    $http.get("GetServices").
        then(function (response,status,headers,config){

            $scope.services=response.data.services;
        })


    $scope.Edit=function(id){
        $scope.service_id=id;
        $http.get("ServiceDetails/"+$scope.service_id).
            then(function (response,status,headers,config){
                $scope.data=response.data;
            })
    }


    $scope.addservices=function(){
        location.href="AddService";
    }

    $scope.submit=function(id){
        $scope.service_id=id;

        var service={
            service_id:$scope.service_id,
            service_name:$scope.data.service_name,
            description:$scope.data.description,
            charges:$scope.data.charges
        }

        $http.post("EditService",service).
            then(function (response,status,headers,config){
                $scope.status = response.data.status;

                if($scope.status){
                    location.href="ViewService";
                }
            });
    }

});