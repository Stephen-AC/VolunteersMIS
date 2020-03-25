<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/31
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="preVolunteer" class="edu.gdut.gytw.volunteerMIS.entity.PreVolunteer" scope="request"></jsp:useBean>
<html>
<head>
    <title>注册成为注册志愿者</title>
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
    <div style="height: 2000px;width:80%;background-color: white;margin: 0 auto;margin-top: 70px;text-align: center">
        <c:choose>
            <c:when test="${empty requestScope.ifcreate}">
            <h1>注册志愿者申请表</h1>
            <form action="CreatePreVolunteerServlet" method="post">
                <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                    基本信息
                </div>
                <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                    <tr>
                        <td align="right">学号：</td>
                        <td><input name="sno" class="put"></td>
                        <td align="right">姓名：</td>
                        <td><input name="name" class="put"></td>
                    </tr>
                    <tr>
                        <td align="right">性别：</td>
                        <td>
                            <select name="sex" class="put">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </td>
                        <td align="right">年级：</td>
                        <td>
                            <select name="grade" class="put">
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">专业：</td>
                        <td><input name="major" class="put"></td>
                        <td align="right">学院：</td>
                        <td><input name="semester" class="put"></td>
                    </tr>
                    <tr>
                        <td align="right">电话：</td>
                        <td><input name="phone" class="put"></td>
                    </tr>
                </table>
                <div><br><br><br></div>
                <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">详细信息</div>
                <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                    <tr>
                        <td align="right" colspan="2">方言：</td>
                        <td colspan="2"><input name="dialect" class="put" style="width: 533px"></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">特长：</td>
                        <td colspan="2"><textarea name="speciality" class="put" style="width: 533px; height: 161px"></textarea></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">加入原因</td>
                        <td colspan="2"><textarea name="reason" class="put" style="width: 533px; height: 161px"></textarea></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">在校经历</td>
                        <td colspan="2"><textarea name="experience" class="put" style="width: 533px; height: 161px"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center"><input class="put" type="submit" value="提交" style="width: 50px;text-indent: unset"/>&nbsp;&nbsp;&nbsp;<input class="put" type="reset" value="重置" style="width: 50px;text-indent: unset"/></td>
                    </tr>
                </table>
            </form>
            </c:when>
            <c:otherwise>
                <h2>提交结果如下</h2>
                <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
                    基本信息
                </div>
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
                        <td colspan="4" align="center"><a href="index.jsp"><input class="put" type="button" value="返回首页" style="width: 50px;text-indent: unset"/></a></td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
