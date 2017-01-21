function drawGraph(datasetName) {
    $(document).off(".firstCall");
    $.ajax({
        url: 'learner/results?dataset=' + datasetName,
        data: {
            format: 'json'
        },
        error: function () {
            $('#info').html('<p>An error has occurred</p>');
        },
        dataType: 'json',
        success: function (data) {
            var jsonPretty = JSON.stringify(data, null, 4);

            var eventCount = data.EventCount;
            var datasetName = data.DatasetName;
            var dataObj = data.Data;
            for (var key in dataObj) {
                var dataset = [];
                var dataArray = dataObj[key].Data;
                for (var shapelet in dataArray) {
                    dataset[shapelet] = [];
                    var shapeletEvent = dataArray[shapelet].EventType;
                    var shapeletValues = dataArray[shapelet].Values;
                    for (var count=0; count< shapeletValues.length; count++) {
                        dataset[shapelet][count] = shapeletValues[count];
                    }
                }
                draw(dataset,key);
            }
        },
        type: 'GET'
    });
}

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function draw(dataset, graphNo) {
    var datasetValue = [];
    var lableNames = [];
    var data = dataset;

    for (var j = 0; j < dataset.length; j++) {
        datasetValue[j] =
        {
            borderColor: getRandomColor(),
            title: '2013',
            fill: false,
            lineTension: 0,
            label: '# shapelet',
            data: data[j]
        };
    }
    var len = dataset[0].length;
    for (var j=0; j<len; j++){
        lableNames[j] = "Col " + (j + 1);
    }


    var ctx = document.getElementById("canvas"+ graphNo);
    document.getElementById('button'+graphNo).style.visibility = 'visible';
    document.getElementById('tab'+graphNo).style.visibility = 'visible';
    var lineChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: lableNames,
            datasets: datasetValue
        },
        backgroundColor: 'transparent',
        borderColor: '#F78511',
        options: {
            responsive : true,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }

        }
    });

    ctx.onclick = function (evt) {
        // var helpers = Chart.helpers;
        //
        // var eventPosition = helpers.getRelativePosition(e, lineChart.chart);
        // var mouseX = eventPosition.x;
        // var mouseY = eventPosition.y;
        //
         var activePoints = lineChart.getElementAtEvent(evt);
        console.log(activePoints);
        // console.log(activePoints);
        // // var dataset = lineChart.getDatasetAtEvent(e);
        // // console.log(dataset);
        // var meta = lineChart.getDatasetMeta(0);
        // var x = meta.data[0]._model.x
        // console.log(activePoints);
        //
        // var firstPoint = activePoints[0];
        // console.log(firstPoint);
        // if (firstPoint !== undefined) {
        //     alert(firstPoint.index + ': ' + firstPoint.label);
        // }


    };
}
