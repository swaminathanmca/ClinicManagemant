<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2017
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<html ng-app="myApp" ng-controller="getAppoinment">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/css/timepicker.less" rel="stylesheet">
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
              <li>
                <a href="ViewAppointment"> View Appointment</a>
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
            <h3 class="panel-title"> View Appointment</h3>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-4">
                <div class="input-group">
                  <span class="input-group-addon">Branch</span>
                  <select class="form-control" name="doctor_name" ng-model="doctor_id" ng-options=" d.doctor_id as d.profile_name  for d in doctors"></select>
                </div>

              </div>
              <div class="col-lg-4">
                <div class="input-group">
                  <span class="input-group-addon">Date</span>
                  <input type="text" class="form-control" name="mfg_date" placeholder="mm-dd-yyyy" ng-click="open1($event)" datepicker-popup="{{format}}" ng-model="adate" min-date="date"  is-open="opened1" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" ng-change="getDoctor(adate)"  required/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open1($event)" style="height: 37px" ><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                </div>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-lg-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform" novalidate>
                  <fieldset>

                    <div class="alert alert-success" role="alert" dir-paginate="x in details | orderBy : time | itemsPerPage :3">
                      <div class="row">
                        <div class="col-lg-3">
                          <a href="#" class="alert-link">{{x.name}}<br>{{x.contact_no}} </a>
                        </div>

                        <div class="col-lg-3">
                          <h6>APPOINMENTS</h6>
                          <p>{{x.date}}</p>
                          <p>{{x.time}}</p>
                        </div>
                        <div class="col-lg-3">
                          <h6>CARE PROVIDER</h6>
                          <p>DR.{{x.doctor_name}}</p>
                        </div>
                        <div class="col-lg-3" ng-if="x.flag==0">
                             <button type="button" class="btn btn-info" ng-click="showarrival(x.appoinment_id,x.patient_pid)">Mark Arrival</button>
                            <button type="button" class="btn btn-black" ng-click="deletearrival(x.appoinment_id,x.patient_pid)">Cancel</button>
                        </div>
                        <div class="col-lg-3" ng-if="x.flag==1">
                          <span class="label label-default">Cancelled</span>
                        </div>
                        <div class="col-lg-3" ng-if="x.flag==2">
                          <span class="label label-success">Arrival</span>
                        </div>

                      </div>


                    </div>
                    <p class=" text-center">
                      <dir-pagination-controls max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls>
                    </p>

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
<script src="<%=request.getContextPath()%>/static/js/getAppoinment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>


</body>
</html>
