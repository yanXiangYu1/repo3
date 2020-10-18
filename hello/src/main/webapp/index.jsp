
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello maven!!!!
<form action="${pageContext.request.contextPath}/addUser" method="get">
    用户名:<input type="text" name="username" size="30">
    密码:<input type="password" name="password" size="30">
    <input type="submit" name="注册">
</form>
</body>
</html>
