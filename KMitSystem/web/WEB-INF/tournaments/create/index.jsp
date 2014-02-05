<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Turnier Erstellen">
        <meta name="author" content="Malte Dammann">

        <title>Turnier Erstellen - leago</title>

        <%            String link = request.getContextPath();

            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }

            List<Team> teams = (ArrayList<Team>) request.getAttribute("teams");
            if (teams == null) {
                teams = new ArrayList<Team>();
            }

            List<Team> teamsAdded = new ArrayList<Team>();
        %>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>

        <%@include file="../../snipplets/header.jspf" %>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Turniere Erstellen <small>Erstelle Turniere und lade Teams ein!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li><a href="<%=link%>/tournaments">Turniere</a></li>
                        <li class="active">Turnier erstellen</li>
                    </ol>
                </div>
            </div><!-- /.row -->

            <div class="row">  
                <div class="col-xs-1"></div>
                <div class="col-sm-6 col-sm-offset-3 col-xs-10">
                    <div class="row">
                        <form class="form-horizontal" role="form" action="<%=link%>/tournament/create" method="post">

                            <h2 class="page-header">Turnierdatenblatt</h2>

                            <div class="form-group">
                                <label for="inputTurniername" class="col-sm-2 control-label">Turnier*</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="tournament_name_create" placeholder="Name" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputMatchdays" class="col-sm-2 control-label">Runden</label>
                                <div class="col-sm-8">
                                    <input type="number" min="1" class="form-control" name="tournament_matchdays_create" placeholder="Spieltage">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputVenue" class="col-sm-2 control-label">Location</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="tournament_venue_create" placeholder="Austragungsort">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPassword" class="col-sm-2 control-label">Passwort</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="tournament_password_create" placeholder="Passwort">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPasswordReenter" class="col-sm-2 control-label">Passwort</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="tournament_password_reenter_create" placeholder="Passwort wiederholen">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputStartDate" class="col-sm-2 control-label">Startdatum</label>
                                <div class="col-sm-6">
                                    <input type="date" name="tournamen_start_date_create">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputEndDate" class="col-sm-2 control-label">Enddatum</label>
                                <div class="col-sm-6">
                                    <input type="date" name="tournamen_end_date_create">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputTerm" class="col-sm-2 control-label">Anmeldefrist</label>
                                <div class="col-sm-6">
                                    <input type="DATE"  name="tournamen_term_create">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputTerm" class="col-sm-2 control-label">Beschreibung</label>
                                <div class="col-sm-8">
                                    <textarea style="width:100%" name="tournamen_description_create" maxlength="255" placeholder="Beschreibe dein Turnier, maximal 255 Zeichen..." rows="5"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputTeam" class="col-sm-2 control-label">Teams</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="tournament_teamAdd_create" placeholder="Teamname">
                                    <datalist id="userAuswahl">
                                        <% for (int idx = 0; idx < teams.size(); idx++) {%>
                                        <option value="<%= teams.get(idx).getName()%>"> 
                                            <% } %>
                                    </datalist>
                                    <a href="#">Team hinzuf&uuml;gen</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <small>*Nur der Turniername ist Pflicht. Alles andere kannst du auf dem Turnierdashboard bearbeiten.</small>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-8">
                                    <button type="submit" class="btn btn-primary"><span class="fa fa-pencil"> Erstellen <i class="fa fa-angle-right"></i></button>
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
            </div> <!-- row --> 

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