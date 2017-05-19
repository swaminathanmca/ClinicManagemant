<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2017
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="patientReport">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.css" rel="stylesheet">
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
            <a href="DoctorDashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Complaint<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddComplaint">Add Complaint</a>
              </li>
              <li>
                <a href="ViewComplaint">View Complaint</a>
              </li>
            </ul>
          <li>
            <a href="patientHistory"><i class="fa fa-history fa-fw"></i>Patient History</a>
          </li>
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
      <div class="col-lg-12">
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
                <div class="col-lg-3">
                  <div class="input-group">
                    <span class="input-group-addon">Start Date</span>
                    <input type="text" class="form-control" name="mfg_date" placeholder="mm-dd-yyyy" ng-click="open1($event)" datepicker-popup="{{format}}" ng-model="from_date" max-date="date"  is-open="opened1" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open1($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>

                  </div>
                        <span class="text-danger wrapper text-center ng-binding"
                              ng-show="myform.mfg_date.$invalid">Please Enter MFG Date </span>
                </div>
                <div class="col-lg-3">
                  <div class="input-group">
                    <span class="input-group-addon">End DATE</span>
                    <input type="text" class="form-control" name="exp_date" placeholder="mm-dd-yyyy" ng-click="open2($event)" datepicker-popup="{{format}}" ng-model="to_date"  min-date="from_date"  is-open="opened2" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open2($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>

                  </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform.exp_date.$invalid">Please Enter EXP Date </span>
                </div>
                <div class="col-lg-1">
                  <img ng-click="fromSubmit()"  src="<%=request.getContextPath()%>/static/img/search.png" style="width: 20px;height: 20px;margin-left: 11px; margin-top: 10px;" class="ng-pristine ng-untouched ng-valid">
                </div>
                <div class="col-lg-3">
                  <div class="input-group">
                    <span class="input-group-addon">Months</span>
                    <SELECT class="form-control" ng-change="submit(pmonths)" ng-model="pmonths">
                      <OPTION VALUE="1">3 Months</OPTION>
                      <OPTION VALUE="2">6 Months</OPTION>
                      <OPTION VALUE="3">12 Months</OPTION>
                    </SELECT>
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
                              <th>Patient Pid</th>
                              <th>Patient Name </th>
                              <th>Date</th>
                              <th>Complaints</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr dir-paginate="x in report | filter:search | orderBy : first_name | itemsPerPage :5">
                              <td>{{x.patient_pid}}</td>
                              <td>{{x.first_name}}&nbsp;{{x.last_name}}</td>
                              <td>{{x.created_at}}</td>
                              <td>{{x.referal_details}}</td>
                            </tr>
                            </tbody>
                            </table>
                            <p class="text-center">
                              <dir-pagination-controls max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls>
                            </p>


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
      <div class="col-lg-1"></div>
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
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/patientReport.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>



</body>
</html>