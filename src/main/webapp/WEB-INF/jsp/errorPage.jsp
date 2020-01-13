<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2020/1/7
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div
        style="width: 500px;border:1px solid lightgray;margin: 200px auto;padding: 80px">
    系统出现了异常，异常原因是：
    ${exception}
    <br><br>
    出现异常的地址是:
    ${url}
</div>
</body>
</html>
