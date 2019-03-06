<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\22 0022
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
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
<div style="position:absolute;top:0px;width:1100px;border:5px solid skyblue;height:550px;">
    <div><input class="btn btn-primary" value="退票" onClick="refundFunction()"/></div>

    <div id="noPayGrid" class="easyui-datagrid" style="width:1090px;"></div>
</div>
</body>
  <script type="text/javascript" src="js/jquerysession.js"></script>

<script>
    var cus_id;
    var boo_time;
    var boo_number;
    var boo_no;
    var boo_berth;
    $(function () {

        eval("var source ="+'<%=(String)request.getAttribute("bookinfoGroupJson")%>'+";");

        var xcolumns =[[
            {title:'航空公司',field:'com_code',width:80},
            {title:'身份证号',field:'cus_id',width:150},
            {title:'航班号',field:'boo_no',width:70},
            {title:'起飞时间',field:'boo_btime',width:140},
            {title:'到达时间',field:'boo_atime',width:140},
            {title:'起始地址',field:'boo_baddress',width:80},
            {title:'抵达地址',field:'boo_aaddress',width:80},
            {title:'价格',field:'boo_fare',width:70},
            {title:'舱位',field:'boo_berth',width:70},
            {title:'座位号',field:'boo_number',width:50},
            {title:'订票时间',field:'boo_time',width:150}
        ]];
        $("#noPayGrid").datagrid({
            columns:xcolumns,
            data:source
        });

        $("#noPayGrid").datagrid({
            onClickRow:function(index,row){
                cus_id = row.cus_id;
                 boo_time = row.boo_time;
                 boo_number = row.boo_number;
                 boo_no = row.boo_no;
                 boo_berth = row.boo_berth;
            }
        });


    });
    function refundFunction() {

        $.ajax({
            type:"Post",
            url:"refundServlet",
            data:{
                cus_id:cus_id,
                boo_time:boo_time,
                boo_number:boo_number,
                boo_no:boo_no,
                boo_berth:boo_berth
            },
            async:false,
            success:function (data) {
                eval("var source ="+data+";");
                $("#noPayGrid").datagrid('loadData',source);
            }

        });
    }
</script>
</html>

