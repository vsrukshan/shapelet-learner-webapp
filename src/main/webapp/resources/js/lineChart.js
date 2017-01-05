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
        fillColor: 'rgba(220,220,220,0)',
        strokeColor: 'rgba(220,180,0,1)',
        title: '2013',
        data: data[j]
    };
    lableNames[j] = "Col " + (j+1);
}

var lineChartData = {
    labels: lableNames, 
    datasets: datasetValue

};

Chart.defaults.global.animationSteps = 50;
Chart.defaults.global.tooltipYPadding = 16;
Chart.defaults.global.tooltipCornerRadius = 0;
Chart.defaults.global.tooltipTitleFontStyle = "normal";
Chart.defaults.global.tooltipFillColor = "rgba(0,160,0,0.8)";
Chart.defaults.global.animationEasing = "easeOutBounce";
Chart.defaults.global.responsive = true;
Chart.defaults.global.scaleLineColor = "black";
Chart.defaults.global.scaleFontSize = 16;

var ctx = document.getElementById("canvas").getContext("2d");
var LineChartDemo = new Chart(ctx).Line(lineChartData, {
    pointDotRadius: 2,
    bezierCurve: false,
    scaleShowVerticalLines: false,
    scaleGridLineColor: "black"
});
