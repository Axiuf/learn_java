<%--
  Created by IntelliJ IDEA.
  User: axiuf
  Date: 2021/2/22
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个SpringMVC项目</p>
    <p><a href="test/some.do">发起some.do请求</a></p>
    <p><a href="test/other.do">发起other.do请求</a></p>

    <br>
    <form action="test/some.do" method="get">
        <input type="submit" value="跳转到some页面"/>
    </form>
    <br>
    <form action="test/other.do" method="post">
        <input type="submit" value="跳转到other页面"/>
    </form>

</body>
</html>