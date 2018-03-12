<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/styles.css">
</head>
<body>
<div class="jumbotron">
    <p><h2 class="display-4">Your choise is: ${whichCoin} </h2></p>
    <p class="lead">Start date: ${startdate}</p>
    <p class="lead">End date: ${enddate} </p>
</div>

<div class="container">
    <div class="row">
        <div class="col">
            <p>MAX: ${max.price}</p>
        </div>
        <div class="col">
            <p>MIN: ${min.price}</p>
        </div>
        <div class="col">
            <p>AVG: ${avg}</p>
        </div>
        <div class="col">
            <p>MED: ${med}</p>
        </div>
    </div>
</div>

<#list cryptos>
    <#items as crypto>
            <p>${crypto.date} ${crypto.price}</p>
    </#items>
</#list>
</body>
</html>