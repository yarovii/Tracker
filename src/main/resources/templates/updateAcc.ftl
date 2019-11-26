<#import "parts/common.ftl" as co>

<@co.page true>
    <form action="/account/update" method="post">
        <div class="input-group flex-nowrap">
            <div class="input-group-prepend">
                <span class="input-group-text" id="addon-wrapping">@</span>
            </div>
            <input type="text" class="form-control" value="${account.title}" name="title" aria-label="title" aria-describedby="addon-wrapping">
            <input type="text" class="form-control" value="${account.text}" name="text" aria-label="title" aria-describedby="addon-wrapping">
            <input type="hidden" value="${account.id}" name="id">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</@co.page>