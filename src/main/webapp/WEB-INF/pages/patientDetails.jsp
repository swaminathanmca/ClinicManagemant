<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/9/2017
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="patientDetails">
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
            <a href="#"><i class="fa fa-dashboard fa-fw"></i>Dashboard</a>
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
              <h3 class="panel-title">Patient Details</h3>

          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
               <form class="form-horizontal ng-invalid" role="form" name="myform"
                     novalidate>
                 <fieldset>
                   <div class="col-xs-3">
                   </div>
                   <div class="col-xs-1 col-xs-offset-8">
                     <h4><img src="<%=request.getContextPath()%>/static/img/editicon.png" class=" pull-left" data-toggle="modal" data-target="#myModal" style="padding-left: 45px" ng-click="editUser()">
                     </h4>
                   </div>
                   <div class="form-group">
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Patient Id</span>
                         <label class="form-control" type="text">{{data.patient_pid}}</label>
                       </div>
                     </div>
                     <div class="col-lg-6">
                       <div class="input-group">
                         <span class="input-group-addon"> Name</span>
                         <label class="form-control" type="text"> {{data.first_name}} &nbsp;{{data.last_name}}</label>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Blood Group</span>
                         <label class="form-control" type="text" ng-if="data.blood_group==1">A POSITIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==2">A NEGATIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==3">B POSITIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==4">B NEGATIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==5">O POSITIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==6">O NEGATIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==7">AB POSITIVE</label>
                         <label class="form-control" type="text" ng-if="data.blood_group==8">AB NEGATIVE</label>
                       </div>
                     </div>
                     </div>


                   <div class="form-group">
                   <div class="col-lg-3">
                     <div class="input-group">
                       <span class="input-group-addon">Gender</span>
                       <label class="form-control" type="text" ng-if="data.gender==1">Male</label>
                       <label class="form-control" type="text" ng-if="data.gender==0">Female</label>
                     </div>
                   </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Marital Status</span>
                         <label class="form-control" type="text" ng-if="data.mstatus==1">Married</label>
                         <label class="form-control" type="text" ng-if="data.mstatus==0">UnMarried</label>
                       </div>
                     </div>
                  <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">Address</span>
                      <label class="form-control" type="text" >{{data.address1}},{{data.address2}}</label>
                    </div>
                  </div>
                   </div>
                   <div class="form-group">
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">City</span>
                         <label class="form-control" type="text">{{data.city}}</label>

                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">State</span>
                         <label class="form-control" type="text">{{data.state}}</label>

                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Country</span>

                         <select id="countries1" class="input-medium form-control" name="country" disabled></select>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Pincode</span>
                        <label class="form-control" type="text">{{data.pincode}}</label>

                       </div>
                     </div>

                   </div>
                   <div class="form-group">
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Contact No</span>
                         <label class="form-control" type="text">{{data.contact_no}}</label>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Res No</span>
                         <label class="form-control" type="text">{{data.mobile_no}}</label>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Email</span>
                         <label class="form-control" type="text">{{data.email}}</label>

                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Dob</span>
                         <label class="form-control" type="text">{{data.dob}}</label>
                       </div>
                     </div>
                   </div>
                   <hr>
                   <h4>Emergency  Contact Details</h4>
                   <div class="form-group">
                   <div class="col-lg-6">
                     <div class="input-group">
                       <span class="input-group-addon"> Name</span>
                       <label class="form-control" type="text"> {{data.name}}</label>
                     </div>
                   </div>
                   <div class="col-lg-3">
                     <div class="input-group">
                       <span class="input-group-addon"> Relation </span>
                       <label class="form-control" type="text"> {{data.relation}}</label>
                     </div>
                   </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Contact No</span>
                         <label class="form-control" type="text">{{data.emr_contact_no}}</label>
                       </div>
                     </div>
                   </div>
                   <div class="form-group">
                   <div class="col-lg-6">
                     <div class="input-group">
                       <span class="input-group-addon">Address</span>
                       <label class="form-control" type="text" >{{data.emr_address1}},{{data.emr_address2}}</label>
                     </div>
                   </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Res No</span>
                         <label class="form-control" type="text">{{data.emr_mobile_no}}</label>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Email</span>
                         <label class="form-control" type="text">{{data.email_id}}</label>

                       </div>
                     </div>
                   </div>

                   <div class="form-group">
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">City</span>
                         <label class="form-control" type="text">{{data.emr_city}}</label>

                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">State</span>
                         <label class="form-control" type="text">{{data.emr_state}}</label>
                       </div>
                     </div>


                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Country</span>

                         <select id="countries2" class="input-medium form-control" name="country" disabled></select>
                       </div>
                     </div>
                     <div class="col-lg-3">
                       <div class="input-group">
                         <span class="input-group-addon">Pincode</span>
                         <label class="form-control" type="text">{{data.emr_pincode}}</label>

                       </div>
                     </div>


                   </div>
                   <div class="form-group">
                     <div class="col-lg-10">

                     </div>
                     <div class="col-lg-2">
                       <input type="submit" value="Proceed" class="btn btn-primary" ng-click="proceed()">
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

  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header panel-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Patient</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">
              <form role="form" class="form-horizontal" name="myform1"  ng-submit="submit(x.patient_pid)">
                <fieldset>

                  <div class="form-group">

                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">First Name</span>
                        <input type="text" class="form-control" ng-model="x.first_name" name="first_name" required>
                      </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform1.first_name.$invalid &&  myform1.first_name.$touched">Please First Name </span>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Last Name</span>
                        <input type="text" class="form-control" ng-model="x.last_name" name="last_name" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.last_name.$invalid &&  myform1.last_name.$touched">Please Last Name </span>
                    </div>

                  </div>
                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Blood</span>
                        <select  ng-model="blood_iid" class="form-control"   ng-options="s.blood_id as s.blood_type for s in blood" required></select>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Gender</span>
                        <select ng-model="gender" class="form-control">
                          <option value="1">Male</option>
                          <option value="0">Female</option>
                        </select>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">MStatus</span>
                        <select ng-model="x.mstatus" class="form-control">
                          <option value="1">Married</option>
                          <option value="0">UnMarried</option>
                        </select>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Dob</span>
                        <input type="text" id="datepicker" class="form-control datepicker" name="dob" ng-model="x.dob" name="dob" required>
                      </div>
                       <span class="text-danger wrapper text-center ng-binding"
                             ng-show="myform1.dob.$invalid &&  myform1.dob.$touched">Please Enter Date </span>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Address1</span>
                        <input type="text" class="form-control" ng-model="x.address1" name="address1" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.address1.$invalid &&  myform1.address1.$touched">Please Enter Address </span>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Address2</span>
                        <input type="text" class="form-control" ng-model="x.address2" name="address2" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.address2.$invalid &&  myform1.address2.$touched">Please Enter Address</span>
                    </div>
                  </div>




                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">City</span>
                        <input type="text" class="form-control" ng-model="x.city" name="city" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.city.$invalid &&  myform1.city.$touched">Please Enter City</span>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">State</span>
                        <input type="text" class="form-control" ng-model="x.state" name="state" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.state.$invalid &&  myform1.state.$touched">Please Enter State </span>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Country</span>
                        <select id="countries3" class="input-medium form-control" name="country" ></select>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Pincode</span>
                        <input type="text" class="form-control" ui-mask="999999" ng-model="x.pincode" name="pincode" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.pincode.$invalid &&  myform1.pincode.$touched">Please Enter Valid Pincode</span>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Contact No</span>
                        <input type="text" class="form-control" ui-mask="9999-999-999" ng-model="x.contact_no" name="contact_no" required>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.contact_no.$invalid &&  myform1.contact_no.$touched">Please Enter Contact No </span>
                      </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Res No</span>
                        <input type="text" class="form-control" ui-mask="9999-999-999" ng-model="x.mobile_no" name="mobile_no" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.mobile_no.$invalid &&  myform1.mobile_no.$touched">Please Enter Res No </span>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Email</span>
                        <input type="text" class="form-control" ng-model="x.email" name="email" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.email.$invalid &&  myform1.email.$touched">Please Enter Email </span>
                    </div>
                    </div>

                  <hr>
                  <h4>Emergency  Contact Details</h4>
                  <div class="form-group">
                    <div class="col-lg-5">
                      <div class="input-group">
                      <span class="input-group-addon">Name</span>
                      <input type="text" class="form-control" ng-model="x.name" name="name" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.name.$invalid &&  myform1.name.$touched">Please Enter Name </span>
                      </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                      <span class="input-group-addon">Relation</span>
                      <input type="text" class="form-control" ng-model="x.relation" name="relation" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.relation.$invalid &&  myform1.relation.$touched">Please Enter Relation </span>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                      <span class="input-group-addon">Contact No</span>
                      <input type="text" class="form-control" ui-mask="9999-999-999" ng-model="x.emr_contact_no" name="emr_contact_no" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_contact_no.$invalid &&  myform1.emr_contact_no.$touched">Please Enter Contact No </span>
                    </div>
                    </div>

                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Address1</span>
                        <input type="text" class="form-control" ng-model="x.emr_address1" name="emr_address1" required>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_address1.$invalid &&  myform1.emr_address1.$touched">Enter Emergency Address</span>
                      </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Address2</span>
                        <input type="text" class="form-control" ng-model="x.emr_address2" name="emr_address2" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_address2.$invalid &&  myform1.emr_address2.$touched">Enter Emergency Address </span>
                    </div>
                    </div>

                  <div class="form-group">
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Res No</span>
                        <input type="text" class="form-control" ui-mask="9999-999-999" ng-model="x.emr_mobile_no" name="emr_mobile_no" required>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_mobile_no.$invalid &&  myform1.emr_mobile_no.$touched">Please Enter Res No </span>
                      </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Email</span>
                        <input type="text" class="form-control" ng-model="x.email_id" name="email_id" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.email_id.$invalid &&  myform1.email_id.$touched">Please Enter Email </span>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">City</span>
                        <input type="text" class="form-control" ng-model="x.emr_city" name="emr_city" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_city.$invalid &&  myform1.emr_city.$touched">Please Enter City </span>
                    </div>
                    </div>

                  <div class="form-group">
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">State</span>
                        <input type="text" class="form-control" ng-model="x.emr_state" name="emr_state" required>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_state.$invalid &&  myform1.emr_state.$touched">Please Enter State </span>
                      </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Country</span>
                        <select id="countries4" class="input-medium form-control" name="country" ></select>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Pincode</span>
                        <input type="text" class="form-control" ui-mask="999999" ng-model="x.emr_pincode" name="emr_pincode" required>
                      </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform1.emr_pincode.$invalid &&  myform1.emr_pincode.$touched">Please Enter Valid Pincode </span>
                    </div>
                    </div>

                  <div class="form-action">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"  ng-disabled="myform1.$invalid" ng-click="submitted=true">Save</button>
                        <button  class="btn btn-inverse" data-dismiss="modal">Cancel</button>
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
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addPatient.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getPatient.js"></script>
<script src="<%=request.getContextPath()%>/static/js/patientDetails.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>

</body>
</html>
