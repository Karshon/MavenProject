<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <!-- 引入JQuery -->
      <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
     <!-- 引入EasyUI -->
      <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>
      <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
      <script type="text/javascript" src="js/jquery-easyui-1.6.11/locale/easyui-lang-zh_CN.js"></script>
      <!-- 引入EasyUI的样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/default/easyui.css" type="text/css"/>
      <!-- 引入EasyUI的图标样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/icon.css" type="text/css"/>
    <title>泛美航空</title>
    <script  type="text/javascript">
        $(function () {
            $("#gender").combobox({
                panelHeight:"auto"
            });
            //验证邮箱格式是否正确
            $("input",$("#emailcheck").next("span")).blur(function(){
                var temp = $("#emailcheck").val();
                var regular =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
                if(!regular.test(temp)){
                    $("#checkemail_message").attr("type","");
                }else {
                    $("#checkemail_message").attr("type","hidden");
                }
            })
            $("input",$("#idcard").next("span")).blur(function() {
                var temp = $("#idcard").val();
                console.log(temp);
               var regular = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
                if(!regular.test(temp)){
                  $("#idcardcheck").attr("type","");
                }else{
                   $("#idcardcheck").attr("type","hidden");
               }
            })
        });
    </script>
</head>
<body background="imag/timg.jpg">
<div style="position:absolute;top:50px;left:50px;">
    <div class="easyui-panel" title="注册泛美航空账号" style="width:500px;height:400px;">
        <form action="RegisterServlet"  method="Post" style="position:absolute;top:100px;left:100px;height:600px;width:500px;border:0px solid;border-color:black;">
            <div><label>账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="username"  value="" /></label></div>
            <div><label>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-passwordbox" name="password"  value=""/></label></div>
            <div ><label>身份证号:&nbsp;&nbsp;&nbsp;<input id="idcard" class="easyui-textbox" name="cus_id" style="" value=""/></label></div>
            <div style="position:absolute;top:72px;left:280px;"><input type="hidden" id="idcardcheck"  style="border:none;color:red;width:115px;" disabled="disabled" value="身份证格式不正确"/></div>
            <div  ><label>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="gender" name="cus_sex" class="easyui-combobox" style="width: 50px;" value="">
                 <option value="男">男</option>
                 <option value="女">女</option>
            </select></label>
            </div>
            <div  style=""><label>电话:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-numberbox" name="cus_telnumber" style="" value=""/></label></div>
            <div  style=""><label>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="emailcheck" name="cus_email" style="" class="easyui-textbox"   /></label></div>
            <div style="position:absolute;top:180px;left:280px;"><input id="checkemail_message" type="hidden" style="width:100px;border:none;color:red;" disabled="disabled" value="邮箱格式不正确"/></div>
            <div><button type="submit" class="easyui-linkbutton" style="position:relative;top:40px;left:130px;height:30px;width:50px;" >注册</button></div>
        </form>
    </div>
</div>
</body>
</html>