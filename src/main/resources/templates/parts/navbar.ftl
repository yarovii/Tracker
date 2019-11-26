<#import "log.ftl" as l>
<#include "security.ftl">
<#macro navbar isLogged>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Tracker</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/account">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/lenders">Lenders</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">UserList</a>
                </li>
            </#if>
        </ul>
        <#if isLogged>
            <div class="navbar-text mr-2"><#if user??>${name} <#else></#if></div>
            <@l.logout/>
        </#if>
    </div>
</nav>
</#macro>