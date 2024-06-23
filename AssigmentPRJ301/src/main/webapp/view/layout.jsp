<%-- 
    Document   : layout
    Created on : 9 Jun 2024, 09:17:52
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Layout</title>
    </head>
    <body>
        <jsp:include page=""/>
        <div class="content">
            <jsp:include page="${pageContent}"/>
        </div>
        
    </body>
</html>
