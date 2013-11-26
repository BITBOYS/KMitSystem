<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Landing Page">
        <meta name="author" content="Malte Dammann">

        <title>Kickern mit System - Welcome</title>

        <%            
            String link = request.getContextPath();

            List<com.kmitsystem.tools.errorhandling.Error> errors = (ArrayList<com.kmitsystem.tools.errorhandling.Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<com.kmitsystem.tools.errorhandling.Error>();
            }
        %>

        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>
        <%@include file="snipplets/header.jspf" %>

        <div id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide One');"></div>
                    <div class="carousel-caption">
                        <h1>Kickern Mit System - Dein Tool f&uuml;r Tischfussballmatches und Turniere!</h1>
                    </div>
                </div>
                <div class="item">
                    <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div>
                    <div class="carousel-caption">
                        <h1>Automatisiertre Statistiken</h1>
                    </div>
                </div>
                <div class="item">
                    <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div>
                    <div class="carousel-caption">
                        <h1>Habt Spa&szlig;, werdet besser und viel Spa&szlig; beim Training!</h1>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="icon-prev"></span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="icon-next"></span>
            </a>
        </div>

        <div class="section">

            <div class="container">
                
                <%@include file="snipplets/error.jspf" %>

                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <h3><i class="fa fa-check-circle"></i> Erstellt Turniere</h3>
                        <p>The 'Modern Business' website template by <a href="http://startbootstrap.com">Start Bootstrap</a> is built with <a href="http://getbootstrap.com">Bootstrap 3</a>. Make sure you're up to date with latest Bootstrap documentation!</p>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <h3><i class="fa fa-pencil"></i> Findet Freunde</h3>
                        <p>You're ready to go with this pre-built page structure, now all you need to do is add your own custom stylings! You can see some free themes over at <a href="http://bootswatch.com">Bootswatch</a>, or come up with your own using <a href="http://getbootstrap.com/customize/">the Bootstrap customizer</a>!</p>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <h3><i class="fa fa-folder-open"></i> Ranking</h3>
                        <p>This template features many common pages that you might see on a business website. Pages include: about, contact, portfolio variations, blog, pricing, FAQ, 404, services, and general multi-purpose pages.</p>
                    </div>
                </div><!-- /.row -->

            </div><!-- /.container -->

        </div><!-- /.section -->

        <div class="section-colored text-center">

            <div class="container">

                <div class="row">
                    <div class="col-lg-12">
                        <h2>Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh </h2>
                        <p>Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh Yaeh </p>
                        <hr>
                    </div>
                </div><!-- /.row -->

            </div><!-- /.container -->

        </div><!-- /.section-colored -->

        <div class="section">

            <div class="container">

                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <h2>Kickern mit System Features:</h2>
                        <ul>
                            <li>Erstellt Turniere mit deinen Freunden</li>
                            <li>Erstellt Teams</li>
                            <li>Tragt eure Matches ein und behaltet den Überblick</li>
                            <li>Sieh deine Statistiken ein</li>
                            <li>100% <strong>Free</strong> to Use</li>
                            <li>Mobile Responsive Design</li>
                        </ul>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <img class="img-responsive" src="http://placehold.it/700x450/cccccc/ffffff">
                    </div>
                </div><!-- /.row -->

            </div><!-- /.container -->

        </div><!-- /.section -->

        <div class="container">
            
            <%if(user == null){%>

            <div class="row well">
                <div class="col-lg-8 col-md-8">
                    <h4>'Kickern mit System' ist ein Webbasiertes Tool um eure Kicker-Statistik zu f&uuml;hren!</h4>
                    <p>
                        <a href="<%=link%>/login">Loggt</a> euch ein oder registriert euch jetzt!</p>
                </div>
                <div class="col-lg-4 col-md-4">
                    <a class="btn btn-lg btn-success pull-right" href="<%=link%>/register">Jetzt registrieren <i class="fa fa-angle-right"></i></a>
                </div>
            </div><!-- /.row -->
            <%}%>

        </div><!-- /.container -->

        <div class="container">

            <%@include file="snipplets/footer.jspf" %>

        </div><!-- /.container -->

        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=link%>/public/js/jquery.js"></script>
        <script src="<%=link%>/public/js/bootstrap.js"></script>
        <script src="<%=link%>/public/js/modern-business.js"></script>
    </body>
</html>
