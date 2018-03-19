<!DOCTYPE html>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/styles.css">
</head>
<body>

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark"
">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link h3" href="/web/currency"> Currencies </a>
        </li>
        <li class="nav-item active">
            <a class="nav-link h3" href="/web/operation" value=${cryptoCurrency}> Operations <span class="sr-only">(current)</span></a>
        </li>
    </ul>
    <div class="nav-item dropdown mr-sm-2">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
            Admin Panel
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action 1</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Action 3</a>
        </div>
    </div>
</div>
</nav>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <div class="col-md-3">
            <span class="navbar-text h5">Crypto Currency: ${cryptoCurrency}</span>
        </div>
        <div class="col-md-15">
            <span class="navbar-text h5">Report from date ${startdate} to date ${enddate}</span>
        </div>
    </div>
</nav>
<span style="display:block; height:25px;"></span>

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