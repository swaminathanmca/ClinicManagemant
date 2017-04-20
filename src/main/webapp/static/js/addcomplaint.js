/**
 * Created by Admin on 4/17/2017.
 */
app.controller('AddComplaint',function($scope,$http,$window) {
    $scope.role = $window.sessionStorage.role_name;
    $scope.email = $window.sessionStorage.email;
    $scope.submit=function(){
        var complaint ={
            complaint_name:$scope.name,
            complaint_description:$scope.description
        }

        $http.post('AddComplaint',complaint)
            .then(function (response,status,headers,config){
                $scope.result=response.data;
                location.href="ViewComplaint";
            });
    }
})