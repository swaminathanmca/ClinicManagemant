app.controller('viewSpeciality', function ($scope, $http, $window){
    $http.get("GetSpeciality")
        .then(function (response) {
            $scope.speciality = response.data.speciality;
        });


    $scope.Edit=function(id){
        $http.get("SpecialityDetail/"+id)
            .then(function (response){
                $scope.data=response.data;
            })
    }

    $scope.addSpeciality=function(){
        location.href="AddSpeciality";
    }

    $scope.submit=function(id){
        var speciality={
            speciality_name:$scope.data.speciality_name,
            description:$scope.data.description
        }
        $http.post('EditSpeciality/'+id,speciality)
            .then(function(response,headers,config,status){
                $scope.status=response.data.status;
                location.href="ViewSpeciality";
            })

    }
});