<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="WEB-INF/css/styles.css">

    <title>Currency Usage Statistics</title>
</head>
<body>
<nav class="navbar sticky-top navbar-expand navbar-dark bg-dark">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link h3" href="/currency"> Currencies </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link h3" href="/operation" value=${cryptoCurrency}> Operations<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <div class="nav-item dropdown mr-sm-2">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false" style="color:white">
                Extras
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/statistic">Statistics</a>
            </div>
        </div>
    </div>
</nav>
            <#list stats>
                <#items as currenciesStatistics>
                <p>${CurrencyStatistic.name}</p>
                <p>${CurrencyStatistic.value}</p>
                </#items>
            </#list>
</body>
</html>