<%-- 
    Document   : add-course
    Created on : 14 Jul 2024, 10:18:29
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new course</title>
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
            <div class="row mt-5">
                <h3 class="text-center">Add new Course</h3>
                <div class="col-12">
                    <form action="addCourse" method="POST">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" name="course">
                            <label for="floatingInput">Course Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="floatingSelect" aria-label="Floating label select example" name="lecturer">
                                <c:forEach items="${requestScope.lecList}" var="l">
                                    <option value="${l.id}">${l.name}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingSelect">Lecturer</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="floatingSelect1" aria-label="Floating label select example" name="subject">
                                <c:forEach items="${requestScope.subList}" var="sub">
                                    <option value="${sub.id}">${sub.name}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingSelect1">Subject</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="floatingSelect2" aria-label="Floating label select example" name="semester">
                                <c:forEach items="${requestScope.seList}" var="se">
                                    <option value="${se.id}">${se.season}${se.year}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingSelect2">Semester</label>
                        </div>
                        <button type="submit" class="btn btn-outline-success">Add new</button>
                    </form>
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
