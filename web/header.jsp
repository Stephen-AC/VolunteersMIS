<%--
  Created by IntelliJ IDEA.
  User: BuTTer
  Date: 2019/12/15
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    div,body{
        margin: 0;
        border: 0;
    }
    .header{
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 70px;
        background-color: white;
        box-shadow: 0 0 1px 0px rgba(0,0,0,0.3), 0 0 6px 2px rgba(0,0,0,0.15);
    }
    ul{
        list-style: none;
        margin: 0;
    }
    a{
        text-decoration: none;
        color: black;
    }
    .login{
        font-size: 20px;
    }
</style>
<div class="header">
    <div style="display: block;position: relative;margin: 0 auto;height: 70px;width: 80%">

        <div style="display: inline-block;height: 70px;width: 70px;margin-left: 20px">
            <a href="index.jsp" style="display: block;height: 70px;"><img src=img/logo.png height="60px" width="60px" style="margin-top: 5px;margin-left: 5px"></a>
        </div>
        <div style="display: inline-block;height: 70px;width: 500px;text-align: left;line-height: 70px;position: absolute">
            <a href="index.jsp" style="display: block;height: 70px;"><span style="font-family: 黑体;font-size: 40px;font-weight: bold">管院团委志愿者管理系统</span></a>
        </div>
        <div style="display: inline-block;height: 70px;float: right;position: relative;text-align: center;line-height: 70px;margin-right: 10px;">
            <c:choose>
                <c:when test="${empty sessionScope.account}">
                    <ul>
                        <li style="float: left">
                            <a class="login" href="login.jsp">登录</a>
                            <span class="login">/</span>
                            <a class="login" href="register.jsp">注册</a>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul>
                        <li style="float: left">
                            <span class="login">欢迎${sessionScope.account}
                                <c:if test="${sessionScope.role eq 'administrator'}">
                                    <c:out value="管理员"></c:out>
                                </c:if>
                                <c:if test="${sessionScope.role eq 'volunteer'}">
                                    <c:out value="志愿者"></c:out>
                                </c:if>
                            </span>
                            <span class="login">/</span>
                            <a class="login" href="SignoutServlet">退出登录</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
        <c:choose>
            <c:when test="${empty role}">
                <div style="display: inline-block;height: 70px;float: right;position: relative;text-align: center;line-height: 70px;margin-right: 10px;">
                    <ul>
                        <li style="float: left">
                            <a href="login.jsp" style="font-size: 20px">事务管理</a>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <div style="display: inline-block;height: 70px;float: right;position: relative;text-align: center;line-height: 70px;margin-right: 10px;">
                    <ul>
                        <li style="float: left">
                            <a href="managements.jsp">事务管理</a>
                        </li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
