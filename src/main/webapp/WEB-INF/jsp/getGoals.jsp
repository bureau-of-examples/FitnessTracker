<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 18/06/2015
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="My Goals" useJQuery="true">

    <div class="row">
        <div class="col-md-12">
            <div class="well-lg">
                <div class="row" style=" font-weight: 400">
                    <div class="col-md-4">Id</div>
                    <div class="col-md-8">Minutes</div>
                </div>

                <div>
                    <c:forEach items="${goals}" var="goal">
                        <div class="row">
                            <div class="col-md-4">${goal.id} - ${goal.description}</div>
                            <div class="col-md-6">${goal.minutes}</div>
                            <div class="col-md-2"><button data-goal-id="${goal.id}" class="btn btn-default pull-right goal-selector">Select</button></div>
                        </div>
                        <br>
                        <div class="row" style="border: 1px solid lightgray;">
                            <div class="col-md-12">
                                <div class="row" style="font-weight: 300">
                                    <div class="col-md-1">Id</div>
                                    <div class="col-md-2">Activity</div>
                                    <div class="col-md-9">Minutes</div>
                                </div>
                                <c:forEach items="${goal.exercises}" var="exercise">
                                    <div class="row">
                                        <div class="col-md-1">${exercise.id}</div>
                                        <div class="col-md-2">${exercise.activity}</div>
                                        <div class="col-md-9">${exercise.minutes}</div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <a href="${pageContext.request.contextPath}/">Go back</a>
        </div>
    </div>

    <script>
        $("button.goal-selector").click(function(){
            var goalId = $(this).data("goal-id");
            var object = {goalId : goalId};
            $.ajax("${pageContext.request.contextPath}/setGoal.html", {method:'POST',  data:object})
                    .done(function(){
                        alert("This goal is set as the current goal.");
                    })
                    .fail(function (jqXHR, textStatus) {
                        alert("Failed to set current goal: " + textStatus);
                    });
        });
    </script>
</t:page>


