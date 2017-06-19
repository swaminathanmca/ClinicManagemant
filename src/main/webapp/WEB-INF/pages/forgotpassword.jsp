<%--
  Created by IntelliJ IDEA.
  User: Lissomsoft
  Date: 06/14/17
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<html ng-app="myApp" ng-controller="forgotPassword">
<head>
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/static/css/custom.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="background-color: #E4E5E6">
<div class="container">
  <div class="jumbotron" style="background-color: #E4E5E6">
  </div>
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="login-panel panel">
        <div class="panel-heading">

          <p class="text-center">
            <img src="../Clinic/static/img/logo.png"  width="70" height="50" >

          </p>
          <h1 class="text-center" style="color:#0F80A2" >Login</h1>
          <%--  <h1 class="text-center">Login</h1>--%>
          <%--  <p class="text-muted">Sign In to your account</p>--%>
        </div>
        <div class="panel-body">
          <form role="form" >
            <fieldset>

              <div class="form-group">
                <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i> </span>
                  <input class="form-control" placeholder="E-mail" name="email" type="email" ng-model="email" autofocus required>
                </div>
                <div class="text-danger wrapper text-center ng-binding" ng-show="status==false">
                  Please enter valid Email-Id
                </div>
              </div>
              <div class="row">
                <div class="col-lg-4">
                  <input type="submit" ng-click="submit()" class="btn  btn-block btn-blue" value="Submit"/>
                </div>
              </div>
              <!-- Change this to a button or input when using this as a form -->

            </fieldset>
          </form>
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
        <div class="row">
          <div class="col-lg-12">
            <form role="form" class="form-horizontal" name="myform1"  ng-submit="submitModel()">
              <fieldset>

                <h4 class="text-center "><a style="color: #333;"> <i class="fa fa-warning"></i></a> Check your email for further instructions.</h4>

                <div class="modal-body">
                  <div class="form-action">
                    <div class="row">
                      <div class="text-center">
                        <button type="submit" class="btn " style="background-color: #20A8D8;padding: 6px 55px" ng-click="submitted=true">Ok</button>

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
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>

<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/fp.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>

</body>
</html>
