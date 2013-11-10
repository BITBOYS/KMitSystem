<%-- 
    Document   : index.jsp
    Created on : 10.11.2013, 10:48:37
    Author     : Maik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% String text = String.valueOf(request.getSession().getAttribute("text")); %>
    </head>
    <body>
        <h1>Tems</h1>
        
        <h1>Team erstellen Dummy!</h1>
            <form action="${pageContext.request.contextPath}/CreateTeamServlet" method="post">
                <input type="text" name="name" placeholder="Turniername" required>
                <input type="text" name="tag" placeholder="Tag" required>
                <input type="password" name="password" placeholder="Password">
                <input type="submit" name="submit">
            </form>
            <% out.print(text.equals("") ? "" : (text + " " + text.length())); %>
    </body>
</html>
