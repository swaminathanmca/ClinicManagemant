<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/20/2017
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<div id="wrapper">

  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0px">
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
          <li ng-show="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-hospital-o"></i> Clinic<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="Dashboard">Add CLinic</a>
              </li>
              <li>
                <a href="GetClinic">View Clinic</a>
              </li>
            </ul>

          </li>
          <li ng-show="role=='Admin'">
            <a href="#"><i class="fa fa-table fa-fw"></i> Branch<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddBranch">Add Branch</a>
              </li>
              <li>
                <a href="GetBranch">View Branch</a>
              </li>
            </ul>
          </li>

          <li ng-hide="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-user-md"></i> Doctor<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddDoctor">Add Doctor</a>
              </li>
              <li>
                <a href="#">View Doctor</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
          </li>
          <li>
            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
          </li>
          <li>
            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
          </li>


        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>





</div>







<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
