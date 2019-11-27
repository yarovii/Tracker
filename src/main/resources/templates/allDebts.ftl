<#import "parts/common.ftl" as co>
<#import "parts/crud.ftl" as crud>
<@co.page true>
    <form action="/account/${account}" method="post">
        <div class="mb-3">
            <div class="col-sm-4">
                <input type="number" class="form-control form-control-sm" name="price" placeholder="Price"/>
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control form-control-sm" name="comment" placeholder="Comment"/>
            </div>
            <div class="col-sm-4">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1" value="true" name="active">
                    <label class="custom-control-label" for="customCheck1">Is it active</label>
                </div>
            </div>
            <div class="col-auto">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </div>
        </div>
    </form>
    <div class="card-deck">
    <#list debts as debt>
        <div class="card">
            <h5 class="card-header">Price: ${debt.price}</h5>
            <div class="card-body">
                <p class="card-text">${debt.comment}</p>
                <p class="card-text"><#if debt.active>Debt is active<#else>Debt repaid</#if></p>
            </div>
            <@crud.delete "/account/${account}/delete" true "${debt.id}"/>
            <@crud.delete "/account/${account}/update" false "${debt.id}"/>
        </div>
    <#else>
        </div>
        <h3>No debts</h3>
    </#list>

</@co.page>