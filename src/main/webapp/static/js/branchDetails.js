/**
 * Created by Lissomsoft on 3/15/2017.
 */
app.controller('branchdetails',function($scope,$window,$http){
console.log($window.sessionStorage.branch_id);
    $scope.role=$window.sessionStorage.role_name;
$http.get("BranchDetails/"+$window.sessionStorage.branch_id).
    then(function(response,status,headers,config){
        $scope.branch=response.data.branch;
        $('#countries1').bfhcountries({country:$scope.branch.country});

        $('#countries2').bfhcountries({country:$scope.branch.chief_country});
    });


    $scope.editUser=function(id){

        $scope.branch_id=$window.sessionStorage.branch_id;

        $http.get("BranchDetails/"+ $scope.branch_id).
            then(function(response,status,headers,config){
                $scope.x=response.data.branch;
                $('#countries3').bfhcountries({country:$scope.branch.country});

                $('#countries4').bfhcountries({country:$scope.branch.chief_country});
            });
    }


    $scope.submit=function(id){
        $scope.branch_id=id;
        $scope.country=$('#countries3').val();
        $scope.chief_country=$('#countries4').val();

        var ClinicUser={
            branch_id:$scope.x.branch_id,
            branch_name:$scope.x.branch_name,
            address1:$scope.x.address1,
            address2:$scope.x.address2,
            city:$scope.x.city,
            state:$scope.x.state,
            country:$scope.country,
            pin_code:$scope.x.pin_code,
            email_id:$scope.x.email_id,
            contact_no:$scope.x.contact_no,
            password:$scope.x.password,
            description:$scope.x.description,
            chief_id:$scope.x.Chief_id,
            chief_name:$scope.x.Chief,
            chief_address1:$scope.x.Chief_address1,
            chief_address2:$scope.x.Chief_address2,
            chief_city:$scope.x.Chief_city,
            chief_state:$scope.x.Chief_state,
            chief_country:$scope.chief_country,
            chief_contact_no:$scope.x.Chief_conatct_no,
            chief_email_id:$scope.x.Chief_email_id,
            chief_pin_code:$scope.x.Chief_pincode,
            gender:$scope.x.Chief_gender
        }

        $http.post("EditBranch",ClinicUser).
            then(function (response,status,headers,config){
                $scope.data = response.data;


        });



    }

});