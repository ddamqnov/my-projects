<%--
  Created by IntelliJ IDEA.
  User: Damqnov
  Date: 14-4-28
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/resources/lib/jquery-2.1.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/jquery.validate.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/lib/bootstrap.js"></script>
</head>
<body>
<div id="title"  >
    <h2 class="text-success">Статистика</h2>
</div>
<div class="row">
    <div class="col-md-12">
        <form class="navbar-form navbar-left" id="main-nav">
            <div class="row">
                <div class="col-md-12" id="cnt">
                    <label for="get-spec-field">Изберете специалност: </label>
                    <select id="get-spec-field" name="get-fac-field" class="form-control">  </select>

                    <label for="get-course-field">Изберете курс: </label>
                    <select id="get-course-field" name="get-course-field" class="form-control"></select>

                    <label for="get-subject-field">Изберете предмет:</label>
                    <select id="get-subject-field" name="get-subject-field" class="form-control"></select>

                    <label for="get-type-field">Вид:</label>
                    <select id="get-type-field" name="get-type-field" class="form-control"></select>
                </div>

                <div class="col-md-1" id="submit-btn">  </div>
            </div>
        </form>
    </div>
</div>

<hr>
<div id="table-cnt"></div>
<script src="${pageContext.request.contextPath}/resources/script/statistic.js"></script>
</body>
</html>
