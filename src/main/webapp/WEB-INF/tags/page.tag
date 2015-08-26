<%@tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pageTitle" required="false" %>
<%@ attribute name="useJavaScript" required="false" type="java.lang.Boolean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css">

    <c:if test="${useJavaScript}">
        <script src="${pageContext.request.contextPath}js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}js/site.js"></script>
    </c:if>

    <title>${pageTitle}</title>
</head>
<body>
<div class="container">

    <div class="page-header">
        <h2><s:message code="project.appname" />&nbsp;<small> <s:message code="project.name" /></small></h2>
    </div>

    <section class="main">
        <jsp:doBody/>
    </section>

    <footer>
        <hr>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <p><s:message code="project.name" /> based on the following <a href="http://www.pluralsight.com/">Pluralsight</a> courses presented by <a href="http://www.pluralsight.com/author/bryan-hansen">Bryan Hansen</a>:
                </p>
                <ul>
                    <li><a href="http://www.pluralsight.com/courses/springmvc-intro">Introduction to Spring MVC</a></li>
                    <li><a href="http://www.pluralsight.com/courses/spring-jpa-hibernate">Spring with JPA and Hibernate</a></li>
                    <li><a href="http://www.pluralsight.com/courses/spring-security-fundamentals">Spring Security Fundamentals</a></li>
                </ul>
                <p>The project source code is can be found on Github:<br>
                    <a href="https://github.com/zhy2002/FitnessTracker">https://github.com/zhy2002/FitnessTracker</a>
                </p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>
