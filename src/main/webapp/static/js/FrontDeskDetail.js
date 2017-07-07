/**
 * Created by Admin on 3/22/2017.
 */
/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('frontdeskdetail',function($scope,$window,$http){

    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;

    $http.get("trackSession/" + $scope.email)
        .then(function (response, status, headers, config) {
            $scope.trackdata = response.data;
            $scope.clinic_name=$scope.trackdata.clinic_name;
            $scope.branch_name=$scope.trackdata.branch_name;
        });


    $http.get("frontdeskDetails/"+$window.sessionStorage.profile_id)
        .then(function(response){
            $scope.data=response.data.frontdesk;
            $('#countries1').bfhcountries({country: $scope.data.country})
        })

    $scope.editUser=function(id){
        $scope.profile_id=id;
        $http.get("frontdeskDetails/"+$scope.profile_id)
            .then(function(response,status){
                $scope.x=response.data.frontdesk;
                $('#countries2').bfhcountries({country: $scope.data.country})

                $http.get("ViewBranch/"+$scope.x.clinic_id)
                    .then(function(response){
                        $scope.branch=response.data.branch;

                    })

            })


    }



    $scope.submit=function(){

        $scope.country=$('#countries2').val();
        var doctor={

            firstname:$scope.x.name,
            gender:$scope.x.gender,
            reg_no:$scope.x.reg_id,
            qualification:$scope.x.qualification,
            specialization:$scope.x.specialization,
            address1:$scope.x.address1,
            address2:$scope.x.address2,
            city:$scope.x.city,
            state:$scope.x.state,
            country:$scope.country,
            pincode:$scope.x.pincode,
            contact_no:$scope.x.phone,
            email_id:$scope.x.email,
            password:$scope.x.password,
            clinic_id:$scope.x.clinic_id,
            profile_id:$scope.x.profile_id,
            branch_id:$scope.x.branch_id,
            doctor_id:$scope.x.doctor_id
        }

        $http.post("EditFrontDesk",doctor).
            then(function(response,status,header,config){
                $scope.status=response.data;
                location.href="FrontDeskDetail";
            })

    }
})