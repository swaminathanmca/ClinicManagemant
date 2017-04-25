  <%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/9/2017
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="patientVisit">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.css">
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
    <div class="row">
      <div class="col-lg-1"></div>
      <div class="col-lg-10">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title"> Patient Visit</h3>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()"
                      novalidate>
                  <fieldset>

                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">
                            Patient Id
                          </span>
                        <label class="form-control" type="text" name="patient_id" >{{data.patient_pid}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">
                             Name
                          </span>
                          <label class="form-control" type="text" name="name" >{{data.first_name}}&nbsp;{{data.last_name}}</label>
                        </div>
                      </div>

                    </div>

                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">
                            Speciality
                          </span>
                          <select class="form-control" ng-options="s.speciallity_id as s.speciality_name for s in specialitydetails" ng-model="speciallity_id" ng-change="doctor(speciallity_id)" name="speciality" required></select>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">
                            Practitioner
                          </span>
                          <select class="form-control" ng-options="s.doctor_id as s.profile_name for s in profile" ng-model="doctor_id" name="doctor" required></select>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                        <span class="input-group-addon">Height</span>
                        <input type="text" class="form-control" ng-model="height" name="height" maxlength="3"  ng-pattern="/^[0-9]*$/" required>
                          <span class="input-group-addon">CM</span>
                        </div>
                         <span class="text-danger wrapper text-center ng-binding"
                               ng-show="myform.height.$error.pattern">Please Enter Valid Height</span>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Weight</span>
                          <input type="text" class="form-control" ng-model="weight" name="weight" maxlength="3"  ng-pattern="/^[0-9]*$/" required>
                          <span class="input-group-addon">KG</span>
                        </div>
                         <span class="text-danger wrapper text-center ng-binding"
                               ng-show="myform.weight.$error.pattern">Please Enter Valid Weight</span>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">BP</span>
                          <input type="text" class="form-control" ng-model="pressure" name="pressure"  ng-pattern="/^[0-9]*$/" required>
                        </div>
                          <span class="text-danger wrapper text-center ng-binding"
                                ng-show="myform.pressure.$error.pattern">Please Enter Valid Pressure</span>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">
                             Type
                          </span>
                          <select class="form-control" ng-model="vtype" name="vtype" required>
                            <option value="0">Normal </option>
                            <option value="1">Emergency</option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Referal Details</span>
                          <textarea type="text" class="form-control" ng-model="rdetails" name="rdetails"  required></textarea>
                        </div>
                      </div>
                    </div>

                    <div class="form-actions">
                      <div class="row">
                        <div class="col-lg-offset-4 col-lg-7">
                          <button type="submit" class="btn btn-success"
                                  ng-disabled="myform.$invalid " ng-click="submitted=true">Save
                          </button>
                          <button type="button" class="btn btn-inverse">Cancel</button>
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
  </div>
  </div>



<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/patientVisit.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script>

</script>
</body>
</html>
