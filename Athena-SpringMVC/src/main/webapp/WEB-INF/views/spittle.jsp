<%--
  Desc: 
  User: Remilia
  DateTime: 2016-10-30 23:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Spittr</title>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">--%>
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}" />
            </span>
            <span class="spittleLocation">
                (<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" /> )
            </span>
        </div>
    </div>
</body>
</html>
