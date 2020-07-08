<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2020/4/21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="css/my.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<html>
<head>
    <title>用户信息展示</title>
</head>
<body>
    <p align="center">
        <a href="toadd?pageCount=${userPages.pages}">添加</a>
    </p>

    <form action="index" method="post" style="text-align: center">
        姓名：（支持模糊查询）<input type="text" name="name" value="${name}">
        <input type="submit" value="查询">
    </form>

    <table border="1" cellspacing="0" cellpadding="0" width="50%" align="center" id="mytable">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>生日</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userPages.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${user.address}</td>
                <td>
                    <a href="delete?id=${user.id}&pageCount=${userPages.pageNum}">删除</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="toupdate?id=${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center">
        <a href="index?pageNow=1&name=${name}">首页</a>
        <a href="index?pageNow=${userPages.prePage}&name=${name}">上一页</a>
        <c:forEach items="${userPages.navigatepageNums}" var="i">
            <a href="index?pageNow=${i}&name=${name}" ${i==userPages.pageNum?"class='nowPage'":""}>[${i}]</a>
        </c:forEach>
        <a href="index?pageNow=${userPages.nextPage}&name=${name}">下一页</a>
        <a href="index?pageNow=${userPages.pages}&name=${name}">尾页</a>
    </p>
</body>
</html>
