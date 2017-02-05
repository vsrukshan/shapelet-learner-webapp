<%--
  Created by IntelliJ IDEA.
  User: rnavagamuwa
  Date: 1/6/17
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Demo Page</title>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/websockets/sockjs.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/websockets/stomp.min.js"></script>

    <script>

        $(document).ready(function () {
            var socket = new SockJS('/gs-guide-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    console.log(JSON.parse(greeting.body).content);
                    $('#startProcessResult').append("<p>" + JSON.parse(greeting.body).content + " successfully generated</p>");
                    $('#startProcessResult').show();
                });
            });
        });

        function generateQuery(datasetName) {
            $(document).off(".firstCall");
            $.ajax({
                url: '/learner/queries',
                data: "dataset=" + datasetName,
                error: function () {
                    $('#generatedQueryResult').html('<p>An error has occurred</p>');
                },
                dataType: 'json',
                success: function (data) {
                    var jsonPretty = JSON.stringify(data, null, 4);
                    console.log(jsonPretty);
                    document.getElementById("generatedQueryResult").innerHTML = jsonPretty;
                },
                type: 'GET'
            });
        }

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
                    $('#infoShowFiles').html('<p>An error has occurred</p>');
                },
                dataType: 'json',
                success: function (data) {
                    var jsonPretty = JSON.stringify(data, null, 4);
                    console.log(jsonPretty);
                    document.getElementById("infoShowFiles").innerHTML = jsonPretty;
                },
                type: 'GET'
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

        $(document).ready(function () {
            $('#loading').hide();
            $('#startProcessResult').hide();
        });

        $(document).ready(function () {
            $('#loading').hide();
            $.getJSON("/datasets", function (json) {
                $('#myselect').empty();
                $.each(json.Files, function (i, obj) {
                    $('#myselect').append($('<option>').text(obj.File_Name).attr('value', obj.val));
                });
            });
        });

        function showGraph(datasetName) {
            window.location.href = "/redirect?dataset=" + datasetName;
        }

    </script>
</head>
<body>
<form id="submitForm" method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">

</form>
<button value="Submit" onclick="uploadJqueryForm()">Upload</button>
<i></i><br/>
<div id="result"></div>
<div id="loading">
    <p><img src="${pageContext.request.contextPath}/resources/img/jquery/loading-overlay.gif"/></p>
</div>

<h2>Following datasets are already in the server</h2>
<button value="ShowFiles" onclick="showFilesOnServer()">Show Files On Server</button>
<div id="infoShowFiles"></div>

<h2>Select the relevant dataset and press start.</h2>
<div>
    <select id="myselect" name="myselect"></select>
    <input id="email" type="text" name="email" placeholder="Email address">
    <button value="Submit"
            onclick="startProcess(document.getElementById('myselect').value,document.getElementById('email').value)">
        Start processing
    </button>
</div>
<div id="infoStartProcess"></div>
<div id="startProcessResult">
    <button value="Submit"
            onclick="showGraph(document.getElementById('myselect').value.replace('.arff','').replace('.csv',''))">Show
        generated graphs
    </button>
    <button value="Submit"
            onclick="generateQuery(document.getElementById('myselect').value.replace('.arff','').replace('.csv',''))">
        Generate Queries
    </button>
</div>
<div id="generatedQueryResult"></div>

</body>
</html>
