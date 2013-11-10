<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Loginformular">
    <meta name="author" content="Malte Dammann">

    <title>Login - KmS</title>

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
                <li><a href="../service">Info</a></li>
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
          <h1 class="page-header">Login <small>Hier einloggen!</small></h1>
          <ol class="breadcrumb">
            <li><a href="../index.jsp">Home</a></li>
            <li class="active">Login</li>
          </ol>
        </div>
        
        <div class="col-lg-12">
           <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
            <div align="center">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="You!">
                </div>  
                <br>  
                <form class="form-signin" action="../dashboard/" method="post" role="form">
                <input type="email" class="form-control" placeholder="Email" required autofocus>
                <input type="password" class="form-control" placeholder="Password" required>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                </form>
            </div>
                <a href="../faq" class="pull-right need-help">Brauchst du Hilfe? </a><span class="clearfix"></span>
            	<br>
                <a href="../register" class="text-center new-account">Noch nicht angemeldet? Jetzt account erstellen! </a>
       	 </div>
        </div>

      </div><!-- /.row -->
      
      <br>
        <div class="alert alert-success">Dein Account wurde bestätigt. Log dich jetzt mit deinen Benutzerdaten ein.</div>
        <div class="alert alert-info">Check deine Mails und bestätige deinen Account.</div>
        <div class="alert alert-danger">Username oder Passwort ist falsch.</div>
      
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
    <script src="../public/js/jquery.js"></script>
    <script src="../public/js/bootstrap.js"></script>
    <script src="../public/js/modern-business.js"></script>
  </body>
</html>