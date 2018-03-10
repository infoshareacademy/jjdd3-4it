<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<#list cryptos>
    <#items as crypto>
            <p>${crypto.date} ${crypto.price}</p>
        </div>
    </#items>
</#list>


</body>
</html>