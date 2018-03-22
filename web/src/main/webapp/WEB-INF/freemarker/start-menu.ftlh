<head>
    <!-- Plotly.js -->
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>

<body>

<div id="myDiv"><!-- Plotly chart will be drawn inside this DIV --></div>
<script>

    var data = [
        {
            type: 'scatter',
            mode: "lines",
            x: [${axisX}],
            y: [${axisY}]
        }
    ];

    Plotly.newPlot('myDiv', data);

</script>

</body>