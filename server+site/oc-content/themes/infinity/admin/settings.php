<?php if ( (!defined('ABS_PATH')) ) exit('ABS_PATH is not loaded. Direct access is not allowed.'); ?>
<?php if ( !OC_ADMIN ) exit('User access is not allowed.'); ?>
<h2 class="render-title <?php echo (osc_get_preference('footer_link', 'infinity_theme') ? '' : 'separate-top'); ?>"><?php _e('INFINITY Tweaks', 'infinity'); ?></h2>
<form action="<?php echo osc_admin_render_theme_url('oc-content/themes/infinity/admin/settings.php'); ?>" method="post" class="nocsrf">
    <input type="hidden" name="action_specific" value="settings" />
    <fieldset>
        <div class="form-horizontal">
            <div class="form-row">
                <div class="form-label"><?php _e('Searchbar Label', 'infinity'); ?></div>
                <div class="form-controls"><input type="text" class="xlarge" name="keyword_placeholder" value="<?php echo osc_esc_html( osc_get_preference('keyword_placeholder', 'infinity_theme') ); ?>"></div>
            </div>
            <div class="form-row">
                <div class="form-label"><?php _e('Show lists as:', 'infinity'); ?></div>
                <div class="form-controls">
                    <select name="defaultShowAs@all">
                        <option value="gallery" <?php if(infinity_default_show_as() == 'gallery'){ echo 'selected="selected"' ; } ?>><?php _e('Gallery','infinity'); ?></option>
                        <option value="list" <?php if(infinity_default_show_as() == 'list'){ echo 'selected="selected"' ; } ?>><?php _e('List','infinity'); ?></option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-label"><?php _e('Footer link', 'infinity'); ?></div>
                <div class="form-controls">
                    <div class="form-label-checkbox"><input type="checkbox" name="footer_link" value="1" <?php echo (osc_get_preference('footer_link', 'infinity_theme') ? 'checked' : ''); ?> > <?php _e('Add this link to my footer: ', 'infinity'); ?></div>
                    <span class="help-box"><?php _e('Website design by <a href="http://ibthemes.com/" target="_blank">IBthemes.com</a>', 'infinity'); ?></span>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" value="<?php _e('Save changes', 'infinity'); ?>" class="btn btn-submit">
            </div>
        </div>
    </fieldset>
</form>




<?php
if ( ! defined('ABS_PATH')) exit('ABS_PATH is not loaded. Direct access is not allowed.');
 ?>
 <h1>PHP INFO</h1>
<style type="text/css">

#phpinfo body, td, th, h1, h2 {font-family: sans-serif;}
#phpinfo pre {margin: 0; font-family: monospace;}
#phpinfo a:link {color: #262626; text-decoration: none; background-color: #fab023;}
#phpinfo a:hover {text-decoration: underline;}
#phpinfo table {border-collapse: collapse; width:800px;}
#phpinfo .center {text-align: center;}
#phpinfo .center table { margin-left: auto; margin-right: auto; text-align: left;}
#phpinfo .center th { text-align: center !important; }
#phpinfo td, th { border: 1px solid #262626; font-size: 100%; vertical-align: baseline;}
#phpinfo h1 {font-size: 150%;}
#phpinfo h2 {font-size: 125%;}
#phpinfo .p {text-align: left;}
#phpinfo .e {background-color: #fab023; font-weight: bold; color: #262626;}
#phpinfo .h {background-color: #fab023; font-weight: bold; color: #262626;}
#phpinfo .v {background-color: #9f9f9f; color: #262626;}
#phpinfo .vr {background-color: #9f9f9f; text-align: right; color: #262626;}
#phpinfo img {float: right; border: 0;}
#phpinfo hr {width: 1000px; background-color: #9f9f9f; border: 0; height: 1px; color: #262626;}
</style>

<div id="phpinfo">
<?php

ob_start () ;
phpinfo () ;
$pinfo = ob_get_contents () ;
ob_end_clean () ;


echo ( str_replace ( "module_Zend Optimizer", "module_Zend_Optimizer", preg_replace ( '%^.*<body>(.*)</body>.*$%ms', '$1', $pinfo ) ) ) ;

?>
</div>