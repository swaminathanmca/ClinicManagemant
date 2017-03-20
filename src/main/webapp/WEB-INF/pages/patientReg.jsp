<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/9/2017
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">
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
            <a href="AddBranch"><i class="fa fa-table fa-fw"></i> Branch</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> User<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddUser">Add User</a>
              </li>
              <li>
                <a href="#">View User</a>
              </li>
            </ul>

          </li>
          <li>
            <a href="AddPatient"><i class="fa fa-table fa-fw"></i> Patient </a>
          </li>
          <li>
            <a href="#"><i class="fa fa-edit fa-fw"></i> Forms</a>
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
      <div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Patient Registration</h3>
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
                <span class="input-group-addon">First Name</span>
                <input type="text" class="form-control" placeholder="Enter The First Name" ng-model="first_name">
              </div>
            </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Last Name</span>
                  <input type="text" class="form-control" placeholder="Enter The last Name" ng-model="last_name">
                </div>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Gender</span>
                  <div class="radio  fileRadioBox form-control">&nbsp;
                    <label>
                      <input type="radio" name="sex" value="1" ng-model="patient.gender" required="" class="ng-pristine ng-untouched ng-valid ng-valid-required" checked>&nbsp;Male
                    </label>
                    <label>
                      <input type="radio" name="sex" value="0" ng-model="patient.gender" required="" class="ng-pristine ng-untouched ng-valid ng-valid-required ">&nbsp;Female
                    </label>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Marital Status</span>
                  <select class="form-control">
                    <option value="1">Married</option>
                    <option value="0">Single</option>
                  </select>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Blood Group</span>
                  <select class="form-control">
                    <option value="1">A</option>
                    <option value="0">AB</option>
                    <option value="2">B</option>
                    <option value="3">O</option>
                  </select>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">RH(D) Factor</span>
                  <select class="form-control">
                    <option value="1">POSITIVE</option>
                    <option value="0">NEGATIVE</option>

                  </select>
                </div>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="bfh-datepicker "  data-max="today"  ng-mpdel="">
                  </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Patient Category</span>
                  <select class="form-control" ">
                    <option value="1">Normal</option>
                    <option value="0">Urgent</option>
                  </select>
                </div>
              </div>

                <div class="col-lg-6">
                  <div class="input-group">
                    <span class="input-group-addon">Address1</span>
                    <input type="text" class="form-control" ng-model="address1" name="address1">
                  </div>
                </div>

            </div>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address2</span>
                  <input type="text" class="form-control" ng-model="address2" name="address2">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">City</span>
                  <input type="text" class="form-control" ng-model="city" name="city">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">State</span>
                  <input type="text" class="form-control" ng-model="state" name="state">
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Country</span>

                  <select class="form-control bfh-countries" data-country="IN" ></select>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Pin Code</span>
                  <input type="text" class="form-control" ng-model="pin_code"  name="pin_code">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Mobile No</span>
                  <input class="form-control" type="text" ui-mask="999-999-9999" name="mobile_no" ng-model="mobile_no">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Res No</span>
                  <input class="form-control" type="text" ui-mask="999-999-9999" name="res_no" ng-model="res_no">
                </div>
              </div>
            </div>

            <hr>
            <h4>Emergency  Contact Details</h4>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Name</span>
                  <input class="form-control" type="text" ng-model="emr_name" name="emr_name">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Relation with Patient</span>
                  <input class="form-control" type="text" ng-model="relation" name="relation">
                </div>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address2</span>
                  <input type="text" class="form-control" name="address2" ng-model="emr_address2">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address1</span>
                  <input type="text" class="form-control" name="emr_address1" ng-model="emr_address1">
                </div>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">City</span>
                  <input type="text" class="form-control" ng-model="emr_city" name="emr_city">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">State</span>
                  <input type="text" class="form-control" ng-model="emr_state" name="emr_state">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Country</span>
                  <select class="form-control bfh-countries" data-country="IN" ></select>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">PinCode</span>
                  <input type="text" class="form-control" ng-model="emr_pin_code" name="emr_pin_code">
                </div>
              </div>
            </div>
          <div class="form-group">
            <div class="col-lg-3">
              <div class="input-group">
                <span class="input-group-addon">Mobile No</span>
                <input type="text" class="form-control" ui-mask="999-999-9999" name="emr_mobile_no" ng-model="emr_mobile_no">
              </div>
            </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Res No</span>
                  <input type="text" class="form-control" ui-mask="999-999-9999" name="emr_res_no" ng-model="emr_res_no">
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
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
