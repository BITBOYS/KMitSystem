<%@page import="java.util.ArrayList"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Turniere Page">
        <meta name="author" content="Malte Dammann">

        <title>Turniere - KmS</title>

        <%            String link = request.getContextPath();
            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
            List<Tournament> tournaments = (List<Tournament>) request.getAttribute("tournaments");
        %>

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
                    <h1 class="page-header">Turniere <small>Suche spezielle Turniere oder deine Freunde!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li class="active">Turniere</li>
                    </ol>
                </div>

                <%if (user != null) {%>
                <div class="row">
                    <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10">
                        <a class="btn btn-success" href="<%=link%>/tournament/create"><span class="fa fa-pencil"> Turnier erstellen <i class="fa fa-angle-right"></i></span></a>
                    </div>
                </div><!-- .row -->
                <%}%>

                <div class="row">  
                    <div class="col-lg-12">
                        <h2 class="page-header">Turniersuche</h2>
                        <div class="row well">
                            <form class="form-horizontal" role="form" action="<%=link%>/tournaments">

                                <div class="col-lg-4 col-lg-offset-1">

                                    <div class="form-group">
                                        <label for="inputTurniername" class="col-sm-2 control-label">Turnier</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="tournament_name_search" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputTeamname" class="col-sm-2 control-label">Team</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="team_name_search" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputUsername" class="col-sm-2 control-label">User</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" name="user_name_search" placeholder="Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-lg-offset-1">

                                    <div class="form-group">
                                        <label for="inputDate" class="col-sm-2 control-label">Erstellmonat</label>
                                        <div class="col-lg-6  col-offset-2">
                                            <input type="month" name="createMonth_search">
                                        </div>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="running_search"> laufendes Turnier
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="finished_search"> beendetes Turnier
                                        </label>
                                    </div>
                                    <p class="help-block">Suche nach Turniernamen oder speziell nach Turnieren in denen Teams und User spielen.</p>
                                    <div class="form-group">
                                        <div class="col-md-offset-8">
                                            <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Suche <i class="fa fa-angle-right"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div> <!-- row --> 

                    <hr>

                    <% if (tournaments != null) { %>

                    <% if (errors.size() > 0) { %>
                    <div class="alert alert-info">Es wurden keine Turniere geunden</div>
                    <% } else { %>
                    <% if (tournaments.size() == 1) {%>
                    <div class="alert alert-success">Es wurde <%=tournaments.size()%> Turniere gefunden gefunden</div>
                    <% } else {%>
                    <div class="alert alert-success">Es wurden <%=tournaments.size()%> Turniere gefunden</div>
                    <% } %>
                    <% } %>

                    <% for (int idx = 0; idx < tournaments.size(); idx++) {%>

                    <hr>

                    <div class="row">

                        <div class="col-md-7">
                            <a href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>"><img class="img-responsive" src="http://placehold.it/750x350"></a>
                        </div>

                        <div class="col-md-5">
                            <h3><%=tournaments.get(idx).getName()%></h3>
                            <h4>Leader: <a href="<%=link%>/user/profile?user=<%=tournaments.get(idx).getLeader().getUsername()%>"><%=tournaments.get(idx).getLeader().getUsername()%></a></h4>
                            <p><%= tournaments.get(idx).getDescription()%></p>
                            <a class="btn btn-success" href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>">Zum Turnier <i class="fa fa-angle-right"></i></a>
                        </div>

                    </div>

                    <% }
                        }%>
                </div>
            </div>
        </div>

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