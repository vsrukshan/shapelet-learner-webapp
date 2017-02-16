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
    <link rel="stylesheet" type="text/css" href="../../resources/css/custom.css"/>

    <!-- EOF CSS INCLUDE -->
</head>
<body>

<%--POP-UP MESSAGE--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h3 class="modal-title" id="myModalLabel">Notification</h3>
            </div>
            <div class="modal-body" id="results">
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<%--END POP-UP MESSAGE--%>

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
            <li class="active">
                <a href="dashboard"><span class="fa fa-desktop"></span> <span class="xn-text">Dashboard</span></a>

            <li><a href="graph_visualizer"><span class="fa fa-users"></span> Shapelet Visualizer</a></li>

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
            <li class="xn-icon-button pull-right">
                <a><span class="fa fa-comments"
                         onclick="showGraph(document.getElementById('datasetName').innerHTML)"></span></a>
                <div id="notificatio" class="informer informer-info">0</div>
            <!-- END MESSAGES -->
            <!-- TASKS -->
            <!-- END TASKS -->
        </ul>
        <!-- END X-NAVIGATION VERTICAL -->

        <!-- START BREADCRUMB -->
        <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Dashboard</li>
        </ul>
        <!-- END BREADCRUMB -->

        <!-- PAGE CONTENT WRAPPER -->
        <div class="page-content-wrap">
            <%--STRAT FILE UPLOAD--%>
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading"><strong>Upload Files</strong>
                    </div>
                    <div class="panel-body">

                        <!-- Standar Form -->
                        <h4>Select files from your computer</h4>
                        <form action="../uploadFile" method="POST" enctype="multipart/form-data" id="submitForm"
                              enctype="multipart/form-data">
                            <div class="form-inline">
                                <div class="form-group">
                                    <input type="file" name="file" id="js-upload-files" multiple>
                                </div>
                                <button type="submit" class="btn btn-sm btn-primary" onclick="uploadJqueryForm()"
                                        id="js-upload-submit">Upload file
                                </button>
                            </div>
                        </form>
                        <div id="result"></div>
                        <div id="loading">
                            <p><img src="../../resources/img/jquery/loading-overlay.gif"/>
                            </p>
                        </div>
                        <!-- Drop Zone -->
                        <h4>Or drag and drop files below</h4>
                        <div class="upload-drop-zone" id="drop-zone">
                            Just drag and drop files here
                        </div>

                        <!-- Upload Finished -->
                        <div class="js-upload-finished">
                            <h3>Select Previous Uploaded Files</h3>

                        </div>
                        <%--<div>--%>
                        <%--<select onchange="selectDatabase()" id="myselect" name="myselect"></select>--%>
                        <%--</div>--%>
                        <div>
                            <select id="myselect" name="myselect"></select>
                            <input id="email" type="text" name="email" placeholder="Email address">
                            <button value="Submit"
                                    onclick="startProcess(document.getElementById('myselect').value,document.getElementById('email').value)">
                                Start processing
                            </button>
                        </div>
                        <div id="infoStartProcess"></div>
                        <div id="datasetName" style="display: none;"></div>
                    </div>
                </div> <!-- /container -->
            </div>
            <!-- END PAGE CONTENT WRAPPER -->
        </div>
        <!-- END PAGE CONTENT -->
    </div>
    <!-- END PAGE CONTAINER -->

    <!-- MESSAGE BOX-->
    <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
        <div class="mb-container">
            <div class="mb-middle">
                <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                <div class="mb-content">
                    <p>Are you sure you want to log out?</p>
                    <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                </div>
                <div class="mb-footer">
                    <div class="pull-right">
                        <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                        <button class="btn btn-default btn-lg mb-control-close">No</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MESSAGE BOX-->

    <!-- START PRELOADS -->
    <audio id="audio-alert" src="../../resources/audio/alert.mp3" preload="auto"></audio>
    <audio id="audio-fail" src="../../resources/audio/fail.mp3" preload="auto"></audio>
    <!-- END PRELOADS -->

    <!-- START SCRIPTS -->

    <!-- START PLUGINS -->
    <!-- END PLUGINS -->

    <!-- START THIS PAGE PLUGINS-->

    <script type="text/javascript" src="../../resources/js/plugins/morris/raphael-min.js"></script>
    <script type="text/javascript" src="../../resources/js/plugins/rickshaw/d3.v3.js"></script>
    <script type="text/javascript" src="../../resources/js/plugins/rickshaw/rickshaw.min.js"></script>

    <script type="text/javascript" src="../../resources/js/plugins/moment.min.js"></script>
    <!-- END THIS PAGE PLUGINS-->

    <!-- START TEMPLATE -->

    <script src="../../resources/js/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="../../resources/js/plugins/jquery/jquery.form.js"></script>
    <script src="../../resources/js/custom.js"></script>
    <script src="../../resources/js/plugins/websockets/sockjs.min.js"></script>
    <script src="../../resources/js/plugins/websockets/stomp.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#loading').hide();
            $('#startProcessResult').hide();
            $.getJSON("/datasets", function (json) {
                $('#myselect').empty();
                $.each(json.Files, function (i, obj) {
                    $('#myselect').append($('<option>').text(obj.File_Name).attr('value', obj.val));
                });
            });

            var socket = new SockJS('/gs-guide-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    var notify = document.getElementById("notificatio");
                    notify.innerHTML = "1";
                    notify.className = "informer informer-danger";
                    var snd = new Audio("../../resources/audio/success.wav");
                    snd.play();

                    $('#results').append("<p><h4>" + JSON.parse(greeting.body).content + " dataset - Shapelets has been generated successfully</h4></p>");
                    $('#myModal').modal('show');

                    var datasetName = document.getElementById("datasetName");
                    datasetName.innerHTML = JSON.parse(greeting.body).content;
                });
            });
        });
    </script>


    <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->
</body>
</html>






