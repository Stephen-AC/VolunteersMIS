<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/31
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="gdut" uri="/myTagLib" %>
<html>
<head>
    <title>${preVolunteer.name}申请表</title>
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
<script>
    function method1(){
        var arr = document.getElementsByName("result");
        arr[0].value="pass";
        document.method.submit();
    }
    function method2(){
        var arr = document.getElementsByName("result");
        arr[0].value="reject";
        document.method.submit();
    }
</script>
<body>
<%@include file="header.jsp"%>
<div class="body">
    <h2>${requestScope.preVolunteer.name}注册志愿者申请表</h2>

    <c:choose>
        <c:when test="${!empty requestScope.sno}">
            <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                基本信息
            </div>
            <gdut:volunteerInfo sno="${requestScope.sno}" var="preVolunteer">
                <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                    <tr>
                        <td align="right">学号：</td>
                        <td>${preVolunteer.sno}</td>
                        <td align="right">姓名：</td>
                        <td>${preVolunteer.name}</td>
                    </tr>
                    <tr>
                        <td align="right">性别：</td>
                        <td>${preVolunteer.sex}</td>
                        <td align="right">年级：</td>
                        <td>${preVolunteer.grade}</td>
                    </tr>
                    <tr>
                        <td align="right">专业：</td>
                        <td>${preVolunteer.major}</td>
                        <td align="right">学院：</td>
                        <td>${preVolunteer.semester}</td>
                    </tr>
                    <tr>
                        <td align="right">电话：</td>
                        <td>${preVolunteer.phone}</td>
                    </tr>
                </table>
                <div><br><br><br></div>
                <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">详细信息</div>
                <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                    <tr>
                        <td align="right" colspan="2">方言：</td>
                        <td colspan="2">${preVolunteer.dialect}</td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">特长：</td>
                        <td colspan="2">${preVolunteer.speciality}</td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">在校经历</td>
                        <td colspan="2">${preVolunteer.experience}</td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="hidden" name="result" value=""/>
                            <input type="button" value="通过" onclick="method1()" />
                            <c:choose>
                                <c:when test="${empty requestScope.passSuccess}">&nbsp;&nbsp;&nbsp;</c:when>
                                <c:otherwise>提交成功</c:otherwise>
                            </c:choose>
                            <input type="button" value="拒绝通过" onclick="method2()" />
                            <c:choose>
                                <c:when test="${empty requestScope.rejectSuccess}"></c:when>
                                <c:otherwise>提交成功</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </gdut:volunteerInfo>
        </c:when>
        <c:otherwise>
            <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                待注册志愿者基本信息
            </div>
            <form action="reviewPreVolunteerServlet" method="post" name="method">
                <input name="sno" value="${param.sno}" type="hidden">
                <gdut:preVolunteer sno="${param.sno}" var="preVolunteer">
                    <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                        <tr>
                            <td align="right">学号：</td>
                            <td>${preVolunteer.sno}</td>
                            <td align="right">姓名：</td>
                            <td>${preVolunteer.name}</td>
                        </tr>
                        <tr>
                            <td align="right">性别：</td>
                            <td>${preVolunteer.sex}</td>
                            <td align="right">年级：</td>
                            <td>${preVolunteer.grade}</td>
                        </tr>
                        <tr>
                            <td align="right">专业：</td>
                            <td>${preVolunteer.major}</td>
                            <td align="right">学院：</td>
                            <td>${preVolunteer.semester}</td>
                        </tr>
                        <tr>
                            <td align="right">电话：</td>
                            <td>${preVolunteer.phone}</td>
                        </tr>
                    </table>
                    <div><br><br><br></div>
                    <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">详细信息</div>
                    <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                        <tr>
                            <td align="right" colspan="2">方言：</td>
                            <td colspan="2">${preVolunteer.dialect}</td>
                        </tr>
                        <tr>
                            <td align="right" colspan="2">特长：</td>
                            <td colspan="2">${preVolunteer.speciality}</td>
                        </tr>
                        <tr>
                            <td align="right" colspan="2">加入原因</td>
                            <td colspan="2">${preVolunteer.reason}</td>
                        </tr>
                        <tr>
                            <td align="right" colspan="2">在校经历</td>
                            <td colspan="2">${preVolunteer.experience}</td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <input type="hidden" name="result" value=""/>
                                <input type="button" value="通过" onclick="method1()" />
                                <c:choose>
                                    <c:when test="${empty requestScope.passSuccess}">&nbsp;&nbsp;&nbsp;</c:when>
                                    <c:otherwise>提交成功</c:otherwise>
                                </c:choose>
                                <input type="button" value="拒绝通过" onclick="method2()" />
                                <c:choose>
                                    <c:when test="${empty requestScope.rejectSuccess}"></c:when>
                                    <c:otherwise>提交成功</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </gdut:preVolunteer>
            </form>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
