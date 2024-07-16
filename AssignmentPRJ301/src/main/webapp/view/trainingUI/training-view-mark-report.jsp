<%-- 
    Document   : training-view-mark-report
    Created on : 15 Jul 2024, 11:04:30
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
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <c:if test="${requestScope.report eq null}">
                        <form action="viewReport" method="POST" class="mb-3">
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
                    <c:if test="${requestScope.report ne null}">
                        <table class="table table-bordered mt-5">
                            <thead>
                                <tr>
                                    <th scope="col">Student Roll</th>
                                    <th scope="col">Student Name</th>
                                    <th scope="col">Subject</th>
                                    <th scope="col">Average Mark</th>
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.report}" var="r">
                                    <tr>
                                        <th scope="row">${r.studentId.roll}</th>
                                        <td>${r.studentId.name}</td>
                                        <td>${r.subjectId.name}</td>
                                        <td>
                                            <p class="text-center" style="margin: 0;">${r.averageMark}</p>
                                        </td>
                                        <td>
                                            ${r.markStatus == true ? '<p class="text-center" style="margin:0; padding:4px; background:green; color:#fff; border-radius:10px;">Passed</p>' 
                                                                   : '<p class="text-center" style="margin:0; padding:4px; background:red; color:#fff; border-radius:10px;">Not Passed</p>'}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
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
