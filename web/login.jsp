<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/15
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录账号</title>
</head>
<style>
    .body{
        text-align: center;
        font-family: 微软雅黑;
        line-height: 1.5;
        color: black;
        margin-top: 100px;
    }
    label{
        display: block;
    }
    .put{
        height: 45px;border-radius: 3px;border: 1px solid #ced4da;text-indent: 7px;width: 250px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<div class="body">
    <form action="loginServlet" method="post">
        <img src=img/logo.png>
        <h2>请登录</h2>
        <label><input type="text" placeholder="账号" class="put" name="account"/></label>
        <label><input type="password" placeholder="密码" class="put" size="30" name="password"/></label>
        <select name="role" class="put" >
            <option value="administrator">管理员</option>
            <option value="volunteer">志愿者</option>
        </select>
        <c:if test="${!empty check}">
            <p style="color: red">账号或密码有错，请从新输入</p>
        </c:if>
        <div>
            <br><input type="submit" value="提交" class="put" style="background-color: #007bff;color: white;font-size: 20px;">
        </div>
    </form>
</div>
</body>
</html>
