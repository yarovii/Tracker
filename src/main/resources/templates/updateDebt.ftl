<#import "parts/common.ftl" as co>
<@co.page true>
    <form action="/account/${account}/update" method="post">
    <div class="input-group flex-nowrap">
        <div class="input-group-prepend">
            <span class="input-group-text" id="addon-wrapping">@</span>
        </div>
        <input type="number" class="form-control" value="${debt.price}" name="price" aria-label="title" aria-describedby="addon-wrapping">
        <input type="text" class="form-control" value="${debt.comment}" name="comment" aria-label="title" aria-describedby="addon-wrapping">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="debt_id" value="${debt.id}">
        <button type="submit" class="btn btn-primary">Update</button>
    </div>
    </form>
</@co.page>