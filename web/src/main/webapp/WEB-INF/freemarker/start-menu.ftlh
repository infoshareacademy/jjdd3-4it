<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="WEB-INF/css/styles.css">
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <title>Operation list</title>
</head>
<body>

<nav class="navbar sticky-top navbar-expand navbar-dark bg-dark">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link h3" href="/currency"> Currencies </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link h3" href="/operation" value=${cryptoCurrency}> Date Selector<span class="sr-only">(current)</span></a>
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
<nav class="navbar navbar-dark bg-dark justify-content-between" style="color:white">
    <span class="navbar-text h5" style="color:white">Report from date ${startdate} to date ${enddate}</span>
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

<div id="myDiv"></div>

<script>

    // Plotly.d3.csv("https://raw.githubusercontent.com/plotly/datasets/master/finance-charts-apple.csv")

    var trace1 =

            {
                type: "scatter",
                mode: "lines",
                name: 'Diagram',
                x: [${axisX}],
                y: [${axisY}],
                line: {color: '#17BECF'}
            }
    ;

    var max = {
        x: ['${max.date}'],
        y: ['${max.price}'],
        mode: 'markers',
        name: 'maximum',
        marker: {
            color: 'rgb(219, 64, 82)',
            size: 12
        }
    };
    var min = {
        x: ['${min.date}'],
        y: ['${min.price}'],
        mode: 'markers',
        name: 'minimum',
        marker: {
            color: 'rgb(100, 100, 0)',
            size: 12
        }
    };
    var med = {
        x: ['${startdate}', '${enddate}'],
        y: ['${med}', '${med}'],
        mode: 'linear',
        name: 'median',
        marker: {
            color: 'rgb(0, 64, 82)',
            size: 12
        }
    };
    var avg = {
        x: ['${startdate}', '${enddate}'],
        y: ['${avg}', '${avg}'],
        mode: 'linear',
        name: 'average',
        marker: {
            color: 'rgb(128, 0, 128)',
            size: 6
        }
    };

    var data = [trace1, max, min, med, avg];

    var layout = {
        title: '${cryptoCurrency}',
        xaxis: {
            range: ['${startdate}', '${enddate}'],
            type: 'date'

        }
    };

    Plotly.newPlot('myDiv', data, layout);

</script>

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