<%-- 
    Document   : lecturer-add-exam
    Created on : 6 Jul 2024, 15:34:27
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Exam</title>
        <!--Bootstrap CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="../view/css/lecturerUI/lecturer-add-exam.css"/>
    </head>
    <body>
        <div class="container">
            <div clas="row">
                <h4 class="text-center mt-5">Add new exam</h4>
                <div class="col-4"></div>
                <div class="col-4" style="margin-top: 140px;">
                    <form action="add" method="POST" class="create-form">
                        <input type="date" name="start_time"/>
                        <div class="form-floating mt-3">
                            <select name="duration" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                <option selected>Open this select menu</option>
                                <option value="15">15 Minutes</option>
                                <option value="20">20 Minutes</option>
                                <option value="30">30 Minutes</option>
                                <option value="40">40 Minutes</option>
                                <option value="45">45 Minutes</option>
                                <option value="50">50 Minutes</option>
                                <option value="60">60 Minutes</option>
                                <option value="90">90 Minutes</option>
                            </select>
                            <label for="floatingSelect">Duration</label>
                        </div>
                        <input type="hidden" name="course_id" value="${param.course_id}"/>
                        <div class="form-floating mt-3">
                            <select name="assessment_id" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                <c:forEach items="${requestScope.assessment}" var="a">
                                    <option value="${a.id}">${a.name}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingSelect">Assessment</label>
                        </div>
                        <button type="submit" class="btn btn-outline-success mt-3">Success</button>
                    </form>
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
