<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2020/4/21
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
    <style type="text/css">
        label.error{
            color: red;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/messages_zh.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#myform").validate({
                rules:{
                    name:{
                        required:true,
                        rangelength:[2,6]
                    },
                    password:{
                        required:true,
                        rangelength:[3,10]
                    },
                    birthday:{
                        required:true
                    },
                    address:{
                        required:true
                    }
                },
                messages:{
                    name:{
                        required:"用户名必须填写",
                        rangelength:"用户名长度介于6到10之间"
                    },
                    password:{
                        required:"密码必须填写",
                        rangelength:"密码长度介于3到10之间"
                    },
                    birthday:{
                        required:"生日必须填写"
                    },
                    address:{
                        required:"地址必须填写"
                    }
                }
            });
        });
    </script>
</head>
<body>
    <form action="add" method="post" style="text-align: center" id="myform">
        <p>
            <input type="hidden" name="pageCount" value="${pageCount}">
        </p>
        <p>
            用户名:<input type="text" name="name">
        </p>
        <p>
            密码:<input type="text" name="password">
        </p>
        <p>
            生日:<input type="date" name="birthday">
        </p>
        <p>
            地址:<input type="text" name="address">
        </p>
        <p>
            <input type="submit" value="注册">
        </p>
    </form>
</body>
</html>
