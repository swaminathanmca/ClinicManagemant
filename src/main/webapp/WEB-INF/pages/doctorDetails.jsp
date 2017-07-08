<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 3/21/2017
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  ng-app="myApp"  ng-controller="doctorDetails ">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/sb-admin-2.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
</head>
<body>
<div id="wrapper">
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0px">
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
            <a href="#"><i class="fa fa-user-md"></i> Doctor<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="AddDoctor">Add Doctor</a>
              </li>
              <li>
                <a href="ViewDoctor">View Doctor</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
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
            <!-- /.nav-second-level -->
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


        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>
  <div id="page-wrapper">
    <br>
    <div class="row">
      <div class="col-lg-12">
        <h4 class="page-header"> {{clinic_name}} Hospital  <span></span> (Branch : &nbsp;{{branch_name}})</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Doctor Details</h3>
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
                          <span class="input-group-addon">Name</span>
                          <label class="form-control" type="text">{{data.name}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Address</span>
                          <label class="form-control" type="text">{{data.address1}},{{data.address2}}</label>
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
                      <span class="input-group-addon">PinCode</span>
                      <label class="form-control" type="text">{{data.pincode}}</label>
                    </div>
                  </div>
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Gender</span>
                      <label class="form-control" type="text" ng-if="data.gender==1">Male</label>
                      <label class="form-control" type="text" ng-if="data.gender==0">FeMale</label>
                    </div>
                  </div>
                </div>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Country</span>
                          <select id="countries1" class="input-medium form-control" name="country" disabled></select>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Qualification</span>
                          <label class="form-control" type="text">{{data.qualification}}</label>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Specialization</span>
                          <li  class="form-control">
                            <span ng-repeat="specailitys in speciality"> {{specailitys.speciality_name}},</span>
                          </li>
                        </div>
                      </div>


                    </div>
                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon">Email Id</span>
                          <label class="form-control" type="text">{{data.email}}</label>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Phone No</span>
                          <label class="form-control" type="text">{{data.phone}}</label>
                        </div>
                      </div>
                      <div class="col-lg-3">
                        <div class="input-group">
                          <span class="input-group-addon">Register Id</span>
                          <lablel class="form-control" type="text">{{data.reg_id}}</lablel>
                        </div>
                      </div>
                    </div>


     <div class="form-group">
       <div class="col-lg-6 ">
         <div class="input-group">
           <span class="input-group-addon">Clinic Name</span>
           <label class="form-control">{{data.clinic_name}}</label>
         </div>
       </div>
       <div class="col-lg-3">
         <div class="input-group">
           <span class="input-group-addon">Consulting Fees</span>
           <label class="form-control">{{data.charges}}</label>
         </div>
       </div>
       <div class="col-lg-3">
         <div class="input-group">
           <span class="input-group-addon">Room No</span>
           <label class="form-control">{{data.roomno}}</label>
         </div>
       </div>

     </div>
                    <div class="form-group">
                      <div class="col-lg-6">
                        <div class="input-group">
                          <span class="input-group-addon" id="branch_name">Branch</span>
                          <li  class="form-control">
                            <span ng-repeat="branch in branches"> {{branch.branch_name}},</span>
                          </li>
                          <%--  <label class="form-control" type="text">{{branch_name}}</label>--%>
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



  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header panel-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Doctor</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-lg-12">
              <form role="form" class="form-horizontal" name="myform" ng-submit="submit(x.branch_id)">
              <fieldset>
              <div class="form-group">
                <div class="col-lg-6">
                  <div class="input-group">
                    <span class="input-group-addon">Name</span>
                    <input type="text" class="form-control" ng-model="x.name">
                  </div>
                </div>

                <div class="col-lg-6">
                  <div class="input-group">
                    <span class="input-group-addon">Gender</span>
                    <div class="checkbox  fileRadioBox form-control">
                      <label>
                        <input type="radio" name="sex" value="1" ng-model="x.gender"   class="ng-pristine ng-untouched ng-valid ng-valid-required" checked="checked"/>&nbsp;Male
                      </label>
                      <label>
                        <input type="radio" name="sex" value="0" ng-model="x.gender"  class="ng-pristine ng-untouched ng-valid ng-valid-required">&nbsp;Female
                      </label>
                    </div>

                  </div>
                </div>
              </div>
                <div class="form-group">
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Register No</span>
                      <input class="form-control" type="text" ng-model="x.reg_id">
                    </div>
                  </div>
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Qualification</span>
                      <input class="form-control" type="text" ng-model="x.qualification">
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">Specialization</span>
                      <multiple-autocomplete ng-model="selectSpecialization" name="multipleSelect" required="true" object-property="speciality_name"
                                             after-select-item="afterselectItem"
                                             after-remove-item="afterremoveItem"
                                             before-select-item="beforeselectItem"
                                             suggestions-arr="specialitydetails">
                      </multiple-autocomplete>
                    </div>
                  </div>
                </div>
              <div class="form-group">
                <div class="col-lg-6">
                  <div class="input-group">
                    <span class="input-group-addon">Address1</span>
                    <input type="text" class="form-control" name="address1" ng-model="x.address1">
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="input-group">
                    <span class="input-group-addon">Address2</span>
                    <input type="text" class="form-control" name="address2" ng-model="x.address2">
                  </div>
                </div>
              </div>
            <div class="form-group">
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">City</span>
                  <input type="text" class="form-control" name="city" ng-model="x.city">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">State</span>
                  <input type="text" class="form-control" name="city" ng-model="x.state">
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">
                    Country
                  </span>
                  <select id="countries2" class="input-medium form-control" name="country" ></select>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="input-group">
                  <span class="input-group-addon">
                    PinCode
                  </span>
                  <input class="form-control" type="text" ng-model="x.pincode" name="pincode">
                </div>
              </div>
            </div>
                <div class="form-group">
                  <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">Phone No</span>
                      <input  type="text " class="form-control" ui-mask="9999-999-999" ng-model="x.phone" name="cphoneno" ng-blur="EditChiefContact(x.profile_id,x.phone)" required>
                    </div>
                     <span class="text-danger wrapper text-center ng-binding"
                           ng-show="myform.cphoneno.$invalid">Please  Enter Phone No </span>
                                              <span class="text-danger wrapper text-center ng-binding" ng-show="err==false">
                                                       The Mobile Number Already Taken
                                                           </span>
                  </div>
                  <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">Email Id</span>
                      <input  type="text " class="form-control" ng-model="x.email" name="email" ng-blur="EditCemail(x.profile_id,x.email)" required>
                    </div>
                    <span class="text-danger wrapper text-center ng-binding"
                          ng-show="myform.email.$invalid">Please  Enter Email-id </span>
                                            <span class="text-danger wrapper text-center ng-binding" ng-show="err_chief_email==false">
                                                       The Email Already Taken
                                                           </span>
                  </div>
                 <%-- <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Branch</span>
                      &lt;%&ndash;<select class="form-control"  ng-options="s.branch_id as s.branch_name for s in branch" ng-model="x.branch_id"></select>&ndash;%&gt;

                    </div>
                  </div>
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Password</span>
                      <input class="form-control" ng-model="x.password" name="password">
                    </div>
                  </div>--%>

                </div>
                <div class="form-group">
                  <div class="col-lg-6" >
                    <div class="input-group">
                      <span class="input-group-addon">Branch Name</span>
                      <%-- <select class="form-control" ng-options="s.branch_id as s.branch_name for s in branchDetails" ng-model="data.branch_id"></select>--%>
                      <multiple-autocomplete ng-model="selectedList" name="multipleSelect" required="true" object-property="branch_name"
                                             after-select-item="afterSelectItem"
                                             after-remove-item="afterRemoveItem"
                                             before-select-item="beforeSelectItem"
                                             suggestions-arr="branch">
                      </multiple-autocomplete>
                    </div>
        <span class="text-danger wrapper text-center ng-binding"
       ng-show="myform.multipleSelect.$invalid && myform.multipleSelect.$untouched">Please  Select Branch </span>
                  </div>
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Consulting Fee</span>
                      <input type="text" class="form-control" ng-model="x.charges" required>
                    </div>
                  </div>
                  <div class="col-lg-3">
                    <div class="input-group">
                      <span class="input-group-addon">Room No</span>
                      <input type="text" class="form-control" ng-model="x.roomno" >
                    </div>
                  </div>


                </div>
                <div class="form-action">
                  <div class="row">
                    <div class="col-lg-offset-4 col-lg-7">
                      <button type="submit" class="btn btn-success"
                              ng-disabled="myform.$invalid  || !chiefError || !chiefEmail " ng-click="submitted=true">Save
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


<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/metisMenu/metisMenu.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/getClinic.js"></script>
<script src="<%=request.getContextPath()%>/static/js/doctorDetails.js"></script>
<script src="<%=request.getContextPath()%>/static/js/clinicDetails.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>


<script src="<%=request.getContextPath()%>/static/vendor/bootstrap-helpers/js/bootstrap-formhelpers.min.js"></script>
</body>
</html>
