
<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%
            String link = request.getContextPath();
            
            List<User> users = (ArrayList<User>) request.getAttribute("users");
            if (users == null) users = new ArrayList<User>();

            List<Tournament> tournaments = (ArrayList<Tournament>) request.getAttribute("tournaments");
            if (tournaments == null) tournaments = new ArrayList<Tournament>();

            List<User> member = (ArrayList<User>) request.getAttribute("member");
            if (member == null) member = new ArrayList<User>();
            
            Team team = (Team) request.getAttribute("team");
        %>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User Dshboard">
        <meta name="author" content="Maik Schmaddebeck">

        <title>Team Dashboard - KmS</title>

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
                    <h1 class="page-header">Team-Dashboard <small>Dein Kontrollzentrum</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li><a href="<%=link%>/user/profil">Profil</a></li>
                        <li class="active">User-Dashboard</li>
                    </ol>
                </div>
            </div>
                
            <!-- Errors & Alerts -->
            <%@include file="../../snipplets/error.jspf" %>

            <!-- Service Tabs -->

            <div class="row">

                <div class="col-lg-12">
                    <h2 class="page-header"><%=team.getName()%> Teamoptionen</h2>
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#infos" data-toggle="tab">Infos</a></li>
                        <li><a href="#user" data-toggle="tab">Mitglieder</a></li>
                        <li><a href="#tournaments" data-toggle="tab">Turniere</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="infos">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Name &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="change_name" action="<%=link%>/team/dashboard" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Name</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="name_old" placeholder="alter Name" required>
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="text" class="form-control" name="name_new" placeholder="neuer Name" required>
                                                <input type="text" class="form-control" name="name_new2" placeholder="neuer Name" required>
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
                                    <h2 class="page-header">Tag &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="change_tag" action="<%=link%>/team/dashboard" method="post">
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

                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Passwort &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="change_password" action="<%=link%>/team/dashboard" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Passwort</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="password_old" placeholder="altes Passwort">
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="password" class="form-control" name="password_new" placeholder="neues Passwort">
                                                <input type="password" class="form-control" name="password_new2" placeholder="neuer Passwort">
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
                                    <h2 class="page-header">Teamleiter &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="change_leader" action="<%=link%>/team/dashboard" method="post">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Teamleiter</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="password" placeholder="Passwort">
                                            </div>
                                            <div class="col-lg-6 col-md-offset-2">
                                                <input list="userAuswahl" name="leader_new" class="form-control" autocomplete="off" placeholder="User" required>
                                                 <datalist id="userAuswahl">
                                                     <% for(int idx = 0; idx < users.size(); idx++) {%>
                                                         <option value="<%= users.get(idx).getUsername() %>"> 
                                                     <% } %>
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

                        <div class="tab-pane fade" id="user">
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Deine Teams</h2>
                                </div>

                                <div class="col-lg-12 col-md-12 hero-feature">
                                    <div class="caption">
                                        <div class="panel panel-default">
                                            <!-- Default panel contents -->
                                            <div class="panel-heading">Mitglieder</div>

                                            <!-- Table -->
                                            <table class="table">
                                                <tbody>
                                                    <% for(int idx = 0; idx < member.size(); idx++) { %>
                                                    <tr>
                                                        <td><%=member.get(idx).getUsername()%></td>
                                                        <td><p><a href="<%=link%>/user/profile?user=<%=member.get(idx).getUsername()%>" class="btn btn-success">Userprofil <i class="fa fa-angle-right"></i></a> 
                                                            <form method="post" action="<%=link%>/team/dashboard?action=kick" id="<%=member.get(idx).getUsername()%>">
                                                                <input type="text" value="<%=member.get(idx).getUsername()%>" name="kick_user" style="display:none">
                                                                <a onclick="document.getElementById('<%=member.get(idx).getUsername()%>').submit();" class="btn btn-danger">Entfernen <i class="fa fa-angle-right"></i></a>
                                                            </form></p></td> 
                                                    </tr>  
                                                    <% } %>
                                                    <% if(member.size() == 0) { %>
                                                        <tr>Keine Turniere</tr>
                                                    <% } %>
                                                </tbody>
                                            </table>
                                        </div>     
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="tournaments">
                            <i class="fa fa-flag pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">Aktuelle Turniere</h2>
                                </div>

                                <div class="col-lg-12 col-md-12 hero-feature">
                                    <div class="caption">
                                        <div class="panel panel-default">
                                            <!-- Default panel contents -->
                                            <div class="panel-heading">Turniere</div>

                                            <!-- Table -->
                                            <table class="table">
                                                <tbody>  
                                                    <% for(int idx = 0; idx < tournaments.size(); idx++) { %>
                                                    <tr>
                                                        <td><%=tournaments.get(idx).getName()%></td> 
                                                        <td><p><a href="<%=link%>/tournament/profile?team=<%=tournaments.get(idx).getName()%>" class="btn btn-success">Turnierprofil <i class="fa fa-angle-right"></i></a> 
                                                            <form method="post" action="<%=link%>/team/dashboard?action=leave" id="<%=tournaments.get(idx).getName()%>">
                                                                <input type="text" value="<%=tournaments.get(idx).getName()%>" name="leave_tournament" style="display:none">
                                                                <a onclick="document.getElementById('<%=tournaments.get(idx).getName()%>').submit();" class="btn btn-danger">Verlassen <i class="fa fa-angle-right"></i></a>
                                                            </form></p></td> 
                                                    </tr>  
                                                    <% } %>
                                                    <% if(tournaments.size() == 0) { %>
                                                        <tr>Keine Turniere</tr>
                                                    <% } %>
                                                </tbody>  
                                            </table>  
                                        </div>      
                                    </div>
                                </div> 
                            </div>

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