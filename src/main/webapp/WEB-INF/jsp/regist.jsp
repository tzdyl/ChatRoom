<%--
  Created by IntelliJ IDEA.
  User: ylw
  Date: 2018/5/30
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="${pageContext.request.contextPath }/addUser" >
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userid"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</head>
<body>

</body>
</html>
