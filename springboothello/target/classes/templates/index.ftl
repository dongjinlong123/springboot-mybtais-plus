后台传递的值：${name}
<#if sex==1>
男
<#elseif sex==2>
女
<#else>
其他
</#if>

<#list userList as user>
	${user}
</#list>
