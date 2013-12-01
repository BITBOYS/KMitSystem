<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.Team"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User Profil">
        <meta name="author" content="Malte Dammann">

        <title>User Profil - KmS</title>

        <%
            String link = request.getContextPath();
            User user_profile = (User)request.getAttribute("user");
            List<Team> teams = (List<Team>)request.getAttribute("teams");
            List<Tournament> tournaments = (List<Tournament>)request.getAttribute("tournaments");
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
                    <h1 class="page-header">User-Profil <small>Alles &uuml;ber <%=user_profile.getUsername()%></small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li class="active">Profil</li>
                    </ol>
                </div>
            </div>

            <div class="row">

                <div class="col-lg-12">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#statistik" data-toggle="tab">Statistik</a></li>
                        <li><a href="#team" data-toggle="tab">Teams</a></li>
                        <li><a href="#turnier" data-toggle="tab">Turniere</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="statistik">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%=user_profile.getUsername()%>s pers&ouml;nliche Statistik</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">&Uuml;bersicht</div>

                                        <!-- Table -->
                                        <table class="table">  
                                            <thead>  
                                                <tr>  
                                                    <th><span class="label label-primary">Turnierteilnahmen</span></th> 
                                                    <th><span class="label label-success">Turniersiege</span></th>  
                                                    <th><span class="label label-primary">Matches</span></th>  
                                                    <th><span class="label label-success">Gesmatsiege</span></th>  
                                                    <th><span class="label label-danger">Niederlagen</span></th>  
                                                    <th><span class="label label-primary">Tordifferenz</span></th> 
                                                    <th><span class="label label-success">Tore</span></th>  
                                                    <th><span class="label label-danger">Gegentore</span></th> 
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <tr>  
                                                    <td><%=user_profile.getStatistics().getTournament_participations()%></td> 
                                                    <td><%=user_profile.getStatistics().getTournament_wins()%></td> 
                                                    <td><%=user_profile.getStatistics().getMatches()%></td>   
                                                    <td><%=user_profile.getStatistics().getWins()%></td>  
                                                    <td><%=user_profile.getStatistics().getDefeats()%></td>  
                                                    <td><%=user_profile.getStatistics().getGoal_difference()%></td>  
                                                    <td><%=user_profile.getStatistics().getGoals()%></td>  
                                                    <td><%=user_profile.getStatistics().getGoals_conceded()%></td> 
                                                </tr>  
                                            </tbody>  
                                        </table>  
                                    </div>  

                                </div>

                            </div><!-- /.row -->


                        </div>


                        <div class="tab-pane fade" id="team">
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">  

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%=user_profile.getUsername()%>s Teams</h2>
                                </div>

                                <!-- Schleife zum Anzeigen aller Teams in denen man sich befindet -->
                                <% for(int idx = 0; idx < teams.size(); idx++) { %>
                                <div class="col-lg-4 col-md-4 hero-feature">
                                    <div class="thumbnail">
                                        <h3><%=teams.get(idx).getName()%> <small> Leader: 
                                                <a href="<%=link%>/user/profile?user=<%=teams.get(idx).getLeader().getUsername()%>"><%=teams.get(idx).getLeader().getUsername()%></a></small></h3>
                                        <div class="caption">
                                            <div class="panel panel-default">
                                                <!-- Default panel contents -->
                                                <div class="panel-heading">Stats</div>

                                                <!-- Table -->
                                                <table class="table">  
                                                    <thead>  
                                                        <tr>  
                                                            <th class="tooltip-social"><a href="#" data-toggle="tooltip" data-placement="top" title="Turniersiege" class="label label-success">TS</a></th>  
                                                            <th><span title="Gesamtsiege" class="label label-success">GS</span></th>  
                                                            <th><span title="Niederlagen" class="label label-danger">N</span></th>  
                                                            <th><span title="Tore" class="label label-success">T</span></th>  
                                                            <th><span title="Gegentore" class="label label-danger">GT</span></th>  
                                                            <th><span title="Tordifferenz" class="label label-primary">TD</span></th> 
                                                        </tr>  
                                                    </thead>  
                                                    <tbody>  
                                                        <tr>  
                                                            <td><%=teams.get(idx).getStatistics().getTournament_wins() %></td>  
                                                            <td><%=teams.get(idx).getStatistics().getWins() %></td>  
                                                            <td><%=teams.get(idx).getStatistics().getDefeats() %></td>  
                                                            <td><%=teams.get(idx).getStatistics().getGoals() %></td>  
                                                            <td><%=teams.get(idx).getStatistics().getGoals_conceded() %></td>  
                                                            <td><%=teams.get(idx).getStatistics().getGoal_difference()%></td> 
                                                        </tr>  
                                                    </tbody>  
                                                </table>  
                                            </div>  
                                            <p><a href="<%=link%>/team/profile?team=<%=teams.get(idx).getName()%>" class="btn btn-primary">Zum Teamprofil <i class="fa fa-angle-right"></i></a></p>
                                        </div>
                                    </div>
                                </div>
                                <% } %>

                            </div><!-- /.row -->
                        </div>

                        <div class="tab-pane fade" id="turnier">
                            <i class="fa fa-flag pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%=user_profile.getUsername()%>s Turniere</h2>
                                </div>

                                <% for(int idx = 0; idx < tournaments.size(); idx++) { %>
                                <div class="col-lg-4 col-md-4 hero-feature">
                                    <div class="thumbnail">
                                        <h3><%= tournaments.get(idx).getName() %> <small> Leader: <a href="#"><%= tournaments.get(idx).getLeader().getUsername() %></a></small></h3>
                                        <div class="caption">
                                            <p>Beschreibung Beschreibung Beschreibung Beschreibung </p>
                                            <div class="panel panel-default">
                                                <!-- Default panel contents -->
                                                <div class="panel-heading">Daten</div>

                                                <!-- Table -->
                                                <table class="table">  
                                                    <thead>  
                                                        <tr>  
                                                            <th>Startdatum</th>  
                                                            <th>Enddatum</th>  
                                                            <th>Status</th>   
                                                        </tr>  
                                                    </thead>  
                                                    <tbody>  
                                                        <tr>  
                                                            <td><%= tournaments.get(idx).getStart_date() %></td>  
                                                            <td><%= tournaments.get(idx).getEnd_date() %></td>  
                                                            <td><% if(tournaments.get(idx).getPassword() == null) 
                                                                    out.print("&Ouml;ffentlich"); 
                                                                    else out.print("Privat");%>
                                                            </td> 
                                                        </tr>  
                                                    </tbody>  
                                                </table>  
                                            </div>  
                                            <p><a href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>" class="btn btn-primary">Zum Turnierprofil <i class="fa fa-angle-right"></i></a></p>
                                        </div>
                                    </div>
                                </div> 
                                <% } %>

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
