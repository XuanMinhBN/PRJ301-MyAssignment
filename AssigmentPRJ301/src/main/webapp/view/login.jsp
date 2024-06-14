<%-- 
    Document   : login
    Created on : 9 Jun 2024, 10:44:39
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <!--Bootstrap CSS-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <!--Custom CSS-->
        <link rel="stylesheet" href="view/css/login.css"/>
    </head>
    <body>
        <!-- Login page -->
        <div class="containter-fluid">
            <div class="row">
                <div class="col-sm-0 col-lg-4"></div>
                <div class="col-sm-12 col-lg-4">
                    <div class="form-popup">
                        <div class="form-box">
                            <div class="form-register">
                                <h2 style="margin-bottom: 20px">Login with your role</h2>
                                <div class="switch">
                                    <div class="personal-form" onclick="tab1()">Student</div>
                                    <div class="business-form" onclick="tab2()">Teacher</div>
                                </div>
                                <div class="register-type">
                                    <form id="form">
                                        <div id="page" class="personal-switch">
                                            <select
                                                class="form-select"
                                                aria-label="Default select example"
                                                >
                                                <option selected>What is your campus?</option>
                                                <option value="1">Hola</option>
                                                <option value="2">Fuda</option>
                                                <option value="3">Hovilo</option>
                                                <option value="4">Xavalon</option>
                                            </select>
                                            <div class="register_email mb-3">
                                                <input
                                                    type="email"
                                                    class="form-control"
                                                    id="registEmail"
                                                    aria-describedby="emailHelp"
                                                    placeholder="Student Email"
                                                    />
                                            </div>
                                            <div class="register_password mb-3">
                                                <input
                                                    type="password"
                                                    class="form-control"
                                                    id="registPassword"
                                                    placeholder="Password"
                                                    />
                                            </div>
                                            <button type="submit" class="btn btn-primary">
                                                Login
                                            </button>
                                        </div>

                                        <div id="page" class="business-switch">
                                            <select
                                                class="form-select"
                                                aria-label="Default select example"
                                                >
                                                <option selected>What is your campus?</option>
                                                <option value="1">Hola</option>
                                                <option value="2">Fuda</option>
                                                <option value="3">Hovilo</option>
                                                <option value="4">Xavalon</option>
                                            </select>
                                            <div class="register_email mb-3">
                                                <input
                                                    type="email"
                                                    class="form-control"
                                                    id="registEmail"
                                                    aria-describedby="emailHelp"
                                                    placeholder="Teacher email"
                                                    />
                                            </div>
                                            <div class="register_password mb-3">
                                                <input
                                                    type="password"
                                                    class="form-control"
                                                    id="registPassword"
                                                    placeholder="Password"
                                                    />
                                            </div>
                                            <button type="submit" class="btn btn-primary">
                                                Login
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-0 col-lg-4"></div>
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
        <script src="view/js/login.js"></script>
    </body>
</html>
