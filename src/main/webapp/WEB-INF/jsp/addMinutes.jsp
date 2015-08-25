<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 11/06/2015
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:page pageTitle="Add Minutes" useJavaScript="true">

    <c:if test="${empty totalMinutes}">
        <c:set var="totalMinutes" value="0"/>
    </c:if>

    <script type="text/javascript">
        $(document).ready(function () {
            $.getJSON(
                    '<spring:url value="activities.json" />',
                    {ajax: true},
                    function (data) {
                        var html = '<option value="">----Please select default----</option>';
                        for (var i = 0; i < data.length; i++) {
                            html += '<option value="' + data[i].desc + '">' + data[i].desc + '</option>';
                        }

                        var dropdown = $("#activities");
                        dropdown.html(html);
                        dropdown.val(dropdown.attr("value"));//refresh value
                    }
            )
        });
    </script>

    <div class="row">
        <div class="col-md-offset-8 col-md-4"> Language: <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
        </div>
    </div>
    <div class="row">
            <%--<div class="col-md-8">${controllerHash}</div>--%>
        <div class="col-md-12">
            <h4>${action} <span>${goal.id} - ${goal.description}</span></h4>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <form:form commandName="exercise">

                <div class="form-inline">
                    <div class="form-group">
                        <label for="txtMinutes"><spring:message code="goal.text"/></label>
                        <form:input id="txtMinutes" path="minutes" cssClass="form-control"/>

                        <label for="activities" class="sr-only">Activity</label>
                        <select id="activities" name="activity" value="${exercise.activity}"
                                class="form-control"></select>

                        <input type="submit" value="Save" class="btn btn-default">
                    </div>
                </div>

                <form:errors path="*" cssClass="errorblock" element="div"/>
            </form:form>
            <br>
            <br>

            <c:if test="${not empty actionResult}">

                <div class="alert alert-success" role="alert">
                    ${actionResult}
                </div>
            </c:if>

        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="alert alert-info">
                <p>Your goal is: <strong>${goal.minutes}</strong> minute(s).</p>
                <p>You exercised <strong>${totalMinutes}</strong> minute(s).</p>
            </div>
            <br>
            <a href="../">Back to default page.</a>
        </div>
    </div>
</t:page>
