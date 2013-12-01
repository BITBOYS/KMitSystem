<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="com.kmitsystem.tools.objects.Statistics"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <%
            String link = request.getContextPath();
            Team team = (Team)request.getAttribute("team");
            List<User> member = (List<User>)request.getAttribute("member");
            List<Tournament> tournaments = (List<Tournament>)request.getAttribute("tournaments");
        %>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Team Profil">
        <meta name="author" content="Malte Dammann">

        <title>Team Profil - KmS</title>

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
                    <h1 class="page-header">Team-Profil <small>Alles &uuml;ber <%=team.getName()%>!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li><a href="<%=link%>\teams">Teams</a></li>
                        <li class="active">Profil</li>
                    </ol>
                </div>
            </div>
                            
            <% if(user != null && user.getUsername().equals(team.getLeader().getUsername())) {%>    
                <form method="post" action="<%=link%>/team/dashboard" id="<%=team.getName()%>">
                    <input type="text" value="<%=team.getName()%>" name="team" style="display:none">
                    <a onclick="document.getElementById('<%=team.getName()%>').submit();" class="btn btn-primary"><span class="fa fa-pencil"> Team Dashboard <i class="fa fa-angle-right"></i></a>
                </form>
            <% } %>

            <div class="row">

                <div class="col-lg-12">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#member" data-toggle="tab">Mitglieder</a></li>
                        <li><a href="#tournaments" data-toggle="tab">Turniere</a></li>
                        <li><a href="#statistics" data-toggle="tab">Statistiken</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="member">
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">  

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%=team.getName()%>s Mitglieder</h2>
                                
                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">Teammitglieder</div>
                                        <div class="list-group">
                                            <% for(int idx = 0; idx < member.size(); idx++) { %>
                                            <a href="<%=link%>/user/profile?user=<%=member.get(idx).getUsername()%>" class="list-group-item"><%= member.get(idx).getUsername() %></a>
                                            <% } %>
                                        </div>
                                    </div>
                                </div>

                            </div><!-- /.row -->
                        </div>

                        <div class="tab-pane fade" id="tournaments">
                            <i class="fa fa-flag pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%=team.getName()%>s aktuelle Turniere</h2>
                                </div>

                                <% for(int idx = 0; idx < tournaments.size(); idx++) { %>
                                <div class="col-lg-4 col-md-4 hero-feature">
                                    <div class="thumbnail">
                                        <h3><%= tournaments.get(idx).getName() %> <small> Leader: <a href="#"><%= tournaments.get(idx).getLeader().getUsername() %></a></small></h3>
                                        <img src="http://placehold.it/800x500" alt="">
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
                                            <p><a href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>" class="btn btn-success">Zum Turnierprofil <i class="fa fa-angle-right"></i></a></p>
                                        </div>
                                    </div>
                                </div> 
                                <% } %>
                            </div><!-- /.row -->

                        </div>

                        <div class="tab-pane fade in" id="statistics">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header"><%= team.getName() %>s Statistik</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">&Uuml;bersicht</div>

                                        <!-- Table -->
                                        <table class="table">  
                                            <thead>  
                                                <tr>  
                                                    <th>Turniersiege</th> 
                                                    <th>Turnierteilnahmen</th> 
                                                    <th>Gesmatsiege</th>  
                                                    <th>Niederlagen</th>  
                                                    <th>Tore</th>  
                                                    <th>Gegentore</th>  
                                                    <th>Matches</th>  
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <tr>  
                                                    <td><%= team.getStatistics().getTournament_wins() %></td>
                                                    <td><%= team.getStatistics().getTournament_participations()%></td>  
                                                    <td><%= team.getStatistics().getWins() %></td>  
                                                    <td><%= team.getStatistics().getDefeats() %></td>  
                                                    <td><%= team.getStatistics().getGoals() %></td>  
                                                    <td><%= team.getStatistics().getGoals_conceded() %></td> 
                                                    <td>?</td> 
                                                </tr>  
                                            </tbody>  
                                        </table>  
                                    </div>  

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