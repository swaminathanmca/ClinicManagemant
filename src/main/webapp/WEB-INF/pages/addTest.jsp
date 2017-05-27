<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 05/26/17
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="LaboratoryTest">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/js-custom-select/style.css" rel="stylesheet">
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
    <div class="col-lg-12">

    </div>
  </div>

  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Add Laboratory</h3>
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit(info.patient_info_id)"
                    novalidate>
                <fieldset>
                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Patient Id</span>
                        <label type="text" class="form-control" >{{patientcomplaint.patient_pid}} </label>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Name</span>
                        <label class="form-control" type="text">{{patientcomplaint.first_name}} &nbsp; {{patientcomplaint.last_name}}</label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Test Type</span>
                        <SELECT class="form-control" ng-options="x.test_type as x.test_type for x in type" ng-model="x.test_type" ng-change="typelab(x.test_type)" required></SELECT>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Test Name</span>
                        <SELECT class="form-control" ng-options="s.test_name as s.test_name for  s in lab" ng-model="test_name" required></SELECT>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Remarks</span>
                        <input type="text" class="form-control" ng-model="remarks">
                      </div>
                    </div>
                  </div>




                  <div class="form-action">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"
                                ng-disabled="myform.$invalid" ng-click="submitted=true">Add
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
          <div  class="row" ng-if="selectedmaster.length ">

            <div class="col-lg-12">
              <div class="table-responsive">

                <table class="table table-striped table-bordered table-hover " id="dataTables-example">
                  <thead>
                  <tr class="success">
                    <th><input type="checkbox" ng-model="selectedAll" ng-click="checkAll()"  /></th>
                    <th>Test Name</th>
                    <th>Remarks</th>

                  </tr>
                  </thead>
                  <tbody>
                  <tr ng-repeat="x in selectedmaster">
                    <td><input type="checkbox" ng-model="x.selected" class="check"   ng-click="edit(x.selected)"/></td>
                    <td>{{x.test_name}}</td>
                    <td>{{x.remarks}}</td>

                  </tr>
                  </tbody>
                  </table>
                </div>
              <div class="form-action">
                <div class="row">
                  <div class="col-lg-offset-4 col-lg-7">
                    <button type="submit" class="btn btn-success" ng-click="prescriptionAdd()">Proceed</button>
                    <button  type="submit" class="btn btn-danger " ng-click="remove()" >Remove</button>
                    <button  type="submit" class="btn btn-primary" id="sub" ng-click="editPres()" disabled='disabled' data-target="#myform1" data-toggle="modal">Modify</button>

                  </div>
                </div>
              </div>
            </div>

          </div>


        </div>

      </div>
    </div>
  </div>



</div>

  <div class="modal fade" id="myform1" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header panel-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit LabInvestigation</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">

              <form role="form" class="form-horizontal" name="myform1"  ng-submit="editsubmit(data.labinvestigation_id)">
                <fieldset>

                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Test Type</span>
                        <SELECT class="form-control" ng-options="xs.test_type as xs.test_type for xs in invtype" ng-model="data.test_type" ng-change="typelabModel(data.test_type)" required></SELECT>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Test Name</span>
                        <SELECT class="form-control" ng-options="st.test_name as st.test_name for  st in labinst" ng-model="data.test_name" required></SELECT>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="input-group">
                        <span class="input-group-addon">Remarks</span>
                        <input type="text" class="form-control" ng-model="data.remarks">
                      </div>
                    </div>
                  </div>

                  <div class="form-action">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"
                                ng-disabled="myform1.$invalid "
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
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addTest.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>
