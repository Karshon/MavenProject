<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>泛美航空</title>
</head>
<body background="imag/timg.jpg" background-size="contain;">
<% List<String > info = (List<String >) request.getAttribute("info");
    if(info!=null){
        Iterator<String > iter = info.iterator();
        while(iter.hasNext()){
    %>
<div style="position:absolute;top:5px;left:200px;"><label><%=iter.next()%></label></div>
<%}}%>
<div style="position:absolute;top:30px;left:800px;"><h1> 泛美航空，欢迎您！</h1></div>
<div style="position:absolute;top:30px;left:40px;">
<div class="easyui-panel" title="用户登录" style="width:380px;height:380px;">
    <form action="LoginServlet"  method="post" style="height:300px;width:300px;border:2px solid white;">
        <div style="position:relative;top:50px;left:40px;"><input id="username" name="username" class="easyui-textbox" style="height:30px;width:250px;" prompt= "请输入用户名" /></div>

        <div  style="position:relative;top:80px;left:40px;"><input name="password" class="easyui-passwordbox" style="height:30px;width:250px;" prompt= "请输入密码"/></div>
        <div style="position:relative;top:100px;left:40px;width:150px;" >
             <label> <input  id="checkbox1" class="easyui-checkbox" onClick="test();"/> 下次自动登录</label>
        </div>
        <div style="position:relative;width:150px;top:73px;left:220px;">
             <a href="test1.jsp" style="text-decoration:none;color:black" >忘记密码？</a>
         </div>
        <div style="position:relative;top:120px;left:30px;height:40px;width:300px;">
             <input id="login_bt" type="submit" background="black" class="easyui-linkbutton" style="position:absolute;width:80px;left:20px;height:30px;" value="登录"/>
            <input id="register.jsp" type="button" class="easyui-linkbutton"  style="position:absolute;left:170px;width:80px;height:30px;" onClick="register();"value="注册"/>
        </div>

    </form>
</div>
</div>
<script>

    function register(){
        window.location.href="Register.jsp";
    }
</script>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">

</body>

