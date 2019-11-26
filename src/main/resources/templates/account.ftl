<#import "parts/common.ftl" as co>
<#import "parts/crud.ftl" as crud>

<@co.page true>
    <h1>Account page</h1>
    <form action="/account" method="post">
        <#--<div class="form-row align-items-center">
            <div class="col-auto">
                <label class="sr-only" for="inlineFormInput">price</label>
                <input type="number" class="form-control mb-2" id="inlineFormInput" placeholder="100">
            </div>
            <div class="col-auto">
                <label class="sr-only" for="inlineFormInputGroup">Username</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">@</div>
                    </div>
                    <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Username">
                </div>
            </div>
        </div>-->
        <div class="mb-3">
            <#--<label for="validationTextarea">Textarea</label>
            <textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea"></textarea>
            <div class="invalid-feedback">
                Enter a comment.
            </div>-->
            <div class="col-sm-4">
            <input type="text" class="form-control form-control-sm" name="title" placeholder="Title"/>
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control form-control-sm" name="text" placeholder="Comment"/>
            </div>
            <div class="col-auto">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </div>
        </div>
    </form>
    <div class="card-deck">
    <#list accounts as account>
        <div class="card">
            <h5 class="card-header">${account.title}</h5>
            <div class="card-body">
                <p class="card-text">${account.text}</p>

                <a href="/account/${account.id}" class="btn btn-primary">Go somewhere</a>
            </div>
            <@crud.delete "/account/delete" true "${account.id}"/>
            <@crud.delete "/account/update" false "${account.id}"/>
        </div>
    <#else>
        </div>
        <h3>No accounts</h3>
    </#list>
</@co.page>