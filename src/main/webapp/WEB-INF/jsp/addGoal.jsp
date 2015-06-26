<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Add Goal">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <form:form commandName="goal">
                <form:errors path="*" cssClass="errorblock" element="div"/>

                <div class="row">
                    <label class="col-md-3 control-label">Id:</label>

                    <div class="col-md-9 form-group">
                        <p class="form-control-static">${goal.id}</p>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <label for="minutes">Enter Minutes:</label>
                    </div>

                    <div class="col-md-9 form-group">
                        <form:input id="minutes" path="minutes"  cssClass="form-control" />
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-12">
                        <form:errors path="minutes" cssClass="help-block error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <label for="minutes">Enter Description:</label>
                    </div>

                    <div class="col-md-9 form-group">
                        <form:input id="description" path="description" cssClass="form-control" />
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-12">
                        <form:errors path="description" cssClass="help-block error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-9 col-md-offset-3">
                        <input class="btn btn-primary" type="submit" value="Enter Goal"/>
                    </div>
                </div>


            </form:form>
        </div>
    </div>
</t:page>



