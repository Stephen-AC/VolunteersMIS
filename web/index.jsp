<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/14
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="gdut" uri="/myTagLib" %>
<jsp:useBean id="pb" class="edu.gdut.gytw.volunteerMIS.common.PageBean" scope="session" />
<jsp:setProperty name="pb" property="currPage"/>
<html>
    <head>
    <title>管院团委志愿活动管理系统</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div style="height: 2000px;width:80%;background-color: white;margin: 0 auto;margin-top: 70px;text-align: center">
            <div style="width: 100%;box-shadow: 0 0 1px 0px rgba(0,0,0,0.3), 0 0 6px 2px rgba(0,0,0,0.15);">
            <img src=img/activity.jpg style="width: 100%">
            </div><br><br>
            <center>
                <h2>近期活动</h2>
            <div style="text-align: left;width: inherit;border: 1px lightgray solid">
                <table style="display: inline-block;margin: auto 0;font-size: 30px;color: cornflowerblue;font-family: 微软雅黑" align="center">
        <%--          <tr>
                    <td align="right">标题：</td>
                    <td align="right">时间：</td>
                    <td align="right">要求：</td>
                    <td align="right">内容：</td>
                  </tr>--%>
                <c:if test="${!empty activitiesList}">
                  <gdut:page var="activity" list="${activitiesList}" pb="${pb}">
                    <tr>
                      <td>${activity.title}</td>
        <%--              <td>${activity.time}</td>
                      <td>${activity.request}</td>
                      <td>${activity.details}</td>--%>
                      </tr>
                  </gdut:page>
                    <tr>
                        <td>
                            <a href="index.jsp?currPage=0">首页</a>&nbsp;
                            <c:if test="${pb.currPage<2}">
                                <a href="index.jsp?currPage=0"></a>
                            </c:if>
                            <c:choose>
                                <c:when test="${pb.currPage<2}"><a href="index.jsp?currPage=0">上一页</a>&nbsp;</c:when>
                                <c:otherwise><a href="index.jsp?currPage=${pb.currPage-1}">上一页</a>&nbsp;</c:otherwise>
                            </c:choose>
                            <c:forEach begin="0" end="${pb.totalPage-1}" var="x">
                                <a href="index.jsp?currPage=${x}">${x+1}&nbsp;</a>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${pb.currPage>pb.totalPage-1}"><a href="index.jsp?currPage=${pb.totalPage}">下一页</a>&nbsp;</c:when>
                                <c:otherwise><a href="index.jsp?currPage=${pb.currPage+1}">下一页&nbsp;</a></c:otherwise>
                            </c:choose>
                            <a href="index.jsp?currPage=${pb.totalPage-1}">末页</a>
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
                </c:if>
                <c:if test="${empty activitiesList}">
                        <h3>
                            无活动
                        </h3>
                </c:if>

                </table>
          </div>
            </center>
        </div>
    </body>
</html>