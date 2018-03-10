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
<p>MAX: ${max.date} ${max.price}</p>
<p>MIN: ${min.date} ${min.price}</p>
<p>AVG: ${avg}</p>
<p>MED: ${med}</p>

</body>
</html>