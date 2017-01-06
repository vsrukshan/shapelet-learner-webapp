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
</head>
<body>
<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">


    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>