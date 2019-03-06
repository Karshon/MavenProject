<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>泛美航空</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.11/themes/icon.css">


</head>
<body background="imag/bg4.jpeg" backgroung-size="cover;" >
<div style="position:absolute;top:30px;left:100px;">
    <div style="position:absolute;z-index:2;width:250px;height:580px;border:5px solid skyblue" >
        <div id="menuTree" class="easyui-tree" ></div>
    </div>
    <div style="position:absolute;left:1260px;">
        <input class="easyui-linkbutton" style="width:80px;height:30px;background-color: yellow;"  onClick="myWindow();" value="退出登录"/>
    </div>
    <div style="position:absolute;z-index:1;top:30px;left:245px;height:580px;">
        <iframe id="mainIframe" name="mainIframe" src="flight.jsp" frameborder="0" scrolling="auto"
        style="height:550px;width:1100px;"></iframe>
    </div>
</div>
<div class="easyui-window" id="myWindow" title="提醒" style="width:200px;height:160px;" >
    <div style="position:absolute;top:50px;left:50px;"><label >请确认是否退出？</label></div>
    <div style="position:absolute;top:100px;left:30px;"><input style="width:40px;height:30px;" class="easyui-linkbutton" onclick="exit()" value="确认"/></div>
    <div style="position:absolute;top:100px;left:130px;"><input style="width:40px;height:30px;" class="easyui-linkbutton" onclick="cancel()" value="取消"/></div>
</div>
<script>
    function myWindow(){
        $("#myWindow").window('open');
    }
    function exit(){
        window.location.replace("offlineServlet");
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
                text:"主页"
            },
            {
                text:"个人信息",
                children: [
                    {
                        text:"查看个人信息"

                    },{
                        text:"修改密码"
                    }
                ]
            },
            {
                text:"订票信息",
                children:[
                    {
                        text:"未付款订单"
                    },
                    {
                        text:"已付款订单"
                    }
                ]
            }
        ];
        $("#menuTree").tree({
            data:tree,
        });
        $("#menuTree").tree({
            onClick: function(node) {
                if(node.text == "退出登录"){
                    window.location.replace("offlineServlet");
                }else if(node.text=="修改密码"){
                    $("#mainIframe").attr("src","updatePwd.jsp");
                }else if(node.text=="查看个人信息"){
                    $("#mainIframe").attr("src","CusInfoServlet");
                }else if(node.text=="主页"){
                    $("#mainIframe").attr("src","flight.jsp");
                }else if(node.text=="未付款订单"){
                    $("#mainIframe").attr("src","findNoPayServlet");
                }else if(node.text=="已付款订单"){
                    $("#mainIframe").attr("src","findPaidServlet");
                }
            }
        });
    });
</script>
</body>

