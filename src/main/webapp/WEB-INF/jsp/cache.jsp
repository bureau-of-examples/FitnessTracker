<%--
  Created by IntelliJ IDEA.
  User: JOHNZ
  Date: 24/06/2015
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Client caching test">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p>The time is ${now}.</p>

            <a href="">link to this page again will not send a request.</a>
        </div>
    </div>

    <t:gobackLink />
</t:page>
