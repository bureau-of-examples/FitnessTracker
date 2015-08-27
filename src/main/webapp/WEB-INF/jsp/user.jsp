
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:page pageTitle="Page not found">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h3>Current User Details</h3>
            <br>
            <div class="row">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.username}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Roles</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <c:if test="${f:length(user.authorities) == 0}">
                                   <span><em>None</em></span>
                                </c:if>
                                <c:forEach items="${user.authorities}" var="authority">
                                    <span class="tag">${authority.authority}</span>
                                </c:forEach>
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Permissions</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <c:if test="${f:length(user.permissions) == 0}">
                                    <span><em>None</em></span>
                                </c:if>
                                <c:forEach var="entry" items="${user.permissions}">
                                    <span class="tag">${entry.key} - ${entry.value}</span>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                </form>

            </div>

        </div>
    </div>

    <t:gobackLink />
</t:page>
