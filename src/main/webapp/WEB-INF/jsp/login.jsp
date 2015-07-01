<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 1/07/2015
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:page pageTitle="Login is required">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h3>Fitness Tracker Custom Login Page</h3>
            <c:if test="${not empty error}">
                <div class="errorblock">
                    Your login was unsuccessful. <br>
                    Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

            <form action="j_spring_security_check.html" name="f" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="txtUsername" class="col-sm-2 control-label">Username:</label>

                    <div class="col-md-10">
                        <input id="txtUsername" name="j_username" autofocus="autofocus" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="txtPassword" class="col-sm-2 control-label">Password:</label>

                    <div class="col-md-10">
                        <input id="txtPassword" name="j_password" type="password" class="form-control">
                    </div>
                </div>

                <input type="submit" value="Login" class="btn btn-default">
                <input type="reset" value="Reset" class="btn btn-default">
                <sec:csrfInput />
            </form>
        </div>
    </div>
</t:page>
