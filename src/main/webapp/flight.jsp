
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>


      <!-- 引入JQuery -->
      <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


      <!-- 引入EasyUI -->
      <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

      <!-- 引入EasyUI的样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/default/easyui.css" type="text/css"/>
      <!-- 引入EasyUI的图标样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/icon.css" type="text/css"/>
        <script src="js/jquery-easyui-1.6.11/locale/easyui-lang-zh_CN.js"></script>

</head>
<body  >

<div style="position:absolute;left:0px;height:auto;top:0px;border-top:5px solid skyblue;border-right:5px solid skyblue;">
    <div class="easyui-panel" style="width:1095px;height:130px;">
        <div style="position:absolute;left:30px;top:15px;"><label>出发地&nbsp;&nbsp;&nbsp;&nbsp;<input id="fli_baddress" class="easyui-textbox" name="fli_address"/></label></div>
    <div style="position:absolute;left:290px;top:12px;width:100px;"> <span style="font-size: 30px;" class="glyphicon glyphicon-minus" aria-hidden="true"></span></div>
        <div style="position:absolute;left:340px;top:15px;"><label>目的地&nbsp;&nbsp;&nbsp;&nbsp;<input id="fli_aaddress" class="easyui-textbox" name="fli_aaddress"/></label></div>
    <div style="position:absolute;left:600px;top:15px;"><label> 出发时间&nbsp;&nbsp;&nbsp;&nbsp;<input id="fli_btime" class="easyui-datebox" name="fli_btime" /></label></div>
        <div style="position:absolute;left:30px;top:70px;"><label>舱位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select style="height:30px;" id="fli_type" name="fli_type">
            <option value="头等舱">头等舱</option>
            <option value="公务舱">公务舱</option>
            <option value="经济舱">经济舱</option>
        </select></label></div>
    <div style="position:absolute;left:750px;top:70px;"><input style="width:80px;height:30px;"class="easyui-linkbutton" value="查询" onClick="loadGridData()" /></div>

</div>
</div>
<div style="position:absolute;top:135px;width:1100px;height:415px;border-bottom:5px solid skyblue;border-right:5px solid skyblue;">
    <!--datagrid控件-->
    <div id="main " style="position:absolute;top:0px;left:100px;width:1000px;height:400px;" >
        <div id="myGrid1" class="easyui-datagrid" style="width:925px;"></div>
    </div>

</div>

</body>
<script>

    $(function(){
    var xcolumns =[[
        {title:'航空公司',field:'com_name',width:150},
        {title:'飞机机型',field:'air_code',width:100},
        {title:'航班号',field:'fli_no',width:100},
        {title:'起飞时间',field:'fli_btime',width:200},
        {title:'到达时间',field:'fli_atime',width:200},
        {title:'价格',field:'fli_fare',width:100},
        {title:'剩余座位',field:'fli_number',width:70}
    ]];
    $('#myGrid1').datagrid({
       columns:xcolumns
    });
    $("#myGrid1").datagrid({
        onClickRow:function (index,row) {
            var fli_baddress = $("#fli_baddress").val();
            var fli_aaddress = $("#fli_aaddress").val();
            var com_code=row.com_code;
            var fli_no = row.fli_no;
            var fli_fare = row.fli_fare;
            var fli_number = row.fli_number;
            var  fli_type     = $("#fli_type").val();
            var url = "addBookInfoServlet?com_code="+com_code+"&fli_no="+fli_no+"&fli_baddress="+fli_baddress+"&fli_aaddress="+fli_aaddress
            +"&fli_type="+fli_type+"&fli_fare="+fli_fare+"&fli_number="+fli_number;
            window.location.href = url;
        }
    });
    });
    function loadGridData(){
        var  fli_baddress = $("#fli_baddress").val();
        var  fli_aaddress = $("#fli_aaddress").val();
        var  fli_btime    = $("#fli_btime").val();
        var  fli_type     = $("#fli_type").val();
        $.ajax({
           type:"Post",
            url:"loadGdServlet",
            data:{
                fli_baddress:fli_baddress,
                fli_aaddress:fli_aaddress,
                fli_btime:fli_btime,
                fli_type:fli_type
            },
            async:false,
            success:function(data){
                eval("var source ="+data+";");
               $('#myGrid1').datagrid({
                  data:source
               });
            }
        });
    }
</script>
</html>
