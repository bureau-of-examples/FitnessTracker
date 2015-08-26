<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Last Modified Test">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div>Last modified at ${modifiedTime}</div>
            <div>Now is ${now}</div>

            <br>
            <a href="?">Normal Get (304 not modified)</a> | <a href="?update=true">Refresh page content</a>
        </div>
    </div>

    <t:gobackLink />
</t:page>