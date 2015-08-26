<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="text" required="false" %>

<c:if test="${empty text}">
    <c:set var="text" value="Go back" />
</c:if>
<div class="row go-back-link">
    <div class="col-md-10 col-md-offset-1">
        <a href="${pageContext.request.contextPath}/">${text}</a>
    </div>
</div>