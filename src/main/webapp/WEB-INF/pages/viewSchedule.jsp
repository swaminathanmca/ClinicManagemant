<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 07/08/17
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="getSchedule">
<head>
    <title></title>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/js-custom-select/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css"
        rel="stylesheet">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/vendor/jquery-ui/jquery-ui.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
          <li ng-show="role=='Admin'">
            <a href="#"><i class="fa fa-table fa-fw"></i> Branch<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddBranch">Add Branch</a>
              </li>
              <li>
                <a href="GetBranch">View Branch</a>
              </li>
            </ul>
          </li>
          <li ng-hide="role=='SuperAdmin'">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Doctor<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddDoctor">Add Doctor</a>
              </li>
              <li>
                <a href="ViewDoctor">View Doctor</a>
              </li>
            </ul>
          </li>
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
            <a href="#"><i class="fa fa-user-o"></i> FrontDesk<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddFrontDesk">Add FrontDesk</a>
              </li>
              <li>
                <a href="ViewFrontDesk">View FrontDesk</a>
              </li>
            </ul>
          </li>
          <li ng-show="role=='BranchAdmin' || role=='Admin'">
            <a href="#"><i class="fa fa-ambulance"></i>&nbsp;Services<span class="fa arrow"></span> </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddService"> Add Service</a>
              </li>
              <li>
                <a href="ViewService">View Service</a>
              </li>
            </ul>
          </li>
          <li>
            <a href=""><i class="fa fa-calendar-minus-o"></i>&nbsp;  Schedule <span class="fa arrow"></span> </a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddSchedule"> Add Schedule</a>
              </li>
              <li>
                <a href="ViewSchedule">View Schedule</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h4 class="page-header"> {{clinic_name}} Hospital  <span></span> (Branch : &nbsp;{{branch_name}})</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-3">
        <div class="input-group">
          <span class="input-group-addon">Branch</span>
          <select class="form-control" ng-options="b.branch_id as b.branch_name for b in branchDetails" name="branch" ng-model="branch_id" ng-change="getDoctor(branch_id)"></select>
        </div>

        </div>
      <div class="col-lg-4">
        <div class="input-group">
          <span class="input-group-addon">Practitioner</span>
          <select class="form-control" ng-options="p.doctor_id as p.profile_name for p in profile" name="doctor_name" ng-model="doctor_id" ng-change="getSchedule(doctor_id)">

          </select>

        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Schedule</h3>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
               <div class="table-responsive">
                 <table class="table table-striped table-bordered table-hover " id="dataTables-example">
                     <thead>
                     <tr>

                       <th>Start Date</th>
                       <th>End Date</th>
                       <th>Start Time</th>
                       <th>End Time</th>
                       <th>Options</th>
                     </tr>

                     </thead>
                     <tbody>
                     <tr ng-repeat="x in schedule">
                       <td>{{x.start_date}}</td>
                       <td>{{x.end_date}}</td>
                       <td>{{x.start_time}}</td>
                       <td>{{x.end_time}}</td>
                       <td><button type="button" name="edit" class="btn btn-sm" data-toggle="modal" data-target="#myModal" ng-click="edit(x.schedule_id)">Edit</button></td>

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
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit  Schedule</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">
              <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit(scheduledetails.schedule_id)" novalidate>
                <fieldset>
              <div class="form-group">
                <div class="col-lg-4">
                <div class="input-group">
                  <span class="input-group-addon">Start Date</span>
                  <input type="text" class="form-control" name="exp_date" placeholder="mm-dd-yyyy" ng-click="open2($event)" datepicker-popup="{{format}}" ng-model="scheduledetails.start_date"  ng-change="change()" min-date="date"  max-date="dtmax" is-open="opened2" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                         <button type="button" class="btn btn-default" ng-click="open2($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                </div>
                  <span style="color: red"  ng-show="myform.exp_date.$untouched" >Start date should be greater than today. </span>
                </div>
                <div class="col-lg-4">
                  <div class="input-group">
                    <span class="input-group-addon">Start Time</span>
                    <input  type="text" class="form-control timer" placeholder="__:__ __" ng-model="scheduledetails.start_time" ng-change="timeValidation()">
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="input-group">
                    <span class="input-group-addon">End Time</span>
                    <input  type="text" class="form-control timer" placeholder="__:__ __" ng-model="scheduledetails.end_time" ng-change="timeValidation()">
                  </div>
                  <span style="color: red"  ng-show="toTimeFlag" >To time should be greater than from time. </span>
                </div>
              </div>
                  <div class="form-group">
                    <div class="col-lg-8">
                      <div class="input-group">
                        <span class="input-group-addon">Day Frequency</span>
                        <div class="checkbox fileRadioBox form-control" >&nbsp;
                          <label>
                            <input type="checkbox"  ng-true-value="'2'"  ng-false-value="''"  ng-model="scheduledetails.day1"   class="ng-pristine ng-untouched" checked="checked" />MON
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'3'"  ng-false-value="''"  ng-model="scheduledetails.day2"   class="ng-pristine ng-untouched" checked="checked" />TUE
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'4'"  ng-false-value="''"  ng-model="scheduledetails.day3"   class="ng-pristine ng-untouched" checked="checked" />WED
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'5'"  ng-false-value="''"  ng-model="scheduledetails.day4"   class="ng-pristine ng-untouched" checked="checked" />THU
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'6'"  ng-false-value="''"  ng-model="scheduledetails.day5"   class="ng-pristine ng-untouched" checked="checked" />FRI
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'7'"  ng-false-value="''"  ng-model="scheduledetails.day6"   class="ng-pristine ng-untouched" checked="checked" />SAT
                          </label>
                          <label>
                            <input type="checkbox"   ng-true-value="'1'"  ng-false-value="''"  ng-model="scheduledetails.day7"   class="ng-pristine ng-untouched" checked="checked" />SUN
                          </label>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-3">
                      <div class="checkbox pb10 fileRadioBox">
                        <label>
                          <input type="radio" name="type"  value="0"   ng-model="scheduledetails.end_type" ng-click="changes()"  required>Never End
                        </label>
                        <label>
                          <input type="radio" name="type" value="1"  ng-model="scheduledetails.end_type"   required>
                          After
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-3">
                      <div class="input-group">
                        <span class="input-group-addon">Occurences</span>
                        <input class="form-control" type="text" ng-model="scheduledetails.occurences" ng-disabled="scheduledetails.end_type==0">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="input-group">
                        <span class="input-group-addon">Time Duration </span>
                        <div class="checkbox pb10 fileRadioBox">
                          <label>
                            <input type="radio" name="time"  value="0"   ng-model="scheduledetails.time"   required>15 Minutes
                          </label>
                          <label>
                            <input type="radio" name="time" value="1"  ng-model="scheduledetails.time"      required> 30 Minutes
                          </label>
                          <label>
                            <input type="radio" name="time" value="2"  ng-model="scheduledetails.time"      required> 1  Hour
                          </label>
                        </div>

                      </div>
                    </div>
                  </div>
                  <div class="form-group" ng-show="con_status==false">
                    <div class="col-lg-12">
                      <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error: </span>
                        Schedule Unavailable
                      </div>
                    </div>
                  </div>

                  <div class="form-actions">
                    <div class="row">
                      <div class="col-lg-offset-4 col-lg-7">
                        <button type="submit" class="btn btn-success"
                                ng-disabled="myform.$invalid || toTimeFlag  " ng-click="submitted=true">Add Schedule
                        </button>
                        <button type="button" class="btn btn-inverse" data-dismiss="modal" >Cancel</button>
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
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getSchedule.js"></script>
</body>
</html>
