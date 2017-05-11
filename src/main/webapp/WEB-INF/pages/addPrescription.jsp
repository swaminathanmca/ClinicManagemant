<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 04/28/17
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="Prescription">
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
            <h3 class="panel-title">Add Prescription</h3>
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
                          <label class="form-control" type="text">{{patientcomplaint.first_name}}&nbsp;{{patientcomplaint.last_name}}</label>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">
                            TYPE
                          </span>
                         <SELECT class="form-control" ng-model="myform.type" ng-change="typepres(myform.type)" required>
                           <option value="1">Tablet</option>
                           <option value="2">Syrup</option>
                           <option value="3">Injection</option>
                         </SELECT>
                        </div>
                      </div>
                      <div class="col-lg-4">
                        <div class="input-group">
                          <span class="input-group-addon">Prescription</span>
                         <%-- <SELECT class="form-control" ng-model="pres" ng-options="s.medicine_id as s.medicine_name for s in medicines">

                          </SELECT>--%>
                          <div   name="myform.medicine_id"  custom-select="s.medicine_id as s.medicine_name for s in medicines | filter: { medicine_name: $searchTerm }"   ng-model="medicine_id" required>

                          </div>
                        </div>

                      </div>
                <div class="col-lg-3">
                  <div class="input-group">
                    <span class="input-group-addon">Fasting</span>
                    <SELECT class="form-control" name="frequency" ng-model="myform.frequency" required>
                      <option value="0">Before</option>
                      <option value="1">After</option>
                    </SELECT>
                  </div>
                </div>
          <div class="col-lg-2">
            <div class="input-group">
              <span class="input-group-addon" >Days</span>
              <input name="dayscount" class="form-control" type="text"  ng-model="myform.count" ng-pattern="/^[0-9]*$/" required>
            </div>
             <span class="text-danger wrapper text-center ng-binding"
                   ng-show="myform.dayscount.$error.pattern">Please Enter Valid Days</span>
                                                <span class="text-danger wrapper text-center ng-binding"
                                                      ng-show="myform.dayscount.$invalid &&  myform.dayscount.$touched">Please Enter Days</span>
          </div>

                    </div>
<div class="form-group">
  <div class="col-lg-6">
    <div class="input-group">
                          <span class="input-group-addon">
                            Frequency
                          </span>
      <div class="checkbox  fileRadioBox form-control">&nbsp;
        <label>
          <input type="checkbox" ng-checked="selected=='1'"  ng-true-value="'1'"  ng-false-value="' '"  ng-model="myform.mrng"   class="ng-pristine ng-untouched ng-valid ng-valid-required" checked="checked" />&nbsp;Morning
        </label>
        <label>
          <input type="checkbox"  ng-checked="selected=='1'" ng-true-value="'1'" ng-false-value="' '"  ng-model="myform.aftn"  class="ng-pristine ng-untouched ng-valid ng-valid-required" >&nbsp;AfterNoon
        </label>
        <label>
          <input type="checkbox" ng-checked="selected=='1'"  ng-true-value="'1'" ng-false-value="' '" ng-model="myform.nght"  class="ng-pristine ng-untouched ng-valid ng-valid-required" >&nbsp;Night
        </label>
      </div>

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

            <div class="row" ng-if="selectedmaster.length ">
              <div class="col-lg-12">
                <div class="table-responsive">

                  <table class="table table-striped table-bordered table-hover " id="dataTables-example">
                    <thead>
                    <tr class="success">
                      <th><input type="checkbox" ng-model="selectedAll" ng-click="checkAll()"  /></th>
                      <th>Medicine_name</th>
                      <th>Mg</th>
                      <th>Frequency</th>
                      <th>Morning</th>
                      <th>AfterNoon</th>
                      <th>Night</th>
                      <th>Days</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr dir-paginate="x in selectedmaster | filter:search | orderBy : first_name | itemsPerPage :5" ng-click="editPatient(x.patient_id)">
                      <td><input type="checkbox" ng-model="x.selected" class="check"   ng-click="edit(x.selected)"/></td>
                      <td>{{x.medicine_name}}</td>
                      <td>{{x.mg}}</td>
                      <td ><p ng-if="x.frequency==0">Before Fasting</p>
                        <p ng-if="x.frequency==1">After  Fasting</p></td>
                      <td><p ng-if="x.mrg_qty==1"><i class="fa fa-check"></i> </p></td>
                      <td><p ng-if="x.aft_qty==1"><i class="fa fa-check"></i> </p></td>
                      <td><p ng-if="x.ngt_qty==1"><i class="fa fa-check"></i> </p></td>
                      <td>{{x.days}}</td>

                    </tr>


                    </tbody>

                  </table>
                  <p class=" text-center">
                    <dir-pagination-controls max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls>
                  </p>


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
          <h4 class="modal-title">Edit Prescription</h4>
        </div>

        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">
              <form role="form" class="form-horizontal" name="myform1"  ng-submit="editsubmit(x.prescription_id)">
                <fieldset>


                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Type</span>
                        <SELECT class="form-control" ng-model="types" ng-change="typepres(types)" required>
                          <option value="1">Tablet</option>
                          <option value="2">Syrup</option>
                          <option value="3">Injection</option>
                        </SELECT>
                      </div>
                    </div>
                    <div class="col-lg-5">
                      <div class="input-group">
                        <span class="input-group-addon">Prescription</span>
                        <div   name="medicine_id"  custom-select="s.medicine_id as s.medicine_name for s in medicines | filter: { medicine_name: $searchTerm }"   ng-model="x.medicine_id" required>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Fasting</span>
                        <SELECT class="form-control" name="frequency" ng-model="frequencys" required>
                          <option value="0">Before</option>
                          <option value="1">After</option>
                        </SELECT>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Days</span>
                        <input type="text" class="form-control" ng-model="x.days" required>
                      </div>
                    </div>

                    <div class="col-lg-6">
                      <div class="input-group">
                          <span class="input-group-addon">
                            Frequency
                          </span>
                        <div class="checkbox  fileRadioBox form-control">&nbsp;
                          <label>
                            <input type="checkbox" ng-checked="x.mrg_qty=='1'"  ng-true-value="'1'"  ng-false-value="' '"  ng-model="x.mrg_qty"   class="ng-pristine ng-untouched ng-valid ng-valid-required" checked="checked" />&nbsp;Morning
                          </label>
                          <label>
                            <input type="checkbox"  ng-checked="x.aft_qty=='1'" ng-true-value="'1'" ng-false-value="' '"  ng-model="x.aft_qty"  class="ng-pristine ng-untouched ng-valid ng-valid-required" >&nbsp;AfterNoon
                          </label>
                          <label>
                            <input type="checkbox" ng-checked="x.ngt_qty=='1'"  ng-true-value="'1'" ng-false-value="' '" ng-model="x.ngt_qty"  class="ng-pristine ng-untouched ng-valid ng-valid-required" >&nbsp;Night
                          </label>
                        </div>

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
<script src="<%=request.getContextPath()%>/static/js/addPrescription.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
</body>
</html>
