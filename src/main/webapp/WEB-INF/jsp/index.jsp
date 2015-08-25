<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:page pageTitle="Main Page">

    <div class="row" >

        <div class="col-md-12">
            <div class="well bg-info">
                <div class="pull-right">
                    <c:url var="logoutUrl" value="/logout.html"/>
                    <span>Welcome <sec:authentication property="name"/>!</span>
                    <form action="${logoutUrl}" method="post" style="display: inline-block">
                        <input type="submit" value="Logout" class="btn btn-sm btn-warning "/>
                        <sec:csrfInput/>
                    </form>
                </div>

                <h3>Test pages</h3>

            <div class="row">
                <div class="col-md-12">
                    <div class="well bg-info">
                        <h3>Test pages</h3>

                        <div class="btn-group-justified" role="group">
                            <a class="btn btn-default" href="sayHello.html">Greeting</a>
                            <a class="btn btn-default" href="params/.html">Params</a>
                            <a class="btn btn-default" href="redirect/my_value.html">Redirect</a>
                            <a class="btn btn-default" href="params/111;p=111;q=222/matrix.html">Matrix Variable</a>
                            <a class="btn btn-default" href="lastModified.html">Last Modified</a>
                            <a class="btn btn-default" href="cache.html">Cache</a>
                        </div>
                    </div>
                <div class="btn-group-justified" role="group">
                    <a class="btn btn-default" href="sayHello.html">Greeting</a>
                    <a class="btn btn-default" href="params/.html">Params</a>
                    <a class="btn btn-default" href="redirect/my_value.html">Redirect</a>
                    <a class="btn btn-default" href="params/111;p=111;q=222/matrix.html">Matrix Variable</a>
                    <a class="btn btn-default" href="lastModified.html">Last Modified</a>
                    <a class="btn btn-default" href="cache.html">Cache</a>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-default" href="javascript:void(0)">Admin</a>
                    </sec:authorize>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-body">
                            <h3>What would you like to do...</h3>
                             <br>
                            <div class="row">
                                <div class="col-md-3"><a href="addGoal.html" class="btn btn-default">Add Goal</a></div>
                                <div class="col-md-3"><a href="updateGoal.html" class="btn btn-default">Update Goal</a>
                                </div>
                                <div class="col-md-3"><a href="getGoals.html" class="btn btn-default">Get Goals</a>
                                </div>
                                <div class="col-md-3"><a href="getGoalReports.html" class="btn btn-default">Get Goal
                                    Reports</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:page>
