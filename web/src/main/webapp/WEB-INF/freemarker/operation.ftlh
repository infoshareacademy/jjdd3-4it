<!DOCTYPE html>
<html>
<head>
    <title>Operation list</title>
</head>
<body>
<#list operation>
    <#items as String>
            <p>${String}</p>
        <#sep><p>=======================</p></#sep>
    </#items>
</#list>
</body>
</html>