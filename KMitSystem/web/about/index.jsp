<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Das sind wir.">
        <meta name="author" content="Malte Dammann">

        <title>About Us- KmS</title>

        <%            String link = request.getContextPath();
            String loged_in = String.valueOf(request.getSession().getAttribute("loged_in"));
        %>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>

        <%
            // Including Header
            if (!loged_in.equals("true") || loged_in == null) {
        %>
        <%@include file="../snipplets/header_public.jspf" %>
        <%
        } else {
        %>
        <%@include file="../snipplets/header_private.jspf" %>
        <% }%>

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">About Us <small>Das sind wir!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>">Home</a></li>
                        <li class="disabled"><a href="#">Other Pages</a></li>
                        <li class="active">About Us</li>
                    </ol>
                </div>

            </div>

            <div class="row">

                <div class="col-md-6">
                    <img class="img-responsive" src="http://placehold.it/500x250">
                </div>
                <div class="col-md-6">
                    <h2>Welcome to 'Kickern mit System'</h2>
                    <p>Wir sind ein junges Developer Team und haben unglaublich viel Spa√ü am Kickern. Deshalb haben wir erkannt, dass die Welt ein Kicker-Tool braucht.</p>
                    <p>Und genau hier kommt KmS ins Spiel.</p>
                </div>

            </div>

            <!-- Team Member Profiles -->

            <div class="row">

                <div class="col-lg-12">
                    <h2 class="page-header">Das Team</h2>
                </div>

                <div class="col-sm-4">
                    <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                    <h3>Maik Schmaddebeck <small>Backend Developer und System Designer</small></h3>
                    <p>Maik weiﬂ alles und Maik kann alles.</p>
                    <ul class="list-unstyled list-inline list-social-icons">
                        <li class="tooltip-social facebook-link"><a href="#facebook-profile" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                        <li class="tooltip-social google-plus-link"><a href="#google-plus-profile" data-toggle="tooltip" data-placement="top" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                    </ul>
                </div>

                <div class="col-sm-4">
                    <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                    <h3>Malte Dammann <small>Web Developer und System Designer</small></h3>
                    <p>Malte hat leitet das Frontend-Dev Teams. Au&szlig;erdem unterst&uuml;tzt er das Backend Team!</p>
                    <ul class="list-unstyled list-inline list-social-icons">
                        <li class="tooltip-social facebook-link"><a href="#facebook-profile" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                        <li class="tooltip-social google-plus-link"><a href="#google-plus-profile" data-toggle="tooltip" data-placement="top" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                    </ul>
                </div>

                <div class="col-sm-4">
                    <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                    <h3>Alexander Spottka <small>G&ouml;nnnnnnnnnnnnnnnenenenene</small></h3>
                    <p>Backen! Backen! Backen! Backen! Backen! Backen! Backen! Backen! Brot! Backen! </p>
                    <ul class="list-unstyled list-inline list-social-icons">
                        <li class="tooltip-social facebook-link"><a href="#facebook-profile" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                        <li class="tooltip-social google-plus-link"><a href="#google-plus-profile" data-toggle="tooltip" data-placement="top" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                    </ul>
                </div>

            </div>

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