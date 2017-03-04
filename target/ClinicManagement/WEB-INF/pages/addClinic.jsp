<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/17/2017
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="dashboard">
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
                                <a href="Dashboard">Add Clinic</a>
                            </li>
                            <li>
                                <a href="GetClinic">View Clinic</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Doctor<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Add Doctor</a>
                            </li>
                            <li>
                                <a href="#">View Doctor</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i> Tables</a>
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
                        <h3 class="panel-title">Add Clinic</h3>
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
                                                    <span class="input-group-addon">Clinic Name</span>
                                                    <input class="form-control" placeholder="Clinic Name" name="branch_name"
                                                           type="text" ng-model="clinic_name" maxlength="30" ng-blur="valName()" required>
                                                </div>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.branch_name.$invalid &&  myform.branch_name.$touched">Please Enter Clinic Name</span>
                                                 <span class="text-danger wrapper text-center ng-binding" ng-show="err_name==false">
                                                       The Clinic Name Already Taken
                                                           </span>
                                            </div>
                                           <div class="col-lg-6">
                                               <div class="input-group">
                                                   <span class="input-group-addon">Registration No</span>
                                                   <input class="form-control" placeholder="Registration Number"
                                                          name="reg_no" type="text" ng-model="reg_no" required>
                                               </div>
                                                 <span class="text-danger wrapper text-center ng-binding"
                                                       ng-show="myform.reg_no.$invalid &&  myform.reg_no.$touched">Please Enter Registration Number</span>
                                           </div>
                                            </div>

                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                            <span class="input-group-addon">Address1</span>
                                                <input class="form-control" placeholder="Address"
                                                       name="address1" type="text" ng-model="address1" required>
                                              </div>
                                            <span class="text-danger wrapper text-center ng-binding"
                                                  ng-show="myform.address1.$invalid &&  myform.address1.$touched">Please Enter Address </span>
                                                </div>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                <span class="input-group-addon">Address2</span>
                                                <input class="form-control" placeholder="Address" name="address2"
                                                       type="text" value="" ng-model="address2" required>
                                            </div>
                                             <span class="text-danger wrapper text-center ng-binding"
                                                   ng-show="myform.address2.$invalid &&  myform.address2.$touched">Please Enter Address</span>
                                            </div>
                                            </div>


                                        <div class="form-group">
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">City</span>
                                                    <input class="form-control" placeholder="City" name="city" type="text"
                                                           value="" ng-model="city" required>
                                                </div>
                                                 <span class="text-danger wrapper text-center ng-binding"
                                                       ng-show="myform.city.$invalid &&  myform.city.$touched">Please Enter City</span>
                                            </div>

                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">State</span>
                                                    <input type="text" ng-model="state" class="form-control" placeholder="State" name="state" required>
                                                    </div>
                                                 <span class="text-danger wrapper text-center ng-binding"
                                                       ng-show="myform.state.$invalid &&  myform.state.$touched">Please Enter State</span>
                                                </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Country</span>
                                                    <select id="countries_states1"
                                                            class="input-medium bfh-countries form-control" name="country"
                                                            ng-model="country" data-country="" required></select>
                                                </div>
                                                  <span class="text-danger wrapper text-center ng-binding"
                                                        ng-show="myform.country.$invalid &&  myform.country.$touched">Please Enter Country</span>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Pin Code</span>
                                                    <input class="form-control" placeholder="PinCode" name="pincode"
                                                           type="text" value="" ng-model="pincode" maxlength="6"
                                                           ng-pattern="/^[0-9]*$/" required>
                                                </div>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.pincode.$error.pattern">Please Enter Valid Pin Code</span>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.pincode.$invalid &&  myform.pincode.$touched">Please Enter Pin Code</span>
                                                </div>

                                        </div>


                                        <div class="form-group">
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Email</span>
                                                    <input class="form-control" name="email" type="email" value="" ng-model="email_id" ng-blur="emailvalidate()" required>
                                                </div>
                                                 <span class="text-danger wrapper text-center ng-binding" ng-show="error_email==false">
                                                   The Email Already Taken
                                                     </span>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.email.$invalid &&  myform.email.$touched"> Enter Valid Email</span>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Phone No</span>
                                                    <input class="form-control" name="branch_no" type="text" value=""
                                                           ui-mask="999-999-9999" ng-model="contact_no" ng-blur="validate()"
                                                           required>
                                                    </div>
                                                 <span class="text-danger wrapper text-center ng-binding" ng-show="error==false">
                                                       The Mobile Number Already Taken
                                                           </span>
                                                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.branch_no.$invalid &&  myform.branch_no.$touched">Please Enter Contact Number</span>
                                                </div>



                                            <div class="col-lg-4">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Password</span>
                                                    <input class="form-control" name="password" type="text" ng-model="password" required>
                                                    </div>
                                                <span class="text-danger wrapper text-center ng-binding" ng-show="myform.password.$invalid && myform.password.$touched">Please Enter Password</span>
                                                </div>


                                            </div>

                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Description</span>

                                                <textarea class="form-control"
                                                          placeholder="Write Clinic Description Here.." name="desc"
                                                          type="text" value="" ng-model="desc"  ></textarea>
                                                    </div>
                                                </div>
                                        </div>



                                        <hr>
                                        <div class="form-group">
                                                <div class="col-lg-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Chief Name</span>
                                                        <input class="form-control" placeholder="Chief Name" name="chief_name"
                                                               type="text" ng-model="chief_name" maxlength="30" required>
                                                        </div>
                                                     <span class="text-danger wrapper text-center ng-binding"
                                                           ng-show="myform.chief_name.$invalid &&  myform.chief_name.$touched">Please Enter Chief Name</span>
                                                    </div>


                                                    <div class="col-lg-6">
                                                        <div class="input-group">
                                                        <span class="input-group-addon">Address 1</span>
                                                        <input class="form-control" placeholder="Address"
                                                               name="chief_address1" type="text" ng-model="chief_address1" required>
                                                        </div>
                                                         <span class="text-danger wrapper text-center ng-binding"
                                                               ng-show="myform.chief_address1.$invalid &&  myform.chief_address1.$touched">Please Enter Address</span>
                                                    </div>

                                                </div>


                                            <div class="form-group">
                                                <div class="col-lg-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Address 2</span>
                                                        <input class="form-control" placeholder="Address" name="chief_address2"
                                                               type="text" ng-model="chief_address2" maxlength="30" required>
                                                        </div>
                                                    <span class="text-danger wrapper text-center ng-binding"
                                                          ng-show="myform.chief_address2.$invalid &&  myform.chief_address2.$touched">Please Enter Address</span>
                                                    </div>

                                                <div class="col-lg-3">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">City</span>
                                                        <input class="form-control" placeholder="City"
                                                               name="chief_city" type="text" ng-model="chief_city" required>
                                                        </div>
                                                    <span class="text-danger wrapper text-center ng-binding"
                                                          ng-show="myform.chief_city.$invalid &&  myform.chief_city.$touched">Please Enter City</span>
                                                    </div>
                                                <div class="col-lg-3">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">State</span>
                                                        <input class="form-control" placeholder="State" name="chief_state"
                                                               type="text" ng-model="chief_state" maxlength="30" required>
                                                    </div>
                                                    <span class="text-danger wrapper text-center ng-binding"
                                                          ng-show="myform.chief_state.$invalid &&  myform.chief_state.$touched">Please Enter State</span>
                                                </div>
                                            </div>


                                            <div class="form-group">

                                                <div class="col-lg-3">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Country</span>
                                                        <select class="input-medium bfh-countries form-control" name="chief_country"
                                                                ng-model="chief_country" data-country="" required></select>
                                                        </div>
                                                     <span class="text-danger wrapper text-center ng-binding"
                                                           ng-show="myform.chief_country.$invalid &&  myform.chief_country.$touched">Please Enter Country</span>
                                                    </div>
                                                <div class="col-lg-3">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Pin/Zip</span>
                                                        <input class="form-control" placeholder="Pin /Zip" name="chef_pin" ng-pattern="/^[0-9]*$/"
                                                               type="text" ng-model="chef_pin" maxlength="6" required>
                                                    </div>
                                                     <span class="text-danger wrapper text-center ng-binding"
                                                           ng-show="myform.chef_pin.$error.pattern">Please Enter Valid Pin Code</span>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.chef_pin.$invalid &&  myform.chef_pin.$touched">Please Enter Pin Code</span>
                                                </div>
                                                <div class="col-lg-4">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Gender</span>

                                                        <div class="checkbox  fileRadioBox form-control">
                                                            <label>
                                                                <input type="radio" name="sex" value="1" ng-model="chief_gender" required="" class="ng-pristine ng-untouched ng-valid ng-valid-required">&nbsp;Male
                                                            </label>
                                                            <label>
                                                                <input type="radio" name="sex" value="0" ng-model="chief_gender" required="" class="ng-pristine ng-untouched ng-valid ng-valid-required ">&nbsp;Female
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <span class="text-danger wrapper text-center ng-binding"
                                                          ng-show="myform.chief_country.$invalid &&  myform.chief_country.$touched">Please Enter Gender</span>
                                                </div>

                                                </div>


                                            <div class="form-group">


                                                </div>
                                                <div class="form-group">
                                                <div class="col-lg-3">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">Phone No</span>
                                                        <input class="form-control"  name="chief_contact_no" ui-mask="999-999-9999"  type="text" ng-model="chief_contact_no" ng-blur="validatecontact()" required>
                                                        </div>
                                                     <span class="text-danger wrapper text-center ng-binding"
                                                           ng-show="myform.chief_contact_no.$invalid &&  myform.chief_contact_no.$touched">Please Enter Phone No</span>
                                                     <span class="text-danger wrapper text-center ng-binding" ng-show="err==false">
                                                       The Mobile Number Already Taken
                                                           </span>
                                                    </div>
                                                    <div class="col-lg-3">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Email Id</span>
                                                    <input class="form-control" placeholder="Email"
                                                           name="cheif_email_id" type="text" ng-model="cheif_email_id" ng-blur="validateEmail()" required>
                                                </div>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.cheif_email_id.$invalid &&  myform.cheif_email_id.$touched">Please Enter Email Id</span>
                                                     <span class="text-danger wrapper text-center ng-binding" ng-show="err_chief_email==false">
                                                       The Email Already Taken
                                                           </span></div>
                                            </div>



                                        <!-- Change this to a button or input when using this as a form -->
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-lg-offset-4 col-lg-7">
                                                    <button type="submit" class="btn btn-success"
                                                            ng-disabled="myform.$invalid || !authError || !authErrorEmail || !chiefError || !chiefEmail || !name"
                                                            ng-click="submitted=true">Save
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
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>

</body>
</html>
