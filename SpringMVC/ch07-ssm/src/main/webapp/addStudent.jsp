<%--
  Created by IntelliJ IDEA.
  User: axiuf
  Date: 2021/2/24
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>注册学生</title>
    <base href="<%=basePath%>" />
</head>
<body>
    <div align="center">
        <form action="student/addStudent.do" method="post">
            <table>
                <tr>
                    <td>学生姓名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>学生年龄：</td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
