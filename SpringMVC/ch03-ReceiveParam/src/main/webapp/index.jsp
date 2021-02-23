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

    <p>提交参数给Controller</p>

    <form action="ReceiveProperty.do" method="post">
        姓名：<input type="text" name="name"> <br />
        年龄：<input type="text" name="age"> <br />
        <input type="submit" value="提交参数">
    </form>

    <br />
    <h3>使用对象接收参数</h3>
    <form action="ReceiveObject.do" method="post">
        姓名：<input type="text" name="name"> <br />
        年龄：<input type="text" name="age"> <br />
        <input type="submit" value="提交参数">
    </form>

</body>
</html>