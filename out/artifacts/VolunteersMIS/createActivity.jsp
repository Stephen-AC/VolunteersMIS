<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/16
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .body{
        font-family: 微软雅黑;
        line-height: 1.5;
        color: black;
        margin-top: 130px;
        text-align: center;
    }
    .put{
        height: 45px;border-radius: 3px;border: 1px solid #ced4da;text-indent: 7px;width: 350px;font-size: 20px;
    }
</style>
<head>
    <title>发布志愿活动</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <div class="body">
        <h1>发布志愿者招募文章</h1>
        <c:choose>
            <c:when test="${empty ifcreate}">
                <form action="ActivitesServlet" method="post">
                    <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                        <tr>
                            <td align="right">标题：</td>
                            <td><input name="title" class="put"></td>
                        </tr>
                        <tr>
                            <td align="right">时间：</td>
                            <td><input name="time" class="put"></td>
                        </tr>
                        <tr>
                            <td align="right">要求：</td>
                            <td>
                                <textarea name="request" class="put" style="height: 150px"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">内容：</td>
                            <td><textarea name="details" class="put" style="height: 150px"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input class="put" type="submit" value="提交" style="width: 50px;text-indent: unset"/>&nbsp;&nbsp;&nbsp;<input class="put" type="reset" value="重置" style="width: 50px;text-indent: unset"/></td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:otherwise>
                <h2>添加结果如下</h2>
                <table style="display: inline-block;margin: auto 0;font-size: 20px;font-family: 微软雅黑" align="center">
                    <tr>
                        <td align="right">标题：</td>
                        <td>${activity.title}</td>
                    </tr>
                    <tr>
                        <td align="right">时间：</td>
                        <td>${activity.time}</td>
                    </tr>
                    <tr>
                        <td align="right">要求：</td>
                        <td>${activity.request}</td>
                    </tr>
                    <tr>
                        <td align="right">内容：</td>
                        <td>${activity.details}</td>
                    </tr>
                </table>
                    <div>
                        <a href="createActivity.jsp"><input type="button" value="继续创建活动" class="put"></a>
                        <a href="managements.jsp"><input type="button" value="返回事务管理" class="put"></a>
                    </div>
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>