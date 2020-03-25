<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2020/1/8
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="gdut" uri="/myTagLib" %>
<html>
<head>
    <title>审核报名活动</title>
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
    <c:choose>
        <c:when test="${!empty requestScope.SignActivityMap}">
            <c:forEach items="${requestScope.SignActivityMap}" begin="0" end="${fn:length(requestScope.SignActivityMap)}" var="signActivity">
                <center>
                    <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                            ${signActivity.key}
                    </div>
                    <table>
                        <tr>
                            <td>学号</td>
                            <td>姓名</td>
                            <td>性格</td>
                            <td>方言</td>
                        </tr>
                        <c:forEach items="${signActivity.value}" begin="0" end="${fn:length(signActivity.value)}" var="sno">
                            <gdut:volunteerInfo sno="${sno}" var="volunteer">
                                <tr>
                                    <td>${volunteer.sno}</td>
                                    <td>${volunteer.name}</td>
                                    <td>${volunteer.character}</td>
                                    <td>${volunteer.dialect}</td>
                                    <td><a href="volunteerInfo.jsp?sno=${volunteer.sno}">更多信息</a></td>
                                    <td>
                                        <form method="post" action="reviewSignActivityServlet" style="display: inline">
                                            <input type="hidden" name="sno" value="${volunteer.sno}">
                                            <input type="hidden" name="title" value="${signActivity.key}">
                                            <input type="hidden" name="result" value="通过">
                                            <input name="pass" type="submit" value="通过">
                                        </form>
                                        <form method="post" action="reviewSignActivityServlet" style="display: inline">
                                            <input type="hidden" name="sno" value="${volunteer.sno}">
                                            <input type="hidden" name="title" value="${signActivity.key}">
                                            <input type="hidden" name="result" value="不通过">
                                            <input type="submit" value="不通过">
                                        </form>
                                    </td>
                                </tr>
                            </gdut:volunteerInfo>
                        </c:forEach>
                    </table>
                </center>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h2>尚无待审核活动报名表</h2>
            <br><a href="reviewSignActivityHistory.jsp"><input type="submit" value="查看历史审核记录" class="put" ></a><br>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
