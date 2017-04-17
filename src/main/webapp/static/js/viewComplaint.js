/**
 * Created by Admin on 4/17/2017.
 */
app.controller('ViewComplaint', function ($scope, $http, $window){
    $http.get("GetComplaint")
        .then(function (response) {
            $scope.Complaint = response.data.Complaint;
        });


    $scope.Edit=function(id){
        $http.get("ComplaintDetail/"+id)
            .then(function (response){
                $scope.data=response.data;
            })
    }

    $scope.addSpeciality=function(){
        location.href="Addcomplaint";
    }

    $scope.submit=function(id){
        var speciality={
            Complaint:$scope.data.Complaint,
            description:$scope.data.description
        }
        $http.post('EditComplaint/'+id,speciality)
            .then(function(response,headers,config,status){
                $scope.status=response.data.status;
                location.href="ViewComplaint";
            })

    }
});