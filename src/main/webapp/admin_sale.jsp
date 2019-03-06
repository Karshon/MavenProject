<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\2\17 0017
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售额</title>
    <!-- 引入JQuery -->
      <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

         <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

      <!-- 引入EasyUI -->
      <script type="text/javascript" src="js/jquery-easyui-1.6.11/jquery.easyui.min.js"></script>
      <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
      <script type="text/javascript" src="js/jquery-easyui-1.6.11/locale/easyui-lang-zh_CN.js"></script>
      <!-- 引入EasyUI的样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/default/easyui.css" type="text/css"/>
      <!-- 引入EasyUI的图标样式文件-->
      <link rel="stylesheet" href="js/jquery-easyui-1.6.11/themes/icon.css" type="text/css"/>
    <script src="http://code.highcharts.com/highcharts.js"></script>
</head>
<body>

    <div style="position:absolute;top:50px;left:200px;">
    <div id="container" style="width:550px;height:400px;margin:0 auto"></div>
    </div>
    <script language="JavaScript">
        $(document).ready(function(){

            var title = {
                text:'每月销售总额折线图'
            };
            var subtitle = {
                text:''
            };
            var xAxis = {
                categories: ['一月', '二月', '三月', '四月', '五月', '六月'
                    ,'七月', '八月', '九月', '十月', '十一月', '十二月']
            };
            var yAxis = {
                title: {
                    text: '销售额(元)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            };
            var tooltip = {
                valueSuffix: '\xB0C'
            };
            var legend = {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            };
            $.ajax({
                type:"Post",
                url:"findSaleServlet",
                data:{
                    cus_id:"cus_id"
                },
                async:false

            });
            var series =  [
                {
                    name: '销售额',
                    data: [0, 0, 0, 0, 0, 0, 0,
                       0, 0, 0, 0, 47000]
                },

            ];
            var json = {};

            json.title = title;
            json.subtitle = subtitle;
            json.xAxis = xAxis;
            json.yAxis = yAxis;
            json.tooltip = tooltip;
            json.legend = legend;
            json.series = series;

            $('#container').highcharts(json);

        });
    </script>
</body>
</html>
