<%-- 
    Document   : student-view
    Created on : 3 Jul 2024, 07:23:24
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Syllabus</title>
        <!--Bootstrap CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="../view/css/studentUI/student-view.css"/>
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
                            <h5>${student.name}</h5>
                        </div>
                        <div class="student-id text-center">
                            <h4>Student ID:</h4>
                            <h5>${student.roll}</h5>
                        </div>
                    </div>
                    <table class="table table-bordered border-info">
                        <thead>
                            <tr>
                                <th scope="col">Season</th>
                                <th scope="col">Year</th>
                                <th scope="col">Class</th>
                                <th scope="col">Subject</th>
                                <th scope="col">More Info</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.course}" var="c">
                                <tr>
                                    <th scope="row">${c.semester.season}</th>
                                    <td>${c.semester.year}</td>
                                    <td>${c.name}</td>
                                    <td>${c.subject.name}</td>
                                    <td>
                                        <a href="/AssignmentPRJ301/student/mark?student_id=${student.id}&subject_id=${c.subject.id}" type="button" class="btn btn-outline-info">Mark Report</a>
                                    </td>
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
