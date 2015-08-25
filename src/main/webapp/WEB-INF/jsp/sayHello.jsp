<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Say Hello" useJQuery="true">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<t:page pageTitle="Say Hello" useJQuery="true">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post">

                <div class="form-group">
                    <label for="txtName">Your name:</label>
                    <input id="txtName" name="name" class="form-control" >

                    <!--without this you will set 'Method POST is not allowed' due to spring security-->
                    <security:csrfInput/>
                </div>

                <div id="txtNameEmpty" style="display: none;" class="alert alert-warning" role="alert">Please enter your name.</div>

                <button id="btnSubmit" type="submit" class="btn btn-default">Ok</button>
            </form>
        </div>

    </div>

    <script>
        (function(){
            var errorDiv = $("#txtNameEmpty");
            errorDiv.css("display", "none");

            var nameInput = $("#txtName");
            $("#btnSubmit").click(function(event){
                var name = nameInput.val();
                if(!name){
                    event.preventDefault();
                    errorDiv.css("display", "block");
                }
            });

            nameInput.keydown(function(){
                errorDiv.css("display", "none");
            });
        })();


    </script>
</t:page>