<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\25 0025
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>泛美航空后台管理系统</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
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
<body background="imag/bg4.jpeg" background-size="contain;">
<div>
    <div style="position:absolute;left:100px;top:50px;width:200px;height:665px;float:left;border:5px solid skyblue;">
        <div id="menuTree"  class="bootstrap-treeview"></div>
    </div>
    <div><input class="easyui-linkbutton" style="position:absolute;left:1340px;width:65px;height:30px;" onclick="myWindow();" value="退出登录"/></div>
    <div style="position:absolute;top:50px;left:295px;height:665px;border:5px solid skyblue;">
        <iframe id="mainIframe" name="mainIframe" src="admin_cus.jsp" frameborder="0" scrolling="auto"
                style="height:655px;width:1100px;"></iframe>
    </div>
    <div class="easyui-window" id="myWindow" title="提醒" style="width:200px;height:160px;" >
        <div style="position:absolute;top:50px;left:50px;"><label >请确认是否退出？</label></div>
        <div style="position:absolute;top:100px;left:30px;"><input style="width:40px;height:30px;" class="easyui-linkbutton" onclick="exit()" value="确认"/></div>
        <div style="position:absolute;top:100px;left:130px;"><input style="width:40px;height:30px;" class="easyui-linkbutton" onclick="cancel()" value="取消"/></div>
    </div>
</div>
</body>
<script>
    function myWindow(){
        $("#myWindow").window('open');
    }
    function exit(){
        window.location.replace("admin_index.jsp");
    }
    function cancel(){
        $("#myWindow").window('close');
    }
    $(function () {
        $("#myWindow").window({
            closed:true,
            collapsible:false,
            minimizable:false,
            maximizable:false
        });
        var tree = [
            {
                text:"客户管理",

            },
            {
                text:"航班机票管理",
                nodes: [
                    {
                        text:"订票审核"

                    },{
                        text:"退票管理"
                    }
                ]
            },

            {
                text:"航班信息管理",
                nodes:[
                    {
                        text:"增加航班信息"
                    },
                    {
                        text:"查询航班信息"
                    }

                ]
            },
            {
              text:"报表打印管理",
                nodes:[
                    {
                        text:"销售额"
                    },
                    {
                        text:'打印机票'
                    }
                ]
            },
            {
                text:"人员用户管理",
                nodes:[
                    {text:"高级管理人员"
                    },
                    {
                        text:"管理人员"
                    }
                ]
            },
            {
                text:"票价管理",
                nodes:[
                    {
                        text:'票价折扣'
                    },
                    {
                        text:'票价类型'
                    }
                ]
            }

        ];
        $("#menuTree").treeview({
            data:tree
        });
        $("#menuTree").on('nodeSelected',function(event,data){
            if(data.text=="查询航班信息"){
                $("#mainIframe").attr("src","admin_findFli.jsp");
            }
        });
        $("#menuTree").on('nodeSelected',function(event,data){
            if(data.text=="增加航班信息"){
                $("#mainIframe").attr("src","admin_fliAdd.jsp");
            }
        });
        $("#menuTree").on('nodeSelected',function(event,data){
            if(data.text=="客户管理"){
                $("#mainIframe").attr("src","admin_cus.jsp");
            }
        });
        $("#menuTree").on('nodeSelected',function(event,data){
            if(data.text==""){
                $("#mainIframe").attr("src","admin_cusAdd.jsp");
            }
        });
        $("#menuTree").on('nodeSelected',function(event,data){
            if(data.text=="销售额"){
                $("#mainIframe").attr("src","admin_sale.jsp");
            }
        })

    });
</script>
</html>
