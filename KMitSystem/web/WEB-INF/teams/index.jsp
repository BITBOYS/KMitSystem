
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%> 
        <%@page import="com.kmitsystem.tools.objects.Team"%>
        <%            String link = request.getContextPath();
            System.out.println(link);
            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
            List<Team> teams = (List<Team>) request.getAttribute("teams");
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Teams Page">
        <meta name="author" content="Malte Dammann">

        <title>Teams - Leago</title>

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
                    <h1 class="page-header">Teams <small>Suche speziell nach Teams oder Teams deiner Freunde!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li class="active">Teams</li>
                    </ol>
                </div>

                <%if (user != null) {%>
                <div class="row">
                    <div class="col-xs-3">
                    </div>
                    <div class="col-lg-offset-10 col-xs-2">
                        <a class="btn btn-success" href="<%=link%>/teams/create"><span class="fa fa-pencil"> Team erstellen <i class="fa fa-angle-right"></i></a>
                    </div>
                </div><!-- .row -->
                <%}%>

            </div><!-- .row -->

            <div class="row">
                <div class="col-xs-1"></div>
                <div class="col-md-12 col-xs-10">
                    <h2 class="page-header">Teamsuche</h2>

                    <div class="row well">
                        <form class="form-horizontal" role="form" action="<%=link%>/teams" method="get">

                            <div class="col-sm-4 col-sm-offset-1">

                                <div class="form-group">
                                    <label for="inputTeamname" class="col-sm-2 control-label">Team</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="team" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputTurniername" class="col-sm-2 control-label">Turnier</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="tournament" placeholder="Name">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-5 col-sm-offset-1">

                                <div class="form-group">
                                    <label for="inputUsername" class="col-sm-4 control-label">User</label>
                                    <div class="col-sm-6 ">
                                        <input type="text" class="form-control" name="user" placeholder="Name">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputDate" class="col-sm-4 control-label">Gr&uuml;ndungsdatum</label>
                                    <div class="col-lg-6  col-offset-2">
                                        <input type="date" name="date">
                                    </div>
                                </div>
                                <hr>
                                <p class="help-block">Suche nach Teamnamen, speziell nach Teams die in bestimmtet Turnieren spielen oder in den bestimmte User Mitglied sind.</p>

                                <div class="form-group">
                                    <div class="col-md-offset-8">
                                        <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Suche <i class="fa fa-angle-right"></i></button>
                                    </div>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div> <!-- row --> 

        <% if (teams != null) { %>

        <% if (errors.size() > 0) { %>
        <div class="alert alert-info">Es wurden keine Teams geunden</div>
        <% } else { %>
        <% if (teams.size() == 1) {%>
        <div class="alert alert-success">Es wurde <%=teams.size()%> Team gefunden</div>
        <% } else {%>
        <div class="alert alert-success">Es wurden <%=teams.size()%> Teams gefunden</div>
        <% } %>
        <% } %>

        <% for (int idx = 0; idx < teams.size(); idx++) {%>

        <hr>  

        <div class="row">
            <div class="col-xs-1"></div>
            <div class="col-md-10 col-xs-10">
                <h3><%= teams.get(idx).getName()%></h3>
                <h4>Leader: <a href="<%=link%>/user/profile?user=<%=teams.get(idx).getLeader().getUsername()%>"><%=teams.get(idx).getLeader().getUsername()%></a></h4>
                <p>Gegr&uuml;ndet: <%= teams.get(idx).getCreate_date()%></p>
                <div class="col-xs-6"></div>
                <div class="col-sm-offset-10"> 
                    <a class="btn btn-success" href="<%=link%>/team/profile?team=<%=teams.get(idx).getName()%>">Zum Team <i class="fa fa-angle-right"></i></a>
                </div>

            </div>
        </div> <!-- row --> 

            <% }
                }%>

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