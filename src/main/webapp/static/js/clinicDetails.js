/**
 * Created by Admin on 3/2/2017.
 */

app.controller('clinicDetails',function($scope,$window,$http){

    $scope.name="name";

    $http.get("ViewDetails/"+$window.sessionStorage.clinic_id).
        then(function(response,status,error,headers, config){
            $scope.x=response.data.clinic;
            $scope.clinic=response.data.clinic;

            $('#countries1').bfhcountries({country:$scope.clinic.country});
            $('#countries3').bfhcountries({country:$scope.clinic.country})
            $('#countries2').bfhcountries({country:$scope.clinic.chief_country});
            $('#countries4').bfhcountries({country:$scope.clinic.chief_country});
        })



    $scope.EditName=function(id,name){
        $scope.clinic_id=id;
        $scope.clinic_name=name;
       $http.get("EditName/"+$scope.clinic_id+"/"+$scope.clinic_name).
           then(function(response,status,error,headers,config){
               $scope.err_name=response.data.status;
               if($scope.err_name==false){
                   $scope.name="";
               }else{
                   $scope.name="name";
               }
           })
    }




});