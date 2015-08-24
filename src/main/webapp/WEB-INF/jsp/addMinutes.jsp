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
<t:page pageTitle="Add Minutes" useJQuery="true">

    <c:if test="${empty totalMinutes}">
        <c:set var="totalMinutes" value="0" />
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
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <div class="row">
                    <div class="col-md-2"><spring:message code="goal.text"/></div>
                    <div class="col-md-2"><form:input path="minutes"/></div>
                    <div class="col-md-8">

                        <select id="activities" name="activity" value="${exercise.activity}">

                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4"><input type="submit" value="Save"></div>
                    <div class="col-md-8"><span>${actionResult}</span></div>
                </div>
            </form:form>
        </div>
    </div>
    <div class="row">
        <h3>Your goal is: ${goal.minutes} minutes.</h3>

        <h3>You exercised ${totalMinutes} minutes.</h3>
        <a href="../">Back to default page.</a>
    </div>
</t:page>
