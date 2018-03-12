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
<form method="post" action="/web${action!"/list"}">
<p></p>
<a href="/web/currency" id="goback" class="btn btn-primary">Go Back To Crypto Currency Selection</a>
<hr/>
<h2>Your selected Crypto Currency is ${currencyName}</h2>
<hr/>

<p>Kindly select the starting date:</p>
<form action="/web/list">
    From Date:
    <input type="date" name="start" value="2017-01-01" min="2017-01-01" max="2017-12-31" required>
    <p></p>
    <p>Kindly select the ending date: </p>
    To Date:
    <input type="date" name="end" value="2017-12-31" min="2017-01-01" max="2017-12-31" required>
    <hr/>
    <h4>From the list below please select an operation to be performed on the currency you chose:</h4>
    <hr/>
    <input type="hidden" name="currency" value="${currencyName}"/>
            <#list operation>
                <#items as FrontendObject>
                <div class="col">
                    <div class="card">
                        <div class="card-body" name=${FrontendObject.name}>
                            <h5 class="card-title">${FrontendObject.description}</h5>
                            <div class="card-footer">
                                <button name="operation" type="submit" value=${FrontendObject.name}>Show Result</button>
                                <!--<a href="/web/list" class="btn btn-primary">Show Result</a>-->
                            </div>
                        </div>
                    </div>
                </div>
                </#items>
            </#list>
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