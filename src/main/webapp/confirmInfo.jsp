<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\21 0021
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% %>
<head>
    <title>Title</title>
</head>
<body>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
   <h1>&nbsp;&nbsp;请确认您的订单！</h1>
<div style="position:absolute;top:50px;left:150px;">
  <form action="addBookInfoServletAction" method="post">
      <div style="position:absolute;top:230px;left:100px;" > 身份证号:<input id="cus_id" name="cus_id" style="border:0px;outline: none;" readonly value="<%=(String)session.getAttribute("cus_id")%>"/></div>
      <div style="position:absolute;top:70px;left:100px;">航空公司:<input id="com_code" name="com_code" style="border:0px;outline: none;" readonly value="<%=session.getAttribute("com_code")%>"></div>
      <div style="position:absolute;top:70px;left:470px;"> 航班号:<input id="fli_no" name="fli_no" style="border:0px;outline: none;" readonly value="<%=(String)session.getAttribute("fli_no")%>"/></div>
      <div style="position:absolute;top:110px;left:100px;">出发地:<input id="boo_baddress" name="boo_baddress" style="border:0px;outline: none;" readonly  value="<%=(String)session.getAttribute("boo_baddress")%>"></div>
      <div style="position:absolute;top:110px;left:470px;">目的地:<input id=" boo_aaddress" name="boo_aaddress" style="border:0px;outline: none;" readonly  value="<%=(String)session.getAttribute("boo_aaddress")%>"></div>
      <div style="position:absolute;top:150px;left:100px;">出发时间:<input id="boo_btime" name="boo_btime" style="border:0px;outline: none;" readonly  value="<%=(String)session.getAttribute("boo_btime")%>"/></div>
      <div style="position:absolute;top:150px;left:470px;">抵达时间:<input id="boo_atime" name="boo_atime"style="border:0px;outline: none;" readonly  value="<%=(String)session.getAttribute("boo_atime")%>"/></div>
      <div style="position:absolute;top:190px;left:100px;">舱位:<input id="boo_berth" name="boo_berth" style="border:0px;outline: none;" readonly value="<%=(String)session.getAttribute("boo_berth")%>"/></div>
      <div style="position:absolute;top:190px;left:470px;">座位号:<input id="boo_number" name="boo_number" style="border:0px;outline: none;" readonly  value="<%=(String)session.getAttribute("boo_number")%>"/></div>

      <div style="position:absolute;top:230px;left:470px;">金额:<input id="boo_fare" name="boo_fare" style="border:0px;outline: none;" readonly value="<%=(String)session.getAttribute("boo_fare")%>"/></div>

    <div style="position:absolute;top:300px;left:100px;">  <input class="btn btn-default" type="submit" value="确认"></input>    </div>


      <div style="position:absolute;top:300px;left:470px;" > <a href="flight.jsp" ><input  class="btn btn-default"  value="取消" style="width:60px;"/></a></div>
  </form>
</div>
</body>
</html>
