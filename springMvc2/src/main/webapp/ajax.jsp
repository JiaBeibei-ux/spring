<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/26
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList[0]={name:'Jack',age:10};
        userList[1]={name:'Rose',age:20};
        console.log(userList);
        $.ajax({
            /*/springMVc  localhost:8080/springMVc*/
            url:'${pageContext.request.contextPath}/user/index14',
            type:'post',
            data:JSON.stringify(userList),
            contentType:'application/json;charset:utf-8'
        });
    </script>
</head>
<body>

</body>
</html>
