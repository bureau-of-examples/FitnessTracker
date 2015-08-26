<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<t:page pageTitle="My Goals" useJavaScript="true" useAjax="true">

    <div class="row">
        <div class="col-xs-12">

            <h3><s:message code="fitnesstracker.getgoals.header" /></h3>

            <div class="row strong">
                <div class="col-xs-4">Id</div>
                <div class="col-xs-8">Minutes</div>
            </div>

            <div class="row">
                <div class="col-xs-12">

                    <c:forEach items="${goals}" var="goal">
                        <div class="row ${goal.id == currentGoalId ? '' : 'not-default'}">
                            <div class="col-xs-4">${goal.id} - ${goal.description} <span class="selected glyphicon glyphicon-fire"></span></div>
                            <div class="col-xs-6">${goal.minutes}</div>
                            <div class="col-xs-2">
                                <button data-goal-id="${goal.id}" class="btn btn-default pull-right goal-selector">
                                    Select
                                </button>
                            </div>
                        </div>
                        <br>

                        <div class="row" style="border: 1px solid lightgray;">
                            <div class="col-xs-12">

                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Activity</th>
                                        <th>Minutes</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${goal.exercises}" var="exercise">
                                        <tr>
                                            <td>${exercise.id}</td>
                                            <td>${exercise.activity}</td>
                                            <td>${exercise.minutes}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table>

                            </div>
                        </div>
                        <br>
                    </c:forEach>

                    <c:if test="${fn:length(goals) eq 0}">
                        <p>No goal found. </p>
                    </c:if>
                </div>

            </div>

        </div>
    </div>

    <t:gobackLink/>

    <script>
        $("button.goal-selector").click(function () {
            var row = $(this).closest(".row");
            if(!row.hasClass("not-default"))
                return;

            var goalId = $(this).data("goal-id");
            var object = {goalId: goalId};
            var header = $("meta[name='_csrf_header']").attr("content");
            var token = $("meta[name='_csrf']").attr("content");
            var requestHeaders = {};
            requestHeaders[header] = token;
            $.ajax("${pageContext.request.contextPath}/setGoal.html", {method: 'POST', data: object, headers: requestHeaders})
                    .done(function () {
                        row.parent().children(".row").addClass("not-default");
                        row.removeClass("not-default");
                    })
                    .fail(function (jqXHR, textStatus) {
                        alert("Failed to set current goal: " + textStatus);
                    });
        });
    </script>
</t:page>


