<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2020/4/21
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
    <form action="update" method="post" style="text-align: center">
        <p>
            <input type="hidden" name="id" value="${user.id}">
        </p>
        <p>
            用户名:<input type="text" name="name" value="${user.name}">
        </p>
        <p>
            密码:<input type="text" name="password" value="${user.password}">
        </p>
        <p>

            生日:<input type="date" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>">
        </p>
        <p>
            地址:<input type="text" name="address" value="${user.address}">
        </p>
        <p>
            <input type="submit" value="修改">
        </p>
    </form>
</body>
</html>
