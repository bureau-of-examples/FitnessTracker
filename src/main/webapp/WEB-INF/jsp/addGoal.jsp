<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:page pageTitle="Add Goal">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <h3>
                <c:if test="${not empty param.create}" >
                    <s:message code="fitnesstracker.addgoal.header" />
                </c:if>
                <c:if test="${empty param.create}" >
                    <s:message code="fitnesstracker.updategoal.header" />
                </c:if>
            </h3>
            <br>
            <form:form commandName="goal">

                <form:errors path="*" cssClass="alert alert-warning" element="div"/>

                <div class="row">
                    <label class="col-md-3 control-label">Id:</label>

                    <div class="col-md-9 form-group">
                        <p class="form-control-static">${goal.id == null ? "N/A" : goal.id}</p>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <label for="minutes">Enter Minutes:</label>
                    </div>

                    <div class="col-md-9 form-group">
                        <form:input id="minutes" path="minutes"  cssClass="form-control" />
                        <form:errors path="minutes" cssClass="help-block error"/>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-3">
                        <label for="minutes">Enter Description:</label>
                    </div>

                    <div class="col-md-9 form-group">
                        <form:input id="description" path="description" cssClass="form-control" />
                        <form:errors path="description" cssClass="help-block error"/>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-9 col-md-offset-3">
                        <input class="btn btn-primary" type="submit" value="Enter Goal"/>
                    </div>
                </div>

                <sec:csrfInput />
            </form:form>
        </div>
    </div>


    <t:gobackLink />

</t:page>



