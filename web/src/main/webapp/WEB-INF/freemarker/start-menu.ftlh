<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/styles.css">
</head>
<body>

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark"">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/web/currency"> Currencies </a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/web/operation"> Operations <span class="sr-only">(current)</span></a>
        </li>
    </ul>
    <div class="nav-item dropdown mr-sm-2">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Admin Panel
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action 1</a>
            <a class="dropdown-item" href="#">Action 2</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Action 3</a>
        </div>
    </div>
</div>
</nav>

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