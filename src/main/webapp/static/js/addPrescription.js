/**
 * Created by Lissomsoft on 04/28/17.
 */
app.controller('Prescription',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;

    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })


    $scope.typepres=function(id){
        $scope.type=id;
      $http.get("PrescriptionType/"+$scope.type).
          then(function (response, status, headers, config) {
              $scope.medicines=response.data.medicines;

          })
    }



    $scope.submit=function(){

        var prescription={

        }

    }

});