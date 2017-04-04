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
                     <h4><img src="<%=request.getContextPath()%>/static/img/editicon.png" class=" pull-left" data-toggle="modal" data-target="#myModal" style="padding-left: 45px" ng-click="editUser(data.profile_id)">
                     </h4>
                   </div>
                   <div class="form-group">
                     <div class="col-lg-6">
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
                   </div>

                   <div class="form-group">
                   <div class="col-lg-3">
                     <div class="input-group">
                       <span class="input-group-addon">Gender</span>
                       <label class="form-control" type="text" ng-if="data.gender==1">Male</label>
                       <label class="form-control" type="text" ng-if="data.gender==0">FeMale</label>
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
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
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
