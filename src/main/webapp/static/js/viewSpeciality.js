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
});