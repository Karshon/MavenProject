<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\25 0025
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>泛美航空后台管理系统</title>
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

</head>
<body>
<div style="position:absolute;top:0px;height:150px;width:1100px;border:1px solid skyblue;">
<div style="position:absolute;top:60px;left:300px;"><label>客户账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" id="cus_account" name="cus_account"/></label></div>
        <div style="position:absolute;top:60px;left:650px;"><input style="width:65px;height:30px;" type="button" class="easyui-linkbutton" value="&nbsp;查询客户  " onClick="findCustomer()"/></div>

</div>
<div style="position:absolute;top:160px;left:930px; "><input style="width:65px;height:30px;" class="easyui-linkbutton" value="&nbsp;删除选中" onClick="deleteCustomer()"/></div>

    <div id="main " style="position:absolute;top:200px;left:100px;height:300px;" >
            <div id="myGrid1" class="easyui-datagrid" style="width:900px;"></div>
    </div>
</body>
<script>
    var cus_account;
    $(function () {
        var xcolumns =[[
            {title:'账号',field:'cus_account',width:70},
            {title:'身份证号',field:'cus_id',width:200},
            {title:'性别',field:'cus_sex',width:100},
            {title:'电话',field:'cus_telnumber',width:150},
            {title:'邮箱',field:'cus_email',width:200},
            {title:'注册时间',field:'cus_time',width:100},
            {title:'积分',field:'cus_integral',width:70}
        ]];
        $('#myGrid1').datagrid({
           columns:xcolumns
        });
        $('#myGrid1').datagrid({
           onClickRow:function (index,row) {
               cus_account = row.cus_account;
           }
        });
    });
    function deleteCustomer() {
     $.ajax({
        type:"Post",
        url:"deleteCusServlet",
        data:{
            cus_account:cus_account
        } ,
         async:false,
         success:function(data){
            eval("var source = "+data+";");
            $('#myGrid1').datagrid({
                data:source
            });
         }
     });
    }
    function findCustomer(){
        var cus_account = $('#cus_account').val();
        $.ajax({
            type:"Post",
            url:"admin_findCusServlet",
            data:{
                cus_account:cus_account
            },
            async:false,
            success:function(data){
                eval("var source = "+data+";");
                $('#myGrid1').datagrid({
                    data:source
                });
            }
        });

    };
</script>
</html>
