<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 05/12/17
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="AddLaboratoryType">
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
          <li>
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
          <li>
            <a href="AdminBranch"><i class="fa fa-table fa-fw"></i>  Branch</a>
          </li>


          <li>
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
            <a href="#"><i class="fa fa-ambulance"></i>&nbsp;Services<span class="fa arrow"></span> </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddService"> Add Service</a>
              </li>
              <li>
                <a href="ViewService">View Service</a>
              </li>
            </ul>
          </li>
          <li>
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
      <div class="col-lg-12">
      </div>
    </div>

    <div class="row">
      <div class="col-lg-1"></div>
      <div class="col-lg-10">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Add Laboratory</h3>
          </div>
          <div class="panel-body">
            <div class="col-lg-12">

              <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()"
                    novalidate>
                <fieldset>
                    <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Test Type</span>
                        <input type="text" class="form-control" ng-model="test_type" required>
                      </div>

                    </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Test Name</span>
                          <input type="text" class="form-control" ng-model="test_name" required>
                        </div>
                      </div>


                    </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <div class="input-group">
                        <span class="input-group-addon">Description</span>
                        <textarea type="text" class="form-control" ng-model="description" required></textarea>
                      </div>
                    </div>
                  </div>

                  <div class="form-actions">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"
                                ng-disabled="myform.$invalid "    ng-click="submitted=true">Save
                        </button>
                        <button type="button" class="btn btn-inverse" ng-click="back()">Cancel</button>
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






<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addLaboratoryType.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
