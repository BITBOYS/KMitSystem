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

        <%
            String link = request.getContextPath();
            
            List<Error> errors = (ArrayList<Error>) request.getSession().getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
        %>

        <title>Sign Up - KmS</title>

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

                <% if (errors.size() > 0) {
                    for (int idx = 0; idx < errors.size(); idx++) {%>

                <div class="alert alert-warning"> <%= errors.get(idx).getErrorMessage()%> </div>

                <% }
                    request.getSession().setAttribute("errors", null);
                }%>

                <div class="col-lg-12">
                    <h1 class="page-header">Sign Up <small>Viel Spaﬂ beim Kickern!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="active">Sign Up</li>
                    </ol>
                </div>

                <div align="center">	
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <div align="center">
                            <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                                 alt="You!">
                        </div>  
                        <br>   
                        <form action="${pageContext.request.contextPath}/CreateUserServlet" method="post" class="form" role="form">
                            <div class="row">
                                <div class="col-md-12">
                                    <input class="form-control" name="name" placeholder="Name" type="text"
                                           required autofocus />
                                    <input class="form-control" name="email" placeholder="Deine E-Mail" type="email" required/>
                                    <input class="form-control" name="password" placeholder="Passwort" type="password" required/>
                                    <input class="form-control" name="reenter_password" placeholder="Passwort wiederholen" type="password" required/>
                                </div>
                            </div>

                            <br>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Sign up</button>
                        </form>
                        <a href="<%=link%>/faq" class="pull-right need-help">Brauchst du Hilfe? </a><span class="clearfix"></span>
                        <br>
                        <a href="<%=link%>/login" class="text-center new-account">Schon angemeldet? Jetzt einloggen! </a>
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