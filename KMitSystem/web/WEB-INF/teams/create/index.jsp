<%@page import="com.kmitsystem.tools.objects.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Teams erstellen">
        <meta name="author" content="Malte Dammann">

        <% 
            String path = request.getContextPath();
            
            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
            
            List<User> users = (ArrayList<User>) request.getAttribute("users");
            if (users == null) {
                users = new ArrayList<User>();
            }
        %>

        <title>Teams Erstellen - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="<%=path%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=path%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=path%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
                    <a class="navbar-brand" href="tournaments">KmS</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="<%=path%>/teams">Teams</a></li>
                        <li><a href="<%=path%>/tournaments">Turniere</a></li> 
                        <li><a href="<%=path%>/statistics">Statistiken</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="<%=path%>/about">About</a></li>
                                <li><a href="<%=path%>/faq">FAQ</a></li>
                                <li><a href="<%=path%>/contact">Kontakt</a></li>
                                <li><a href="<%=path%>/service">Info</a></li>
                                <li><a href="<%=path%>/sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path%>/user/profil">Profil</a></li> 
                                <li><a href="<%=path%>/user/dashboard">Dashboard</a></li> 
                                <li><a href="<%=path%>/">Logout</a></li> 
                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Teams Erstellen <small>Erstelle Teams und lade Freunde ein!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=path%>/">Home</a></li>
                        <li><a href="<%=path%>/teams">Teams</a></li>
                        <li class="active">Teams-erstellen</li>
                    </ol>
                </div>
            </div><!-- /.row -->

            <div class="row">
                   <div class="col-lg-12">
                       <div class="row">
                           <form class="form-horizontal" role="form" action="<%=path%>/teams/create" method="post">

                               <div class="col-lg-4 col-lg-offset-1">
                                   <div class="form-group">
                                       <label for="inputTeamname" class="col-sm-2 control-label">Name</label>
                                       <div class="col-lg-8">
                                           <input type="text" class="form-control" name="name" placeholder="Teamname" required>
                                       </div>
                                   </div>
                                   
                                   <div class="form-group">
                                       <label for="inputTurniername" class="col-sm-2 control-label">Tag</label>
                                       <div class="col-lg-8">
                                           <input type="text" class="form-control" name="tag" placeholder="Tag" required>
                                       </div>
                                   </div>
                               </div>
                               
                               <div class="col-lg-6 col-lg-offset-1">
                                    <div class="form-group">
                                        <label for="inputUsername" class="col-sm-2 control-label">Passwort</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="password" placeholder="Passwort">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputUsername" class="col-sm-2 control-label">Passwort wiederholen</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="reenter_password" placeholder="Passwort wiederholen">
                                        </div>
                                    </div>
                               </div>
                               
                               <div class="form-group">
                                    <div class="col-lg-4 col-lg-offset-1">
                                       <label for="userAuswahl" class="col-sm-2 control-label">User</label>
                                       <div class="col-lg-8">
                                           <input list="userAuswahl" name="user" autocomplete="off" class="form-control" >
                                            <datalist id="userAuswahl">
                                                <% for(int idx = 0; idx < users.size(); idx++) {%>
                                                    <option value="<%= users.get(idx).getUsername() %>"> 
                                                <% } %>
                                            </datalist>
                                            <a href="#">User hinzuf&uuml;gen</a>
                                       </div>
                                    </div>
                               </div>

                                <div class="form-group col-lg-4 col-lg-offset-1">
                                    <div class="col-md-offset-6">
                                        <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Erstellen <i class="fa fa-angle-right"></i></button>
                                    </div>
                                </div>
                           </form>
                        </div>
                           
                        <div class="row">
                            <% for(int idx = 0; idx < errors.size(); idx++) { %>
                                <% if(errors.get(idx).getStatus().equals(Error.ERROR)) { %>
                                <div class="alert alert-danger"><%= errors.get(idx).getErrorMessage() %></div>
                                <% } else if(errors.get(idx).getStatus().equals(Error.INFO)) { %>
                                <div class="alert alert-info"><%= errors.get(idx).getErrorMessage() %></div>
                            <% } } %>
                        </div>
                           
                   </div>
               </div>
           </div> <!-- row --> 

        </div><!-- /.container -->

        <div class="container">

            <hr>

            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; KmS 2013</p>
                    </div>
                </div>
            </footer>

        </div><!-- /.container -->

        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=path%>/public/js/jquery.js"></script>
        <script src="<%=path%>/public/js/bootstrap.js"></script>
        <script src="<%=path%>/public/js/modern-business.js"></script>

    </body>
</html>