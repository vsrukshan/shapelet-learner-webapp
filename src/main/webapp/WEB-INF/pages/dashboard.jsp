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
                <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
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
                <a href="#"><span class="fa fa-comments"></span></a>
                <div class="informer informer-danger">4</div>
                <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                    <div class="panel-heading">
                        <h3 class="panel-title"><span class="fa fa-comments"></span> Messages</h3>
                        <div class="pull-right">
                            <span class="label label-danger">4 new</span>
                        </div>
                    </div>
                    <div class="panel-body list-group list-group-contacts scroll" style="height: 200px;">
                        <a href="#" class="list-group-item">
                            <div class="list-group-status status-online"></div>
                            <img src="../../resources/assets/images/users/user2.jpg" class="pull-left" alt="John Doe"/>
                            <span class="contacts-title">John Doe</span>
                            <p>Praesent placerat tellus id augue condimentum</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <div class="list-group-status status-away"></div>
                            <img src="../../resources/assets/images/users/user.jpg" class="pull-left"
                                 alt="Dmitry Ivaniuk"/>
                            <span class="contacts-title">Dmitry Ivaniuk</span>
                            <p>Donec risus sapien, sagittis et magna quis</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <div class="list-group-status status-away"></div>
                            <img src="../../resources/assets/images/users/user3.jpg" class="pull-left" alt="Nadia Ali"/>
                            <span class="contacts-title">Nadia Ali</span>
                            <p>Mauris vel eros ut nunc rhoncus cursus sed</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <div class="list-group-status status-offline"></div>
                            <img src="../../resources/assets/images/users/user6.jpg" class="pull-left"
                                 alt="Darth Vader"/>
                            <span class="contacts-title">Darth Vader</span>
                            <p>I want my money back!</p>
                        </a>
                    </div>
                    <div class="panel-footer text-center">
                        <a>Show all messages</a>
                    </div>
                </div>
            </li>
            <!-- END MESSAGES -->
            <!-- TASKS -->
            <li class="xn-icon-button pull-right">
                <a href="#"><span class="fa fa-tasks"></span></a>
                <div class="informer informer-warning">3</div>
                <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                    <div class="panel-heading">
                        <h3 class="panel-title"><span class="fa fa-tasks"></span> Tasks</h3>
                        <div class="pull-right">
                            <span class="label label-warning">3 active</span>
                        </div>
                    </div>
                    <div class="panel-body list-group scroll" style="height: 200px;">
                        <a class="list-group-item" href="#">
                            <strong>Phasellus augue arcu, elementum</strong>
                            <div class="progress progress-small progress-striped active">
                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%
                                </div>
                            </div>
                            <small class="text-muted">John Doe, 25 Sep 2014 / 50%</small>
                        </a>
                        <a class="list-group-item" href="#">
                            <strong>Aenean ac cursus</strong>
                            <div class="progress progress-small progress-striped active">
                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 80%;">80%
                                </div>
                            </div>
                            <small class="text-muted">Dmitry Ivaniuk, 24 Sep 2014 / 80%</small>
                        </a>
                        <a class="list-group-item" href="#">
                            <strong>Lorem ipsum dolor</strong>
                            <div class="progress progress-small progress-striped active">
                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="95"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 95%;">95%
                                </div>
                            </div>
                            <small class="text-muted">John Doe, 23 Sep 2014 / 95%</small>
                        </a>
                        <a class="list-group-item" href="#">
                            <strong>Cras suscipit ac quam at tincidunt.</strong>
                            <div class="progress progress-small">
                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0"
                                     aria-valuemax="100" style="width: 100%;">100%
                                </div>
                            </div>
                            <small class="text-muted">John Doe, 21 Sep 2014 /</small>
                            <small class="text-success"> Done</small>
                        </a>
                    </div>
                    <div class="panel-footer text-center">
                        <a>Show all tasks</a>
                    </div>
                </div>
            </li>
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

            <!-- START WIDGETS -->
            <div class="row">
                <div class="col-md-3">
                    <!-- START WIDGET MESSAGES -->
                    <div class="widget widget-default widget-item-icon">
                        <div class="widget-item-left">
                            <span class="fa fa-envelope"></span>
                        </div>
                        <div class="widget-data">
                            <div class="widget-int num-count">2</div>
                            <div class="widget-title">Events</div>
                            <div class="widget-subtitle">In your Dataset</div>
                        </div>
                        <div class="widget-controls">
                            <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip"
                               data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                        </div>
                    </div>
                    <!-- END WIDGET MESSAGES -->

                </div>
                <div class="col-md-3">

                    <!-- START WIDGET MESSAGES -->
                    <div class="widget widget-default widget-item-icon">
                        <div class="widget-item-left">
                            <span class="fa fa-envelope"></span>
                        </div>
                        <div class="widget-data">
                            <div class="widget-int num-count">4234521</div>
                            <div class="widget-title">Shapelets</div>
                            <div class="widget-subtitle">In your Dataset</div>
                        </div>
                        <div class="widget-controls">
                            <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip"
                               data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                        </div>
                    </div>
                    <!-- END WIDGET MESSAGES -->

                </div>
                <div class="col-md-3">

                    <!-- START WIDGET REGISTRED -->
                    <div class="widget widget-default widget-item-icon" onclick="location.href='graph_visualizer';">
                        <div class="widget-item-left">
                            <span class="fa fa-user"></span>
                        </div>
                        <div class="widget-data">
                            <div class="widget-int num-count">375</div>
                            <div class="widget-title">Important Shapelets</div>
                            <div class="widget-subtitle">In your Dataset</div>
                        </div>
                        <div class="widget-controls">
                            <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip"
                               data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                        </div>
                    </div>
                    <!-- END WIDGET REGISTRED -->

                </div>
                <div class="col-md-3">

                    <!-- START WIDGET CLOCK -->
                    <div class="widget widget-info widget-padding-sm">
                        <div class="widget-big-int plugin-clock">00:00</div>
                        <div class="widget-subtitle plugin-date">Loading...</div>
                        <div class="widget-controls">
                            <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip"
                               data-placement="left" title="Remove Widget"><span class="fa fa-times"></span></a>
                        </div>
                        <div class="widget-buttons widget-c3">
                            <div class="col">
                                <a href="#"><span class="fa fa-clock-o"></span></a>
                            </div>
                            <div class="col">
                                <a href="#"><span class="fa fa-bell"></span></a>
                            </div>
                            <div class="col">
                                <a href="#"><span class="fa fa-calendar"></span></a>
                            </div>
                        </div>
                    </div>
                    <!-- END WIDGET CLOCK -->

                </div>
            </div>
            <!-- END WIDGETS -->

            <%--STRAT FILE UPLOAD--%>
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading"><strong>Upload Files</strong>
                        <small>File upload</small>
                    </div>
                    <div class="panel-body">

                        <!-- Standar Form -->
                        <h4>Select files from your computer</h4>
                        <form action="uploadFile" method="POST" enctype="multipart/form-data" id="submitForm"
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
                        <div>
                            <select onchange="selectDatabase()" id="myselect" name="myselect"></select>
                        </div>
                    </div>
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
<%--<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>--%>

<!-- START PLUGINS -->
<script type="text/javascript" src="../../resources/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/bootstrap/bootstrap.min.js"></script>
<!-- END PLUGINS -->

<!-- START THIS PAGE PLUGINS-->
<script type='text/javascript' src='../../resources/js/plugins/icheck/icheck.min.js'></script>
<script type="text/javascript"
        src="../../resources/js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/scrolltotop/scrolltopcontrol.js"></script>

<script type="text/javascript" src="../../resources/js/plugins/morris/raphael-min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/morris/morris.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/rickshaw/d3.v3.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/rickshaw/rickshaw.min.js"></script>
<script type='text/javascript' src='../../resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
<script type='text/javascript' src='../../resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>
<script type='text/javascript' src='../../resources/js/plugins/bootstrap/bootstrap-datepicker.js'></script>
<script type="text/javascript" src="../../resources/js/plugins/owl/owl.carousel.min.js"></script>

<script type="text/javascript" src="../../resources/js/plugins/moment.min.js"></script>
<script type="text/javascript" src="../../resources/js/plugins/daterangepicker/daterangepicker.js"></script>
<!-- END THIS PAGE PLUGINS-->

<!-- START TEMPLATE -->
<script type="text/javascript" src="../../resources/js/settings.js"></script>

<script type="text/javascript" src="../../resources/js/plugins.js"></script>
<script type="text/javascript" src="../../resources/js/actions.js"></script>

<script type="text/javascript" src="../../resources/js/demo_dashboard.js"></script>
<script src="../../resources/js/plugins/jquery/jquery.min.js"></script>
<script src="../../resources/js/plugins/jquery/jquery.form.js"></script>
<script src="../../resources/js/custom.js"></script>

<script>
    $(document).ready(function () {
        $('#loading').hide();
        $.getJSON("/datasets", function (json) {
            $('#myselect').empty();
            $.each(json.Files, function (i, obj) {
                $('#myselect').append($('<option>').text(obj.File_Name).attr('value', obj.val));
            });
        });
    });
</script>
<!-- END TEMPLATE -->
<!-- END SCRIPTS -->
</body>
</html>






