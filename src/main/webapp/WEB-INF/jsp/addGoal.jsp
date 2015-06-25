<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Add Goal">

    <div class="row">
        <div class="col-md-10 col-md-offset-1">

            <form:form commandName="goal">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <div class="row">
                    <div class="col-md-2"><label for="minutes">Enter Minutes:</label></div>
                    <div class="col-md-2"><form:input id="minutes" path="minutes"/></div>
                    <div class="col-md-8"><form:errors path="minutes" cssClass="error"/></div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-4 col-md-offset-2">
                        <input class="btn btn-primary" type="submit" value="Enter Goal Minutes"/>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</t:page>



