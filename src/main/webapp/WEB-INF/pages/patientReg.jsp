<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/9/2017
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="Patient">
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
      <div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Patient Registration</h3>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
        <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit(branch_id)"
              novalidate>
          <fieldset>
            <div class="form-group">
              <div class="col-lg-6">
              <div class="input-group">
                <span class="input-group-addon">First Name</span>
                <input type="text" class="form-control" placeholder="Enter The First Name" ng-model="first_name" name="fname" required>
              </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.fname.$invalid &&  myform.fname.$touched">Please Enter First Name</span>
            </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Last Name</span>
                  <input type="text" class="form-control" placeholder="Enter The Last Name" ng-model="last_name" name="lname" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.lname.$invalid &&  myform.lname.$touched">Please Enter Last Name</span>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Gender</span>
                 <SELECT class="form-control" ng-model="gender" name="gender" required>
                   <option value="1">Male</option>
                   <option value="0">Female</option>
                 </SELECT>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.gender.$invalid &&  myform.gender.$touched">Please Select Gender</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Marital Status</span>
                  <select class="form-control" ng-model="maritalstatus" name="mstatus" required>
                    <option value="1">Married</option>
                    <option value="0">Single</option>
                  </select>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.mstatus.$invalid &&  myform.mstatus.$touched">Please Select Status</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">BloodGroup</span>

                  <select class="form-control" ng-options="s.blood_id as s.blood_type for s in blood" ng-model="blood_id"  name="blood_id" required></select>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.blood_id.$invalid &&  myform.blood_id.$touched">Please Select Blood Group</span>
              </div>


            </div>
            <div class="form-group">
              <div class="col-lg-3">
<div class="input-group">
  <span class="input-group-addon">Dob</span>
  <input type="text" id="datepicker" class="form-control" name="dob" ng-model="dob" required>
</div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.dob.$invalid &&  myform.dob.$touched">Please Enter Dob</span>


                  </div>

              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Email</span>
                 <input  type="email" class="form-control" name="email" ng-model="email_id" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.email.$invalid &&  myform.email.$touched">Please Enter Email-Id</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Mobile No</span>
                  <input class="form-control" type="text" ui-mask="999-999-9999" name="mobile_no" ng-model="mobile_no"  required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.mobile_no.$invalid &&  myform.mobile_no.$touched">Please Enter Mobile No</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Res No</span>
                  <input class="form-control" type="text" ui-mask="999-999-9999" name="res_no" ng-model="res_no" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.res_no.$invalid &&  myform.res_no.$touched">Please Enter Mobile No</span>
              </div>


            </div>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address1</span>
                  <input type="text" class="form-control" ng-model="address1" name="address1"  required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.address1.$invalid &&  myform.address1.$touched">Please Enter Address</span>
              </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address2</span>
                  <input type="text" class="form-control" ng-model="address2" name="pat_address"  required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.pat_address.$invalid &&  myform.pat_address.$touched">Please Enter Address</span>
              </div>

            </div>

            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">City</span>
                  <input type="text" class="form-control" ng-model="city" name="city" ng-model="city" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.city.$invalid &&  myform.city.$touched">Please Enter City</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">State</span>
                  <input type="text" class="form-control" ng-model="state" name="state" ng-model="state" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.state.$invalid &&  myform.state.$touched">Please Enter State</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Country</span>

                  <select class="form-control bfh-countries"   ng-model="country" name="pcountry" required></select>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.pcountry.$invalid &&  myform.pcountry.$touched">Please Enter Country</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Pin Code</span>
                  <input type="text" class="form-control" ng-model="pincode"  name="pin_code" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.pin_code.$invalid &&  myform.pin_code.$touched">Please Enter Country</span>
              </div>

            </div>

            <hr>
            <h4>Emergency  Contact Details</h4>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Name</span>
                  <input class="form-control" type="text" ng-model="emr_name" name="emr_name" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_name.$invalid &&  myform.emr_name.$touched">Please Enter The Name</span>
              </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Relation with Patient</span>
                  <input class="form-control" type="text" ng-model="relation" name="relation" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.relation.$invalid &&  myform.relation.$touched">Please Enter Relation</span>
              </div>

            </div>
            <div class="form-group">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address1</span>
                  <input type="text" class="form-control" name="emr_address1" ng-model="emr_address1" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_address1.$invalid &&  myform.emr_address1.$touched">Please Enter Address</span>
              </div>
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">Address2</span>
                  <input type="text" class="form-control" name="address2" ng-model="emr_address2" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.address2.$invalid &&  myform.address2.$touched">Please Enter Address</span>
              </div>


            </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">City</span>
                  <input type="text" class="form-control" ng-model="emr_city" name="emr_city" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_city.$invalid &&  myform.emr_city.$touched">Please Enter City</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">State</span>
                  <input type="text" class="form-control" ng-model="emr_state" name="emr_state" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_state.$invalid &&  myform.emr_state.$touched">Please Enter State</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Country</span>
                  <select class="form-control bfh-countries"   ng-model="country" name="emr_country" required></select>

                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_country.$invalid &&  myform.emr_country.$touched">Please Enter Country</span>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">PinCode</span>
                  <input type="text" class="form-control" ng-model="emr_pincode" name="emr_pincode" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_pincode.$invalid &&  myform.emr_pincode.$touched">Please Enter Pincode</span>
              </div>
            </div>
          <div class="form-group">
            <div class="col-lg-3">
              <div class="input-group">
                <span class="input-group-addon">Mobile No</span>
                <input type="text" class="form-control" ui-mask="999-999-9999" name="emr_mobile_no" ng-model="emr_mobile_no" required>
              </div>
              <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_mobile_no.$invalid &&  myform.emr_mobile_no.$touched">Please Enter Mobile No</span>
            </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">Res No</span>
                  <input type="text" class="form-control" ui-mask="999-999-9999" name="emr_res_no" ng-model="emr_res_no" required>
                </div>
                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_res_no.$invalid &&  myform.emr_res_no.$touched">Please Enter Contact Number</span>
              </div>
            <div class="col-lg-3">
              <div class="input-group">
                <span class="input-group-addon">Email-Id</span>
                <input  type="text" class="form-control" ng-model="emr_email" name="emr_email" required>
              </div>
              <span class="text-danger wrapper text-center ng-binding" ng-show="myform.emr_email.$invalid &&  myform.emr_email.$touched">Please Enter Email</span>
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
<script src="<%=request.getContextPath()%>/static/js/addPatient.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
