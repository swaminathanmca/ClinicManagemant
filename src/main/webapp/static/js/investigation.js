/**
 * Created by Lissomsoft on 05/05/17.
 */

app.controller('Investigation',function($scope,$http,$window){

    $scope.visit_id=$window.sessionStorage.visit_id;
    $scope.branch_id= $window.sessionStorage.branch_id;
    $scope.doctor_id=$window.sessionStorage.doctor_id;
    $scope.info_id=$window.sessionStorage.patient_info_id;

    $scope.laboratory= $window.sessionStorage.lab;
    $scope.prescription= $window.sessionStorage.prescription;
    $scope.none = $window.sessionStorage.none;
    $scope.selectedList=[];
    $scope.services=[];
    $scope.totamt="";
    var obj;
    $http.get("GetComplaint/"+$scope.visit_id)
        .then(function (response){
            $scope.patientcomplaint = response.data.patientcomplaint;

        })

    $http.get("DoctorDetailCharges/"+$scope.doctor_id).
        then(function (response){
            $scope.charges=response.data.charges;
            $scope.camount=$scope.charges;
            $scope.totamt=$scope.camount;
        })

    $http.get("GetServices/"+$scope.branch_id).
        then(function (response,status,headers,config){
            var s=response.data.services;
            for(var i in s){
                var sobj={
                    service_id:s[i].service_id,
                    service_name:s[i].service_name,
                    charges:s[i].charges,
                    amount:s[i].charges
                }
                $scope.services.push(sobj);
            }

        })


    $scope.afterSelectItem = function(item)
    {

        obj = {
            service_id: item.service_id,
            service_name:item.service_name,
            charges:item.charges,
            amount:item.amount,
            discount:''
        };
        $scope.selectedList.push(obj);

        $scope.totamt=$scope.totamt+item.charges;
    }
    $scope.afterRemoveItem = function(item){
        $scope.totamt=0;
        $scope.n1=0;
        $scope.n2=0;
        var index = $scope.selectedList.indexOf(item);
        $scope.selectedList.splice(index,1);
       if($scope.selectedList.length){
           var sr=$scope.selectedList;
           for(var j in sr){
               $scope.n1=$scope.camount+sr[j].amount+$scope.n2;
               $scope.n2=sr[j].amount;
           }
           $scope.totamt=$scope.n1;


       }else{
           $scope.totamt=$scope.camount;
       }


    }

    /*$scope.percentage=function(discount,value,name,id,index){

        $scope.dis=discount;
        $scope.chrg=value;
        $scope.name=name;
        $scope.serid=id;
        var dis=(discount/100)*value;
        $scope.amount=value-dis;
        var ser={
            service_id: $scope.serid,
            service_name:$scope.name,
            charges:$scope.chrg,
            amount:dis
        }
        $scope.selectedList.push(index,ser);


    }*/

    $scope.percentage=function(x,discount,index){
        $scope.totamt=0;
        $scope.crg= x.charges;
        $scope.dis=discount;
        $scope.n1=0;
        $scope.n2=0;
       if($scope.dis!=null){
           var amtdis=($scope.dis/100)*$scope.crg;
           $scope.amnt=$scope.crg-amtdis;
           $scope.selectedList[index].amount=$scope.amnt;
           $scope.selectedList[index].discount= $scope.dis;
           var sr=$scope.selectedList;
           for(var j in sr){
               $scope.n1=$scope.camount+sr[j].amount+$scope.n2;
               $scope.n2=sr[j].amount;
           }
           $scope.totamt=$scope.n1;
       }else{
           $scope.amnt=$scope.crg;
           $scope.selectedList[index].amount=$scope.amnt;
           var sr=$scope.selectedList;
           for(var j in sr){
               $scope.n1=$scope.camount+sr[j].amount+$scope.n2;
               $scope.n2=sr[j].amount;
           }
           $scope.totamt=$scope.n1;
       }
    }

    $scope.cpercentage=function(value){
        $scope.cdis=value;
        $scope.totamt=0;
        $scope.n1=0;
        $scope.n2=0;
        var camnt=($scope.cdis/100)*$scope.charges;

        if($scope.cdis!=null) {
            $scope.camount = $scope.charges - camnt;
            if ($scope.selectedList.length){
                var sr = $scope.selectedList;
            for (var j in sr) {
                $scope.n1 = sr[j].amount + $scope.n2;
                $scope.n2 = sr[j].amount;
            }
            $scope.totamt = $scope.n1 + $scope.camount;
        }else{
                $scope.totamt=$scope.camount;
            }
        }else{
            $scope.camount = $scope.charges;
            if ($scope.selectedList.length){
                var sr = $scope.selectedList;
                for (var j in sr) {
                    $scope.n1 = sr[j].amount + $scope.n2;
                    $scope.n2 = sr[j].amount;
                }
                $scope.totamt = $scope.n1 + $scope.camount;
            }else{
                $scope.totamt=$scope.camount;
            }
        }

    }


   $scope.submit=function(){
       var investigation={
                        visit_id:$scope.visit_id,
                        patient_pid:$scope.patientcomplaint.patient_pid,
                        total_amount:$scope.totamt,
                        service_name:'consulting',
                        discount:$scope.cdiscount,
                        charges:$scope.charges,
                        investServices:$scope.selectedList
                    }

            $http.post("AddInvestigation",investigation).
                then(function (response,status,headers,config){
                    $scope.status=response.data.status;
                    if($scope.status){
                        location.href="Invoice";
                    }
                })


     }

    $scope.back=function(){

        if($scope.laboratory==1){
            location.href="PatientTest";
        }else if($scope.prescription==1){
            location.href="AddPrescription";
        }else{
            location.href="EditpatientComplaint";
        }
    }


})