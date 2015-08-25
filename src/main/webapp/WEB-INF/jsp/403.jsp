<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 1/07/2015
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Page not found">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h3>You are not authorized.</h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="${pageContext.request.contextPath}/">Go back</a>
        </div>
    </div>
</t:page>
