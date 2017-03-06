<html ng-app="myApp" ng-controller="myCtrl">
<head>
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/vendor/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="jumbotron" style="background-color: #fff">
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" >
                        <fieldset>
                            <div class="text-danger wrapper text-center ng-binding" ng-show="message">
                                Please enter valid username or password
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="email" type="email" ng-model="email" autofocus required>
                            </div>

                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="" ng-model="password" required>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" ng-click="submit()" class="btn btn-lg btn-success btn-block" value="Login"/>
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
<script src="<%=request.getContextPath()%>/static/js/index.js"></script>
<script src="<%=request.getContextPath()%>/static/js/mask.js"></script>
<script src="<%=request.getContextPath()%>/static/js/dirPagination.js"></script>

</body>
</html>