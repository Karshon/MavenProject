<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\15 0015
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.xmj.vo.Customer"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">

    <% Customer cus = (Customer)request.getAttribute("Customer");

%>
    <title>Title</title>
</head>
<body >

<div style="position:absolute;top:0px;width:1100px;height:550px;border:5px solid skyblue;">
<form action="updateCusServlet"  method="Post" style="position:absolute;top:50px;left:150px;width:500px;">
    <div style="position:relative;top:10px;left:20px;"><text>账号:</text><input name="cus_account" style="position:relative;left:50px;height:30px;width:250px;border:0px;outline: none;" value="<%=cus.getCus_account()%>" readonly/></div>

    <div  style="position:relative;top:50px;left:20px;"><text>身份证号:</text><input name="cus_id" style="position:relative;left:20px;height:30px;width:250px;border:0px;outline: none;" value="<%=cus.getCus_id()%>"/></div>

    <div  style="position:relative;top:90px;left:20px;"><text>电话:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</text><input class="easyui-textbox"  name="cus_telnumber" style="position:relative;left:50px;height:30px;width:250px;" value="<%=cus.getCus_telnumber()%>"/></div>
    <div  style="position:relative;top:130px;left:20px;"><text>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</text><input class="easyui-textbox"  name="cus_email" style="position:relative;left:50px;height:30px;width:250px;" value="<%=cus.getCus_email()%>"/></div>
    <div  style="position:relative;top:170px;left:20px;"><text>积分:</text><input name="cus_integral" style="position:relative;left:50px;height:30px;width:250px;border:0px;outline: none;" value="<%=cus.getCus_integral()%>" readonly/></div>
    <button type="submit" class="easyui-linkbutton" style="position:absolute;top:350px;left:180px;width:80px;height:30px;" >修改</button>
</form>
</div>
</body>
</html>
