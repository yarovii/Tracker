<#macro delete path isDelete idDel>
    <form action="${path}" method="get">
        <div class="col-sm-10">
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
            <input type="hidden" value="${idDel}" name="id">
            <button type="submit" class="btn btn-primary mb-1"><#if isDelete>Delete<#else>Update</#if></button>
        </div>
    </form>
</#macro>