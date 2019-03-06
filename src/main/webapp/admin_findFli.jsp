<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\26 0026
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
    <div style="height:110px;border-bottom:2px solid skyblue;" >
        <div style="position:absolute;top:60px;left:300px;"><label>航班号:&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" id="fli_no" name="fli_no"/></label></div>

        <div style="position:absolute;top:60px;left:650px;"> <input type="button" class="easyui-linkbutton" style="width:65px;height:30px;" value="查询" onclick="findFli()"/></div>

    </div>
    <div style="position:absolute;top:160px;left:900px;"><input type="button" class="easyui-linkbutton"  style="width:65px;height:30px;"  value="关闭航班" onclick="closeFli()"></div>
    <div style="position:absolute;top:160px;left:980px;"><input type="button" class="easyui-linkbutton"  style="width:65px;height:30px;"  value="修改航班" onclick="findFli2()"></div>

    <div id="main " style="position:absolute;top:200px;left:100px;height:300px;" >
            <div id="myGrid1" class="easyui-datagrid" style="width:700px;"></div>
        </div>
</body>
<script>
    var fli_no;
    $(function () {
        var xcolumns =[[
            {title:'航空公司',field:'com_code',width:70},
            {title:'机型号码',field:'air_code',width:100},
            {title:'航班号',field:'fli_no',width:100},
            {title:'起始地址',field:'fli_baddress',width:70},
            {title:'抵达地址',field:'fli_aaddress',width:70},
            {title:'起始时间',field:'fli_btime',width:100},
            {title:'抵达时间',field:'fli_atime',width:70},


            {title:'航班状态',field:'fli_refund',width:100},

        ]];
        $('#myGrid1').datagrid({
            columns:xcolumns
        });
        $('#myGrid1').datagrid({
            onClickRow:function(index,row){
                fli_no=row.fli_no;

            }
        })
    });
    function findFli() {
        var fli_no = $('#fli_no').val();


        $.ajax({
           type:'Post',
           url:'admin_findFliServlet' ,
            data:{
               fli_no:fli_no
            },
            async:false,
            success:function (data) {
               eval("var source ="+data+";");
               $('#myGrid1').datagrid({
                  data:source
               });

            }
        });

    }
    function findFli2(){
        window.location.href = "admin_updateFliServlet?&fli_no="+fli_no;
    }
    function closeFli() {

        $.ajax({
            type:'Post',
            url:'updateFli_refundServlet' ,
            data:{
                fli_no:fli_no
            },
            async:false,
            success:function (data) {
                eval("var source="+data+";");
                $('#myGrid1').datagrid({
                    data:source
                })
            }

        });
    }
</script>
</html>
