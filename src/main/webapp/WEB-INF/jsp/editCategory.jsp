<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2020/1/8
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin: 0px auto; width:500px">
    <form action="updateCategory" method="post">
        name:<input name="name" value="${category.name}"><br>
        <input name="id" type="hidden" value="${category.id}">
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
