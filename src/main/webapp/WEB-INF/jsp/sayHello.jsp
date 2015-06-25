<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Say Hello">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post">

                <div class="form-group">
                    <label for="txtName">Your name:</label>
                    <input id="txtName" name="name" class="form-control" >
                </div>

                <button type="submit" class="btn btn-default">Ok</button>
            </form>
        </div>

    </div>
</t:page>