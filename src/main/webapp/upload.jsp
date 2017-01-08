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
    <title>Upload File Request Page</title>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/jquery/jquery.form.js"></script>
    <script>
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

        $(document).ready(function () {
            $('#loading').hide();
        });


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
<button value="ShowFiles" onclick="showFilesOnServer()">ShowFiles</button>
<div id="info"></div>
</body>
</html>
