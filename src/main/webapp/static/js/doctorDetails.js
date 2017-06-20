/**
 * Created by Lissomsoft on 3/21/2017.
 */

app.controller('doctorDetails',function($scope,$window,$http){
    $scope.branch_name=[];
    $scope.branchList=[];
    var obj;
    var spec;
    $scope.role=$window.sessionStorage.role_name;
    $scope.email= $window.sessionStorage.email;
    $scope.chiefEmail="Taken";
    $scope.chiefError="Already Taken";
    $http.get("doctorDetails/"+$window.sessionStorage.profile_id)
        .then(function(response){
            $scope.data=response.data.branch;
            $('#countries1').bfhcountries({country: $scope.data.country})
            $scope.branches=$scope.data.branches;
            $scope.speciality=$scope.data.specialization;

        })

    $scope.editUser=function(id){
        $scope.profile_id=id;
        $http.get("doctorDetails/"+$scope.profile_id)
            .then(function(response,status){
                $scope.x=response.data.branch;
                $scope.selectedList=$scope.x.branches;
                $scope.selectSpecialization=$scope.x.specialization;
                var result=$scope.selectedList;

                $('#countries2').bfhcountries({country: $scope.data.country})

                $http.get("ViewBranch/"+$scope.x.clinic_id)
                        .then(function(response){
                        $scope.branch=response.data.branch;
                        /* for(var i=0;i<result.length;i++){
                            var obj={
                                branch_id: result[i].branch_id,
                                branch_name:result[i].branch_name,
                                address1:result[i].address1,
                                address2:result[i].address2,
                                contact_no:result[i].contact_no,
                                description:result[i].description
                            }

                            var index = $scope.selectedList.indexOf(obj);

                            $scope.branch.splice(index,1);
                            console.log("dfsafdsa",$scope.branch);
                        }*/

                    })

                $http.get("GetSpeciality")
                    .then(function(response){
                        $scope.specialitydetails=response.data.speciality;
                    })
            })
    }

    $scope.afterRemoveItem = function(item){
        obj1 = {
            branch_id: item.branch_id,
            branch_name:item.branch_name,
            address1:item.address1,
            address2:item.address2,
            contact_no:item.contact_no,
            description:item.description
        };


    }


    $scope.afterSelectItem = function(item){

        obj2 = {
            branch_id: item.branch_id,
            branch_name:item.branch_name,
            address1:item.address1,
            address2:item.address2,
            contact_no:item.contact_no,
            description:item.description
        };
        if ($scope.selectedList.indexOf(item) == -1) {
            $scope.selectedList.push(obj2);}
    }
    $scope.afterremoveItem = function(item){
        spec={
            speciallity_id : item.speciality_id,
            speciality_name: item.speciality_name,
            description:item.description
        };


    }
    $scope.afterselectItem=function(item){

        spec={
            speciallity_id : item.speciality_id,
            speciality_name: item.speciality_name,
            description:item.description
        };

        if($scope.selectSpecialization.indexOf(item)== -1){
            $scope.selectSpecialization.push(spec);
        }

    }


    $scope.EditChiefContact=function(id,contact_no){
        $scope.chief_id=id;
        $scope.cihef_contactno=contact_no;
        $http.get("EditChiefContact/"+$scope.chief_id+"/"+$scope.cihef_contactno).
            then(function(response,status,error){
                $scope.err=response.data.status;

                if($scope.err==false){
                    $scope.chiefError="";
                }else{
                    $scope.chiefError="Already Taken";
                }
            })
    }

    $scope.EditCemail=function(id,email_id){
        $scope.chief_id=id;
        $scope.email_id=email_id;
        $http.get("EditChiefEmail/"+$scope.chief_id+"/"+$scope.email_id).
            then(function(response,status,error){
                $scope.err_chief_email=response.data.status;
                console.log($scope.err_chief_email);
                if($scope.err_chief_email==false){
                    $scope.chiefEmail="";
                }else{
                    $scope.chiefEmail="Taken";
                }
            })
    }

    $scope.submit=function(){
        $scope.country=$('#countries2').val();
       var doctor={
           firstname:$scope.x.name,
           gender:$scope.x.gender,
           reg_no:$scope.x.reg_id,
           qualification:$scope.x.qualification,
           specialization:$scope.selectSpecialization,
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
           branch:$scope.selectedList,
           doctor_id:$scope.x.doctor_id,
           charge:$scope.x.charges
       }
        $http.post("EditDoctor",doctor).
            then(function(response,status,header,config){
                $scope.status=response.data;
                location.href="doctorDetail";
            })

    }
})