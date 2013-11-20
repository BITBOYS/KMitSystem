<!DOCTYPE html>
<html lang="en">
    <head>
        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Teams erstellen">
        <meta name="author" content="Malte Dammann">

        <%            
            String text = String.valueOf(request.getSession().getAttribute("text"));
            String link = request.getContextPath();

            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
        %>

        <title>Teams Erstellen - KmS</title>

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
                    <h1 class="page-header">Teams Erstellen <small>Erstelle Teams und lade Freunde ein!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li><a href="<%=link%>/teams">Teams</a></li>
                        <li class="active">Teams-erstellen</li>
                    </ol>
                </div>
            </div><!-- /.row -->

            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <form class="form-horizontal" role="form" action="<%=link%>/teams/create" method="post">

                            <div class="col-lg-4 col-lg-offset-1">
                                <div class="form-group">
                                    <label for="inputTeamname" class="col-sm-2 control-label">Name</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="name" placeholder="Teamname" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputTurniername" class="col-sm-2 control-label">Tag</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" name="tag" placeholder="Tag" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6 col-lg-offset-1">
                                <div class="form-group">
                                    <label for="inputUsername" class="col-sm-2 control-label">Passwort</label>
                                    <div class="col-lg-6">
                                        <input type="text" class="form-control" name="password" placeholder="Passwort">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputUsername" class="col-sm-2 control-label">Passwort wiederholen</label>
                                    <div class="col-lg-6">
                                        <input type="text" class="form-control" name="reenter_password" placeholder="Passwort wiederholen">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-4 col-lg-offset-1">
                                    <label for="userAuswahl" class="col-sm-2 control-label">User</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" style="display: inline" name="userAuswahl" placeholder="Username">
                                        <a href="#" style="display: inline">User hinzuf&uuml;gen</a>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group col-lg-4 col-lg-offset-1">
                                <div class="col-md-offset-6">
                                    <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Erstellen <i class="fa fa-angle-right"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="row">
                        <% for (int idx = 0; idx < errors.size(); idx++) { %>
                        <% if (errors.get(idx).getStatus().equals(Error.ERROR)) {%>
                        <div class="alert alert-danger"><%= errors.get(idx).getErrorMessage()%></div>
                        <% } else if (errors.get(idx).getStatus().equals(Error.INFO)) {%>
                        <div class="alert alert-info"><%= errors.get(idx).getErrorMessage()%></div>
                        <% }
                                }%>
                    </div>

                </div>
            </div>
        </div> <!-- row --> 

    </div><!-- /.container -->

    <div class="container">

        <%@include file="../../snipplets/footer.jspf"%> %>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=link%>/public/js/jquery.js"></script>
    <script src="<%=link%>/public/js/bootstrap.js"></script>
    <script src="<%=link%>/public/js/modern-business.js"></script>

</body>
</html>