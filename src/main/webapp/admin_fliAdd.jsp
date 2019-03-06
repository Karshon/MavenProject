<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\26 0026
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>泛美航空</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">

</head>
<body>
<div style="position:absolute;top:50px;left:300px;">
        <form action="admin_fliAddServlet" method="post">
            <div><label>航空公司:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="com_code"/></label></div>
            <div><label>机型号码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="air_code"/></label></div>
            <div><label>航班号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input class="easyui-textbox" name="fli_no"/></label></div>
            <div><label>起始地点:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_baddress"/></label></div>
            <div><label>抵达地点:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_aaddress"/></label></div>
            <div><label>起始时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_btime"/></labeL></div>
            <div><label>抵达地点:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_atime"/></label></div>
            <div><label>头等舱人数:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Fnumber"/></label></div>
            <div><label>公务舱人数:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Cnumber"/></label></div>
            <div><label>经济舱人数:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Ynumber"/></label></div>
            <div><label>头等舱价格:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Ffare"></label></div>
            <div><label>公务舱价格:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Cfare"/></label></div>
            <div><label>经济舱价格:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_Yfare"/></label></div>
            <div><label>退票记录时间:&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="fli_refundtime"/></label></div>
            <div><input class="easyui-linkbutton" style="position:relative;top:40px;left:150px;height:50px;width:70px;"type="submit" value="保存"/></div>
        </form>
</div>
</body>
</html>
