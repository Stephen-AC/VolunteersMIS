<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2020/1/8
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .body{
        font-family: 微软雅黑;
        line-height: 1.5;
        color: black;
        margin-top: 130px;
        text-align: center;
    }
</style>
<body>
<%@include file="header.jsp"%>
<div class="body">
    <h2>活动详情</h2>
    <form action="signActivityServlet" method="post">
        <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
            <tr>
                <td align="right">标题：</td>
                <td>${requestScope.volunteerActivity.title}</td>
            </tr>
            <tr>
                <td align="right">时间：</td>
                <td>${requestScope.volunteerActivity.time}</td>
            </tr>
            <tr>
                <td align="right">要求：</td>
                <td>
                    ${requestScope.volunteerActivity.request}
                </td>
            </tr>
            <tr>
                <td align="right">内容：</td>
                <td>${requestScope.volunteerActivity.details}</td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="title" value="${requestScope.volunteerActivity.title}">
                    <input type="hidden" name="time" value="${requestScope.volunteerActivity.time}">
                    <input type="hidden" name="request" value="${requestScope.volunteerActivity.request}">
                    <input type="hidden" name="details" value="${requestScope.volunteerActivity.details}">
                    <input type="submit" value="报名参加活动"/>
                </td>
            </tr>
        </table>
    </form>
    <c:if test="${!empty ifcreate}">
        <c:choose>
            <c:when test="${ifcreate}">
                报名成功
            </c:when>
            <c:otherwise>
                你已经报名，无需重复提交
            </c:otherwise>
        </c:choose>
    </c:if>
</div>
</body>
</html>
