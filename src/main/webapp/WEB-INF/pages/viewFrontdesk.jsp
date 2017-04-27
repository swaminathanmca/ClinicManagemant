<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/20/2017
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="getFrontdesk">
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
                <a href="ViewDoctor">View Doctor</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
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



        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>


  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h4 class="page-header">FrontDesk Details</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <div class="row">
              <div class="col-lg-3">
                <button class="btn btn-primary" type="button" ng-click="addFrontDesk()" ng-if="role=='BranchAdmin'">Add FrontDesk</button>
                <select class="form-control" name="branch_id"  ng-options="s.branch_id as s.branch_name for s in branchDetails" ng-change="frontDesk(branch_iid)" ng-model="branch_iid" ng-if="role=='Admin'"></select>
              </div>
              <div class="col-lg-6">

              </div>
              <div class="col-lg-3">
                <label class="input-group pull-right" style="width: 180px">
                  <span class="input-group-addon glyphicon glyphicon-search" style="top:0px;"></span>
                  <input type="text" ng-model="search" class="input-group  form-control" placeholder="Search">
                </label>
              </div>
            </div>


          </div>

          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                    <tr class="success">
                      <th>FrontDesk Name</th>
                      <th>E-Mail</th>
                      <th>Contact</th>
                      <th>Address</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr dir-paginate="x in data | filter:search | orderBy : clinicName | itemsPerPage :5"  ng-click="editFrontDesk(x.profile_id)">
                      <td>{{x.name}}</td>
                      <td>{{x.email_id}}</td>
                      <td>{{x.contact_no}}</td>
                      <td>{{x.address1}},{{x.address2}}</td>
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
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addUser.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getDoctor.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getFrontdesk.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>
