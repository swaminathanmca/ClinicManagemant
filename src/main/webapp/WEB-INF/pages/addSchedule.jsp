<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 06/19/17
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp" ng-controller="Schedule">
<head>
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
                <a href="#">View Schedule</a>
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

    <div class="row">

      <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title"> Doctor Schedule</h3>
          </div>

          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12">
                <form class="form-horizontal ng-invalid" role="form" name="myform" ng-submit="submit()"
                      novalidate>
                  <fieldset>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Branch</span>
                          <select class="form-control" ng-options="b.branch_id as b.branch_name for b in branchDetails" ng-model="branch_idd" ng-change="getDoctor(branch_idd)">
                          </select>
                        </div>
                      </div>
                      <div class="col-lg-4">
                        <div class="input-group">
                          <span class="input-group-addon">Practitioner</span>
                          <%--<select class="form-control" ng-options="s.doctor_id as s.profile_name for s in profile" ng-model="doctor_id" name="doctor" ng-blur="change(doctor_id)" required></select>--%>
                         <%-- <div name="doctor"  custom-select="s.doctor_id as s.profile_name for s in profile | filter: { profile_name : $searchTerm }"   ng-model="doctor_id" ng-change="change(doctor_id)" required>--%>
                          <input type="text" ng-model="selected" typeahead="s as s.profile_name  for s in profile | filter:{profile_name:$viewValue} | limitTo:5"  name="doctor" class="form-control" ng-blur="validate()"  required>
                        </div>
                        <span style="color: red" ng-show="validateDoctor">Please choose a valid doctor.</span>

                      </div>

                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Start Date</span>
                          <input type="text" class="form-control" name="exp_date" placeholder="mm-dd-yyyy" ng-click="open2($event)" datepicker-popup="{{format}}" ng-model="from_date"  min-date="date"  max-date="dtmax" is-open="opened2" datepicker-options="dateOptions" close-text="Close" style="height: 37px" disabled="disabled" required/>
                      <span class="input-group-btn">
                         <button type="button" class="btn btn-default" ng-click="open2($event)" style="height: 37px"><i class="glyphicon glyphicon-calendar"></i></button>
                      </span>
                        </div>
                      </div>


                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Start Time </span>
                          <input  type="text" class="form-control timer" placeholder="__:__ __" ng-model="start_time" ng-change="timeValidation()">
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">End Time</span>
                          <input  type="text" class="form-control timer" placeholder="__:__ __" ng-model="end_time" ng-change="timeValidation()">
                        </div>
                        <span style="color: red"  ng-show="toTimeFlag" >To time should be greater than from time. </span>
                      </div>

                      <div class="col-lg-6">
                          <div class="input-group">
                            <span class="input-group-addon">Day Frequency</span>
                            <div class="checkbox fileRadioBox form-control">&nbsp;
                              <label>
                                <input type="checkbox"  ng-true-value="'2'"  ng-false-value="''"  ng-model="day1"   class="ng-pristine ng-untouched" checked="checked" />MON
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'3'"  ng-false-value="''"  ng-model="day2"   class="ng-pristine ng-untouched" checked="checked" />TUE
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'4'"  ng-false-value="''"  ng-model="day3"   class="ng-pristine ng-untouched" checked="checked" />WED
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'5'"  ng-false-value="''"  ng-model="day4"   class="ng-pristine ng-untouched" checked="checked" />THU
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'6'"  ng-false-value="''"  ng-model="day5"   class="ng-pristine ng-untouched" checked="checked" />FRI
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'7'"  ng-false-value="''"  ng-model="day6"   class="ng-pristine ng-untouched" checked="checked" />SAT
                              </label>
                              <label>
                                <input type="checkbox"   ng-true-value="'1'"  ng-false-value="''"  ng-model="day7"   class="ng-pristine ng-untouched" checked="checked" />SUN
                              </label>
                            </div>
                          </div>
                        </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="checkbox pb10 fileRadioBox">
                          <label>
                            <input type="radio" name="type"  value="0"   ng-model="type" ng-click="changes()"  required>Never End
                          </label>
                          <label>
                            <input type="radio" name="type" value="1"  ng-model="type"   required>
                            After
                          </label>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Occurences</span>
                          <input class="form-control" type="text" ng-model="adays" ng-disabled="type==0">
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Time Duration </span>
                          <div class="checkbox pb10 fileRadioBox">
                            <label>
                              <input type="radio" name="time"  value="0"   ng-model="time"   required>15 Minutes
                            </label>
                            <label>
                              <input type="radio" name="time" value="1"  ng-model="time"      required> 30 Minutes
                            </label>
                            <label>
                              <input type="radio" name="time" value="2"  ng-model="time"      required> 1  Hour
                            </label>
                          </div>

                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-lg-6" ng-if="day1=='MON'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> MON
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day2=='TUE'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> TUE
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day3=='WED'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> WED
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day4=='THU'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> THU
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day5=='FRI'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> FRI
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day6=='SAT'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> SAT
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                      <div class="col-lg-6" ng-if="day7=='SUN'">
                        <div class="col-lg-3">
                          <img class="check_img" src="<%=request.getContextPath()%>/static/img/checked_box.png"> SUN
                        </div>
                        <div class="col-lg-9">{{start_time}}&nbsp-&nbsp{{end_time}}</div>
                      </div>
                    </div>
                    <div class="form-group" ng-show="con_status">
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
                                  ng-disabled="myform.$invalid || toTimeFlag || validateDoctor " ng-click="submitted=true">Add Schedule
                          </button>
                          <button type="button" class="btn btn-inverse" ng-click="cancel()">Cancel</button>
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
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/moment/moment.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/addSchedule.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
