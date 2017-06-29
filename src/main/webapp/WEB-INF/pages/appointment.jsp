<html ng-app="myApp" ng-controller="appointment">
<head>
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
          rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/css/timepicker.less" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/js-custom-select/style.css" rel="stylesheet">

    <%-- <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">--%>

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
                                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()"
                                      novalidate>
                                    <fieldset>

                                        <div class="form-group">

                                            <div class="col-lg-4">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Date</span>
                                                    <input type="text" class="form-control" name="dob"
                                                           placeholder="mm-dd-yyyy" ng-click="open1($event)"
                                                           datepicker-popup="{{format}}" ng-model="dob"
                                                           is-open="opened1" datepicker-options="dateOptions"
                                                           close-text="Close" style="height: 37px" disabled="disabled"/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open1($event)" style="height: 37px"><i
                        class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                                                </div>

                                            </div>

                                            <div class="col-lg-4">
                                                <input type="text" ng-model="contact_no" class="form-control"
                                                       placeholder="Search">
                                            </div>
                                            <div class="col-lg-1">
                                                <img ng-click="fromSubmit()"
                                                     src="<%=request.getContextPath()%>/static/img/search.png"
                                                     style="width: 20px;height: 20px;margin-left: -20px; margin-top: 10px;"
                                                     class="ng-pristine ng-untouched ng-valid">
                                            </div>
                                            <div class="col-lg-2">
                                                <input type="button" class="btn btn-primary" value="Add Appoinment"
                                                       data-toggle="modal" data-target="#myModal"
                                                       style="background-color: #ffffff;color: #333">
                                            </div>

                                        </div>

                                        <div class="row" ng-if="data.length">
                                            <div class="col-lg-12">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered">
                                                        <thead>
                                                        <tr class="success">
                                                            <th>No</th>
                                                            <th>Name</th>
                                                            <th>Address</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr ng-repeat="x in data | filter:search | orderBy : first_name">

                                                            <td>{{$index+1}}</td>
                                                            <td class="und_ref"><a ng-click="addAppointment(x.patient_id)">{{x.first_name}}&nbsp;{{x.last_name}}</a>
                                                            </td>
                                                            <td>{{x.address1}},{{x.address2}}</td>

                                                        </tr>
                                                        </tbody>

                                                    </table>
                                                </div>
                                            </div>
                                        </div>

                                        <div ng-show="y.status">
                                            <div class="form-group">
                                                <div class="col-lg-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Name</span>
                                                        <label class="form-control" type="text">{{y.first_name}}</label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Doctor</span>

                                                        <div name="doctor_id"
                                                             custom-select="d.doctor_id as d.profile_name for d in doctors | filter: { profile_name: $searchTerm }"
                                                             ng-model="doctor_id" required>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-lg-4">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Date</span>
                                                        <input type="text" class="form-control" name="exp_date"
                                                               placeholder="mm-dd-yyyy" ng-click="open2($event)"
                                                               datepicker-popup="{{format}}" ng-model="app_date"
                                                               min-date="date" is-open="opened2"
                                                               datepicker-options="dateOptions" close-text="Close"
                                                               style="height: 37px" disabled="disabled" required/>
                             <span class="input-group-btn">
                               <button type="button" class="btn btn-default" ng-click="open2($event)"
                                       style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                             </span>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="form-actions">
                                                <div class="row">
                                                    <div class="col-lg-offset-4 col-lg-7">
                                                        <button type="submit" class="btn btn-success"
                                                                ng-disabled="myform.$invalid "
                                                                ng-click="submitted=true">Save
                                                        </button>
                                                        <button type="button" class="btn btn-inverse">Cancel</button>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>


    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header panel-primary">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New Patient Appointment</h4>
                </div>
                <div class="modal-body">


                    <form role="form" class="form-horizontal" name="myform1" ng-submit="submitt()">
                        <fieldset>
                            <div class="form-group">

                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">First Name</span>
                                        <input class="form-control" placeholder="First name" name="first_name" type="text"
                                               ng-model="first_name" required>
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform1.first_name.$invalid &&  myform1.first_name.$touched">Please Enter First Name</span>
                                </div>

                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">Last Name</span>
                                        <input class="form-control" placeholder="Last name" name="last_name" type="text"
                                               ng-model="last_name" required>
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform1.last_name.$invalid &&  myform1.last_name.$touched">Please Enter Last Name</span>
                                </div>

                            </div>

                            <div class="form-group">
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Doctor</span>

                                        <div name="doctor_id"
                                             custom-select="d.doctor_id as d.profile_name for d in doctors | filter: { profile_name: $searchTerm }"
                                             ng-model="doctor_id" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Dob</span>
                                        <input type="text" class="form-control" name="dob" placeholder="mm-dd-yyyy"
                                               ng-click="open1($event)" datepicker-popup="{{format}}" ng-model="datee"
                                               is-open="opened1" datepicker-options="dateOptions" close-text="Close"
                                               style="height: 37px" disabled="disabled"/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open1($event)" style="height: 37px"><i
                        class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Mobile No</span>
                                        <input class="form-control" placeholder="Mobile No" name="mobile_no" type="text"
                                               ng-model="mobile_no">
                                    </div>
                                    <span class="text-danger wrapper text-center ng-binding"
                                          ng-show="myform1.mobile_no.$invalid &&  myform1.mobile_no.$touched">Please Enter Mobile No</span>
                                </div>
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Res No</span>
                                        <input class="form-control" placeholder="Res No" name="res_no" type="text"
                                               ng-model="res_no">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">Email</span>
                                        <input class="form-control" placeholder="Email" name="email" type="text"
                                               ng-model="email">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">Address1</span>
                                        <input class="form-control" name="address1" type="text" ng-model="address1">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">Address2</span>
                                        <input class="form-control" name="address2" type="text" ng-model="address2">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">City</span>
                                        <input class="form-control" name="city" type="text" ng-model="city">
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">State</span>
                                        <input class="form-control" name="state" type="text" ng-model="state">
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">Country</span>
                                        <select class="form-control bfh-countries"   ng-model="country" name="country" ></select>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">Pin code</span>
                                        <input class="form-control" name="pin_code" type="text" ng-model="pin_code"
                                               maxlength="6"
                                               ng-pattern="/^[0-9]*$/">
                                    </div>
                                </div>

                            </div>


                            <div class="form-group"></div>

                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-lg-offset-4 col-lg-7">
                                        <button type="submit" class="btn btn-success"
                                                ng-disabled="myform1.$invalid " ng-click="submitted=true">Save
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

</div>


</div>


<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
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
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>


</body>
</html>
