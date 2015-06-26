<%--
  Created by IntelliJ IDEA.
  User: JOHNZ
  Date: 26/06/2015
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Oops!">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="errorblock">
                    ${errorMessage}
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="${pageContext.request.contextPath}/">Go back</a>
        </div>
    </div>
</t:page>