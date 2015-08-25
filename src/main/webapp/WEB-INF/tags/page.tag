<%@tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" %>
<%@ attribute name="useJQuery" required="false" type="java.lang.Boolean" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/site.css'>

    <%if(Boolean.TRUE.equals(useJQuery)){%>
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/angular.js"></script>
    <%}%>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${pageTitle}</title>
</head>
<body>
<div class="container">

    <div class="page-header">
        <h2>Fitness Tracker <small>Spring + JPA demo webapp</small></h2>
    </div>

    <jsp:doBody/>

    <footer></footer>
</div>
</body>
</html>
