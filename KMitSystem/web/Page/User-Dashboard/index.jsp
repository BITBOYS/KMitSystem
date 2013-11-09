<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="User Dshboard">
    <meta name="author" content="Malte Dammann">

    <title>User Dashboard - KmS</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="../../css/css/modern-business.css" rel="stylesheet">
    <link href="../../css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
          <a class="navbar-brand" href="../../index.jsp">KmS</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../Teams/index.jsp">Teams</a></li>
            <li><a href="../Turniere/index.jsp">Turniere</a></li> 
            <li><a href="../Statistiken/index.jsp">Statistiken</a></li> 
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
              <ul class="dropdown-menu">
              <li role="presentation" class="dropdown-header">For your Interest</li>
              	<li role="presentation" class="divider"></li>
                <li><a href="../AboutUs/index.jsp">About</a></li>
                <li><a href="../FAQ/index.jsp">FAQ</a></li>
                <li><a href="../Contact/contact.jsp">Kontakt</a></li>
                <li><a href="../Service/index.jsp">Info</a></li>
                <li><a href="../Sidebar/index.jsp">Sidebar Page</a></li>
              </ul>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
              <ul class="dropdown-menu">
                  <li><a href="../User-Dashboard/index.jsp">Dashboard</a></li> 
                <li><a href="../../index.jsp">Logout</a></li> 
              </ul>
             </li>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>

    <!-- Page Content -->

    <div class="container">
      
      <div class="row">
      
        <div class="col-lg-12">
          <h1 class="page-header">User-Dashboard <small>Dein Kontrollzentrum!</small></h1>
          <ol class="breadcrumb">
            <li><a href="../../index.jsp">Home</a></li>
            <li class="active">User-Dashboard</li>
          </ol>
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
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/modern-business.js"></script>
    
  </body>
</html>