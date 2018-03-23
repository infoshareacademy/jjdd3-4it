<!DOCTYPE html>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../styles/styles.css">
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>


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

    <div id="myDiv"></div>

    <script>
    var data1 =
    {
    x: [${axisX}],
    y: [${axisY}],
    type: 'scatter',
    mode: "lines"
    };


    var data2 = {
        x: ['${max.date}'],
        y: ['${max.price}'],
        mode: 'markers',
        name: 'maximum',

        marker: {
            color: 'rgb(219, 64, 82)',
            size: 12
        }
    };
   var data = [data1, data2];
    var layout = {
        title: 'Custom Range',
        xaxis: {
            range: ['${startdate}', '${enddate}'],
            type: 'date'

        }
    };
    Plotly.newPlot('myDiv', data, layout);
    </script>

    <#--<div id="myDiv"></div>-->
    <#--<script>-->
        <#--var main = [-->

            <#--{-->

                <#--x: ['${max.date}'],-->
                <#--y: ['${max.price}'],-->
                <#--type: 'scatter'-->

            <#--}-->

        <#--];-->

        <#--var max = {-->
            <#--x: ['${max.date}'],-->
            <#--y: ['${max.price}'],-->
            <#--mode: 'markers',-->
            <#--name: 'maximum',-->
            <#--marker: {-->
                <#--color: 'rgb(219, 64, 82)',-->
                <#--size: 12-->
            <#--}-->
        <#--};-->
        <#--var min = {-->
            <#--x: ['${min.date}'],-->
            <#--y: ['${min.price}'],-->
            <#--mode: 'markers',-->
            <#--name: 'minimum',-->
            <#--marker: {-->
                <#--color: 'rgb(100, 100, 0)',-->
                <#--size: 12-->
            <#--}-->
        <#--};-->
        <#--var med = {-->
            <#--x: ['${startdate}', '${enddate}'],-->
            <#--y: ['${med}','${med}'],-->
            <#--mode: 'linear',-->
            <#--name: 'median',-->
            <#--marker: {-->
                <#--color: 'rgb(0, 64, 82)',-->
                <#--size: 12-->
            <#--}-->
        <#--};-->
        <#--var avg = {-->
            <#--x: ['${startdate}', '${enddate}'],-->
            <#--y: ['${avg}','${avg}'],-->
            <#--mode: 'linear',-->
            <#--name: 'average',-->
            <#--marker: {-->
                <#--color: 'rgb(128, 0, 128)',-->
                <#--size: 6-->
            <#--}-->
        <#--};-->
        <#--var data = [main, min, max, avg, med];-->
        <#--var layout = {-->
            <#--title: 'Custom Range',-->
            <#--xaxis: {-->
                <#--range: ['${startdate}', '${enddate}'],-->
                <#--type: 'date'-->

            <#--}-->
        <#--};-->
        <#--Plotly.newPlot('myDiv', data, layout);-->
    <#--</script>-->

</body>
</html>