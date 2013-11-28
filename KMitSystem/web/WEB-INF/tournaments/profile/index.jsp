
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

        <title>Turnier Profil - KmS</title>

        <%            
            String link = request.getContextPath();
            Tournament tournament = (Tournament) request.getAttribute("tournament");
            List<Team> teams = (List<Team>) request.getAttribute("teams");
            List<User> member = (List<User>) request.getAttribute("member");
            String name = tournament.getName();
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
            
            <%if (user != null) {%>
                <div class="row">
                    <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10">
                        <a class="btn btn-success" href="#"><span class="fa fa-plus"> Turnier beitreten <i class="fa fa-angle-right"></i></span></a>
                    </div>
                </div><!-- .row -->
            <%}%>
            
            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Turnier Profil <small>Hier siehst du alles &uuml;ber <%=name%>!</small></h1>
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
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="news">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <p><%=tournament.getDescription()%></p>
                            <p>Leader: <a href="<%=link%>/user/profil?user=<%=tournament.getLeader().getUsername()%>"> <%=tournament.getLeader().getUsername()%> </a></p>
                            <p>Zeitraum: <%=tournament.getStart_date()%> bis <%=tournament.getEnd_date()%></p>
                            <p>Anmeldefrist: <%=tournament.getTerm_of_application()%></p>
                            <p>Spieltage: <%=tournament.getNr_matchdays()%></p>
                            <p>Austragungsort: <a href="https://maps.google.com/maps?q=<%=tournament.getVenue()%>&hl=de&sll=28.149503,-71.71875&sspn=88.855059,173.144531&hnear=<%=tournament.getVenue()%>&t=m&z=10"><%=tournament.getVenue()%></a></p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">Spielplan f&uml;r "<%=name%>"</h2>

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
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Hier steht die aktuelle Tabelle</p>
                            <div class="row">  

                                <div class="col-lg-12">
                                    <h2 class="page-header">Tabelle f&uml; <%=tournament.getName()%></h2>
                                </div>

                                <div class="panel panel-default">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">Stats</div>

                                    <!-- Table -->
                                    <table class="table">  
                                        <thead>  
                                            <tr>   
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Spiele" class="label label-default">SP</a></th> 
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Punkte" class="label label-default">P</a></th> 
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Siege" class="label label-success">S</a></th>  
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Unentschieden" class="label label-info">U</a></th>  
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Niederlagen" class="label label-danger">N</a></th> 
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Tore" class="label label-success">T</a></th> 
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Gegentore" class="label label-warning">GT</a></th> 
                                                <th><a href="#" data-toggle="tooltip" data-placement="top" title="Tordifferenz" class="label label-default">TD</a></th> 
                                            </tr>  
                                        </thead>  
                                        <tbody>  
                                            <%for (int idx = 0; idx < teams.size(); idx++) {%>
                                            <tr>  
                                                <td><%=tournament.getTable().getTournament_team_matches()%></td>  
                                                <td><%=tournament.getTable().getTournament_team_points()%></td>  
                                                <td><%=tournament.getTable().getTournament_team_wins()%></td>  
                                                <td><%=tournament.getTable().getTournament_team_draws()%></td>  
                                                <td><%=tournament.getTable().getTournament_team_defeats()%></td>  
                                                <td><%=tournament.getTable().getTournament_team_goals()%></td> 
                                                <td><%=tournament.getTable().getTournament_team_goals_conceded()%></td> 
                                                <td><%= (tournament.getTable().getTournament_team_goals())-(tournament.getTable().getTournament_team_goals_conceded())%></td>                                         
                                            </tr>  
                                            <%}%>
                                        </tbody>  
                                    </table>  
                                </div>  

                            </div><!-- /.row -->
                        </div>

                        <div class="tab-pane fade" id="user">
                            <i class="fa fa-gamepad pull-left fa-4x"></i>
                            <p>User-Statistik f&uuml;r dieses Turnier</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">Userstatistik</h2>
                                </div>

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
                                            <%for (int idx = 0; idx < 10; idx++) {%>
                                            <tr>  
                                                <td><%=idx%>.</td>  
                                                <td>1</td>  
                                                <td>10</td>  
                                                <td>2</td> 
                                                <td>2</td> 
                                            </tr>  
                                            <%}%>
                                        </tbody>  
                                    </table>  
                                </div> 

                            </div><!-- /.row -->

                        </div>
                    </div>
                </div>

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