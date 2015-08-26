<%--
  Created by IntelliJ IDEA.
  User: JOHNZ
  Date: 22/06/2015
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Request Parameters">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="well">
                <c:set var="nextId" value="123" />
                <c:if test="${not empty id}">
                    <c:set var="nextId" value="${id + 1}" />
                </c:if>
                <p>The id is: [${id}].
                    <c:if test="${not empty JSESSIONID}">
                        You can set in the url: <a href="${nextId}.html">Set id to '${nextId}'.</a>
                    </c:if>
                </p>

                <c:if test="${not empty JSESSIONID}">
                    <p>JSESSIONID: ${JSESSIONID}</p>
                </c:if>

                <c:if test="${not empty(userAgent)}">
                    <p>You are using [${userAgent}]</p>
                </c:if>

                <c:if test="${not empty(matrixVariables)}">
                    <div>
                        <h4>Matrix variables</h4>
                        <br>
                        <table class="table table-bordered">
                            <tr>
                                <td>Variable</td>
                                <td>Value</td>
                            </tr>
                            <c:forEach items="${matrixVariables}" var="entry">
                                <tr>
                                    <td>${entry.key}</td>
                                    <td>${entry.value}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>

        </div>
    </div>

    <t:gobackLink />
</t:page>
