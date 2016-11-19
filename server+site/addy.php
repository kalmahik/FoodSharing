<?php
mysql_set_charset('utf8');
$cat = strip_tags($_GET['cat']);
$dbnumber = '1014187';
$db = mysql_connect('localhost', $dbnumber,'ih8team');
mysql_select_db($dbnumber, $db);
if(mysql_errno() == 0) {
    mysql_set_charset('utf8');
  } else {
    echo(mysql_error());
  }



$previous_id = mysql_fetch_array(mysql_query("SELECT MAX(pk_i_id) FROM oc_t_item", $db));
$pkid = $previous_id[0]+1;
$date = date("Y-m-d h:i:s");
//$unique = strip_tags($_GET['unique']);
$email = strip_tags($_GET['email']);
$name = strip_tags($_GET['name']);
$ip = "127.0.0.1";
$title = strip_tags($_GET['title']);
$description = strip_tags($_GET['description']);
if(isset($email) && isset($name) && isset($title) && isset($description)){
mysql_query("INSERT INTO oc_t_item (s_ip, dt_pub_date, pk_i_id, fk_i_category_id, s_contact_name, b_enabled, b_active) VALUES ('$ip', '$date', '$pkid', '$cat', '$name', '1', '1')", $db);
mysql_query("INSERT INTO oc_t_item_description (fk_c_locale_code, fk_i_item_id, fk_c_locale_code, s_title, s_description) VALUES ('ru_RU', '$pkid', 'ru_RU', '$title', '$description')", $db);
//mysql_query("INSERT INTO oc_t_item_resource (fk_i_category_id, s_contact_name, b_enabled, b_active) VALUES ('$cat', '$name', '1', '1')", $db);

}
else{
	echo 'Request error.';
}



