<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="com.kmitsystem.tools.objects.Statistics"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%            String link = request.getContextPath();
            Team team = (Team) request.getAttribute("team");
            List<User> member = (List<User>) request.getAttribute("member");
            List<Tournament> tournaments = (List<Tournament>) request.getAttribute("tournaments");
            List<User> users = (List<User>) request.getAttribute("users");
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Team Profil">
        <meta name="author" content="Malte Dammann">

        <title>Team Profil - Leago</title>

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
                    <h1 class="page-header">Team-Profil <small>Alles &uuml;ber "<%=team.getName()%>"!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li><a href="<%=link%>\teams">Teams</a></li>
                        <li class="active">Profil</li>
                    </ol>
                </div>
            </div>

            <div class="row">

                <div class="col-lg-12">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#member" data-toggle="tab">Mitglieder</a></li>
                        <li><a href="#tournaments" data-toggle="tab">Turniere</a></li>
                        <li><a href="#statistics" data-toggle="tab">Statistiken</a></li>
                            <%if (user != null && team.getLeader().getUsername().equals(user.getUsername())) {%>
                        <li><a href="#dashboard" data-toggle="tab">Dashboard</a></li>
                            <%}%>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="member">
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">  

                                <div class="col-lg-12">
                                    <h2 class="page-header">"<%=team.getName()%>'s" Mitglieder</h2>

                                    <div class="panel panel-default">
                                        <div class="panel-heading">Teammitglieder</div>
                                        <div class="list-group">
                                            <% for (int idx = 0; idx < member.size(); idx++) {%>
                                            <a href="<%=link%>/user/profile?user=<%=member.get(idx).getUsername()%>" class="list-group-item"><%= member.get(idx).getUsername()%></a>
                                            <% }%>
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
                                    <h2 class="page-header">"<%=team.getName()%>'s" aktuelle Turniere</h2>
                                </div>

                                <% for (int idx = 0; idx < tournaments.size(); idx++) {%>
                                <div class="col-lg-4 col-md-4 hero-feature">
                                    <div class="thumbnail">
                                        <h3><%= tournaments.get(idx).getName()%> <small> Leader: <a href="#"><%= tournaments.get(idx).getLeader().getUsername()%></a></small></h3>
                                        <div class="caption">
                                            <p><%= tournaments.get(idx).getDescription()%></p>
                                            <div class="panel panel-default">
                                                <div class="panel-heading">Daten</div>

                                                <!-- Table -->
                                                <div class="table-responsive">                                               
                                                    <table class="table table-hover">  
                                                        <thead>  
                                                            <tr>  
                                                                <th>Startdatum</th>  
                                                                <th>Enddatum</th>  
                                                                <th>Status</th>   
                                                            </tr>  
                                                        </thead>  
                                                        <tbody>  
                                                            <tr>  
                                                                <td><%= tournaments.get(idx).getStart_date()%></td>  
                                                                <td><%= tournaments.get(idx).getEnd_date()%></td>  
                                                                <td><% if (tournaments.get(idx).getPassword() == null) {
                                                                        out.print("&Ouml;ffentlich");
                                                                    } else {
                                                                        out.print("Privat");
                                                                    }%>
                                                                </td> 
                                                            </tr>  
                                                        </tbody>  
                                                    </table>  
                                                </div>
                                            </div>  
                                            <p><a href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>" class="btn btn-primary">Zum Turnierprofil <i class="fa fa-angle-right"></i></a></p>

                                            <% if (tournaments.get(idx).getLeader().getUsername().equals(user.getUsername())) {%>
                                            <form method="POST" action="<%=link%>/team/profile?team=<%=team.getName()%>">
                                                <input type="hidden" value="<%=tournaments.get(idx).getName()%>" name="tournament_name" >
                                                <button type="submit" class="btn btn-danger">Turnier verlassen</button>
                                            </form>
                                            <% } %>
                                        </div>
                                    </div>
                                </div> 
                                <% }%>
                            </div><!-- /.row -->

                        </div>

                        <div class="tab-pane fade in" id="statistics">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">"<%= team.getName()%>'s" Statistik</h2>

                                    <div class="panel panel-default">
                                        <!-- Default panel contents -->
                                        <div class="panel-heading">&Uuml;bersicht</div>

                                        <!-- Table -->
                                        <div class="table-responsive">                                               
                                            <table class="table table-hover">  
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
                                                        <td><%= team.getStatistics().getTournament_wins()%></td>
                                                        <td><%= team.getStatistics().getTournament_participations()%></td>  
                                                        <td><%= team.getStatistics().getWins()%></td>  
                                                        <td><%= team.getStatistics().getDefeats()%></td>  
                                                        <td><%= team.getStatistics().getGoals()%></td>  
                                                        <td><%= team.getStatistics().getGoals_conceded()%></td> 
                                                        <td>?</td> 
                                                    </tr>  
                                                </tbody>  
                                            </table> 
                                        </div>
                                    </div>  

                                </div>

                            </div><!-- /.row -->

                        </div>

                        <div class="tab-pane fade" id="dashboard">
                            <i class="fa fa-gears pull-left fa-4x"></i>
                            <p>Nimm &Auml;nderungen an deinem Team vor</p>

                            <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10">
                                <!-- modal caller -->
                                <a href="#modal-dialog-team" class="modal-toggle btn btn-danger" data-toggle="modal" data-modal-type="confirm" data-modal-title="Delete Property" data-modal-text="Are you sure you want to delete the team?" data-modal-confirm-url="#"><span class="fa fa-warning"> Team l&ouml;schen <i class="fa fa-angle-right"></i></span></a>
                            </div>

                            <!--####################################################################################-->
                            <!--# T E A M M I T G L I E D E R ######################################################-->
                            <!--####################################################################################-->

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Teammitglieder</h3>
                                </div>

                                <div class="col-sm-4 col-lg-offset-2 col-md-6 hero-feature">
                                    <div class="caption">
                                        <div class="panel panel-default">
                                            <!-- Default panel contents -->
                                            <div class="panel-heading">Turniermitglieder</div>

                                            <!-- Table -->
                                            <div class="table-responsive">                                               
                                                <table class="table table-hover"> 
                                                    <tbody>
                                                        <% for (int idx = 0; idx < member.size(); idx++) {%>
                                                        <tr>
                                                            <td>
                                                                <div class="col-md-9">
                                                                    <ul class="nav nav-pills">
                                                                        <li class="caption"><a href="<%=link%>/user/profile?user=<%=member.get(idx).getUsername()%>"><%=member.get(idx).getUsername()%></a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <form method="post" action="<%=link%>/team/profile?team=<%=team.getName()%>&action=kick" id="<%=member.get(idx).getUsername()%>">
                                                                        <input type="text" value="<%=member.get(idx).getUsername()%>" name="kick_user" style="display:none">
                                                                        <a onclick="document.getElementById('<%=member.get(idx).getUsername()%>').submit();" class="btn btn-danger">Entfernen <i class="fa fa-angle-right"></i></a>
                                                                    </form>
                                                                </div>
                                                            </td> 
                                                        </tr>  
                                                        <% } %>
                                                        <% if (member.size() == 0) { %>
                                                        <tr>
                                                    <p>Keine Spieler im Team</p>
                                                    </tr>

                                                    <% }%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>     
                                    </div>
                                </div>
                            </div>                    

                            <!--####################################################################################-->
                            <!--# A K T U E L L E # T U R N I E R E ################################################-->
                            <!--####################################################################################-->

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Aktuelle Turniere</h3>
                                </div>

                                <div class="col-sm-4 col-lg-offset-2 col-md-6 hero-feature">
                                    <div class="caption">
                                        <div class="panel panel-default">
                                            <!-- Default panel contents -->
                                            <div class="panel-heading">Turniere</div>

                                            <!-- Table -->
                                            <div class="table-responsive">                                               
                                                <table class="table table-hover"> 
                                                    <tbody>
                                                        <% for (int idx = 0; idx < tournaments.size(); idx++) {%>
                                                        <tr>
                                                            <td>
                                                                <div class="col-md-9">
                                                                    <ul class="nav nav-pills">
                                                                        <li class="caption"><a href="<%=link%>/tournament/profile?tournament=<%=tournaments.get(idx).getName()%>"><%=tournaments.get(idx).getName()%></a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <form method="post" action="<%=link%>/team/profile?team=<%=team.getName()%>&action=leaveT" id="<%=tournaments.get(idx).getName()%>">
                                                                        <input type="text" value="<%=tournaments.get(idx).getName()%>" name="leave_tournament" style="display:none">
                                                                        <a onclick="document.getElementById('<%=tournaments.get(idx).getName()%>').submit();" class="btn btn-danger">Entfernen <i class="fa fa-angle-right"></i></a>
                                                                    </form>
                                                                </div>
                                                            </td> 
                                                        </tr>  
                                                        <% } %>
                                                        <% if (tournaments.size() == 0) { %>
                                                        <tr>Das Team ist in keinem Turnier.</tr>
                                                        <% }%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>     
                                    </div>
                                </div>
                            </div> 

                            <!--####################################################################################-->
                            <!--# T E A M N A M E # Ä N D E R N ####################################################-->
                            <!--####################################################################################-->                                                

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Name &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_name" action="<%=link%>/team/profile?team=<%=team.getName()%>" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Name</label>
                                            <div class="col-sm-6 ">
                                                <input type="text" class="form-control" name="name_new" placeholder="'<%=team.getName()%>'" required>
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

                            <!--####################################################################################-->
                            <!--# T E A M T A G # Ä N D E R N ######################################################-->
                            <!--####################################################################################--> 

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Tag &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_tag" action="<%=link%>/team/profile?team=<%=team.getName()%>" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Tag</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="tag_new" placeholder="neuer Tag" required>
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

                            <!--####################################################################################-->
                            <!--# T E A M P A S S W O R T # Ä N D E R N ############################################-->
                            <!--####################################################################################--> 

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Passwort &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_password" action="<%=link%>/team/profile?team=<%=team.getName()%>" method="post">
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

                            <!--####################################################################################-->
                            <!--# T E A M L E I T E R # Ä N D E R N ################################################-->
                            <!--####################################################################################-->                                         

                            <div class="row">
                                <div class="col-lg-12">
                                    <h3 class="page-header">Teamleiter &auml;ndern</h3>
                                    <form class="form-horizontal" role="form" name="change_leader" action="<%=link%>/team/profile?team=<%=team.getName()%>" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Teamleiter</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="password" placeholder="Team-Passwort">
                                            </div>
                                            <div class="col-lg-6 col-md-offset-2">
                                                <input list="leaderAuswahl" name="leader_new" autocomplete="on" class="form-control" placeholder="Neuer Leader" required>
                                                <datalist id="leaderAuswahl">
                                                    <% for (int idx = 0; idx < users.size(); idx++) {%>
                                                    <option value="<%= users.get(idx).getUsername()%>"> 
                                                        <% }%>
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


                        </div>

                    </div><!-- /Tab closed -->                            
                </div><!-- /Column closed -->
            </div>

        </div><!-- /.row -->

    </div><!-- /.container -->

    <!--####################################################################################-->
    <!--# T E A M ## L Ö S C H E N ## M O D A L ############################################-->
    <!--####################################################################################-->         

    <!-- Alert to confirm the delet -->
    <div id="modal-dialog-team" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3>L&ouml;schen best&auml;tigen</h3>
                </div>
                <div class="modal-body">
                    <p>Bilst du sicher, dass du das Team <b>'<%=team.getName()%>'</b> l&ouml;schen willst?</p>
                    <p>Alle Statistiken werden gel&ouml;scht. Du kannst das Team nicht wieder herstellen.</p>
                </div>
                <div class="modal-footer">
                    <form method="post" action="<%=link%>/team/dashboard?action=delete" id="<%=team.getName()%>">
                        <a href="#" data-dismiss="modal" aria-hidden="true" class="btn btn-default">Abbrechen</a>
                        <input type="text" value="<%=team.getName()%>" name="delete_team" style="display:none">
                        <a href="#" id="btnYes" class="btn btn-primary">L&ouml;schen</a>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">

        <%@include file="../../../snipplets/footer.jspf" %>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=link%>/public/js/jquery.js"></script>
    <script src="<%=link%>/public/js/bootstrap.js"></script>
    <script src="<%=link%>/public/js/modern-business.js"></script>

</body>
</html>
