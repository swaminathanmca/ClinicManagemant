<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="User">
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
                <li ng-show="role=='SuperAdmin'">
                    <a href="#"><i class="fa fa-hospital-o"></i> Clinic<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="Dashboard">Add CLinic</a>
                        </li>
                        <li>
                            <a href="GetClinic">View Clinic</a>
                        </li>
                    </ul>

                </li>
                <li ng-hide="role==SuperAdmin">
                    <a href="AddBranch"><i class="fa fa-table fa-fw"></i> Branch</a>
                </li>

                <li ng-hide="role==SuperAdmin">
                    <a href="#"><i class="fa fa-user-md"></i> User<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="AddUser">Add User</a>
                        </li>
                        <li>
                            <a href="#">View User</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
                </li>
                <li>
                    <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                </li>


            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>

 <div id="page-wrapper" >

     <br>
     <div class="row">
         <p></p>
     </div>
     <div class="row">
         <div class="col-lg-12">
             <div class="panel panel-primary">
                 <div class="panel-heading">
                     <h3 class="panel-title">Add User</h3>
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
                                                 <span class="input-group-addon"> Name</span>
                                                 <input class="form-control" type="text" name="firstname" id="firstname" ng-model="firstname" required/>
                                             </div>
                                         </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Type</span>
                                                 <select class="form-control" type="text" name="email" ng-model="user_type"  required>
                                                     <option value="0">Doctor</option>
                                                     <option value="1">Front Desk</option>
                                                 </select>
                                             </div>
                                         </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Clinic Name</span>
                                                 <label class="form-control" type="text" >{{data.clinic_name}}</label>
                                             </div>
                                         </div>

                                     </div>
                                     <div class="form-group">

                                         <div class="col-lg-6">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Address1 </span>
                                                 <input class="form-control" type="text" name="address1" id="address1" ng-model="address1" required/>
                                             </div>
                                         </div>
                                         <div class="col-lg-6">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Address2 </span>
                                                 <input class="form-control" type="text" name="address2" id="address2" ng-model="address2" required/>
                                             </div>
                                         </div>

                                     </div>
                                     <div class="form-group">
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">City </span>
                                                 <input class="form-control" type="text" name="city" id="city" ng-model="city" required/>
                                             </div>
                                         </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">State </span>
                                                 <input class="form-control" type="text" name="state" id="state" ng-model="state" required/>
                                             </div>
                                         </div>

                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Country</span>
                                                 <select class="input-medium bfh-countries form-control" data-country="IN"></select>
                                             </div>
                                         </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Pin-Code</span>
                                              <input class="form-control" type="text" id="pincode" name="pincode" ng-model="pincode" maxlength="6" ng-pattern="/^[0-9]*$/" required/>
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
                                                 <span class="input-group-addon">Gender</span>
                                                 <div class="checkbox  fileRadioBox form-control">
                                                     <label>
                                                         <input type="radio" name="sex" value="1" ng-model="chief_gender"   class="ng-pristine ng-untouched ng-valid ng-valid-required" checked="checked"/>&nbsp;Male
                                                     </label>
                                                     <label>
                                                         <input type="radio" name="sex" value="0" ng-model="chief_gender"  class="ng-pristine ng-untouched ng-valid ng-valid-required" checked>&nbsp;Female
                                                     </label>
                                                 </div>
                                             </div>
                                         </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Email</span>
                                                 <input class="form-control" type="email" name="email" ng-model="email_id" placeholder="" required/>
                                             </div>
                                         </div>


                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Phone No
                                                 </span>
                                                 <input type="text" class="form-control" ui-mask="999-999-9999" name="phone_no" ng-model="phone_no" required/>
                                             </div>
                                         </div>


                                     </div>
                                     <div class="form-group" >
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Password</span>
                                                 <input type="text" class="form-control" name="password" ng-model="password" required/>
                                             </div>
                                         </div>
                                        <div class="col-lg-3" ng-show="user_type==0">
                                            <div class="input-group">
                                                <span class="input-group-addon" >Reg-No</span>
                                                <input class="form-control" type="text" ng-model="reg_no" required>

                                            </div>
                                        </div>
                                         <div class="col-lg-3">
                                             <div class="input-group">
                                                 <span class="input-group-addon">Branch</span>
                                                 <select class="form-control">
                                                     <option value="0"></option>
                                                 </select>
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
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addUser.js"></script>

<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js">

</script>
</body>
</html>