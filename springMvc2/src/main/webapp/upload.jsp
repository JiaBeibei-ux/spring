<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/27
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3>文件上传</h3>
<form action="${pageContext.request.contextPath}/user/index21" method="post" enctype="multipart/form-data">
     文件名：<input type="text" name="filename"><br>
    请选择文件：<input type="file" name="uploadfile"></br>
    <input type="submit" value="OK">
</form>
</body>
</html>
