<%--
  Created by IntelliJ IDEA.
  User: Damqnov
  Date: 14-4-17
  Time: 13:13
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

<div class="row">
    <!--Information section-->
    <section>
        <div >
            <input id="blackboard-image" class="col-md-7" type="image" src="${pageContext.request.contextPath}/resources/resources/images/blackboard.jpg">
            <article id="information">
                <div class="col-md-10">
                    <h2>Информацията за курсовите задачи и проекти</h2>
                    <p>Трябва да изберете курсова работа и курсов проект в рамките на 01.03.14 - 05.04.2014</p>
                    <h3>За да го направите :</h3>
                    <p>1. Първо трябва да се впишете в системата.<br>
                        2. След това да изберет желания от вас предмет върху който искате да работите. <br>
                        3. Потвъредете изрбанато.
                    </p>
                </div>
            </article>
        </div>
    </section>
    <!--menu-->
    <section>
        <article>
            <div class="buffer-top col-md-4 col-md-offset-1" >
                <div class="row">
                    <div id="login-form-cnt">
                        <form class="form-inline" role="form" id="login-form" method="post">
                            <div class="form-group">
                                <label class="sr-only" for="username">Фак. номер</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Фак. номер">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Парола</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Парола">
                            </div>

                            <button type="submit" class="btn btn-default">Вход</button>
                            <div id="errors-div"></div>
                        </form>
                    </div>
                </div>
                </nav>
            </div>
        </article>
    </section>
    <section id="section">

    </section>
</div>
<script src="${pageContext.request.contextPath}/resources/script/ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/validation.js"></script>
</body>
</html>
