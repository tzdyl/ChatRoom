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

<table>
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>密码</td>
    </tr>
    <c:forEach items="${adminList}" var="s">
    <tr>
        <td>${s.id}</td>
        <td>${s.username}</td>
        <td>${s.password}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
