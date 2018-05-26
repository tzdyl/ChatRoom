<%--
  Created by IntelliJ IDEA.
  User: wanda
  Date: 2018/5/26
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>

<div class="admin-content">
    <h1 style="align-content: center">个人信息</h1>
    <div class="am-tabs am-margin" data-am-tabs>
        <div class="am-tabs-bd">
            <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                <div class="am-g">
                    <c:set value="${existUser}" var="user"/>
                    <div class="am-u-md-3"><b>昵称:</b></div>
                    <div class="am-u-md-3">
                        ${user.nickname}
                    </div>
                    <div class="am-u-md-6" style="float: right">
                        <img class="am-circle" src="${pageContext.request.contextPath}/${user.profilehead}" width="140" height="140" alt="${user.nickname}"/>
                    </div>

                    <div class="am-u-md-3"><b>性别:</b></div>
                    <div class="am-u-md-3">
                        <c:if test="${user.sex == null ||user.sex == ''}">未知</c:if>
                        <c:if test="${user.sex == 1}">男</c:if>
                        <c:if test="${user.sex == 0}">女</c:if>
                        <c:if test="${user.sex == -1}">保密</c:if>
                    </div>
                    <div class="am-u-md-3"><b>年龄:</b></div>
                    <div class="am-u-md-3">
                        <c:if test="${user.age == null || user.age == ''}">未知</c:if>
                        <c:if test="${user.age != null && user.age != ''}">${user.age}</c:if>
                    </div>
                    <div class="am-u-md-3"><b>简介:</b></div>
                    <div class="am-u-md-3">
                        <c:if test="${user.profile == null || user.profile == ''}">
                            这个人很懒,什么都没有留下!
                        </c:if>
                        <c:if test="${user.profile != null && user.profile != ''}">
                            ${user.profile}
                        </c:if>
                    </div>
                    <div class="am-u-md-3"><b>注册时间</b></div>
                    <div class="am-u-md-3">${user.firsttime}</div>
                    <div class="am-u-md-3"><b>最后登录</b></div>
                    <div class="am-u-md-3">${user.lasttime}</div>
                </div>
            </div>
        </div>
    </div>
</div>

<form id="info-setting" action="${pageContext.request.contextPath}/user/${existUser.userid}/editPage" method="post">
    <%--<input type="hidden" id="userid" name="userid" value="${existUser}.userid">--%>
    <input type="submit" id="infosetting" name="infosetting" value="修改个人信息">
</form>

</body>
</html>
