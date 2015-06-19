<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 13/06/2015
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Goal</title>
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/bootstrap.css'>
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/site.css'>
</head>
<body>
<div class="container">
    <jsp:include page="../pageHeader.jsp"/>
    <form:form commandName="goal">
        <form:errors path="*" cssClass="errorblock" element="div"/>
        <div class="row">
            <div class="col-md-2"><label for="minutes">Enter Minutes:</label></div>
            <div class="col-md-2"><form:input id="minutes" path="minutes"/></div>
            <div class="col-md-8"><form:errors path="minutes" cssClass="error"/></div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <input class="btn btn-primary" type="submit" value="Enter Goal Minutes"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
