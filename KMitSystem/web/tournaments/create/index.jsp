<%@page import="com.kmitsystem.tools.objects.Team"%>
<%@page import="com.kmitsystem.tools.objects.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Turnier Erstellen">
        <meta name="author" content="Malte Dammann">

        <title>Turnier Erstellen - KmS</title>

        <%
            String link = request.getContextPath();
            String loged_in = String.valueOf(session.getAttribute("loged_in"));
            
            List<Error> errors = (ArrayList<Error>) request.getAttribute("errors");
            if (errors == null) {
                errors = new ArrayList<Error>();
            }
            
            List<Team> teams = (ArrayList<Team>) request.getAttribute("teams");
            if (teams == null) {
                teams = new ArrayList<Team>();
            }
        %>
        
        <!-- Bootstrap core CSS -->
        <link href="<%=link%>/public/css/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="<%=link%>/public/css/css/modern-business.css" rel="stylesheet">
        <link href="<%=link%>/public/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>

        <%@include file="../../snipplets/header_private.jspf" %>

        <!-- Page Content -->

         <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <h1 class="page-header">Turniere Eestellen <small>Erstelle Turniere und lade Teams ein!</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="<%=link%>/">Home</a></li>
                        <li><a href="<%=link%>/tournaments">Turniere</a></li>
                        <li class="active">Turnier erstellen</li>
                    </ol>
                </div>
            </div><!-- /.row -->

            <div class="row">
                   <div class="col-lg-12">
                       <div class="row">
                           <form class="form-horizontal" role="form" action="<%=link%>/teams/create" method="post">

                               <div class="col-lg-4 col-lg-offset-1">
                                   <div class="form-group">
                                       <label for="inputTournamentname" class="col-sm-2 control-label">Name</label>
                                       <div class="col-lg-8">
                                           <input type="text" class="form-control" name="name" placeholder="Teamname" required>
                                       </div>
                                   </div>
                                   
                                   <div class="form-group">
                                       <label for="inputTournamentname" class="col-sm-2 control-label">dede</label>
                                       <div class="col-lg-8">
                                           <input type="text" class="form-control" name="dede" placeholder="dede" required>
                                       </div>
                                   </div>
                               </div>
                               
                               <div class="col-lg-6 col-lg-offset-1">
                                    <div class="form-group">
                                        <label for="inputTournamentname" class="col-sm-2 control-label">Passwort</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="password" placeholder="Passwort">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputTournamentname" class="col-sm-2 control-label">Passwort wiederholen</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="reenter_password" placeholder="Passwort wiederholen">
                                        </div>
                                    </div>
                               </div>
                               
                               <div class="form-group">
                                    <div class="col-lg-4 col-lg-offset-1">
                                       <label for="userAuswahl" class="col-sm-2 control-label">Team</label>
                                       <div class="col-lg-8">
                                           <input list="userAuswahl" name="user" autocomplete="off" class="form-control" >
                                            <datalist id="userAuswahl">
                                                <% for(int idx = 0; idx < teams.size(); idx++) {%>
                                                    <option value="<%= teams.get(idx).getName()%>"> 
                                                <% } %>
                                            </datalist>
                                            <a href="#">Team hinzuf&uuml;gen</a>
                                       </div>
                                    </div>
                               </div>

                                <div class="form-group col-lg-4 col-lg-offset-1">
                                    <div class="col-md-offset-6">
                                        <button type="submit" class="btn btn-primary"><span class="fa fa-search"> Erstellen <i class="fa fa-angle-right"></i></button>
                                    </div>
                                </div>
                           </form>
                        </div>
                           
                        <div class="row">
                            <% for(int idx = 0; idx < errors.size(); idx++) { %>
                                <% if(errors.get(idx).getStatus().equals(Error.ERROR)) { %>
                                <div class="alert alert-danger"><%= errors.get(idx).getErrorMessage() %></div>
                                <% } else if(errors.get(idx).getStatus().equals(Error.INFO)) { %>
                                <div class="alert alert-info"><%= errors.get(idx).getErrorMessage() %></div>
                            <% } } %>
                        </div>
                           
                   </div>
               </div>
           </div> <!-- row --> 

        </div><!-- /.container -->

        <div class="container">

            <%@include file="../../snipplets/footer.jspf" %>

        </div><!-- /.container -->

        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<%=link%>/public/js/jquery.js"></script>
        <script src="<%=link%>/public/js/bootstrap.js"></script>
        <script src="<%=link%>/public/js/modern-business.js"></script>

    </body>
</html>