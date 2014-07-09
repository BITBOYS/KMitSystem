<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Offline Page">
        <meta name="author" content="Malte Dammann">

        <title>Offline - Leago</title>

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
                    <h1 class="page-header">Offline <small>Schnell wieder eine Verbindng herstellen</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="disabled"><a href="#">Other Pages</a></li>
                        <li class="active"><%=pageContext.getErrorData().getStatusCode()%></li>
                    </ol>
                </div>

            </div>

            <div class="row">

                <div class="col-lg-12">
                    <p class="error-404">You are Offline></p>
                    <p class="lead">Du bist nicht online. F&uml;r diese Seite brauchst du eine Internetverbindung.</p>
                    <p> Versuche es dann erneut!</p>
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