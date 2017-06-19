<html ng-app="myApp" ng-controller="myCtrl">
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
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i> </span>
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" ng-model="email" autofocus required>
                                </div>
                                <div class="text-danger wrapper text-center ng-binding" ng-show="message">
                                    Please enter valid username or password
                                </div>

                            </div>

                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> </span>
                                <input class="form-control" placeholder="Password" name="password" type="password" value="" ng-model="password" required>
                                    </div>
                            </div>
                    <div class="row">
                        <div class="col-lg-4">
                        <input type="submit" ng-click="submit()" class="btn  btn-block btn-blue" value="Login"/>
                        </div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-6">
                            <a href="<%=request.getContextPath()%>/ForgotPassword" class="txt-clr"  >Forgot Password ?</a>
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

<script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/multiple-select/multiple-select.js"></script>
<script src="<%=request.getContextPath()%>/static/vendor/js-custom-select/customSelect.js"></script>

<script src="<%=request.getContextPath()%>/static/vendor/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>
<script src="<%=request.getContextPath()%>/static/js/angular-base64-upload.js"></script>

</body>
</html>