<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Greetings!">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <h3>Greetings rendered in hello.jsp view -</h3>

            <h3><em>${greeting}</em></h3>
        </div>
    </div>

    <t:gobackLink />
</t:page>
