<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="User Dshboard">
        <meta name="author" content="Malte Dammann">

        <title>User Dashboard - KmS</title>

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
                    <a class="navbar-brand" href="../../">KmS</a>
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
                    <h1 class="page-header">User-Dashboard <small>Dein Kontrollzentrum</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="../">Home</a></li>
                        <li><a href="../">Profil</a></li>
                        <li class="active">User-Dashboard</li>
                    </ol>
                </div>
            </div>

            <!-- Service Tabs -->

            <div class="row">

                <div class="col-lg-12">
                    <h2 class="page-header">Deine Optionen</h2>
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#acc" data-toggle="tab">Account</a></li>
                        <li><a href="#team" data-toggle="tab">Teams</a></li>
                        <li><a href="#turnier" data-toggle="tab">Turniere</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="acc">
                            <i class="fa fa-gear pull-left fa-4x"></i>
                            <div class="row">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                                <div class="col-lg-12">
                                    <h2 class="page-header">E-Mail &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="form_email" action="#">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">E-Mail</label>
                                            <div class="col-sm-6">
                                                <input type="email" class="form-control" id="input_email_alt" placeholder="alte E-Mail">
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="email" class="form-control" id="input_email_neu1" placeholder="neue E-Mail">
                                                <input type="email" class="form-control" id="input_email_neu2" placeholder="neue E-Mail">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-md-offset-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <input type="checkbox" id="sure">
                                                    </span>
                                                    <p type="text" class="form-control">Bist du sicher?</p>
                                                </div><!-- /input-group -->
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Name &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="form_name" action="#">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Name</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="input_name_alt" placeholder="alter Name">
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="text" class="form-control" id="input_name_neu1" placeholder="neuer Name">
                                                <input type="text" class="form-control" id="input_name_neu2" placeholder="neuer Name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-md-offset-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <input type="checkbox" id="sure">
                                                    </span>
                                                    <p type="text" class="form-control">Bist du sicher?</p>
                                                </div><!-- /input-group -->
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>     
                            </div>

                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Passwort &auml;ndern</h2>
                                    <form class="form-horizontal" role="form" name="form_pasword" action="#">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Passwort</label>
                                            <div class="col-sm-6">
                                                <input type="email" class="form-control" id="input_pasword_alt" placeholder="altes Passwort">
                                            </div>
                                            <div class="col-sm-6 col-md-offset-2">
                                                <input type="password" class="form-control" id="input_pasword_neu1" placeholder="neues Passwort">
                                                <input type="password" class="form-control" id="input_pasword_neu2" placeholder="neues Passwort">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-md-offset-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <input type="checkbox" id="sure">
                                                    </span>
                                                    <p type="text" class="form-control">Bist du sicher?</p>
                                                </div><!-- /input-group -->
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary btn-default" type="submit">
                                                    &Auml;ndern</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="team">
                            <i class="fa fa-beer pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h2 class="page-header">Deine Teams</h2>
                                </div>

                                <div class="col-lg-3 col-md-3 hero-feature">
                                    <div class="thumbnail">
                                        <h3>Teamname <small> Leader: <a href="#">User2</a></small></h3>
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
                                            <p><a href="#" class="btn btn-primary">Turnierprofil <i class="fa fa-angle-right"></i></a> <a href="#" class="btn btn-danger">Austreten <i class="fa fa-angle-right"></i></a></p>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        </div>

                        <div class="tab-pane fade" id="turnier">
                            <i class="fa fa-flag pull-left fa-4x"></i>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
                            <div class="row">

                                <div class="col-lg-12">
                                    <h2 class="page-header">Deine Turniere</h2>
                                </div>

                                <div class="col-lg-3 col-md-3 hero-feature">
                                    <div class="thumbnail">
                                        <h3>Turniername <small> Leader: <a href="#">User2</a></small></h3>
                                        <div class="caption">
                                            <div class="panel panel-default">
                                                <!-- Default panel contents -->
                                                <div class="panel-heading">Daten</div>

                                                <!-- Table -->
                                                <table class="table">  
                                                    <thead>  
                                                        <tr>  
                                                            <th>Startdate</th>  
                                                            <th>Enddate</th>  
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
                                            <p><a href="#" class="btn btn-primary">Turnierprofil <i class="fa fa-angle-right"></i></a> <a href="#" class="btn btn-danger">Austreten <i class="fa fa-angle-right"></i></a></p>
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