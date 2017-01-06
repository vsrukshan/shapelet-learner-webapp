<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['line']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('number', 'Day');
            data.addColumn('number', 'Guardians of the Galaxy');
            data.addColumn('number', 'The Avengers');
            data.addColumn('number', 'Transformers: Age of Extinction');
            data.addColumn('number', 'Test 1');
            data.addColumn('number', 'Test 2');
            data.addColumn('number', 'Test 3');

            data.addRows([
                [1,  21, 21, 21, 21, 21, 21],
                [2,  30.9, 69.5, 32.4, 21, 11, 40],
                [3,  25.4,   57, 25.7, 21, 12, 49],
                [4,  11.7, 18.8, 10.5, 31, 14, 13],
                [5,  11.9, 17.6, 10.4, 51, 13, 16],
                [6,   8.8, 13.6,  7.7, 11, 15, 15],
                [7,   7.6, 12.3,  9.6, 32, 12, 24],
                [8,  12.3, 29.2, 10.6, 21, 23, 64],
                [9,  16.9, 42.9, 14.8, 11, 43, 54],
                [10, 12.8, 30.9, 11.6, 13, 54, 45],
                [11,  5.3,  7.9,  4.7, 45, 24, 14],
                [12,  6.6,  8.4,  5.2, 34, 28, 43],
                [13,  4.8,  6.3,  3.6, 21, 23, 24],
                [14,  4.2,  6.2,  3.4, 26, 15, 4]
            ]);

            var options = {
                chart: {
                    title: 'Box Office Earnings in First Two Weeks of Opening',
                    subtitle: 'in millions of dollars (USD)'
                },
                selectionMode: 'multiple',
                tooltip: {trigger: 'selection'},
                aggregationTarget: 'category',
                width: 900,
                height: 500,
                axes: {
                    x: {
                        0: {side: 'top'}
                    }
                }
            };

            var chart = new google.charts.Line(document.getElementById('line_top_x'));

            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div id="line_top_x"></div>
</body>
</html>