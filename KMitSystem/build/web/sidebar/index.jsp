<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Index Page">
    <meta name="author" content="Malte Dammann">

    <title>Index Page - KmSe</title>

    <%
        String link = request.getContextPath();
        String loged_in = String.valueOf(session.getAttribute("loged_in"));
    %>
    
    <!-- Bootstrap core CSS -->
    <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
    <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  </head>

  <body>

    <%@include file="../snipplets/header.jspf" %>

    <!-- Page Content -->

    <div class="container">
      
      <div class="row">
        <div class="col-md-3 col-sm-4 sidebar">
            <ul class="nav nav-stacked nav-pills">
              <li><a href="<%=link%>/">Home</a></li>
              <li><a href="<%=link%>/about">About</a></li>
              <li><a href="<%=link%>/contact">Kontakt</a></li>
              <li class="active"><a href="#">Sidebar Page</a></li>
              <li><a href="<%=link%>/faq">FAQ</a></li>
            </ul>
        </div>
      
        <div class="col-md-9 col-sm-8">
          <h1 class="page-header">Index Page <small>Behalte den &Uuml;berblick.</small></h1>
          <ol class="breadcrumb">
            <li><a href="<%=link%>/">Home</a></li>
            <li class="disabled"><a href="#">Other Pages</a></li>
            <li class="active">Index Page</li>
          </ol>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
        </div>

      </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="container">

        <%@include file="../snipplets/footer.jspf" %>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=link%>/public/js/jquery.js"></script>
    <script src="<%=link%>/public/js/bootstrap.js"></script>
    <script src="<%=link%>/public/js/modern-business.js"></script>
  </body>
</html>