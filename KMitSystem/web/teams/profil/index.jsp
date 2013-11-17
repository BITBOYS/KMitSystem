<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.Tournament"%>
<%@page import="com.kmitsystem.tools.objects.Statistics"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User Profil">
        <meta name="author" content="Malte Dammann">

        <title>Team Profil - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="<%=request.getContextPath()%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=request.getContextPath()%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        
        <%
            Team team = (Team)request.getAttribute("team");
            List<User> member = (List<User>)request.getAttribute("member");
            List<Tournament> tournaments = (List<Tournament>)request.getAttribute("tournaments");
            Statistics stats = (Statistics)request.getAttribute("stats");
        %>
        
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                    <a class="navbar-brand" href="../">KmS</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=request.getContextPath()%>/teams">Teams</a></li>
                        <li><a href="<%=request.getContextPath()%>/tournaments">Turniere</a></li> 
                        <li><a href="<%=request.getContextPath()%>/statistics">Statistiken</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="<%=request.getContextPath()%>/about">About</a></li>
                                <li><a href="<%=request.getContextPath()%>/faq">FAQ</a></li>
                                <li><a href="<%=request.getContextPath()%>/contact">Kontakt</a></li>
                                <li><a href="<%=request.getContextPath()%>/service">Info</a></li>
                                <li><a href="<%=request.getContextPath()%>/sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=request.getContextPath()%>/user/profil">Profil</a></li> 
                                <li><a href="<%=request.getContextPath()%>/user/dashboard">Dashboard</a></li> 
                                <li><a href="<%=request.getContextPath()%>">Logout</a></li> 
                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Team-Profil <small>Alles &uuml;ber <%=team.getName()%>!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=request.getContextPath()%>">Home</a></li>
                        <li><a href="<%=request.getContextPath()%>\teams">Teams</a></li>
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
                                            <a href="#" class="list-group-item"><%= member.get(idx).getUsername() %></a>
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
                                                <div class="panel-heading">Teams</div>
                                                <div class="list-group">
                                                    <a href="#" class="list-group-item">Team1</a>
                                                    <a href="#" class="list-group-item">Team2</a>
                                                </div>
                                            </div>
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
                                            <p><a href="#" class="btn btn-success">Zum Turnierprofil <i class="fa fa-angle-right"></i></a></p>
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
                                                    <th>Gesmatsiege</th>  
                                                    <th>Niederlagen</th>  
                                                    <th>Tore</th>  
                                                    <th>Gegentore</th>  
                                                    <th>Turnierteilnahmen</th> 
                                                    <th>Matches</th>  
                                                </tr>  
                                            </thead>  
                                            <tbody>  
                                                <tr>  
                                                    <td>?</td>  
                                                    <td><%= team.getStatistics().getWins() %></td>  
                                                    <td><%= team.getStatistics().getDefeats() %></td>  
                                                    <td><%= team.getStatistics().getGoals() %></td>  
                                                    <td><%= team.getStatistics().getGoals_conceded() %></td> 
                                                    <td>?</td>  
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

            <hr>

            <footer>
                <div class="row col-lg-12">
                    <div class="col-lg-6">
                        <p>Copyright &copy; KmS 2013</p>
                    </div>
                    <div class="col-lg-2 col-lg-offset-4">
                        <a class="btn btn-toolbar"href="../impressum/">Impressum</a>
                    </div>
                </div>
            </footer>

        </div><!-- /.container -->

        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=request.getContextPath()%>/public/js/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/public/js/bootstrap.js"></script>
        <script src="<%=request.getContextPath()%>/public/js/modern-business.js"></script>

    </body>
</html>