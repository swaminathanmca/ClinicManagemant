app.controller('ViewComplaint', function ($scope, $http, $window){

    $scope.email= $window.sessionStorage.email;
    $http.get("GetComplaint")
        .then(function (response) {
            $scope.complaint = response.data.complaint;

        });

    $http.get("trackSessionBranchDoctor/" + $scope.email).
        then(function (response, status, headers, config,data) {

            $scope.clinic_name = response.data.clinic_name;
        });
    $scope.Edit=function(id){
        $http.get("ComplaintDetail/"+id)
            .then(function (response){
                $scope.data=response.data;
            })
    }

    $scope.addComplaint=function(){
        location.href="AddComplaint";
    }

    $scope.submit=function(id){
        var complaint={
            complaint_name:$scope.data.complaint_name,
            complaint_description:$scope.data.complaint_description
        }
        $http.post('EditComplaint/'+id,complaint)
            .then(function(response,headers,config,status){
                $scope.status=response.data.status;
                location.href="ViewComplaint";
            })

    }
});