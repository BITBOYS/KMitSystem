<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User Profil">
        <meta name="author" content="Malte Dammann">

        <title>User Profil - KmS</title>

        <!-- Bootstrap core CSS -->
        <link href="../../public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="../../public/css/css/modern-business.css" rel="stylesheet">
        <link href="../../public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
                        <li><a href="../../teams">Teams</a></li>
                        <li><a href="../../tournaments">Turniere</a></li> 
                        <li><a href="../../statistics">Statistiken</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../../about">About</a></li>
                                <li><a href="../../faq">FAQ</a></li>
                                <li><a href="../../contact">Kontakt</a></li>
                                <li><a href="../../service">Info</a></li>
                                <li><a href="../../sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../profil">Profil</a></li> 
                                <li><a href="../dashboard">Dashboard</a></li> 
                                <li><a href="../../">Logout</a></li> 
                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">User-Profil <small>Alles �ber "Name"!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../../">Home</a></li>
                        <li class="active">Profil</li>
                    </ol>
                </div>
            </div>
            
            <div class="row">
                
               <div class="col-lg-12">
                    <h2 class="page-header">"Name" pers�nliche Statistik</h2>
                    
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
                                            <td>1</td>  
                                            <td>1</td>  
                                            <td>10</td>  
                                            <td>2</td>  
                                            <td>2</td> 
                                            <td>2</td>  
                                            <td>2</td> 
                                        </tr>  
                                    </tbody>  
                                </table>  
                            </div>  
                    
               </div>
                
            </div><!-- /.row -->

            <div class="row">  

                <div class="col-lg-12">
                    <h2 class="page-header">"Name" Teams</h2>
                </div>
                
                <!-- Schleife zum Anzeigen aller Teams in denen man sich befindet -->
                <%
      //              for(int i = 0; i < teams.length(); i++){
      //                  
      //              }
%>

                <div class="col-lg-6 col-md-6 hero-feature">
                    <div class="thumbnail">
                        <h3>Teamname <small> Leader: <a href="#">User2</a></small></h3>
                        <img src="http://placehold.it/800x500" alt="">
                        <div class="caption">
                            <div class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">Teammitglieder</div>
                                <div class="list-group">
                                    <a href="#" class="list-group-item">User2</a>
                                    <a href="#" class="list-group-item">...</a>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">Stats</div>

                                <!-- Table -->
                                <table class="table">  
                                    <thead>  
                                        <tr>  
                                            <th>TS</th>  
                                            <th>GS</th>  
                                            <th>N</th>  
                                            <th>T</th>  
                                            <th>GT</th>  
                                            <th>aktive Turniere</th> 
                                        </tr>  
                                    </thead>  
                                    <tbody>  
                                        <tr>  
                                            <td>1</td>  
                                            <td>1</td>  
                                            <td>10</td>  
                                            <td>2</td>  
                                            <td>2</td> 
                                            <td>2</td> 
                                        </tr>  
                                    </tbody>  
                                </table>  
                            </div>  
                            <p><a href="#" class="btn btn-primary">Zum Teamprofil <i class="fa fa-angle-right"></i></a></p>
                        </div>
                    </div>
                </div>

            </div><!-- /.row -->
            
            <div class="row">
                
               <div class="col-lg-12">
                   <h2 class="page-header">"Name" aktuellen Turniere</h2>
               </div>
                
               <div class="col-lg-4 col-md-4 hero-feature">
                    <div class="thumbnail">
                        <h3>Turniername <small> Leader: <a href="#">User2</a></small></h3>
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
                                            <td>1.1.1.1</td>  
                                            <td>1.1.1.1</td>  
                                            <td>privat</td> 
                                        </tr>  
                                    </tbody>  
                                </table>  
                            </div>  
                            <p><a href="#" class="btn btn-primary">Zum Turnierprofil <i class="fa fa-angle-right"></i></a></p>
                        </div>
                    </div>
                </div> 
                
            </div><!-- /.row -->

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
        <script src="../../public/js/jquery.js"></script>
        <script src="../../public/js/bootstrap.js"></script>
        <script src="../../public/js/modern-business.js"></script>

    </body>
</html>