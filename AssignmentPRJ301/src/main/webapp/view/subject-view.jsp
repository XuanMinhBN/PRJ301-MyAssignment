<%-- 
    Document   : subject-view
    Created on : 4 Jul 2024, 15:00:06
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4" style="margin-top: 200px;">
                    <c:if test="${requestScope.assessment eq null}">
                        <form action="subject" method="POST"> 
                            <h3 class="text-center">Subject</h3> <select name="subject_id" class="form-select form-select-lg mb-3" aria-label="Large select example">
                                <c:forEach items="${requestScope.subject}" var="c">
                                    <option value="${c.id}">${c.name}</option>
                                </c:forEach>
                            </select>
                            <div class="text-center">
                                <button type="submit" class="btn btn-outline-success">View</button>
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${requestScope.assessment ne null}">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Subject</th>
                                    <th scope="col">Assessment</th>
                                    <th scope="col">Mark Weight</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.assessment}" var="a">
                                    <tr>
                                    <th scope="row">${a.subject.name}</th>
                                    <td>${a.name}</td>
                                    <td>${a.weight}</td>
                                </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </c:if>
                </div>
                <div class="col-4"></div>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
