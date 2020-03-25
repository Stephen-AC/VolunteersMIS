<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2020/1/9
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="gdut" uri="/myTagLib" %>
<html>
<head>
    <title>查看活动报名表审核状态</title>
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
    <center>
    <table>
        <tr>
            <td align="center" style="font-weight: bold;font-size: 35px">活动名</td>
            <td align="center" style="font-weight: bold;font-size: 35px">审核状态</td>
        </tr>
        <c:forEach items="${requestScope.signActivityResults}" begin="0" end="${fn:length(requestScope.signActivityResults)}" var="signActivity">
            <tr>
                <td>
                    <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                        ${signActivity.title}
                    </div>
                </td>
                <td>
                    <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                            ${signActivity.result}
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    </center>
    <p><a href="#" onClick="javascript :history.go(-1)"></a></p>
</div>
</body>
</html>
