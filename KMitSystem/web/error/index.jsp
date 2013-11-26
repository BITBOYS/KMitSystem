<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Error Page">
        <meta name="author" content="Malte Dammann">

        <title>Error Page - KmS</title>

        <%
                String link = request.getContextPath();
                String loged_in = String.valueOf(request.getSession().getAttribute("loged_in"));
        %>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>
        
        <%@include file="../WEB-INF/snipplets/header.jspf" %>

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Error <small>Page Not Found</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="disabled"><a href="#">Other Pages</a></li>
                        <li class="active"><%=pageContext.getErrorData().getStatusCode()%></li>
                    </ol>
                </div>

            </div>

            <div class="row">

                <div class="col-lg-12">
                    <p class="error-404">WHAT?! - <%=pageContext.getErrorData().getStatusCode()%></p>
                    <p class="lead">Es ist ein Fehler aufgetreten.</p>
                    <p>Das tut uns leid! Hier ein paar hilfreiche Links:</p>
                    <ul>
                        <li><a href="<%=link%>">Home</a></li>
                        <li><a href="<%=link%>/login">Login</a></li>
                        <li><a href="<%=link%>/register">Sign Up</a></li>
                        <li><a href="<%=link%>/about">About Us</a></li>
                        <li><a href="<%=link%>/service">Services</a></li>
                        <li><a href="<%=link%>/contact">Kontakt</a></li>
                        <li><a href="<%=link%>/faq">FAQ</a></li>
                    </ul>
                </div>

            </div>

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