function uploadJqueryForm() {
    $(document).on("ajaxStart.firstCall", function () {
        $('#loading').show();
    });
    $(document).on("ajaxStop.firstCall", function () {
        $('#loading').hide();
    });
    $('#result').html('');

    $("#submitForm").ajaxForm({
        success: function (data) {
            $('#result').html(data);
            var i, text = "";
            var res = data.split(".");
            for (i = 0; i < res.length - 1; i++) {
                text += res[i];
            }
            startLearner(text);
        },
        dataType: "text"
    }).submit();
}

function showFilesOnServer() {
    $(document).off(".firstCall");
    $.ajax({
        url: '/datasets',
        data: {
            format: 'json'
        },
        error: function () {
            $('#info').html('<p>An error has occurred</p>');
        },
        dataType: 'json',
        success: function (data) {
            var jsonPretty = JSON.stringify(data, null, 4);
            console.log(jsonPretty);
            document.getElementById("info").innerHTML = jsonPretty;
        },
        type: 'GET'
    });
}

function selectDatabase() {
    var text = document.getElementById('myselect').value;
    startLearner(text);
}

function startLearner(text) {
    var passerName = "/learner/start?dataset=" + text;
    $.ajax({
        type: 'Get',
        url: passerName,
        success: function (data) {
            var jsonPretty = JSON.stringify(data, null, 4);
            console.log(jsonPretty);
        }
    });
}

function startProcess(datasetName, email) {
    $.ajax({
        url: '/learner/start',
        data: "dataset=" + datasetName + "&email=" + email,
        error: function () {
            $('#infoStartProcess').html('<p>An error has occurred</p>');
        },
        success: function (data) {
            console.log(data);
            $('#infoStartProcess').html('<p>' + data + '. Please wait, this might take some time to finish.</p>');
        },
        dataType: "text",
        type: 'GET'
    });
}

function showGraph(datasetName) {
    window.location.href = "/redirect?dataset=" + datasetName;
}