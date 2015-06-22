<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <jsp:include page="WEB-INF/pageHeader.jsp"/>

    <div class="row">
        <div class="col-md-12">
            <ul>
                <li>
                    <a href="greeting.html">Greeting</a>
                </li>
                <li>
                    <a href="params/.html">Params</a>
                </li>

            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel">
                <div class="panel-body">
                    <h2>Welcome to the index page</h2>

                    <div class="row">
                        <div class="col-md-4"><a href="addGoal.html" class="btn btn-default">Add Goal</a></div>
                        <div class="col-md-4"><a href="getGoals.html" class="btn btn-default">Get Goal</a></div>
                        <div class="col-md-4"><a href="getGoalReports.html" class="btn btn-default">Get Goal Reports</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
