<?php
$dbnumber = '';
$db = mysql_connect('localhost', $dbnumber,'ih8team');
mysql_select_db($dbnumber, $db);
$vk_imgs = mysql_fetch_array(mysql_query("SELECT vk_img FROM oc_t_item WHERE pk_i_id=$aid", $db));
$imgurl = $vk_imgs[0];
while ( osc_has_latest_items() ) {
if(osc_count_item_resources()) { 
$img = osc_resource_thumbnail_url();
}
else{
$img = osc_current_web_theme_url('images/no_photo.gif');
}

$url = osc_item_url(); 
$title= osc_item_title();
$cat_id = osc_item_category_id();
$cat_name = osc_item_category(); 
$date = osc_format_date(osc_item_pub_date()); 
$desc = osc_item_description();
 }          

$array = array('url'=>$url, 'title'=>$title, 'cat_id'=>$cat_id, 'cat_name'=>$cat_name, 'date'=>$date, 'desc'=>$desc, 'img'=>$img);

echo json_encode($array);

//mysql_fetch_array(mysql_query("SELECT pk_i_id FROM oc_t_item ORDER BY pk_i_id DESC", $db));
?>
