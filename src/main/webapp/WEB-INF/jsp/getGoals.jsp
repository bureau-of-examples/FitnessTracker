<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 18/06/2015
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Goals Report</title>
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/bootstrap.css'>
</head>
<body>
<div class="container">
    <jsp:include page="../pageHeader.jsp"/>

    <div class="well-lg">
        <div class="row" style=" font-weight: 400">
            <div class="col-md-4">Id</div>
            <div class="col-md-8">Minutes</div>
        </div>

        <div>
            <c:forEach items="${goals}" var="goal">
                <div class="row">
                    <div class="col-md-4">${goal.id}</div>
                    <div class="col-md-8">${goal.minutes}</div>

                </div>
                <div class="row" style="border: 1px solid lightgray;">
                    <div class="col-md-12">
                        <div class="row" style="font-weight: 300">
                            <div class="col-md-1">Id</div>
                            <div class="col-md-2">Activity</div>
                            <div class="col-md-9">Minutes</div>
                        </div>
                        <c:forEach items="${goal.exercises}" var="exercise">
                            <div class="row">
                                <div class="col-md-1">${exercise.id}</div>
                                <div class="col-md-2">${exercise.activity}</div>
                                <div class="col-md-9">${exercise.minutes}</div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>