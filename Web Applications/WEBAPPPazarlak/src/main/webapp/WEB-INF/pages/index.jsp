<%--
  Created by IntelliJ IDEA.
  User: Damqnov
  Date: 14-3-26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пазарлък</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--Importing css files with styles--%>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
    <%--Importing javascript files--%>
    <script src="${pageContext.request.contextPath}/resources/lib/jquery-2.1.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/jquery.validate.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/lib/bootstrap.js"></script>
    <script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/sha1.js"></script>

</head>
<body>
<header  class="navbar navbar-default bottom-buffer ">
    <div class="row ">
        <div class="col-md-offset-2 col-md-2 ">
            <section>
                <!--<input type="image" alt="logo-image">-->
                <div><h2>Пазарлък.com</h2></div>

            </section>
        </div>
        <div class="col-md-2 col-md-offset-5" id="main-nav-container" >
            <nav>
                <section>
                    <ul class="nav nav-pills" id="nav-login">
                        <li class="active dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Вход <span class="caret"></span> </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <form class="form-horizontal" role="form" id="login-form">
                                        <div class="form-group">
                                            <div class="col-sm-10 col-sm-offset-1 input-group">
                                                <span class="input-group-addon">@</span>
                                                <input type="email" class="form-control" id="login-email" placeholder="Имейл" name="mail">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10 col-sm-offset-1 input-group">
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-lock"></span>
                                                </span>

                                                <input type="password" class="form-control" id="login-password" placeholder="Парола" name="password">
                                            </div>
                                        </div>
                                        <div id="errorsDiv"></div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox"> Запомни ме
                                                    </label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-10">
                                                <button type="submit" class="btn btn-default btn-md">Вход</button>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </li>
                        <li class="active" id="regButton">
                            <a  href="#">Регистрация</a>
                        </li>
                    </ul>
                </section>
                <section>
                    <!-- User navigation -->
                </section>
            </nav>

        </div>
    </div>
    <section>
        <!-- Search bar -->
        <div class="row">
            <div class="col-md-2 col-md-offset-2">
                <a href="#" class="btn btn-info btn-lg" id="add-ad-btn">Добави обява</a>
            </div>
            <div class="input-group col-md-5 col-md-offset-3 input-group-lg" >
                <input type="text" class="form-control">
                <span class="input-group-addon">
                    <a href="#">
                        <span class="glyphicon glyphicon-search"></span>
                    </a>
                </span>
            </div>
        </div>
    </section>
</header>
<div class="row top-buffer">
    <aside>
        <div class="col-md-2 col-md-offset-2 ">
            <nav>
                <div class="list-group" id="asideNav"></div>
            </nav>
        </div>
    </aside>

    <div class="col-sm-offset-0 col-md-5 " id="container" >
        <article id="mainArticle">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/resources/resources/images/2.jpg" alt="picture 200x300">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/resources/images/3.jpg" alt="picture 200x300">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/resources/images/1.jpg" alt="picture 200x300">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>

        </article>
    </div>

</div>
<footer>
    <div class="col-md-offset-5">
        <h5>Pazarlak.bg - all rights reserved </h5>
    </div>

</footer>
<script>var ctx = "<%=request.getContextPath()%>"</script>
<script src="${pageContext.request.contextPath}/resources/script/ui.controller.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/login.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/advertisements.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/registration.js"></script>
</body>
</html>