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

    <title>Currency list</title>
</head>
<body>
<h2 class="title">Welcome to your favourite application kindly delivered to you by 4IT Development Team</h2>
<hr/>
<h3 class="title">From the list below please select the Crypto Currency of your choice</h3>
<hr/>
<form method="post" action="/web${action!"/operation"}">
<div class="container">
<div class="row">
            <#list currencies>
                <#items as FrontendObject>
                <div class="col-md-4">
                        <img class="img-top" style="max-width: 10rem;" alt="image" src=${FrontendObject.url}>
                            <h5 class="card-title" name="currencyName">${FrontendObject.name}</h5>
                            <p class="card-text">${FrontendObject.description}</p>
                            <input type="submit" name="Go" value=${FrontendObject.name}><br/><br/>
                </div>
                </#items>
            </#list>
        </div>
</div>
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