<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Passwort vergessen">
        <meta name="author" content="Malte Dammann">

        <title>Password Forgotten - KmS</title>
        
        <%
            String link = request.getContextPath();
            
            List<Error> errors = (ArrayList<Error>) request.getSession().getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
        %>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        
    </head>

    <body>

        <%@include file="../../snipplets/header_private.jspf" %>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Passwort vergessen</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li><a href="<%=link%>/login">Login</a></li>
                        <li class="active">Passwort vergessen</li>
                    </ol>
                </div>

            </div><!-- /.row -->

            <div class="row well col-sm-4 col-lg-offset-4">

                    <form role="form" method="POST" action="#">
                        <div class="row">
                            <div class="form-group">
                                <label for="input2">E-mail</label>
                                <div class="input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="email" name="email" class="form-control" id="input1">
                                </div>
                            </div>
                        </div><!-- /.row -->
                        <div class="row">
                            <div class="form-group">
                                <button type="submit" class="fa fa-mail btn btn-primary"> Submit </button>
                            </div>
                        </div>
                    </form>

            </div><!-- /.row -->

        </div><!-- /.container -->

        <div class="container">

            <%@include file="../../snipplets/footer.jspf" %>

        </div><!-- /.container -->
        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=link%>/public/js/jquery.js"></script>
        <script src="<%=link%>/public/js/bootstrap.js"></script>
        <script src="<%=link%>/public/js/modern-business.js"></script>

    </body>
</html>
