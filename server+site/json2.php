<?php
$cat = strip_tags($_GET['cat']);
$dbnumber = '1014187';
$db = mysql_connect('localhost', $dbnumber,'ih8team');
mysql_select_db($dbnumber, $db);
if(mysql_errno() == 0) {
    mysql_set_charset('utf8');
  } else {
    echo(mysql_error());
  }





$x = $cat_id = "96";
  $max = mysql_fetch_array(mysql_query("SELECT MAX(pk_i_id) FROM oc_t_item WHERE fk_i_category_id=$x", $db));
$min = mysql_fetch_array(mysql_query("SELECT MIN(pk_i_id) FROM oc_t_item", $db));
for ($i=$min[0]; $i <= $max[0]; $i++) {
	
	$cat = mysql_fetch_array(mysql_query("SELECT fk_i_category_id FROM oc_t_item WHERE pk_i_id=$i", $db));
if($cat[0] == ''){
$i++;
}
	$title[$i] = mysql_fetch_row(mysql_query("SELECT s_title FROM oc_t_item_description WHERE fk_i_category_id=$x", $db));
	$desc = mysql_fetch_array(mysql_query("SELECT s_description FROM oc_t_item_description WHERE fk_i_category_id=$x", $db));
	$date = mysql_fetch_array(mysql_query("SELECT dt_pub_date FROM oc_t_item WHERE fk_i_category_id=$x", $db));
	$img = mysql_fetch_array(mysql_query("SELECT s_name FROM oc_t_item_resource WHERE fk_i_category_id=$x", $db));
	$limg = mysql_fetch_array(mysql_query("SELECT pk_i_id FROM oc_t_item_resource WHERE fk_i_category_id=$x", $db));
	$ext = mysql_fetch_array(mysql_query("SELECT s_extension FROM oc_t_item_resource WHERE fk_i_category_id=$x", $db));
	$link = "http://0a.by/oc-content/upload/0/".$limg[0].".".$ext[0];
	if($img[0] == ""){  $link = "no_image";
	echo $title[$i][0]."<br>";
	print_r($title[$i]);
	}
}
	?>