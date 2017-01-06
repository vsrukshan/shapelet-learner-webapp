var datasetValue = [];
var lableNames = [];
var count = 7;
var data = [
    [19, 20, 31, 18, 55, 6, 7],
    [10, 25, 34, 12, 54, 6, 37],
    [11, 21, 23, 11, 50, 6, 57],
    [12, 22, 23, 19, 51, 6, 17],
    [18, 24, 30, 15, 35, 16, 7],
    [16, 22, 35, 14, 25, 6, 7],
    [10, 27, 33, 14, 35, 6, 7]
];

for (var j = 0; j < count; j++) {
    datasetValue[j] =
    {
        borderColor: getRandomColor(),
        title: '2013',
        fill: false,
        lineTension: 0,
        label: '# shapelet',
        data: data[j]
    };
    lableNames[j] = "Col " + (j + 1);
}

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

var ctx = document.getElementById("canvas");
var lineChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: lableNames,
        datasets: datasetValue
    },
    backgroundColor: 'transparent',
    borderColor: '#F78511',
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});

ctx.onclick = function(evt){
    var activePoints = lineChart.getElementsAtEvent(evt);
    console.log(activePoints);
};

