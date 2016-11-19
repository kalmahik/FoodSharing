<?php

if(isset($_POST['user'])){
	echo ("Logged In");
}

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Slide to Login Captcha Demo</title>
<!--
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery-ui-1.9.0.custom.min.js"></script>
-->
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js"></script>

<link href="slidetl.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
<div id="container">
<h1 align="center">Slide to Login </h1>
<h2 align="center">By: ManZzup (http://manzzup.blogspot.com) </h2><h3 align="center"> Download http://zontek.zzl.org/files/slidetl.zip</h3>
<form id="form1" action="index.php" method="post">
Username : <input type="text" value="admin" name="user" /><br />
Password :  <input type="password" value="admin" name="user" />
<br /><br />
<div id="slidetl">
	<div id="slider"></div>
</div>

</form>

<script type="text/javascript" src="slidetl.js"></script>

</div>

</body>
</html>
