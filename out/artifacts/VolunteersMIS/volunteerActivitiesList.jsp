<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2020/1/8
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="gdut" uri="/myTagLib" %>
<jsp:setProperty name="pb" property="currPage"/>
<html>
<head>
    <title>查看可报名自愿活动</title>
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
    <table style="display: inline-block;margin: auto 0;font-size: 30px;color: cornflowerblue;font-family: 微软雅黑" align="center">
        <gdut:page var="activity" list="${sessionScope.activitiesList}" pb="${pb}">
            <tr>
                <td><a href="volunteerActivity.jsp?title=${activity.title}">${activity.title}</a></td>
            </tr>
        </gdut:page>
        <tr>
          <td>
            <a href="volunteerActivitiesList.jsp?currPage=0">首页</a>&nbsp;
            <c:if test="${pb.currPage<2}">
              <a href="volunteerActivitiesList.jsp?currPage=0"></a>
            </c:if>
            <c:choose>
              <c:when test="${pb.currPage<2}"><a href="volunteerActivitiesList.jsp?currPage=0">上一页</a>&nbsp;</c:when>
              <c:otherwise><a href="volunteerActivitiesList.jsp?currPage=${pb.currPage-1}">上一页</a>&nbsp;</c:otherwise>
            </c:choose>
            <c:forEach begin="0" end="${pb.totalPage-1}" var="x">
              <a href="volunteerActivitiesList.jsp?currPage=${x}">${x+1}&nbsp;</a>
            </c:forEach>
            <c:choose>
              <c:when test="${pb.currPage>pb.totalPage-1}"><a href="volunteerActivitiesList.jsp?currPage=${pb.totalPage}">下一页</a>&nbsp;</c:when>
              <c:otherwise><a href="volunteerActivitiesList.jsp?currPage=${pb.currPage+1}">下一页&nbsp;</a></c:otherwise>
            </c:choose>
            <a href="volunteerActivitiesList.jsp?currPage=${pb.totalPage-1}">末页</a>
          </td>
        </tr>
        <c:forEach items="${list}" var="activity" begin="0" end="${fn:length(list)}" >
          <tr>
            <td align="right">${activity.title}</td>
            <td align="right">${activity.time}</td>
            <td align="right">${activity.request}</td>
            <td align="right">${activity.details}</td>
          </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
