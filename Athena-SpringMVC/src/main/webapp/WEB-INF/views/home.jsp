<%--
  Desc: 
  User: Remilia
  DateTime: 2016-10-23 16:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <h1>Welcome to Spittr</h1>

    <a href="<c:url value="/spittles" /> ">Spittles</a> |
    <a href="<c:url value="/spitter/register" /> ">Register</a>
</body>
</html>
