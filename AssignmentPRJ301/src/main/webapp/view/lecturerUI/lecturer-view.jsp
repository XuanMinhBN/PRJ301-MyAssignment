<%-- 
    Document   : lecturer-view
    Created on : 26 Jun 2024, 17:10:15
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturer View</title>
        <!--Bootstrap CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="../view/css/lecturerUI/lecturer-view.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4" style="margin-top: 200px;">
                    <c:if test="${requestScope.assessment eq null}">
                        <form action="view" method="POST"> 
                            <input type="hidden" name="lecturer_id" value="${param.lecturer_id}"/>
                            <h3 class="text-center">Course</h3> <select name="course_id" class="form-select form-select-lg mb-3" aria-label="Large select example">
                                <c:forEach items="${requestScope.course}" var="c">
                                    <option value="${c.id}">${c.name}</option>
                                </c:forEach>
                            </select>
                            <div class="text-center">
                                <button type="submit" class="btn btn-outline-success">View</button>
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${requestScope.assessment ne null}">
                        <h3 class="text-center">Choose assessments:</h3>
                        <form action="mark" method="GET">
                            <input type="hidden" name="lecturer_id" value="${param.lecturer_id}"/>
                            <input type="hidden" name="course_id" value="${param.course_id}"/>
                            <c:forEach items="${requestScope.assessment}" var="a">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="${a.id}" id="flexCheckDefault" name="exam_id">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        ${a.name} - ${a.subject.name} 
                                    </label>
                                </div>
                            </c:forEach>
                            <input type="submit" class="btn btn-outline-success" value="Take"/>
                        </form>
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
