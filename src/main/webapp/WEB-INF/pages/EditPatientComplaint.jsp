<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 05/30/17
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="editComplaints">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.css" rel="stylesheet">
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
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Complaint<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddComplaint">Add Complaint</a>
              </li>
              <li>
                <a href="ViewComplaint">View Complaint</a>
              </li>
            </ul>
          <li>
            <a href="patientHistory"><i class="fa fa-history fa-fw"></i>Patient History</a>
          </li>
          </li>
        </ul>
      </div>

    </div>
  </nav>
  <div id="page-wrapper">
    <br>
    <div class="row">
      <div class="col-lg-1"></div>
      <div class="col-lg-10">
        <h4 class="txtrns"> <a> <i class="fa fa-user"></i></a>&nbsp;&nbsp; {{patientcomplaint.first_name}}&nbsp;{{patientcomplaint.last_name}}&nbsp;&nbsp;&nbsp;&nbsp; <span ng-if="patientcomplaint.gender==1">Male</span> <span ng-if="patientcomplaint.gender==0">Female</span>,{{patientcomplaint.age}} &nbsp;&nbsp;<span>(ID:{{patientcomplaint.patient_pid}})</span> </h4>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-lg-1"></div>
      <div class="col-lg-10">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Patient Complaints</h3>

          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submited()" novalidate>
                  <fieldset>
                    <div class="col-xs-3">
                    </div>
                    <div class="col-xs-1 col-xs-offset-8">
                      <h4><img src="<%=request.getContextPath()%>/static/img/editicon.png" class=" pull-left" data-toggle="modal" data-target="#myModal" style="padding-left: 45px" ng-click="editInfo()">
                      </h4>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Visit Type</span>
                          <label class="form-control" type="text" ng-if="details.type==0" >New</label>
                          <label class="form-control" type="text" ng-if="details.type==1" >Followup</label>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Blood Pressure</span>
                          <label class="form-control" type="text" >{{details.bp}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Diagonics</span>
                          <label type="text" class="form-control" name="diagonics"  >{{details.diagonics}}</label>
                        </div>
                      </div>

                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Complaints</span>
                          <li  class="form-control">
                            <span ng-repeat="complaint in details.complaints"> {{complaint.complaint_name}},</span>
                          </li>
                        </div>
                      </div>

                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Observation</span>
                          <textarea class="form-control" ng-model="details.observation" disabled></textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Investigation</span>
                          <textarea class="form-control" ng-model="details.investigation" disabled></textarea>
                        </div>
                      </div>

                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Procedures</span>
                          <textarea class="form-control" ng-model="details.procedures" disabled></textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-8">
                        <div class="input-group">
                          <span class="input-group-addon">Type</span>
                          <div class="checkbox  fileRadioBox form-control">
                            <label>
                              <input type="radio" name="ltype"  value="1"   ng-model="ltype" required="required">&nbsp;Lab & Prescription
                            </label>
                            <label>
                              <input type="radio" name="ltype" value="2"  ng-model="ltype" required="required">&nbsp;Prescription
                            </label>
                            <label>
                              <input type="radio" name="ltype" value="3"  ng-model="ltype" required="required">&nbsp;None
                            </label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="form-action">
                      <div class="row">
                        <div class="col-lg-offset-4 col-lg-7">
                          <button type="submit" class="btn btn-success"
                                 ng-click="submitted=true">Proceed
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
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header panel-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Patient Complaints</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">
              <form role="form" class="form-horizontal" name="myform" ng-submit="submit(info.patient_info_id)">
                <fieldset>

                  <div class="form-group">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Diagonics</span>
                        <input type="text" class="form-control" name="diagonics" ng-model="detailsInfo.diagonics" />
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Blood Pressure</span>
                        <input type="text" class="form-control" ng-model="detailsInfo.bp"/>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <div class="input-group">
                        <span class="input-group-addon">Complaints</span>
                        <multiple-autocomplete ng-model="selectSpecialization" name="multipleSelect" required="true" object-property="complaint_name"
                                               after-select-item="afterselectItem"
                                               after-remove-item="afterremoveItem"
                                               before-select-item="beforeselectItem"
                                               suggestions-arr="complaint">
                        </multiple-autocomplete>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <div class="input-group">
                        <span class="input-group-addon">Observation</span>
                        <textarea class="form-control" name="obser" ng-model="detailsInfo.observation"></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <div class="input-group">
                        <span class="input-group-addon">Investigation</span>
                        <textarea class="form-control" name="invest" ng-model="detailsInfo.investigation"></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <div class="input-group">
                        <span class="input-group-addon">Procedures</span>
                        <textarea class="form-control" name="procedures" ng-model="detailsInfo.procedures"></textarea>
                      </div>
                    </div>
                  </div>


                  <div class="form-action">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"
                                ng-disabled="myform.$invalid " ng-click="submitted=true">Save
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

<div class="modal fade" id="myModal1" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">

      <div class="modal-header">
        <div class="row">
          <div class="col-lg-12">
            <form role="form" class="form-horizontal" name="myform1"  ng-submit="submitModel()">
              <fieldset>
                <h4>Are you sure you want to proceed with none?</h4>

                <div class="modal-body">
                  <div class="form-action">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"  ng-click="submitted=true">Yes</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                      </div>

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
<script src="<%=request.getContextPath()%>/static/js/editComplaints.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>
