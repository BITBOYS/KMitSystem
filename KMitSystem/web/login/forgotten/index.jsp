<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Passwort vergessen">
        <meta name="author" content="Malte Dammann">

        <title>Password Forgotten - KmS</title>

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
                        <li class="active"><a href="../login">Login</a></li>
                        <li><a href="../register">Sign Up</a></li>        
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li role="presentation" class="dropdown-header">For your Interest</li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../about">About</a></li>
                                <li><a href="../faq">FAQ</a></li>
                                <li><a href="../contact">Kontakt</a></li>
                                <li><a href="../sidebar">Sidebar Page</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Passwort vergessen</h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="disabled"><a href="#">Login</a></li>
                        <li class="active">Passwort vergessen</li>
                    </ol>
                </div>

            </div><!-- /.row -->

            <div class="row well col-sm-4 col-lg-offset-4">

                    <form role="form" method="POST" action="#">
                        <div class="row">
                            <div class="form-group">
                                <label for="input2">E-mail</label>
                                <div class="input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="email" name="email" class="form-control" id="input1">
                                </div>
                            </div>
                        </div><!-- /.row -->
                        <div class="row">
                            <div class="form-group">
                                <button type="submit" class="fa fa-mail btn btn-primary"> Submit </button>
                            </div>
                        </div>
                    </form>

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
