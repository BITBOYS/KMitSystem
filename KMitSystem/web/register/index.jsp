<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="F&uuml;r Kickern mit System Registrieren">
        <meta name="author" content="Malte Dammann">

        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%> 

        <%            String link = request.getContextPath();
        %>

        <title>Sign up - Leago</title>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    </head>

    <body>

        <%@include file="../snipplets/header.jspf" %>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Sign Up <small>Viel Spaﬂ beim Kickern!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="active">Sign up</li>
                    </ol>
                </div>

                <!-- Alerts -->
                <%@include file="../snipplets/error.jspf" %>

                <div align="center" class="col-sm-6 col-md-4 col-md-offset-4 well">
                    <form action="<%=link%>/register" method="post" class="form" role="form">
                        <div class="form-group">
                            <input class="form-control" name="name" placeholder="Name" type="text"
                                   required autofocus />
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="email" placeholder="Email" type="email" required/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="password" placeholder="Password" type="password" required/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="reenter_password" placeholder="Re-enter Password" type="password" required/>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Sign me up!</button>
                        </div>
                    </form>
                    <a href="<%=link%>/faq" class="pull-right need-help">Brauchst du Hilfe? </a><span class="clearfix"></span>
                    <hr>
                    <p class="text-center">Have an account? <b><a href="<%=link%>/login" class="text-center new-account">Log in!</a></b></p>
                </div>
            </div>

        </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="container">

        <%@include file="../snipplets/footer.jspf" %>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=link%>/public/js/jquery.js"></script>
    <script src="<%=link%>/public/js/bootstrap.js"></script>
    <script src="<%=link%>/public/js/modern-business.js"></script>

</body>
</html>