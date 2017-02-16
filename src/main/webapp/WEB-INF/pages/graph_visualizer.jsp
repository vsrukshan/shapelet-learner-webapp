<!DOCTYPE html>
<html lang="en">
<head>
    <!-- META SECTION -->
    <title>Shaplet-Learner</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="icon" href="../../resources/img/favicon.ico" type="image/x-icon"/>
    <!-- END META SECTION -->

    <!-- CSS INCLUDE -->
    <link rel="stylesheet" type="text/css" id="theme" href="../../resources/css/theme-default.css"/>
    <!-- EOF CSS INCLUDE -->

    <%--ChartJs INCLUDE--%>
    <link href="../../resources/css/custom.css" rel="stylesheet">
    <script src="../../resources/js/Chart.min.js"></script>

    <link href="../../resources/css/fonts/googleFonts.css" rel="stylesheet">
    <link href="../../resources/css/fontawesome/font-awesome.min.css" rel="stylesheet">
    <%--EOF ChartJs INCLUDE--%>
</head>
<body>
<!-- START POP-UP MESSAGE -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Please Select a Dataset</h4>
            </div>
            <div class="modal-body">
                <select id="myselect" name="myselect"></select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"
                        onclick="showGraph(document.getElementById('myselect').value.replace('.arff','').replace('.csv',''))">
                    Proceed
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal 2 -->
<div class="modal fade" id="queryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">x</span></button>
                <h4 class="modal-title" id="myModalLabel">Generated Query</h4>
            </div>
            <div id="queryContent" class="modal-body">czcscs</div>
        </div>
    </div>
</div>

<!-- END POP-UP MESSAGE -->

<!-- START PAGE CONTAINER -->
<div class="page-container">

    <!-- START PAGE SIDEBAR -->
    <div class="page-sidebar">
        <!-- START X-NAVIGATION -->
        <ul class="x-navigation">
            <li class="xn-logo">
                <a href="dashboard">Artisan Admin</a>
                <a href="#" class="x-navigation-control"></a>
            </li>
            <li class="xn-profile">
                <a href="#" class="profile-mini">
                    <img src="../../resources/assets/images/users/pp.jpg" alt="Artisan"/>
                </a>
                <div class="profile">
                    <div class="profile-image">
                        <img src="../../resources/assets/images/users/pp.jpg" alt="Artisan"/>
                    </div>
                    <div class="profile-data">
                        <div class="profile-data-name">Team Artisan</div>
                        <div class="profile-data-title">Shaplet-Learner-Developers</div>
                    </div>
                </div>
            </li>
            <li class="xn-title">Navigation</li>
            <li><a href="dashboard"><span class="fa fa-desktop"></span> <span class="xn-text">Dashboard</span></a></li>

            <li class="active"><a href="graph_visualizer"><span class="fa fa-users"></span> Shapelet Visualizer</a></li>
            <li><a href="parallel_coordinate "><span class="fa fa-users"></span> Parallel Coordinates</a></li>

        </ul>
        <!-- END X-NAVIGATION -->
    </div>
    <!-- END PAGE SIDEBAR -->

    <!-- PAGE CONTENT -->
    <div class="page-content">

        <!-- START X-NAVIGATION VERTICAL -->
        <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
            <!-- TOGGLE NAVIGATION -->
            <li class="xn-icon-button">
                <a href="../download.log" class="x-navigation-minimize"><span class="fa fa-download"></span></a>
            </li>
            <!-- END TOGGLE NAVIGATION -->
            <!-- SEARCH -->
            <li class="xn-search">
                <form role="form">
                    <input type="text" name="search" placeholder="Search..."/>
                </form>
            </li>
            <!-- END SEARCH -->
            <!-- SIGN OUT -->
            <li class="xn-icon-button pull-right">
                <a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span></a>
            </li>
            <!-- END SIGN OUT -->
            <!-- MESSAGES -->
            <!-- END MESSAGES -->
            <!-- TASKS -->
            <li class="xn-icon-button pull-right">
                <a><span class="fa fa-comments"></span></a>
                <div id="notificatio" class="informer informer-info">0</div>
            </li>
            <!-- END TASKS -->
        </ul>
        <!-- END X-NAVIGATION VERTICAL -->

        <!-- START BREADCRUMB -->
        <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Shapelet Visualizer</li>
        </ul>
        <!-- END BREADCRUMB -->

        <!-- PAGE CONTENT WRAPPER -->
        <div class="page-content-wrap">
            <div>
                <ul class="nav nav-pills">
                    <li id="tab0" style="visibility: hidden" class="active"><a data-toggle="pill" href="#event0">Event
                        0</a>
                    </li>
                    <li id="tab1" style="visibility: hidden"><a data-toggle="pill" href="#event1">Event 1</a></li>
                    <li id="tab2" style="visibility: hidden"><a data-toggle="pill" href="#event2">Event 2</a></li>
                    <li id="tab3" style="visibility: hidden"><a data-toggle="pill" href="#event3">Event 3</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div id="event0" class="tab-pane fade in active">
                    <div>
                        <canvas id="canvas0" height="140"></canvas>
                    </div>
                    <div style="text-align:center;">
                        <a id="button0" onclick="generateQuery('<%=request.getParameter("dataset")%>', 0)"
                           class="myButton" style="visibility: hidden">Generate
                            Query</a>
                    </div>
                </div>
                <div id="event1" class="tab-pane fade">
                    <div class="row">
                        <canvas id="canvas1" height="140"></canvas>
                    </div>
                    <div style="text-align:center;">
                        <a id="button1" onclick="generateQuery('<%=request.getParameter("dataset")%>',1)"
                           class="myButton" style="visibility: hidden">Generate
                            Query</a>
                    </div>
                </div>
                <div id="event2" class="tab-pane fade">
                    <div class="row">
                        <canvas id="canvas2" height="140"></canvas>
                    </div>
                    <div style="text-align:center;">
                        <a id="button2" onclick="generateQuery('<%=request.getParameter("dataset")%>',2)"
                           class="myButton" style="visibility: hidden">Generate
                            Query</a>
                    </div>
                </div>
                <div id="event3" class="tab-pane fade">
                    <div class="row">
                        <canvas id="canvas3" height="140"></canvas>
                    </div>
                    <div style="text-align:center;">
                        <a id="button3" onclick="generateQuery('<%=request.getParameter("dataset")%>',3)"
                           class="myButton" style="visibility: hidden">Generate
                            Query</a>
                    </div>
                </div>
                <div id="event4" class="tab-pane fade">
                    <div class="row">
                        <canvas id="canvas4" height="140"></canvas>
                    </div>
                    <div style="text-align:center;">
                        <a id="button4" onclick="generateQuery('<%=request.getParameter("dataset")%>',4)"
                           class="myButton" style="visibility: hidden">Generate
                            Query</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTENT WRAPPER -->

    </div>
    <!-- END PAGE CONTENT -->
</div>

<!-- END PAGE CONTAINER -->

<!-- START PRELOADS -->
<audio id="audio-alert" src="../../resources/audio/alert.mp3" preload="auto"></audio>
<audio id="audio-fail" src="../../resources/audio/fail.mp3" preload="auto"></audio>
<!-- END PRELOADS -->

<!-- START SCRIPTS -->
<!-- START PLUGINS -->
<script type="text/javascript" src="../../resources/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/jquery/jquery-ui.min.js"></script>
<script>
    $(document).ready(function () {
        $('#queryModal').modal('hide');
        var datasetName = "<%=request.getParameter("dataset")%>";
        if (datasetName === "null") {
            $.getJSON("/datasets", function (json) {
                $('#myselect').empty();
                $.each(json.Files, function (i, obj) {
                    $('#myselect').append($('<option>').text(obj.File_Name).attr('value', obj.val));
                });
            });
            $('#myModal').modal({backdrop: 'static', keyboard: false})
            $('#myModal').modal('show');
        } else {
            $('#myModal').modal('hide');
            drawGraph("<%=request.getParameter("dataset")%>");
        }
    });
</script>
<script type="text/javascript" src="../../resources/js/plugins/bootstrap/bootstrap.min.js"></script>
<!-- END PLUGINS -->

<!-- START THIS PAGE PLUGINS-->

<script type='text/javascript' src='../../resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
<script type='text/javascript' src='../../resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>
<script type='text/javascript' src='../../resources/js/plugins/bootstrap/bootstrap-datepicker.js'></script>

<!-- END THIS PAGE PLUGINS-->

<!-- START TEMPLATE -->
<script src="../../resources/js/lineChart.js"></script>
<script src="../../resources/js/custom.js"></script>
<script type="text/javascript">
    function generateQuery(datasetName, queryId) {
        $(document).off(".firstCall");
        $.ajax({
            url: '/learner/queries',
            data: "dataset=" + datasetName,
            error: function () {
                $('#generatedQueryResult').html('<p>An error has occurred</p>');
            },
            dataType: 'json',
            success: function (data) {
                var queries = data.Queries;
                var query = queries[queryId].Query;
                var queryContent = document.getElementById("queryContent");
                queryContent.innerHTML = query;
                $('#queryModal').modal('show');
            },
            type: 'GET'
        });
    }

</script>

<!-- END TEMPLATE -->
<!-- END SCRIPTS -->
</body>
</html>






