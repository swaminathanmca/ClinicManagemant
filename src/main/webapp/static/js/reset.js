/**
 * Created by Lissomsoft on 06/14/17.
 */
app.controller('resetPassword',function($scope,$http,$window){

  var url=window.location.href;
  var token=[];
  token=url.split("=");
  $scope.password_token=token[1];

  $scope.submit=function(){

if($scope.password==$scope.repassword){
  $http.post("ResetPassword/"+$scope.password_token+"/"+$scope.password).
      then(function(response){
        $scope.status=response.data.status;
        if($scope.status==true){
          $("#myModal").modal();
        }

      })
}else{
  $scope.equals=false;
}
  }

$scope.submitModel=function(){
  location.href="Login";
}


});