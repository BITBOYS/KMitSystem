<!DOCTYPE html>
<html lang="en" manifest="../public/cache/cache.manifest">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Das sind wir.">
        <meta name="author" content="Malte Dammann">

        <title>About Us - Leago</title>

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

        <%@include file="../snipplets/header.jspf" %>

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
                    <img class="img-responsive" src="<%=link%>/public/images/team.jpg">
                </div>
                <div class="col-md-6">
                    <h2>Welcome to 'Leago'</h2>
                    <p>Wir sind ein junges Developer Team aus Hamburg und haben unglaublich viel Spa&szlig; am Kickern. Deshalb haben wir erkannt, dass die Welt ein Kicker-Tool braucht.</p>
                    <p>Und genau hier kommt Leago ins Spiel. Aus einer scherzhaften Idee wurde ein Konzept. Leago ist in unserer Freizeit entstanden und dient keinen kommerziellen Zwecken. Wer uns trotzdem etwas Gutes tun möchte, kann uns gerne mal einen Kaffee ausgeben.</p>
                </div>

            </div>

            <!-- Team Member Profiles -->

            <div class="row">

                <div class="col-sm-12">
                    <h2 class="page-header">Das Team</h2>
                </div>

                    <div class="col-sm-4">
                        <img class="img-circle img-responsive" src="<%=link%>/public/images/maik.png" width="200px" height="200px">
                        <h3>Maik Schmaddebeck <small>Backend Developer und System Designer</small></h3>
                        <p>Maik mag Kappies.</p>
                        <ul class="list-unstyled list-inline list-social-icons">
                            <li class="tooltip-social"><a href="#xing-profile" data-toggle="tooltip" target="blank" data-placement="bottom" title="Xing"><i class="fa fa-xing fa-2x"></i></a></li>
                            <li class="tooltip-social linkedin-link"><a href="#linkedin-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="LinkedIn"><i class="fa fa-linkedin-square fa-2x"></i></a></li>
                            <li class="tooltip-social facebook-link"><a href="#facebook-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                            <li class="tooltip-social google-plus-link"><a href="#google-plus-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                        </ul>
                    </div>

                    <div class="col-sm-4">
                        <img class="img-circle img-responsive" src="<%=link%>/public/images/malte.png" width="200px" height="200px">
                        <h3>Malte Dammann <small>Web/Backend Developer und System Designer</small></h3>
                        <p>Malte mag Haxe.</p>
                        <ul class="list-unstyled list-inline list-social-icons">
                            <li class="tooltip-social"><a href="https://www.xing.com/profiles/Malte_Dammann2" target="_blank" data-toggle="tooltip" data-placement="bottom" title="Xing"><i class="fa fa-xing fa-2x"></i></a></li>
                            <li class="tooltip-social linkedin-link"><a href="https://de.linkedin.com/in/mdammann" target="_blank" data-toggle="tooltip" data-placement="bottom" title="LinkedIn"><i class="fa fa-linkedin-square fa-2x"></i></a></li>
                            <li class="tooltip-social facebook-link"><a href="https://www.facebook.com/malte.da.3" target="_blank" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                            <li class="tooltip-social google-plus-link"><a href="https://google.com/+MalteDa" target="_blank" data-toggle="tooltip" data-placement="bottom" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                        </ul>
                    </div>

                <div class="col-xs-3"></div>                
                    <div class="col-sm-4 col-xs-10">
                        <img class="img-circle img-responsive" src="<%=link%>/public/images/alex.png" width="200px" height="200px">
                        <h3>Alexander Spottka <small>Backend Devoloper und System Designer</small></h3>
                        <p>Alex mag Dota.</p>
                        <ul class="list-unstyled list-inline list-social-icons">
                            <li class="tooltip-social"><a href="#xing-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="Xing"><i class="fa fa-xing fa-2x"></i></a></li>
                            <li class="tooltip-social linkedin-link"><a href="#linkedin-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="LinkedIn"><i class="fa fa-linkedin-square fa-2x"></i></a></li>
                            <li class="tooltip-social facebook-link"><a href="#facebook-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                            <li class="tooltip-social google-plus-link"><a href="#google-plus-profile" target="blank" data-toggle="tooltip" data-placement="bottom" title="Google+"><i class="fa fa-google-plus-square fa-2x"></i></a></li>
                        </ul>
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