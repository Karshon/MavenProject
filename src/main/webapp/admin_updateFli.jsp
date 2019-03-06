<%@ page import="com.xmj.vo.flightinfomation" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\12\27 0027
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>泛美航空后台管理系统</title>
</head>
<body>
    <%flightinfomation flightinfo = (flightinfomation)request.getAttribute("flightinfo");%>
    <form action="admin_fliUpdateServlet" method="post">
        <div>航班号:<input name="fli_no" value="<%=flightinfo.getFli_no()%>"/></div>
         <div>头等舱价格:<input name="fli_Ffare" value="<%=flightinfo.getFli_Ffare()%>"></div>
        <div>公务舱价格:<input name="fli_Cfare" value="<%=flightinfo.getFli_Cfare()%>"/></div>
        <div>经济舱价格:<input name="fli_Yfare" value="<%=flightinfo.getFli_Yfare()%>"/></div>
        <div>退票记录时间:<input name="fli_refundtime" value="<%=flightinfo.getFli_refundtime()%>"/></div>
        <div><input type="submit" value="保存"/></div>
    </form>

</body>
</html>
