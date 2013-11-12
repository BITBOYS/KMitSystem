<!DOCTYPE html>
<html lang="en">
    <head>
        <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="com.kmitsystem.tools.errorhandling.Error"%> 

        <%
            List<Error> errors = (ArrayList<Error>) request.getSession().getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Teams Page">
        <meta name="author" content="Malte Dammann">

        <title>Teams - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="../public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="../public/css/css/modern-business.css" rel="stylesheet">
        <link href="../public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
                        <li class="active"><a href="../teams">Teams</a></li>
                        <li><a href="../tournaments">Turniere</a></li> 
                        <li><a href="../statistics">Statistiken</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../about">About</a></li>
                                <li><a href="../faq">FAQ</a></li>
                                <li><a href="../contact">Kontakt</a></li>
                                <li><a href="../service">Info</a></li>
                                <li><a href="../sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../user/profil">Profil</a></li> 
                                <li><a href="../user/dashboard">Dashboard</a></li> 
                                <li><a href="../">Logout</a></li> 
                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">
            
            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Teams <small>Suche spezielle Turniere oder deine Freunde!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li class="active">Teams</li>
                    </ol>
                </div>

            <div class="row">
                
                <a class="btn btn-default" href="../teams/create">Team erstellen <i class="fa fa-angle-right"></i></a>
                
            </div><!-- .row -->
            
            <hr>
            
                <div class="row">  
                    <form action="${pageContext.request.contextPath}/CreateTeamServlet" method="post">
                        <input type="text" name="name" placeholder="Turniername" required>
                        <input type="text" name="tag" placeholder="Tag" required>
                        <input type="password" name="password" placeholder="Password">
                        <input type="password" name="password2" placeholder="Password">
                        <input type="submit" name="submit">
                    </form>
                    <% if (errors.size() > 0) {
                    for (int idx = 0; idx < errors.size(); idx++) {%>
                    Error: <%= errors.get(idx).getErrorMessage()%> <br>
                    <%    }
                        request.getSession().setAttribute("errors", null);
                    } else {%>
                    No Errors!
                    <% }%>


                </div> <!-- row -->    

                <div class="row">

                    <div class="col-md-7">
                        <a href="../teams/dashboard"><img class="img-responsive" src="http://placehold.it/750x350"></a>
                    </div>

                    <div class="col-md-5">
                        <h3>Team Name</h3>
                        <h4>Subheading</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                        <a class="btn btn-primary" href="../tournaments/dashboard">Zum Team <i class="fa fa-angle-right"></i></a>
                    </div>

                </div>

                <hr>

                <div class="row">

                    <div class="col-md-7">
                        <a href="../tournaments/dashboard"><img class="img-responsive" src="http://placehold.it/750x350"></a>
                    </div>

                    <div class="col-md-5">
                        <h3>Team Name</h3>
                        <h4>Subheading</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                        <a class="btn btn-primary" href="../tournaments/dashboard">Zum Team <i class="fa fa-angle-right"></i></a>
                    </div>

                </div>

                <hr>

                <div class="row text-center">

                    <div class="col-lg-12">
                        <ul class="pagination">
                            <li><a href="#">&laquo;</a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>        
                    </div>

                </div>

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
                <script src="../public/js/jquery.js"></script>
                <script src="../public/js/bootstrap.js"></script>
                <script src="../public/js/modern-business.js"></script>

                </body>
                </html>
