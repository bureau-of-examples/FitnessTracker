<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Goal Report">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="alert alert-success">
                <h3>Goal Reports</h3>

                <div class="row" style="font-weight: 400">
                    <div class="col-md-1">Minutes</div>
                    <div class="col-md-2">Exercise Minutes</div>
                    <div class="col-md-9">Activity</div>
                </div>
                <c:forEach items="${goalReports}" var="goalReport">
                    <div class="row">
                        <div class="col-md-1">${goalReport.goalMinutes}</div>
                        <div class="col-md-2">${goalReport.exerciseMinutes}</div>
                        <div class="col-md-9">${goalReport.exerciseActivity}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="${pageContext.request.contextPath}/">Go back</a>
        </div>
    </div>
</t:page>
