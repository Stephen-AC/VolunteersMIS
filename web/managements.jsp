<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/31
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>事务管理</title>
</head>
<style>
    .body{
        font-family: 微软雅黑;
        line-height: 1.5;
        color: black;
        margin-top: 130px;
        text-align: center;
    }
    .put {
        height: 45px;
        border-radius: 3px;
        border: 1px solid #ced4da;
        text-indent: 7px;
        width: 350px;
        font-size: 20px;
        background-color: #007bff;
        color: white;
        font-size: 20px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<div class="body">
    <c:choose>
        <c:when test="${sessionScope.role eq 'administrator'}">
            <br><a href="createActivity.jsp"><input type="button" value="发布活动" class="put"></a><br>
            <br><a href="preVolunteerLists.jsp"><input type="button" value="审核注册志愿者申请名单" class="put" ></a><br>
            <br><a href="reviewSignActivity.jsp"><input type="button" value="审核志愿活动报名表" class="put" ></a><br>
        </c:when>
        <c:otherwise>
            <br><a href="volunteerInfo.jsp"><input type="button" value="修改个人资料" class="put"></a><br>
            <br><a href="volunteerActivitiesList.jsp"><input type="button" value="查看所有志愿活动" class="put" ></a><br>
            <br><a href="signActivityResult.jsp"><input type="button" value="查看报名表审核状态" class="put" ></a><br>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
