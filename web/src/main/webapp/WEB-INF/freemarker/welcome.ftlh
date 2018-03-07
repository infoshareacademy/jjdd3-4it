<!DOCTYPE html>
<html>
<head>
    <title>Currency list</title>
</head>
<body>
<#list currencies>
    <#items as String>
            <p>${String}</p>
            <#sep><p>=======================</p></#sep>
    </#items>
</#list>
</body>
</html>