<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 05/05/17
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="Investigation">
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
<div class="col-lg-1"></div>
      <div class="col-lg-10 col-sm-10">
        <h4 class="txtrns"> <a> <i class="fa fa-user"></i></a>&nbsp;&nbsp; {{patientcomplaint.first_name}}&nbsp;{{patientcomplaint.last_name}}&nbsp;&nbsp;&nbsp;&nbsp; <span ng-if="patientcomplaint.gender==1">Male</span> <span ng-if="patientcomplaint.gender==0">Female</span>,{{patientcomplaint.age}} &nbsp;&nbsp;<span>(ID:{{patientcomplaint.patient_pid}})</span> </h4>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-1  col-lg-1"></div>
      <div class="col-sm-10 col-lg-10 ">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <div class="row">
              <div class="col-lg-2">
                <p class="panel-title">Investigation</p>
              </div>
              <div class="col-lg-9"></div>
              <div class="col-lg-1">
                <button type="button" class="btn btn-primary" ng-click="back()">Back</button>
              </div>
            </div>
          </div>
          <br>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12 col-sm-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()" novalidate>
                  <fieldset>
<%--                  <div class="form-group">
                    <div class="col-lg-6 col-sm-6">
                      <div class="input-group">
                        <span class="input-group-addon">Patient Id</span>
                        <label type="text" class="form-control" >{{patientcomplaint.patient_pid}} </label>
                      </div>
                    </div>
                    <div class="col-lg-6 col-sm-6">
                      <div class="input-group">
                        <span class="input-group-addon">Patient Name</span>
                        <label type="text" class="form-control" >{{patientcomplaint.first_name}}&nbsp;{{patientcomplaint.last_name}} </label>
                      </div>
                    </div>
                  </div>--%>
                    <div class="form-group">
                     <%-- <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon"> Consulting Charges </span>
                          <label class="form-control" type="text" >{{charges}}</label>
                        </div>
                      </div>--%>
                      <div class="col-lg-6 col-sm-6">
                        <div class="input-group">
                          <span class="input-group-addon">Services</span>
                          <multiple-autocomplete ng-model="selectedlist"  name="multipleselect"
                                                 object-property="service_name"
                                                 after-select-item="afterSelectItem"
                                                 after-remove-item="afterRemoveItem"

                                                 suggestions-arr="services">
                          </multiple-autocomplete>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-4 col-sm-4">
                        <div class="input-group">
                          <span class="input-group-addon">ServiceName</span>
                          <label class="form-control" type="text">Consulting</label>
                        </div>
                      </div>

                      <div class="col-lg-3 col-sm-3">
                        <div class="input-group">
                          <span class="input-group-addon">Charges</span>
                          <label class="form-control" type="text">{{charges}}</label>
                        </div>
                      </div>
                      <div class="col-lg-3 col-sm-3">
                        <div class="input-group">
                          <span class="input-group-addon">Discount</span>
                          <input type="number" class="form-control" name="discount"  min="0"  max="100" ng-model="cdiscount" ng-blur="cpercentage(cdiscount)" ng-pattern="/^[0-9]*$/" maxlength="3" />
                          <span class="input-group-addon">%</span>
                        </div>

                        <span class="text-danger wrapper text-center ng-binding ng-hide" ng-show="myform.discount.$error.max || myform.discount.$error.min">Please Enter Valid No </span>

                      </div>
                      <div class="col-lg-2 col-sm-2">
                        <div class="input-group">
                          <span class="input-group-addon">Rs</span>

                          <label class="form-control" type="text">{{camount}}</label>

                        </div>
                      </div>
                    </div>


                    <div class="form-group" ng-repeat="x in selectedList" ng-if="selectedList.length">
                      <div class="col-lg-4 col-sm-4">
                  <div class="input-group">
                    <span class="input-group-addon">ServiceName</span>
                    <label class="form-control" type="text">{{x.service_name}}</label>
                  </div>
                      </div>
                      <div class="col-lg-3 col-sm-3">
                        <div class="input-group">
                          <span class="input-group-addon">Charges</span>
                          <label class="form-control" type="text">{{x.charges}}</label>
                        </div>
                      </div>
                      <div class="col-lg-3 col-sm-3">
                        <div class="input-group">
                          <span class="input-group-addon">Discount</span>
                          <input type="number" class="form-control" name="cdis" ng-model="discount" min="0"  max="100" ng-blur="percentage(x,discount,$index)" maxlength="3">
                          <span class="input-group-addon">%</span>
                        </div>
                        <span class="text-danger wrapper text-center ng-binding" ng-show=" myform.cdis.$error.min || myform.cdis.$error.max" >Please Enter Valid No</span>

                      </div>
                      <div class="col-lg-2 col-sm-2">
                        <div class="input-group">
                          <span class="input-group-addon">Rs</span>

                          <label class="form-control" type="text">{{x.amount}}</label>

                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-9 col-sm-9"></div>

                      <div class="col-lg-3 col-sm-3">
                        <div class="input-group">
                          <span class="input-group-addon">Total </span>
                          <label type="text" class="form-control">{{totamt}}</label>

                        </div>
                      </div>
                    </div>
                    <div class="form-action">
                      <div class="row">
                        <div class="col-lg-offset-4 col-lg-7">
                          <button type="submit" class="btn btn-success"
                                  ng-disabled="myform.$invalid   " ng-click="submitted=true">Add
                          </button>
                          <button type="button" class="btn btn-inverse" data-dismiss="modal">
                            Cancel
                          </button>
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
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addPrescription.js"></script>
<script src="<%=request.getContextPath()%>/static/js/investigation.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>
