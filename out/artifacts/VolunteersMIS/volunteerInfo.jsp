<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2020/1/5
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人资料</title>
</head>
<style>
    .put{
        height: 45px;border-radius: 3px;border: 1px solid #ced4da;text-indent: 7px;width: 250px;
    }
    .body{
        text-align: center;
        font-family: 微软雅黑;
        line-height: 1.5;
        color: black;
        margin-top: 100px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<div class="body">
    <h2>个人信息</h2>
    <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">
        基本信息
    </div>
    <form action="saveVolunteerInfoServlet" method="post">
        <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
            <tr>
                <td align="right">学号：</td>
                <td>${requestScope.volunteer.sno}</td>
                <td align="right">姓名：</td>
                <td>${requestScope.volunteer.name}</td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td>${requestScope.volunteer.sex}</td>
                <td align="right">年级：</td>
                <td>${requestScope.volunteer.grade}</td>
            </tr>
            <tr>
                <td align="right">专业：</td>
                <td><input name="major" type="text" class="put" value="${requestScope.volunteer.major}"></td>
                <td align="right">学院：</td>
                <td><input name="semester" type="text" class="put" value="${requestScope.volunteer.semester}"></td>
            </tr>
            <tr>
                <td align="right">电话：</td>
                <td><input name="phone" type="text" class="put" value="${requestScope.volunteer.phone}"></td>
            </tr>
        </table>
        <div><br><br><br></div>
        <div style="text-align: center;width: 640px;border: 1px lightgray solid;margin: 0 auto;font-size: 25px;border-radius: 5px">详细信息</div>
        <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
            <tr>
                <td align="right" colspan="1">籍贯：</td>
                <td colspan="1"><input name="native_place" type="text" class="put" value="${requestScope.volunteer.native_place}"></td>
                <td align="right" colspan="1">宿舍：</td>
                <td colspan="1"><input name="drom" type="text" class="put" value="${requestScope.volunteer.drom}"></td>
            </tr>
            <tr>
                <td align="right" colspan="1">微信：</td>
                <td colspan="1"><input name="wechat" type="text" class="put" value="${requestScope.volunteer.wechat}"></td>
                <td align="right" colspan="1">QQ：</td>
                <td colspan="1"><input name="qq" type="text" class="put" value="${requestScope.volunteer.qq}"></td>
            </tr>
            <tr>
                <td align="right" colspan="1">方言：</td>
                <td colspan="3"><textarea name="dialect" type="text" class="put" style="width: 550px;height: 45px">${requestScope.volunteer.dialect}</textarea></td>
            </tr>
            <tr>
                <td align="right" colspan="1">性格：</td>
                <td colspan="3"><textarea name="speciality" type="text" class="put" style="width: 550px;height: 45px">${requestScope.volunteer.character}</textarea></td>
            </tr>
            <tr>
                <td align="right" colspan="1">特长：</td>
                <td colspan="3"><textarea name="character" type="text" class="put" style="width: 550px;height: 45px">${requestScope.volunteer.speciality}</textarea></td>
            </tr>
            <tr>
                <td align="right" colspan="1">在校经历：</td>
                <td colspan="3"><textarea name="experience" type="text" class="put" style="width: 550px;height: 250px">${requestScope.volunteer.experience}</textarea></td>
            </tr>
            <tr>
                <td align="right" colspan="1">志愿经历：</td>
                <td colspan="3"><textarea name="vol_experience" type="text" class="put" style="width: 550px;height: 250px">${requestScope.volunteer.volExperience}</textarea></td>
            </tr>
            <tr>
                <td align="right" colspan="1">其他：</td>
                <td colspan="3"><textarea name="others" type="text" class="put" style="width: 550px;height: 250px">${requestScope.volunteer.others}</textarea></td>
            </tr>
            <c:if test="${sessionScope.role eq 'volunteer'}">
                <tr>
                    <td colspan="4" align="center"><input type="submit" value="保存"><c:if test="${!empty ifsave}"><span style="color: steelblue">提交成功！</span></c:if></td>
                </tr>
            </c:if>
            <c:if test="${sessionScope.role eq 'administrator'}">
                <tr>
                    <td colspan="4" align="center"><input type="button" value="返回" onclick="javascript :history.go(-1)"></td>
                </tr>
            </c:if>
        </table>
    </form>
</div>
</body>
</html>
