<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 05/19/17
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="DetailsReport">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/js-custom-select/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.css" rel="stylesheet">
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
  <br>
  <div class="row">
    <p></p>
  </div>
  <div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <div class="row">
            <div class="col-lg-2">
              <p class="panel-title">Patient Reports</p>
            </div>
            <div class="col-lg-9"></div>
            <div class="col-lg-1">
              <button type="button" class="btn btn-primary" ng-click="back()">Back</button>
            </div>
          </div>
        </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform"  novalidate>
                  <fieldset>
                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Patient Name</span>
                          <label class="form-control" type="text">{{details.first_name}} &nbsp; {{details.last_name}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Patient Id</span>
                          <label class="form-control" type="text">{{details.patient_pid}}</label>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Procedures</span>
                          <textarea type="text" class="form-control" ng-model="details.procedures"  name="procedures" disabled> </textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Diagnosis</span>
                          <textarea type="text" class="form-control"  name="diagonics" ng-model="details.diagonics" disabled> </textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                      <table class="table table-striped" >
                        <thead>
                        <tr>
                          <th>#</th>
                          <th>Medicine Name</th>
                          <th>MG</th>
                          <th>Frequency</th>
                          <th>Morning</th>
                          <th>AfterNoon</th>
                          <th>Night</th>
                          <th>Days</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat=" x in selectedmaster">
                          <td>{{$index + 1}}</td>
                          <td>{{x.medicine_name}}</td>
                          <td>{{x.mg}}</td>
                          <td><p ng-if="x.frequency==0">Before Fasting</p>
                            <p ng-if="x.frequency==1">After  Fasting</p></td>
                          <td><p ng-if="x.mrg_qty==1"><i class="fa fa-check"></i> </p></td>
                          <td><p ng-if="x.aft_qty==1"><i class="fa fa-check"></i> </p></td>
                          <td><p ng-if="x.ngt_qty==1"><i class="fa fa-check"></i> </p></td>
                          <td>{{x.days}}</td>
                        </tr>

                        </tbody>
                      </table>
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
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/invoice.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/detailsReport.js"></script>
<script src="<%=request.getContextPath()%>/static/js/investigation.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>

