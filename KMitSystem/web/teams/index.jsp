<%-- 
    Document   : index.jsp
    Created on : 10.11.2013, 10:48:37
    Author     : Maik
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kmitsystem.tools.errorhandling.Error"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            List<Error> errors = (ArrayList<Error>)request.getSession().getAttribute("errors"); 
            if(errors == null) {
                errors = new ArrayList<Error>();
            }
        %>
    </head>
    <body>
        <h1>Teams</h1>
        
        <h1>Team erstellen Dummy!</h1>
            <form action="${pageContext.request.contextPath}/CreateTeamServlet" method="post">
                <input type="text" name="name" placeholder="Turniername" required>
                <input type="text" name="tag" placeholder="Tag" required>
                <input type="password" name="password" placeholder="Password">
                <input type="password" name="password2" placeholder="Password">
                <input type="submit" name="submit">
            </form>
            <% if(errors.size() > 0) { 
                  for(int idx = 0; idx < errors.size(); idx++) { %>
                     Error: <%= errors.get(idx).getErrorMessage() %> <br>
            <%    } 
                  request.getSession().setAttribute("errors", null); 
            } else {%>
                No Errors!
            <% } %>
    </body>
</html>
