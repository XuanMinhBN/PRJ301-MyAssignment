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
    </head>
    <body>
        <c:if test="${requestScope.exams eq null}">
        <form action="view" method="POST"> 
            <input type="hidden" name="lecturer_id" value="${param.lecturer_id}"/>
            Course <select name="course_id">
                <c:forEach items="${requestScope.course}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="View"/>
        </form>
        </c:if>
        <c:if test="${requestScope.exams ne null}">
            <form action="mark" method="GET">
                <input type="hidden" name="lecturer_id" value="${param.lecturer_id}"/>
                <input type="hidden" name="course_id" value="${param.course_id}"/>
                <c:forEach items="${requestScope.exams}" var="e">
                    <input type="checkbox" name="exam_id" value="${e.id}"/> ${e.assessment.name} - ${e.assessment.subject.name} - ${e.date} - ${e.duration} minutes <br/>
                </c:forEach>
                    <input type="submit" value="Take"/>
            </form>
        </c:if>
    </body>
</html>
