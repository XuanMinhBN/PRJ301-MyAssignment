<%-- 
    Document   : student-mark-report
    Created on : 7 Jul 2024, 14:11:49
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark Report</title>
        <!--Bootstrap CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="../view/css/studentUI/student-mark-report.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <h3 class="text-center">Information</h3>
                <div class="col-3"></div>
                <div class="col-6 mt-5">
                    <div class="student-info mb-4">
                        <div class="student-name text-center">
                            <h4>Student Name:</h4>
                            <h5>${aStudent.name}</h5>
                        </div>
                        <div class="student-id text-center">
                            <h4>Student ID:</h4>
                            <h5>${aStudent.roll}</h5>
                        </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Subject</th>
                                <th scope="col">Assessment</th>
                                <th scope="col">Mark Weight</th>
                                <th scope="col">Score</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.student}" var="s">
                            <tr>
                                <th scope="row">${s.grades.exam.assessment.subject.name}</th>
                                <td>${s.grades.exam.assessment.name}</td>
                                <td>${s.grades.exam.assessment.weight}</td>
                                <td>${s.grades.score}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-3"></div>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
