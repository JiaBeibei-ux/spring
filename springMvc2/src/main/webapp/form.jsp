<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/26
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>springmvc封装值对象</h3>
<form action="${pageContext.request.contextPath}/user/index13">
姓名：<input type="text" name="userList[0].name"></br>
年龄：<input type="text" name="userList[0].age"></br>
姓名：<input type="text" name="userList[1].name"></br>
年龄：<input type="text" name="userList[1].age"></br>
    <input type="submit" value="OK">
</form>
</body>
</html>
