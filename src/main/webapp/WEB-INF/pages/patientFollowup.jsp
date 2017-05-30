<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2017
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="patientFollowup">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.css" rel="stylesheet">
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
      <p></p>
    </div>
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
                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()" novalidate>
                  <fieldset>
                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Patient Id</span>
                          <label class="form-control" type="text">{{patientcomplaint.patient_pid}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Patient Name</span>
                          <label class="form-control" type="text">{{patientcomplaint.first_name}} {{patientcomplaint.last_name}} </label>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Visit Type</span>
                          <label class="form-control" type="text" ng-if="patientcomplaint.height==0" >New</label>
                          <label class="form-control" type="text" ng-if="patientcomplaint.height==1" >FollowUp</label>

                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Weight</span>
                          <label class="form-control" type="text">{{patientcomplaint.weight}}</label>
                          <span class="input-group-addon">KG</span>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">BP</span>
                          <label class="form-control" type="text"  >{{patientcomplaint.pressure}}</label>
                        </div>
                      </div>

                    </div>
                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Refereal Details</span>
                          <label class="form-control" type="text">{{patientcomplaint.refereal_details}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Diagnosis</span>
                          <textarea type="text" class="form-control" ng-model="info.diagonics" name="diagnosis"  required> </textarea>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.diagnosis.$invalid &&  myform.diagnosis.$touched">Please Enter The Diagnosis</span>
                      </div>

                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Complaint</span>
                          <%-- <select class="form-control" ng-model="complaint_id" name="complaint"  ng-options="s.complaint_id as s.complaint_name for s in complaint" required ></select>--%>
                          <multiple-autocomplete ng-model="selectSpecialization"  name="multipleselect" required="true"
                                                 object-property="complaint_name"
                                                 after-select-item="afterSelectItem"
                                                 after-remove-item="afterRemoveItem"

                                                 suggestions-arr="complaint">
                          </multiple-autocomplete>
                        </div>
                        <span class="text-danger wrapper text-center ng-binding"
                              ng-show="myform.complaint.$invalid &&  myform.complaint.$touched">Please Enter The Complaint</span>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Observation</span>
                          <textarea type="text" class="form-control" ng-model="info.observation" name="observation" rows="4" required> </textarea>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.observation.$invalid &&  myform.observation.$touched">Please Enter The Diagnosis</span>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Investigation</span>
                          <textarea type="text" class="form-control" ng-model="info.investigation" name="investigation" rows="4" required> </textarea>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-12">
                        <div class="input-group">
                          <span class="input-group-addon">Procedures</span>
                          <textarea type="text" class="form-control" ng-model="info.procedures" name="procedures" required> </textarea>
                        </div>
                      <span class="text-danger wrapper text-center ng-binding"
                            ng-show="myform.procedures.$invalid &&  myform.procedures.$touched">Please Enter The Procedures</span>
                      </div>
                    </div>

                  <%--  <div class="form-group">
                      <div class="col-lg-3">


                        <div class="checkbox  fileRadioBox form-control">&nbsp;
                          <label>
                            <input type="checkbox"  ng-model="labassit"   class="ng-pristine ng-untouched ng-valid ng-valid-required" checked="checked" />&nbsp;Lab Test
                          </label>
                        </div>

                      </div>
                    </div>--%>
                    <div class="form-group">
                      <div class="col-lg-5">
                        <div class="input-group">
                          <span class="input-group-addon">
                            TYPE
                          </span>
                          <%-- <SELECT class="form-control" ng-model="myform.type" ng-change="typepres(myform.type)" required>
                             <option value="1">Tablet</option>
                             <option value="2">Syrup</option>
                             <option value="3">Injection</option>
                           </SELECT>--%>
                          <div class="checkbox  fileRadioBox form-control">
                            <label>
                              <input type="radio" name="ltype"  value="1"   ng-model="ltype" required="required">&nbsp;Lab
                            </label>

                            <label>
                              <input type="radio" name="ltype" value="2"  ng-model="ltype" required="required">&nbsp;Prescription

                            </label>

                          </div>
                        </div>
                      </div>


                    </div>

                    <div class="form-actions">
                      <div class="row">
                        <div class="col-lg-offset-4 col-lg-7">
                          <button type="submit" class="btn btn-success"
                                  ng-disabled="myform.$invalid"       ng-click="submitted=true">Save
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
      <div class="col-lg-1"></div>
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
<script src="<%=request.getContextPath()%>/static/js/patientFollowup.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>



</body>
</html>