<%-- 
    Document   : training-view
    Created on : 14 Jul 2024, 10:51:55
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training View</title>
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
                <h3 class="text-center">What will you do next?</h3>
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="path-button text-center">
                        <a href="/AssignmentPRJ301/training/addCourse" type="button" class="btn btn-outline-secondary">Add new course</a>
                        <a href="/AssignmentPRJ301/training/addSemester" type="button" class="btn btn-outline-secondary">Add new Semester</a>
                        <a href="/AssignmentPRJ301/training/viewReport" type="button" class="btn btn-outline-secondary">View Mark Report</a>
                    </div>
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
