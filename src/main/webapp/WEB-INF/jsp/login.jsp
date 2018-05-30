<%--
  Created by IntelliJ IDEA.
  User: wanda
  Date: 2018/5/26
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form id="login-form" action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" id="username" name="userid" placeholder="请输入账号">
        <input type="password" id="password" name="password" placeholder="请输入密码">
        <input type="submit" id="submit" value="登录"><font color="red">${error}${message}</font>
    </form>
    <br/>
<a href="${pageContext.request.contextPath}/regist">注册</a>
</body>
</html>
