<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\24 0024
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">

    <title>泛美航空后台管理</title>
</head>
<body background="imag/timg.jpg" background-size="contain;">
<div style="position:absolute;top:30px;left:800px;"> <h1> 欢迎您进入泛美航空的后台管理系统！</h1></div>
      <%
            String message = (String)request.getAttribute("message");
            if(message!=null){
                %>
      <div><%=message%></div>
      <%
            }
      %>
      <div style="position:absolute;top:30px;left:40px;">
            <div class="easyui-panel" title="管理员登录" style="width:380px;height:380px;">
                     <form action="admin_LoginServlet"  method="post" style="height:300px;width:300px;border:0px solid white;">
                             <div style="position:relative;top:50px;left:40px;"><input name="username" class="easyui-textbox" style="height:30px;width:250px;" prompt= "请输入用户名" /></div>

                             <div  style="position:relative;top:80px;left:40px;"><input name="password" class="easyui-passwordbox" style="height:30px;width:250px;" prompt= "请输入密码"/></div>
                             <div style="position:relative;top:150px;left:120px;width:70px;">
                                     <button id="login_bt" type="submit" background="black" class="easyui-linkbutton" style="width:80px;" >登录</button>

                             </div>
                     </form>
            </div>
      </div>

</body>
</html>
