/**
 * Created by Admin on 4/7/2017.
 */
app.controller('addSpeciality',function($scope,$http,$window)
{
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;



    $scope.submit=function(){
        var speciality ={
            speciality_name:$scope.name,
            description:$scope.description
        }

        $http.post('AddSpeciality',speciality).
            then(function (response,status,headers,config){
                    $scope.result=response.data;
                location.href="ViewSpeciality";
            });
    }
})