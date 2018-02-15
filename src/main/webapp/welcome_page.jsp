<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: EugenKrasotkin
  Date: 2/1/2018
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <p>Welcome dude! <%=new Date(System.currentTimeMillis())%>
    </p>
</head>
<body>
<form action="logout" method="get">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
