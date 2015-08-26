<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Page which is redirected to">
  <div class="row">
    <div class="col-md-10 col-md-offset-1">
      <div>The redirect value is:<em>${redirectValue}</em></div>
      <div>The flash value is:<em>${flashAttribute}</em></div>
    </div>
  </div>

  <t:gobackLink />
</t:page>