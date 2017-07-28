<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/22/2017
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="clinicDetails">
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
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Clinic<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="Dashboard">Add CLinic</a>
                            </li>
                            <li>
                                <a href="GetClinic">View Clinic</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="AdminBranch"><i class="fa fa-table fa-fw"></i> Branch</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-child "></i>&nbsp;Speciality<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddSpeciality"> Add Speciality</a>
                            </li>
                            <li>
                                <a href="ViewSpeciality">View Speciality</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-medkit"></i>&nbsp;Medicine<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddMedicine"> Add Medicine</a>
                            </li>
                            <li>
                                <a href="GetMedicine">View Medicine</a>
                            </li>
                        </ul>
                    </li>
                    <li ng-show="role=='SuperAdmin'">
                        <a href="#">
                            <i class="fa fa-thermometer-full"></i>&nbsp;Laboratory<span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddLaboratory">Add Laboratory</a>
                            </li>
                            <li>
                                <a href="ViewLaboratory">View Laboratory</a>
                            </li>
                        </ul>
                    </li>
                  <%--  <li>
                        <a href="#"><i class="fa fa-ambulance"></i>&nbsp;Services<span class="fa arrow"></span> </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="AddService"> Add Service</a>
                            </li>
                            <li>
                                <a href="ViewService">View Service</a>
                            </li>
                        </ul>
                    </li>--%>
                </ul>
            </div>
        </div>
    </nav>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
<p></p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <%--<button type="button" class="btn btn-primary" ng-click="addClinic()">Add Clinic</button>--%>
                        <p>{{clinic.clinicName}}</p>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" class="form-horizontal">
                                    <fieldset>
                                        <div class="col-xs-3">
                                            </div>
                                        <div class="col-xs-1 col-xs-offset-8">
                                            <h4><img  src="<%=request.getContextPath()%>/static/img/editicon.png" class=" pull-left" data-toggle="modal" data-target="#myModal" style="padding-left: 45px" ng-click="editUser(clinic.clinicId)"></h4>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Clinic Name</span>
                                                    <label class="form-control"
                                                           type="text">{{clinic.clinicName}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Clinic Address</span>
                                                    <label class="form-control" type="text">{{clinic.address1}},{{clinic.address2}}</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">City</span>
                                                    <label class="form-control" type="text">{{clinic.city}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">State</span>
                                                    <label class="form-control" type="text">{{clinic.state}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Country</span>
                                                    <select id="countries1" class="input-medium form-control"
                                                            disabled></select>
                                                </div>

                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Pin Code</span>
                                                    <label class="form-control" type="text">{{clinic.pin_code}}</label>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-4">
                                                <div class="input-group">
                                                    <span class="input-group-addon">E-Mail Id</span>
                                                    <label class="form-control" type="text">{{clinic.email_id}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Phone No</span>
                                                    <label class="form-control" type="text">{{clinic.contact_no}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-5">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Description</span>
                                                    <textarea class="form-control" type="text" disabled>{{clinic.description}}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                    <h4>Chief Information</h4>
                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                         Name
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                         Address
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_address1}},{{clinic.Chief_address2}}</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        City
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_city}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        State
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_state}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Country</span>
                                                    <select id="countries2" class="input-medium form-control"
                                                            disabled></select>
                                                </div>

                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        PinCode
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_pincode}}</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        Email-Id
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_email_id}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        Phone No
                                                    </span>
                                                    <label class="form-control" type="text">{{clinic.Chief_conatct_no}}</label>
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                       Gender
                                                    </span>
                                                    <label class="form-control" type="text" ng-if="clinic.Chief_gender==1">Male</label>
                                                    <label class="form-control" type="text" ng-if="clinic.Chief_gender==0">FeMale</label>
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


    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header panel-primary">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Clinic</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" class="form-horizontal" name="myform"  ng-submit="submit(id)">
                                <fieldset>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        ClinicName
                                                    </span>
                                                <input class="form-control" type="text" ng-model="x.clinicName" name="branch_name" ng-blur="EditName(x.clinicId,x.clinicName)" required/>

                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding" ng-show="err_name==false">The Clinic Name Already Taken</span>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.branch_name.$invalid &&  myform.branch_name.$touched">Please Enter Clinic Name</span>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Register No</span>
                                                <input type="text" class="form-control" ng-model="x.reg_no" name="reg_no" required>
                                            </div>
                                             <span class="text-danger wrapper text-center ng-binding"
                                                   ng-show="myform.reg_no.$invalid &&  myform.reg_no.$touched">Please Enter Registration Number</span>
                                        </div>

                                        </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        Address1
                                                    </span>
                                                <input class="form-control" type="text" ng-model="x.address1" name="address1" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.address1.$invalid &&  myform.address1.$touched">Please Enter Address</span>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        Address2
                                                    </span>
                                                <input class="form-control" type="text" ng-model="x.address2" name="address2" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.address2.$invalid &&  myform.address2.$touched">Please Enter Address</span>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        City
                                                    </span>
                                                <input class="form-control" type="text" ng-model="x.city" name="city" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.city.$invalid &&  myform.city.$touched">Please Enter City</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        State
                                                    </span>
                                                <input class="form-control" type="text" ng-model="x.state" name="state" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.state.$invalid &&  myform.state.$touched">Please Enter State</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon">Country</span>
                                                <select id="countries3" class="input-medium form-control" name="country"  required></select>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.country.$invalid &&  myform.country.$touched">Please Enter Country</span>
                                    </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon">PinCode</span>
                                                <input class="form-control" type="text" ng-model="x.pin_code" ng-pattern="/^[0-9]*$/" ui-mask="999999" name="pin_code" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.pin_code.$invalid &&  myform.pin_code.$touched">Please Enter Pin Code</span>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.pin_code.$error.pattern">Please Enter Valid Pin Code</span>
                                        </div>

                                        </div>
                                    <div class="form-group">

                                        <div class="col-lg-4">
                                            <div class="input-group">
                                                <span class="input-group-addon">E-Mail</span>
                                                <input class="form-control" type="email" ng-model="x.email_id" name="email_id" ng-blur="editEmail(x.branch_id,x.email_id)" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.email_id.$invalid  "> Enter Valid Email</span>
                                             <span class="text-danger wrapper text-center ng-binding" ng-show="error_email==false">
                                                   The Email Already Taken
                                                     </span>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="input-group">
                                                <span class="input-group-addon">PhoneNo</span>
                                                <input class="form-control" type="text" ng-model="x.contact_no" ui-mask="999-999-9999" name="contact_no" ng-blur="editContact(x.branch_id,x.contact_no)" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.contact_no.$invalid"> Enter Phone  No</span>
                                             <span class="text-danger wrapper text-center ng-binding" ng-show="error==false">
                                                       The Mobile Number Already Taken
                                                           </span>

                                        </div>
                                      <%--  <div class="col-lg-4">
                                            <div class="input-group">
                                                <span class="input-group-addon">Password</span>
                                                <input type="text" ng-model="x.password" class="form-control" name="password" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.password.$invalid &&  myform.password.$touched">Please Enter Password</span>
                                        </div>--%>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Description</span>
                                                <input class="form-control" type="text" ng-model="x.description"/>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <h4>Chief Information</h4>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"> Name</span>
                                                <input class="form-control" type="text" ng-model="x.Chief" name="chief_name" required/>

                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.chief_name.$invalid">Please Enter  Name</span>
                                        </div>

                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    Gender
                                                </span>
                                                <div class="checkbox  fileRadioBox">
                                                    <label>
                                                        <input type="radio" name="sex" value="1" ng-model="x.Chief_gender" required>Male
                                                    </label>
                                                    <label>
                                                        <input type="radio" name="sex" value="0" ng-model="x.Chief_gender" required>FeMale
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"> Address1</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_address1" name="caddress1" required/>
                                            </div>
                                             <span class="text-danger wrapper text-center ng-binding"
                                                   ng-show="myform.caddress1.$invalid">Please  Enter Address</span>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"> Address2</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_address2" name="caddress2" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.caddress2.$invalid">Please  Enter Address</span>
                                        </div>


                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon"> City</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_city" name="ccity" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.ccity.$invalid">Please  Enter City</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon"> State</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_state" name="cstate" required/>
                                            </div>
                                             <span class="text-danger wrapper text-center ng-binding"
                                                   ng-show="myform.cstate.$invalid">Please  Enter State</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon">Country</span>
                                                <select id="countries4" class="input-medium form-control" name="ccountry"></select>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.ccountry.$invalid">Please  Select Country</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="input-group">
                                                <span class="input-group-addon">PinCode</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_pincode" ng-pattern="/^[0-9]*$/" ui-mask="999999" name="cpincode" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.cpincode.$invalid">Please  Enter PinCode </span>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.cpincode.$error.pattern">Please Enter Valid Pin Code</span>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"> Email</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_email_id" name="cemail" ng-blur="EditCemail(x.Chief_id,x.Chief_email_id)" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.cemail.$invalid">Please  Enter Email-id </span>
                                            <span class="text-danger wrapper text-center ng-binding" ng-show="err_chief_email==false">
                                                       The Email Already Taken
                                                           </span>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon"> PhoneNo</span>
                                                <input class="form-control" type="text" ng-model="x.Chief_conatct_no" name="cphoneno" ng-blur="EditChiefContact(x.Chief_id,x.Chief_conatct_no)" required/>
                                            </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.cphoneno.$invalid">Please  Enter Phone No </span>
                                            <span class="text-danger wrapper text-center ng-binding" ng-show="err==false">
                                                       The Mobile Number Already Taken
                                                           </span>
                                        </div>

                                    </div>
                                    <div class="form-action">
                                        <div class="row">
                                            <div class="col-lg-offset-4 col-lg-7">
                                                <button type="submit" class="btn btn-success"
                                                        ng-disabled="myform.$invalid || !authError || !authErrorEmail || !chiefError || !chiefEmail || !name"
                                                        ng-click="submitted=true">Save
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
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/clinicDetails.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>


<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>

</body>
</html>
