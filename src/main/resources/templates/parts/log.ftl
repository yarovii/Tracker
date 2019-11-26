<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-sm"> Username: </label>
            <div class="col-sm-4">
                <input type="text" class="form-control form-control-sm" name="username" placeholder="Username"/>
            </div>
        </div>
        <#if isRegisterForm>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-sm"> Email: </label>
            <div class="col-sm-4">
                <input type="email" class="form-control form-control-sm" name="email" placeholder="Email"/>
            </div>
        </div>
        </#if>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-sm"> Password: </label>
            <div class="col-sm-4">
                <input type="password" class="form-control form-control-sm" name="password" placeholder="Password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group row">
            <#if !isRegisterForm> <a href="/registration">Add new user</a><br></#if>
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary"><#if !isRegisterForm>Sign in<#else> Register </#if></button>
            </div>
        </div>
    </form>
</#macro>

<#macro logout>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</#macro>