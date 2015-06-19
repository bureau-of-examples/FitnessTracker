<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 18/06/2015
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Goal Report</title>
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/bootstrap.css'>
</head>
<body>
<div class="container">
    <jsp:include page="../pageHeader.jsp"/>
    <div class="alert alert-success">
        <h1>Goal Reports</h1>

        <div class="row" style="font-weight: 400">
            <div class="col-md-1">Minutes</div>
            <div class="col-md-2">Exercise Minutes</div>
            <div class="col-md-9">Activity</div>
        </div>
        <c:forEach items="${goalReports}" var="goalReport">
            <div class="row">
                <div class="col-md-1">${goalReport.goalMinutes}</div>
                <div class="col-md-2">${goalReport.exerciseMinutes}</div>
                <div class="col-md-9">${goalReport.exerciseActivity}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
