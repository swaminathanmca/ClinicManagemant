<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 04/25/17
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="Medicine">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
</head>
<body>
<div id="wrapper">

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
          <li  ng-show="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Clinic<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="Dashboard">Add Clinic</a>
              </li>
              <li>
                <a href="GetClinic">View Clinic</a>
              </li>
            </ul>

          </li>
          <li  ng-show="role=='SuperAdmin'">
            <a href="AdminBranch"><i class="fa fa-table fa-fw"></i>  Branch</a>
          </li>


          <li  ng-show="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-child "></i>&nbsp;Speciality<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddSpeciality"> Add Speciality</a>
              </li>
              <li>
                <a href="ViewSpeciality">View Speciality</a>
              </li>
            </ul>
          </li>
          <li ng-show="role=='FrontDesk'">
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
          <li ng-show="role=='FrontDesk'">
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
          <li ng-show="role=='FrontDesk'">
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


<%--          <li  ng-show="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-ambulance"></i>&nbsp;Services<span class="fa arrow"></span> </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddService"> Add Service</a>
              </li>
              <li>
                <a href="ViewService">View Service</a>
              </li>
            </ul>
          </li>--%>
          <li ng-show="role=='SuperAdmin'">
            <a href="#">
              <i class="fa fa-thermometer-full"></i>&nbsp;Laboratory<span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddLaboratory">Add Laboratory</a>
              </li>
              <li>
                <a href="ViewLaboratory">View Laboratory</a>
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
      <div class="col-lg-2"></div>
      <div class="col-lg-8" ng-hide="role=='SuperAdmin'">
        <h4 class="page-header"> {{clinic_name}} Hospital  <span></span> (Branch : &nbsp;{{branch_name}})</h4>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-2"></div>
      <div class="col-lg-8">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Add Medicine</h3>
          </div>

          <div class="panel-body">

            <div class="col-lg-12">
              <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()"
                    novalidate>

                <fieldset>
                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">
                          Medicine Name
                        </span>
                        <input class="form-control"  name="medicine_name" ng-model="medicine_name" type="text" required>

                      </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform.medicine_name.$invalid &&  myform.medicine_name.$touched">Please Enter Medicine </span>
                    </div>
                   <%-- <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">MFG DATE</span>
                        <input type="text" class="form-control" name="mfg_date" placeholder="mm-dd-yyyy" ng-click="open1($event)" datepicker-popup="{{format}}" ng-model="from_date" max-date="date"  is-open="opened1" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open1($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                        &lt;%&ndash;<input type="text" class="form-control">&ndash;%&gt;
                      </div>
                        <span class="text-danger wrapper text-center ng-binding"
                              ng-show="myform.mfg_date.$invalid">Please Enter MFG Date </span>
                    </div>--%>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">TYPE</span>
                        <SELECT class="form-control" name="type" ng-model="type" required>
                          <option value="1">Tablet</option>
                          <option value="2">Syrup</option>
                          <option value="3">Injection</option>
                        </SELECT>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.type.$invalid &&  myform.type.$touched">Please Enter Type </span>
                    </div>
                  </div>
               <%--   <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">EXP DATE</span>
                        <input type="text" class="form-control" name="exp_date" placeholder="mm-dd-yyyy" ng-click="open2($event)" datepicker-popup="{{format}}" ng-model="to_date"  min-date="from_date"  is-open="opened2" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open2($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                        &lt;%&ndash;<input type="text" class="form-control">&ndash;%&gt;
                      </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform.exp_date.$invalid">Please Enter EXP Date </span>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">TYPE</span>
                        <SELECT class="form-control" name="type" ng-model="type" required>
                          <option value="1">Tablet</option>
                          <option value="1">Syrup</option>

                        </SELECT>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.type.$invalid &&  myform.type.$touched">Please Enter Type </span>
                    </div>

                  </div>--%>
                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Vendor</span>
                        <input class="form-control" type="text" name="vendor" ng-model="vendor" required>
                      </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform.vendor.$invalid &&  myform.vendor.$touched">Please Enter Vendor </span>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">
                          MG
                        </span>
                        <input class="form-control" type="text" name="mg" ng-model="mg" required>

                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.mg.$invalid &&  myform.mg.$touched" >Please Enter MG </span>
                    </div>
                  </div>

                <div class="form-actions">
                  <div class="row">
                    <div class="col-lg-offset-4 col-lg-7">
                      <button type="submit" class="btn btn-success"
                              ng-disabled="myform.$invalid"  ng-click="submitted=true">Save
                      </button>
                      <button type="button" class="btn btn-inverse" ng-click="cancel()">Cancel</button>
                    </div>
                  </div>
                </div>
                </fieldset>
              </form>
            </div>
          </div>

        </div>
      </div>
      <div class="col-lg-2"></div>
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
<script src="<%=request.getContextPath()%>/static/js/addMedicine.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
