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

    <title>Operation list</title>
</head>
<body>
<nav class="navbar sticky-top navbar-expand navbar-dark bg-dark">

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link h3" href="/web/currency"> Currencies <span class="sr-only">(current)</span></a>
        </li>
    </ul>
    <div class="nav-item dropdown mr-sm-2">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false" style="color:white">
            Admin Panel
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action 1</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Action 2</a>
        </div>
    </div>
</div>
</nav>
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <span class="navbar-brand mb-0 h3"> Select the required Time Frame for the value ${cryptoCurrency}</span>
</nav>
<form method="post" action="/web${action!"/list"}">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <span class="navbar-brand mb-0 h3"> From date: </span>
        <input type="date" name="start" value="2017-01-01" min="2017-01-01" max="2017-12-31" required>
        <span class="navbar-brand mb-0 h3"> To date: </span>
        <input type="date" name="end" value="2017-12-31" min="2017-01-01" max="2017-12-31" required>
    </nav>
    <nav class="navbar navbar-expand navbar-light bg-light justify-content-between">
        <div class="btn">
            <button class="btn btn-outline-success" type="submit">Show Result</button>
        </div>
    </nav>
    <span style="display:block; height:25px;"></span>
    <input type="hidden" name="cryptoCurrency" value="${cryptoCurrency}"/>

</form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="assets/js/app.js"></script>
</body>
</html>