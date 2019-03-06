<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\16 0016
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">

</head>
<body>
<% String info = (String)request.getAttribute("info");
if(info!=null){%>
    <input style="color: red;border:0px;outline:none;" value="<%=info%>"/>

<%}
%>
<div style="position:absolute;top:0px;width:1100px;border:5px solid skyblue;height:550px;">
    <div>
    <form id="aa" action="updatePwdServlet" method="post">
     <div style="position:absolute;left:400px;top:120px;"> <label>旧密码：&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="oldcus_pwd" /></label></div>
     <div style="position:absolute;left:400px;top:180px;"> <label>新密码：&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" id="newcus_pwd" name="newcus_pwd"type="password" /></label></div>
     <div style="position:absolute;left:400px;top:240px;"><label>确认密码:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" id="newcus_pwd1" name="newcus_pwd1" onchange="checkFunction()"type="password" fuck="fuck"/><input id="info" style="position:relative;left:20px;border:0px;outline:none;color:red;"/></label></div>
     <div style="position:absolute;left:470px;top:300px;"><input class="btn btn-primary" value="保存" style="width:60px;position:relative;left:50px;" onclick="saveFunction()" /></div>

 </form>

</div>
</body>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>

<script>
    $(function(){
       // $("input").each(function(index, element){
          //  var e = $(element).attr("name");
           /// if (e == "newcus_account1"){
          //      console.log(element);
           //     $(element).val("fuc");
          //  }
      //  });

    });
    function checkFunction(){

        if($("#newcus_pwd").val()==$("#newcus_pwd1").val()){

         }else{

        $("#info").val("密码不一致");
            console.log($("#info").val());
         }

    }
    function saveFunction(){
        console.log($("#info").val());
       if($("#info").val()=="密码不一致"){

       }else{
           $("#aa").submit();
        }
    }

</script>
</html>
