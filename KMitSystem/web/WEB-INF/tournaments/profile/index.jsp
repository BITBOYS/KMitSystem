
<%@page import="com.kmitsystem.tools.DateKonverter"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="com.kmitsystem.tools.objects.Team"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Turnier Profil">
        <meta name="author" content="Malte Dammann">

        <%            String link = request.getContextPath();
            Tournament tournament = (Tournament) request.getAttribute("tournament");
            List<Team> teams = (List<Team>) request.getAttribute("teams");
            List<User> member = (List<User>) request.getAttribute("member");
            String name = tournament.getName();
        %>

        <title>Turnier Profil - <%=name%></title>

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
                    <h1 class="page-header">Turnier Profil <small>Hier siehst du alles &uuml;ber '<%=name%>'!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li><a href="<%=link%>/tournaments">Turniere</a></li>
                        <li class="active">Profil</li>
                    </ol>
                </div>
            </div><!-- /.row -->

            <!-- Errors & Alerts -->
            <%@include file="../../snipplets/error.jspf" %>

            <div class="row">

                <div class="col-lg-12">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#news" data-toggle="tab">Aktuelles</a></li>
                        <li><a href="#table" data-toggle="tab">Tabelle</a></li>
                        <li><a href="#user" data-toggle="tab">Spielerstatistiken</a></li>
                            <%if (user != null && tournament.getLeader().getUsername().equals(user.getUsername())) {%>
                        <li><a href="#dashboard" data-toggle="tab">Dashboard</a></li>
                            <%}%>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="news">
                            <i class="fa fa-gamepad pull-left fa-4x"></i>
                            <p><%=tournament.getDescription()%></p>
                            <div class="row">
                                <div class="col-lg-5">
                                    <p>Leader: <b><a href="<%=link%>/user/profile?user=<%=tournament.getLeader().getUsername()%>"> <%=tournament.getLeader().getUsername()%> </a></b></p>
                                    <p>Zeitraum: <b><%=DateKonverter.getWebDateString(tournament.getStart_date())%> <%=tournament.getStart_time()%></b> bis <b><%=DateKonverter.getWebDateString(tournament.getEnd_date())%> <%=tournament.getEnd_time()%></b></p>
                                    <p>Anmeldefrist: <%if (tournament.getTerm_of_application() != null) {%>
                                        <b><%=DateKonverter.getWebDateString(tournament.getTerm_of_application())%></b>, <b><%=tournament.getCountdown()%></b></p>
                                    <%} else%> Keine Anmeldefrist
                                    <p>Spieltage: <b><%=tournament.getNr_matchdays()%></b></p>
                                    <p>Austragungsort: <b><a href="https://maps.google.com/maps?q=<%=tournament.getVenue()%>&hl=de&sll=28.149503,-71.71875&sspn=88.855059,173.144531&hnear=<%=tournament.getVenue()%>&t=m&z=10" target="_blank"><%=tournament.getVenue()%></a></b></p>
                                </div>
                                <div class="col-lg-5">
                                    <iframe width="100%" height="200dpx" frameborder="2" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.de/maps?hl=de&q=<%=tournament.getVenue()%>+(<%=tournament.getVenue()%>)&ie=UTF8&t=&z=12&iwloc=B&output=embed"></iframe>
                                </div>
                            </div>
                            <div class="row">

                                <div class="col-sm-12">
                                    <h2 class="page-header">Spielplan f&uuml;r "<%=name%>"</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">Spielplan</div>

                                        <!-- Table -->
                                        <table class="table">  
                                            <thead>  
                                                <tr>  
                                                    <th><span class="label label-success">Datum</span></th> 
                                                    <th><span class="label label-success">Heim</span></th> 
                                                    <th><span class="label label-success">Gast</span></th> 
                                                    <th><span class="label label-success">Ergebnis</span></th> 
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <%for (int idx = 0; idx < 10; idx++) {%>
                                                <tr>  
                                                    <td>1</td>  
                                                    <td>1</td>  
                                                    <td>10</td>  
                                                    <td>2</td> 
                                                </tr>  
                                                <%}%>
                                            </tbody>  
                                        </table>  
                                    </div>  
                                </div>
                            </div><!-- /.row -->
                        </div>


                        <div class="tab-pane fade" id="table">
                            <i class="fa fa-table pull-left fa-4x"></i>
                            <p>Hier steht die aktuelle Tabelle</p>
                            <div class="row">  

                                <div class="col-sm-12">
                                    <h2 class="page-header">Tabelle f&uuml;r "<%=tournament.getName()%>"</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">Tabelle</div>

                                        <!-- Table -->
                                        <table class="table">  
                                            <thead>  
                                                <tr>   
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Platz" class="label label-default">Platz</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Teamname" class="label label-default">TN</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Spiele" class="label label-default">SP</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Win-Rate in %" class="label label-default">WR</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Siege" class="label label-success">S</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Niederlagen" class="label label-danger">N</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Tore" class="label label-success">T</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Gegentore" class="label label-warning">GT</a></th> 
                                                    <th><a href="#" data-toggle="tooltip" data-placement="top" title="Tordifferenz" class="label label-default">TD</a></th> 
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <%for (int idx = 0; idx < tournament.getTable().size(); idx++) {%>
                                                <tr>  
                                                    <td><%=idx + 1%>.</td> 
                                                    <td><a href="/KMitSystem/team/profile?team=<%=tournament.getTable().get(idx).getTeam()%>"><%=tournament.getTable().get(idx).getTeam()%></a></td>  
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_matches()%></td>  
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_winrate()%></td>  
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_wins()%></td>  
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_defeats()%></td>  
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_goals()%></td> 
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_goals_conceded()%></td> 
                                                    <td><%=tournament.getTable().get(idx).getTournament_team_goal_difference()%></td>                                         
                                                </tr>  
                                                <%}%>
                                            </tbody>  
                                        </table>  
                                    </div>  
                                </div>
                            </div><!-- /.row -->
                        </div>

                        <div class="tab-pane fade" id="user">
                            <i class="fa fa-arrow-circle-o-up pull-left fa-4x"></i>
                            <p>Hier siehst du das Ranking alle am Turnier teilnehmenden Spieler.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">Userstatistik f&uuml;r "<%=name%>"</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">Userstatistik</div>

                                        <!-- Table -->
                                        <table class="table">  
                                            <thead>  
                                                <tr>  
                                                    <th><span class="label label-default">Platz</span></th> 
                                                    <th><span class="label label-default">Spieler</span></th> 
                                                    <th><span class="label label-default">Siege</span></th>
                                                    <th><span class="label label-default">Tore</span></th> 
                                                    <th><span class="label label-default">Team</span></th> 
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <%for (int idx = 0; idx < member.size(); idx++) {%>
                                                <tr>  
                                                    <td><%=idx + 1%>.</td>  
                                                    <td><%=member.get(idx).getUsername()%></td>  
                                                    <td><%=member.get(idx).getStatistics().getWins()%></td> 
                                                    <td><%=member.get(idx).getStatistics().getGoals()%></td>  
                                                    <td>kp</td> 
                                                </tr>  
                                                <%}%>
                                            </tbody>  
                                        </table>  
                                    </div>
                                </div>
                            </div><!-- /.row -->
                        </div>

                        <div class="tab-pane fade" id="dashboard">
                            <i class="fa fa-gears pull-left fa-4x"></i>
                            <p>&Auml;ndere dein Turnier</p>

                            <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10">
                                <!-- modal caller -->
                                <a href="#modal-dialog-tournament" class="modal-toggle btn btn-danger" data-toggle="modal" data-modal-type="confirm" data-modal-title="Delete Property" data-modal-text="Are you sure you want to delete the tournament?" data-modal-confirm-url="#"><span class="fa fa-warning"> Turnier l&ouml;schen <i class="fa fa-angle-right"></i></span></a>
                            </div>


                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Turnier-Teams</h3>
                                </div>

                                <div class="col-sm-4 col-lg-offset-2 col-md-6 hero-feature">
                                    <div class="caption">
                                        <div class="panel panel-default">
                                            <!-- Default panel contents -->
                                            <div class="panel-heading">Turniermitglieder</div>

                                            <!-- Table -->
                                            <table class="table">
                                                <tbody>
                                                    <% for (int idx = 0; idx < teams.size(); idx++) {%>
                                                    <tr>
                                                        <td>
                                                            <div class="col-md-9">
                                                                <ul class="nav nav-pills">
                                                                    <li class="caption"><a href="<%=link%>/team/profile?team=<%=teams.get(idx).getName()%>"><%=teams.get(idx).getName()%></a> 
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                            <div class="col-sm-3">
                                                                <form method="post" action="<%=link%>/team/profile?action=kick" id="<%=teams.get(idx).getName()%>">
                                                                    <input type="text" value="<%=teams.get(idx).getName()%>" name="kick_team" style="display:none">
                                                                    <a onclick="document.getElementById('<%=teams.get(idx).getName()%>').submit();" class="btn btn-danger">Entfernen <i class="fa fa-angle-right"></i></a>
                                                                </form>
                                                            </div>
                                                        </td> 
                                                    </tr>  
                                                    <% } %>
                                                    <% if (teams.size() == 0) { %>
                                                    <tr>Keine Teams im Turnier</tr>
                                                    <% }%>
                                                </tbody>
                                            </table>
                                        </div>     
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Name &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_name" action="<%=link%>/tournament/profile" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Name</label>
                                            <div class="col-sm-6 ">
                                                <input type="text" class="form-control" name="name_new" placeholder="'<%=name%>'" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div> 
                            </div>


                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Passwort &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_password" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Passwort</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="password_old" placeholder="altes Passwort">
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="password" class="form-control" name="password_new" placeholder="neues Passwort">
                                                <input type="password" class="form-control" name="password_new2" placeholder="neues Passwort">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Turnierleiter &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_leader" action="<%=link%>/tournament/profile" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Turnierleiter</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="password" placeholder="Turnier-Passwort">
                                            </div>
                                            <div class="col-lg-6 col-md-offset-2">
                                                <input list="leaderAuswahl" name="leader_new" class="form-control" autocomplete="off" placeholder="Neuer Leader" required>
                                                <datalist id="userAuswahl">
                                                    <option value=""> 
                                                </datalist>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Beschreibung &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_description" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Neuer Turnierbeschreibung</label>
                                            <div class="col-sm-6">
                                                <textarea style="width:100%" rows="10" class="form-control" name="description_new" placeholder="'<%=tournament.getDescription()%>'" maxlength="255"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>


                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Austragungsort &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_venue" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Neuer Ort</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="venue_new" placeholder="'<%=tournament.getVenue()%>'">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>


                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Spieltage &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_matchdays" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Spieltage</label>
                                            <div class="col-sm-6">
                                                <input type="number" min="0" class="form-control" name="nr_matchdays_new" placeholder="<%=tournament.getNr_matchdays()%> Spieltage">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Datum &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_start" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Startdatum</label>
                                            <div class="col-sm-6">
                                                <input type="date" class="form-control" name="start_date_new">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                    <form class="form-horizontal" role="form" name="change_end" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Enddatum</label>
                                            <div class="col-sm-6">
                                                <input type="date" class="form-control" name="end_date_new">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                    <form class="form-horizontal" role="form" name="change_term" action="<%=link%>/tournament/profile">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Anmeldefrist</label>
                                            <div class="col-sm-6">
                                                <input type="date" class="form-control" name="term_date_new">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern <i class="fa fa-angle-right"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>

                        </div><!-- /.row -->

                    </div>
                </div>

            </div><!-- /.row -->

        </div><!-- /.container -->

        <div class="container">

            <%@include file="../../../snipplets/footer.jspf" %>

        </div><!-- /.container -->

        <!-- Alert to confirm the delet -->
        <div id="modal-dialog-tournament" class="modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3>L&ouml;schen best&auml;tigen</h3>
                    </div>
                    <div class="modal-body">
                        <p>Bilst du sicher, dass du das Turnier <b>'<%=name%>'</b> l&ouml;schen willst?</p>
                        <p>Alle Statistiken werden gel&ouml;scht. Du kannst das Turnier nicht wieder herstellen.</p>
                    </div>
                    <div class="modal-footer">
                        <form method="post" action="<%=link%>/tournament/profile?action=delete" id="<%=tournament.getName()%>">
                            <a href="#" data-dismiss="modal" aria-hidden="true" class="btn btn-default">Abbrechen</a>
                            <input type="text" value="<%=tournament.getName()%>" name="delete_tournament" style="display:none">
                            <a href="#" id="btnYes" class="btn btn-primary">L&ouml;schen</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=link%>/public/js/jquery.js"></script>
        <script src="<%=link%>/public/js/bootstrap.js"></script>
        <script src="<%=link%>/public/js/modern-business.js"></script>
        <script src="<%=link%>/public/js/modal.js"></script>

    </body>
</html>