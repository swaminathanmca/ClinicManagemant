<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/22/2017
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="getBranch">
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
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Doctor<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddDoctor">Add Doctor</a>
              </li>
              <li>
                <a href="ViewDoctor">View Doctor</a>
              </li>
            </ul>

          </li>
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
            <a href="#"><i class="fa fa-user-o"></i> FrontDesk<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddFrontDesk">Add FrontDesk</a>
              </li>
              <li>
                <a href="ViewFrontDesk">View FrontDesk</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
          </li>
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
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
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
            <a href=""><i class="fa fa-calendar-minus-o"></i>&nbsp;  Schedule <span class="fa arrow"></span> </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddSchedule"> Add Schedule</a>
              </li>
              <li>
                <a href="#">View Schedule</a>
              </li>
            </ul>
          </li>



        </ul>
      </div>

    </div>

  </nav>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h4 class="page-header">{{clinic_name}} Hospital  <span></span> (Branch : &nbsp;{{branch_name}})</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <button type="button" class="btn btn-primary" ng-click="addBranch()">Add Branch</button>
            <label class="input-group pull-right" style="width: 180px">
              <span class="input-group-addon glyphicon glyphicon-search" style="top:0px;"></span>
              <input type="text" ng-model="search" class="input-group  form-control" placeholder="Search">
            </label>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <div class="table-responsive">

                  <table class="table table-striped table-bordered table-hover " id="dataTables-example">
                    <thead>
                    <tr class="success">
                      <th>Branch Name</th>
                      <th>Description</th>
                      <th>Address</th>
                      <th>Contact No</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr dir-paginate="x in branch | filter:search | orderBy : branch_name | itemsPerPage :5"  ng-click="EditBranch(x.branch_id)">
                      <td>{{x.branch_name}}</td>
                      <td>{{x.description}}</td>
                      <td>{{x.address1}},{{x.address2}}</td>
                      <td>{{x.contact_no}}</td>

                    </tr>


                    </tbody>

                  </table>
                  <p class=" text-center">
                    <dir-pagination-controls max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls>
                  </p>
                </div>
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
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addUser.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addBranch.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getBranch.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>

</body>
</html>
