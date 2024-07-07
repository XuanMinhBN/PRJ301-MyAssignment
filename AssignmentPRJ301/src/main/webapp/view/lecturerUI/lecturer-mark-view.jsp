<%-- 
    Document   : lecturer-mark-view
    Created on : 27 Jun 2024, 15:37:12
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturer Mark View</title>
    </head>
    <body>
        <form action="mark" method="POST">
            <table border="1px">
                <tr>
                    <th></th>
                    <c:forEach items="${requestScope.exams}" var="e">
                        <th>
                            ${e.assessment.name} - ${e.assessment.weight}
                        </th>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.students}" var="s">
                 <tr>
                    <td>${s.name}</td>
                    <c:forEach items="${requestScope.exams}" var="e">
                        <td>
                            <input type="hidden" name="grade_id" value="${s.id}_${e.id}" />
                            <input type="text" name="grade${s.id}_${e.id}" 
                                   
                                   <c:forEach items="${requestScope.grades}" var="g">
                                       <c:if test="${g.exam.id eq e.id and g.student.id eq s.id}">
                                       value="${g.score}"
                                       </c:if>
                                   </c:forEach>
                                   />
                        </td>
                    </c:forEach>
                </tr>   
                </c:forEach>
            </table>
            <input type="hidden" name="course_id" value="${param.course_id}"/>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
