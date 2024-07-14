<%-- 
    Document   : training-add-student
    Created on : 14 Jul 2024, 17:41:46
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Students</title>
        <!--Bootstrap CSS-->
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
                <h3>${course.name}</h3>
                <div class="col-12">
                    <div class="row">
                        <form action="addStudent" method="POST">
                            <input type="hidden" name="course_id" value="${param.course_id}"/>
                            <div>
                                <c:forEach items="${requestScope.studentList}" var="s">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="${s.id}" id="flexCheckDefault" name="student">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            ${s.roll} - ${s.name}
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                            <input type="submit" class="btn btn-outline-success" value="Add into Course"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
