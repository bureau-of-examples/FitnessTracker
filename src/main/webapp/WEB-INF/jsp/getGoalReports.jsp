<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Goal Report">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <table class="table table-striped table-hover">
                <caption>Goal Reports</caption>
                <thead>
                <tr>
                    <th>Goal</th>
                    <th>Target</th>
                    <th>Exercised</th>
                    <th># Activities</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${goalReports}" var="goalReport">
                    <tr>
                        <td>${goalReport.goalId} - ${goalReport.description}</td>
                        <td>${goalReport.goalMinutes} minute(s)</td>
                        <td>${goalReport.exerciseMinutes} minutes (s)</td>
                        <td>${goalReport.numberOfActivities}</td>
                        <td>
                            <c:if test="${goalReport.exerciseMinutes == goalReport.goalMinutes}">
                                <span class="glyphicon glyphicon-ok"></span>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

        </div>
    </div>

    <t:gobackLink />
</t:page>
