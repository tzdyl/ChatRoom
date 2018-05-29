<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wanda
  Date: 2018/5/25
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登陆成功，首页</h1>

<h2>欢迎您，${existUser.nickname}!</h2>

<form id="logout-form" action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" id="logout" name="logout" value="注销">
</form>
<form id="info-form" action="${pageContext.request.contextPath}/user/${existUser.userid}/information" method="post">
    <%--<input type="hidden" id="userid" name="userid" value="${existUser}.userid">--%>
    <input type="submit" id="infomation" name="infomation" value="显示个人信息">
</form>
<form id="chat-form" action="${pageContext.request.contextPath}/user/${existUser.userid}/chatPage" method="post">
    <%--<input type="hidden" id="userid" name="userid" value="${existUser}.userid">--%>
    <input type="submit" id="chat" name="chat" value="进入聊天室">
</form>

</body>
</html>
