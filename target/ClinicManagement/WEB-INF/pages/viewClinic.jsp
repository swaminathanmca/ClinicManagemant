<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/22/2017
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="getClinic">
<head>
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
        <div class="row">
            <div class="col-lg-12">
                <h4 class="page-header">Clinic Details</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <button type="button" class="btn btn-primary" ng-click="addClinic()">Add Clinic</button>
                        <label class="input-group pull-right" style="width: 180px">
                            <span class="input-group-addon glyphicon glyphicon-search" style="top:0px;"></span>
                            <input type="text" ng-model="search" class="input-group  form-control" placeholder="Search">
                        </label>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive ">
                                    <table class="table table-striped table-bordered table-hover ">
                                        <thead>
                                        <tr class="success">
                                            <th>Clinic Name</th>
                                            <th>Description</th>
                                            <th>Address</th>
                                            <th>Contact No</th>
                                            <th>Options</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="x in clinic | filter:search ">
                                            <td>{{x.clinicName}}</td>
                                            <td>{{x.description}}</td>
                                            <td>{{x.address}}</td>
                                            <td>{{x.phoneNo}}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm" data-toggle="modal" data-target="#myModal" ng-click="editClinic(x.clinicId)">Edit
                                                </button>
                                                <a class="glyphicon glyphicon-trash hv_change"  data-toggle="modal" data-target="#myModal1" ng-click="openDelete(x.clinicId)"></a>
                                            </td>
                                        </tr>
                                        </tbody>

                                    </table>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Clinic</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal ng-invalid" role="form" name="edit" ng-submit="submit(data.clinicId)" novalidate>
                        <fieldset>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Clinic Name</label>
                                <div class="col-lg-5">
                                    <input class="form-control" placeholder="Clinic Name" name="branch_name" type="text" ng-model="data.clinicName"  required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.branch_name.$invalid &&  edit.branch_name.$touched">Please Enter Clinic Name</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Phone No</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="branch_no" type="text" value="" ui-mask="999-999-9999" ng-model="data.phone_no" ng-blur="validate(data.clinicId)"  required>
                                     <span class="text-danger wrapper text-center ng-binding" ng-show="error==false">
                                    The Mobile Number Already Taken
                               </span>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.branch_no.$invalid &&  edit.branch_no.$touched">Please Enter Contact Number</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Email Id</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="email_id" type="email" value=""  ng-model="data.email_id" ng-blur="emailvalidate(data.clinicId)" required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="error_email==false">
                                   The Email Already Taken
                                   </span>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.email.$invalid &&  ! edit.email.$pristine &&  edit.email.$touched "> Enter Valid Email</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Address</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="address" type="text" value=""  ng-model="data.address"  required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.address.$invalid &&  edit.address.$touched">Please Enter Address</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">City</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="city" type="text" value=""  ng-model="data.city"  required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.city.$invalid &&  edit.city.$touched">Please Enter City</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">State</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="state" type="text" value=""  ng-model="data.state"  required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.state.$invalid &&  edit.state.$touched">Please Enter State</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Pin Code</label>
                                <div class="col-lg-5">
                                    <input class="form-control"  name="pincode" type="text" value=""  ng-model="data.pincode"  required>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.pincode.$error.pattern">Please Enter Valid Pin Code</span>
                                    <span class="text-danger wrapper text-center ng-binding" ng-show="edit.pincode.$invalid &&  edit.pincode.$touched">Please Enter Pin Code</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Description</label>
                                <div class="col-lg-5">
                                    <textarea class="form-control"  name="description" type="text" value=""  ng-model="data.description"  required></textarea>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-lg-offset-4 col-lg-7">
                                        <button type="submit" class="btn btn-primary" ng-disabled="edit.$invalid || !authError || !authErrorEmail " ng-click="submitted=true">Save </button>
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

   <%--Delete Clinic Model--%>
    <div class="modal fade" id="myModal1" role="dialog">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header panel-primary">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Delete Clinic</h4>
                </div>
                <div class="modal-body">
                    <p>Are you sure  want to delete the clinic?</p>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-lg-offset-4 col-lg-7">
                                <button type="button" class="btn btn-inverse" data-dismiss="modal">Cancel</button>
                                &nbsp;&nbsp;
                                <button type="submit" class="btn btn-primary" ng-click="delete(clinicId)">Delete </button>
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
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getClinic.js"></script>
</body>
</html>
