<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Loginformular">
        <meta name="author" content="Malte Dammann">

        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%> 

        <%  String link = request.getContextPath(); %>

        <title>Login - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>

        <%@include file="../snipplets/header_public.jspf" %>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Login <small>Hier einloggen!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li class="active">Login</li>
                    </ol>
                </div>

                <!-- Alerts -->
                <%@include file="../snipplets/error.jspf" %>
                    
                <div class="col-lg-12">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <div class="account-wall">
                            <div align="center">
                                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                                     alt="You!">
                            </div>  
                            <br>  
                            <form class="form-signin" action="<%=link%>/login" method="post" role="form">
                                <input type="email" class="form-control" placeholder="Email" name="email" required autofocus>
                                <input type="password" class="form-control" placeholder="Password" name="password" required>
                                <a href="forgotten" class="pull-right need-help">Passwort vergessen? </a><span class="clearfix"></span>
                                <br>
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                            </form>
                        </div>
                        <a href="<%=link%>/faq" class="pull-right need-help">Brauchst du Hilfe? </a><span class="clearfix"></span>
                        <br>
                        <a href="<%=link%>/register" class="text-center new-account">Noch nicht angemeldet? Jetzt account erstellen! </a>
                    </div>
                </div>

            </div><!-- /.row -->

            <br>

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