<#import "parts/common.ftl" as co>

<@co.page true>
    <h1>Debtors page</h1>
    <form action="/addDebtorWithDebt">
        <div class="form-row align-items-center">
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
        </div>
        <div class="mb-3">
            <label for="validationTextarea">Textarea</label>
            <textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea"></textarea>
            <div class="invalid-feedback">
                Enter a comment.
            </div>
            <div class="col-auto">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </div>
        </div>
    </form>
    <#list debtors as debtor>
    <div class="card">
        <h5 class="card-header">debtor.username</h5>
        <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </div>
    <#else>
        <h3>No debtors</h3>
    </#list>
</@co.page>