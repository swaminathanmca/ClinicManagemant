/**
 * Created by Lissomsoft on 4/3/2017.
 */

app.controller('patientDetails',function($scope,$window,$http){





$http.get("patientDetails/"+$window.sessionStorage.patient_id).
    then(function(response,status,headers,config){
       /* $('#countries1').bfhcountries({country: $scope.data.country})
        $('#countries2').bfhcountries({country:$scope.data.emr_country})*/
        $scope.data=response.data;

        $('#countries1').bfhcountries({country: $scope.data.country})
        $('#countries2').bfhcountries({country: $scope.data.emr_country})
    });



$scope.editUser=function(){

    $http.get("patientDetails/"+$window.sessionStorage.patient_id).
        then(function(response,status,headers,config){
            $scope.x=response.data;
            $('#countries3').bfhcountries({country: $scope.x.country});
            $('#countries4').bfhcountries({country: $scope.x.country});
            $scope.blood_iid=response.data.blood_group;
            $scope.gender=response.data.gender.toString();


        });
    $http.get("BloodGroup")
        .then(function(response,status,headers,config){
            $scope.blood=response.data.blood;

        });

}

    $scope.submit=function(id){
        $scope.id=id;
        console.log(id);
        var patient={


        }
    }





});