<html ng-app="myApp" ng-controller="appointment">
<head>
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
          rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/static/vendor/js-custom-select/style.css" rel="stylesheet">



    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>

<div id="wrapper" id="loader">

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="../Clinic/static/img/logo.png" width="30" height="30"></a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">


            <li class="dropdown ">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/Clinic"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>

            </li>


        </ul>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i><span class="fa arrow"></span> Patient </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddPatient">Add Patient</a>
                            </li>
                            <li>
                                <a href="GetPatient">View Patient</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="ViewPatientVisit"><i class="fa fa-heartbeat"></i>&nbsp;PatientVisit </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-medkit"></i>&nbsp;Medicine<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddMedicine"> Add Medicine</a>
                            </li>
                            <li>
                                <a href="GetMedicine">View Medicine</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-phone"></i>&nbsp; Appointment<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddAppointment"> Add Appointment</a>
                            </li>
                            <li>
                                <a href="ViewAppointment">View Appoinment</a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="page-wrapper">

        <br>

        <div class="row">
            <div class="col-lg-12">

            </div>
        </div>


        <div class="col-lg-1"></div>


        <div class="row">
            <div class="col-lg-10">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="panel-title">Appointments</p>
                            </div>
                        </div>
                    </div>

                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="col-lg-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Doctor</span>
                                                        <div name="doctor_id"
                                                             custom-select="d.doctor_id as d.profile_name for d in doctors | filter: { profile_name: $searchTerm }"
                                                             ng-model="doctor_id" ng-change="doctorschedule(doctor_id); disabled(date, mode);" required>
                                                        </div>
                                                    </div>
                                                </div>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                        <span class="input-group-addon">Date</span>

                                                            <input type="text" id="datepicker" class="form-control">
                                                        </div>

                                                    </div>
                                            </div>
                                <div class="form-group">
                                </div>
                                <div class="form-group">
                                                    <div class="col-lg-12" >
                                                        <p ng-repeat="time in times" class="tag">&nbsp;&nbsp;
                                                        <span ng-if="!($index%8)"> <br/> &nbsp;&nbsp;</span>
                                                        <button type="button"   class="{{(time.booked==1) ? 'btn btn-info fs12 ':(time.booked==0) ? 'btn btn-danger fs12 ':'btn btn-grey fs12 '}}" ng-click="schedule(time.interval,time.booked,time.appoinment_id)" ><i class="fa fa-clock-o"></i> {{time.interval}}<br>{{time.name}}</button>
                                                        </p>
                                                    </div>
                                            </div>








                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <%--  <div class="row">
            <div class="col-lg-1"></div>
           <div class="col-lg-10">
               <div class="alert alert-success" role="alert" ng-if="appoinment_details.status">
                   <div class="row">
                       <div class="col-lg-3">
                           <strong>Patient Name</strong><br>
                           <strong>{{appoinment_details.name}}<br>Tel:{{appoinment_details.contact_no}} </strong>
                       </div>

                       <div class="col-lg-3">
                           <h5><b>APPOINTMENT</b></h5>
                           <p>{{appoinment_details.dov}}</p>
                           <p>{{appoinment_details.time}}</p>
                       </div>
                       <div class="col-lg-3">
                           <h5><b>CARE PROVIDER</b></h5>
                           <p>DR.{{appoinment_details.doctor_name}}</p>
                       </div>
                       <div class="col-lg-3" ng-if="appoinment_details.type==1">
                           <span class="label label-default">Cancelled</span>
                       </div>
                       <div class="col-lg-3" ng-if="appoinment_details.type==2">
                           <span class="label label-success">Arrival</span>
                       </div>
                   </div>
               </div>
               </div>
            </div>--%>

        <div class="col-lg-1"></div>
    </div>
<div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header panel-primary">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">  Appointment Detail</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" name="myform4" >

                    <div class="form-group">
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon">Patient Name</span>
                                <label class="form-control">{{appoinment_details.name}}</label>
                                </div>
                            </div>
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon">Phone No</span>
                                <label class="form-control">{{appoinment_details.contact_no}}</label>
                                </div>
                            </div>
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon"> Date</span>
                                <label class="form-control">{{appoinment_details.dov}}</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon">Time</span>
                                <label class="form-control">{{appoinment_details.time}}</label>
                                </div>
                            </div>
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon">Doctor Name</span>
                                <label class="form-control">{{appoinment_details.doctor_name}}</label>
                                </div>
                            </div>
                        <div class="col-lg-4">
                            <div class="input-group">
                                <span class="input-group-addon">Type</span>
                                <label class="form-control" ng-if="appoinment_details.type==1">New</label>
                                <label class="form-control" ng-if="appoinment_details.type==0">Existing</label>
                                </div>
                            </div>
                    </div>

                    </form>

                </div>

        </div>
    </div>

    </div>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header panel-primary">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New Patient Appointment</h4>
                </div>
                <div class="modal-body">
                    <form role="form" class="form-horizontal" name="myform1" >
                            <div class="form-group">
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Appoinment Date</span>
                                        <label class="form-control">{{dt_date}}</label>
                                    </div>
                                  </div>
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon"> Time</span>
                                        <label class="form-control">{{time}}</label>
                                    </div>
                                </div>
                                <div class="col-lg-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">Type</span>
                                        <div class="checkbox pb10 fileRadioBox form-control">
                                            <label>
                                                <input type="radio" name="type"  value="1"   ng-model="type" ng-click="newpatient()" required>New
                                            </label>

                                            <label>
                                                <input type="radio" name="type" value="0"  ng-model="type"  required>
                                                Existing
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                </div>
                            <div class="form-group" ng-if="type==0">
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <input class="form-control" name="search" placeholder="Enter The Phone No" ng-model="contact_no">
                                        <span class="input-group-addon" ng-click="fromSubmit(contact_no)" ><i class="fa fa-search"></i> </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group" ng-if="inform.length > 0">
                                <div class="col-lg-12" >
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                            <tr class="success">
                                                <th>Patient Pid</th>
                                                <th>Patient Name </th>
                                                <th>Contact No</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr ng-repeat="x in inform">
                                                <td ><a ng-click="valueGetId(x.patient_id,x.first_name,x.last_name,x.contact_no)" class="und_ref"> {{x.patient_pId}}</a></td>
                                                <td>{{x.first_name}}&nbsp;{{x.last_name}}</td>
                                                <td>{{x.contact_no}}</td>

                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                    </form>
                    <form role="form" class="form-horizontal" name="myform" ng-submit="submit()" >
                        <fieldset>
                            <div class="form-group" >
                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">First Name</span>
                                        <input class="form-control" placeholder="First name" name="first_name" type="text"
                                               ng-model="first_name" required>
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform.first_name.$invalid &&  myform.first_name.$touched">Please Enter First Name</span>
                                </div>
                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">Last Name</span>
                                        <input class="form-control" placeholder="Last name" name="last_name" type="text"
                                               ng-model="last_name" required>
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform.last_name.$invalid &&  myform.last_name.$touched">Please Enter Last Name</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Mobile No</span>
                                        <input class="form-control" placeholder="Mobile No" name="mobile_no" type="text"
                                               ng-model="mobile_no" required>
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform.mobile_no.$invalid &&  myform.mobile_no.$touched">Please Enter Mobile No</span>
                                </div>

                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-lg-offset-4 col-lg-7">
                                        <button type="submit" class="btn btn-success"
                                                ng-disabled="myform1.$invalid || myform.$invalid" ng-click="submitted=true">Save
                                        </button>
                                        <button type="button" class="btn btn-inverse" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <div class="modal fade" id="myModal1" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4>Schedule Already Booked.</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal2" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4>Schedule Time Expires.</h4>
                </div>
            </div>
        </div>
    </div>

</div>


</div>


<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addAppointment.js"></script>


<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>


</body>
</html>
