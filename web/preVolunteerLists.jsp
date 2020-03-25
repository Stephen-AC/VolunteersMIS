<%@ taglib prefix="gdut" uri="/myTagLib" %>
<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/31
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pb" class="edu.gdut.gytw.volunteerMIS.common.PageBean" scope="session" />
<jsp:setProperty name="pb" property="currPage"/>
<html>
<head>
    <title>审核注册志愿者报名表</title>
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
        <h2>注册志愿者报名列表</h2>
        <table style="display: inline-block;margin: auto 0;font-size: 30px;color: cornflowerblue;font-family: 微软雅黑" align="center">
            <gdut:page var="preVolunteer" list="${preVolunteerList}" pb="${pb}">
                <tr>
                    <td><a href="preVolunteer.jsp?sno=${preVolunteer.sno}">${preVolunteer.sno}</a></td>
                </tr>
            </gdut:page>
            <tr>
              <td>
                <a href="preVolunteerLists.jsp?currPage=0">首页</a>&nbsp;
                <c:if test="${pb.currPage<2}">
                  <a href="preVolunteerLists.jsp?currPage=0"></a>
                </c:if>
                <c:choose>
                  <c:when test="${pb.currPage<2}"><a href="preVolunteerLists.jsp?currPage=0">上一页</a>&nbsp;</c:when>
                  <c:otherwise><a href="preVolunteerLists.jsp?currPage=${pb.currPage-1}">上一页</a>&nbsp;</c:otherwise>
                </c:choose>
                <c:forEach begin="0" end="${pb.totalPage-1}" var="x">
                  <a href="preVolunteerLists.jsp?currPage=${x}">${x+1}&nbsp;</a>
                </c:forEach>
                <c:choose>
                  <c:when test="${pb.currPage>pb.totalPage-1}"><a href="preVolunteerLists.jsp?currPage=${pb.totalPage}">下一页</a>&nbsp;</c:when>
                  <c:otherwise><a href="preVolunteerLists.jsp?currPage=${pb.currPage+1}">下一页&nbsp;</a></c:otherwise>
                </c:choose>
                <a href="preVolunteerLists.jsp?currPage=${pb.totalPage-1}">末页</a>
              </td>
            </tr>
        </table>
    </div>
</body>
</html>
