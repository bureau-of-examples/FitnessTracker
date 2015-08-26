
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<t:page pageTitle="Login is required" useJavaScript="true">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <h3><s:message code="fitnesstracker.loginpage.header"/></h3>

            <c:if test="${not empty error}">
                <div class="alert alert-warning">
                    Your login was unsuccessful. <br>
                    Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

            <form action="j_spring_security_check.html" name="f" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="txtUsername" class="col-md-2 control-label">Username:</label>

                    <div class="col-md-10">
                        <input id="txtUsername" name="j_username" autofocus="autofocus" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="txtPassword" class="col-md-2 control-label">Password:</label>

                    <div class="col-md-10">
                        <input id="txtPassword" name="j_password" type="password" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" value="Login" class="btn btn-default">
                        <input type="reset" value="Reset" class="btn btn-default">
                    </div>
                </div>

                <sec:csrfInput />
            </form>

            <hr>

            <div id="predefined_users_panel" class="panel panel-default panel-accordion">
                <div class="panel-heading">
                    <h3 class="panel-title"><s:message code="predefinedusers" />
                        <span class="caret"></span></h3>
                </div>
                <div class="panel-body">
                    <table id="predefined_users_table" class="table table-striped">
                        <thead>
                            <tr><th>Username</th><th>Password Hash</th></tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user" >
                                <tr>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="3">
                                    <small>Password is the same as username.</small>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        </div>
    </div>
</t:page>
