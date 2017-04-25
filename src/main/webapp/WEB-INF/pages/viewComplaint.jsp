<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/17/2017
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="ViewComplaint">
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
            <a href="DoctorDashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Complaint<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddComplaint">Add Complaint</a>
              </li>
              <li>
                <a href="ViewComplaint">View Complaint</a>
              </li>
            </ul>
          </li>
          <li>
            <a href="patientHistory"><i class="fa fa-history fa-fw"></i> Patient History</a>
          </li>
        </ul>
      </div>

    </div>

  </nav>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h4 class="page-header">Complaint Details</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <button type="button" class="btn btn-primary" ng-click="addComplaint()">Add Complaint</button>
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
                      <th>Complaint </th>
                      <th>Description</th>
                      <th>Options</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr dir-paginate="x in complaint | filter:search | orderBy : clinicName | itemsPerPage :5" >
                      <td>{{x.complaint_name}}</td>
                      <td>{{x.complaint_description}}</td>
                      <td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal" ng-click="Edit(x.complaint_id)"> Edit</button></td>



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

    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">

        <div class="modal-content">
          <div class="modal-header panel-primary">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Edit Complaint</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-lg-12">
                <form role="form" class="form-horizontal" name="myform"  ng-submit="submit(data.complaint_id)">
                  <fieldset>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon"> Complaint</span>
                          <input type="text" class="form-control" ng-model="data.complaint_name" name="complaint_name" required>
                        </div>
                        <span class="text-danger wrapper text-center ng-binding"
                              ng-show="myform.complaint_name.$invalid && myform.complaint_name.$touched">Please Enter Complaint
                        </span>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Description</span>
                          <textarea type="textarea" class="form-control" ng-model="data.complaint_description" name="description">
                          </textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-actions">
                      <div class="row">
                        <div class="col-lg-offset-4 col-lg-7">
                          <button type="submit" class="btn btn-success"
                                  ng-disabled="myform.$invalid " ng-click="submitted=true">Save
                          </button>
                          <button type="button" class="btn btn-inverse" data-dismiss="modal">Cancel</button>

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
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/viewComplaint.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>

</body>
</html>