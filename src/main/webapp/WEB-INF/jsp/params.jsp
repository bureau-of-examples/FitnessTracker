<%--
  Created by IntelliJ IDEA.
  User: JOHNZ
  Date: 22/06/2015
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>The id is: [${id}]</p>
<p>JSESSIONID: ${JSESSIONID}</p>
<c:if test="${not empty(userAgent)}">
    <p>You are using [${userAgent}]</p>
</c:if>

<c:if test="${not empty(matrixVariables)}">
<div>
    <h4>Matrix variables</h4>
    <table style="border: 1px solid black">
        <tr>
            <td>Variable</td>
            <td>Value</td>
        </tr>
        <c:forEach items="${matrixVariables}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</c:if>
</body>
</html>
