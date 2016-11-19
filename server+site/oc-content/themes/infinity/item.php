<?php
    /*
     *      Osclass – software for creating and publishing online classified
     *                           advertising platforms
     *
     *                        Copyright (C) 2013 OSCLASS
     *
     *       This program is free software: you can redistribute it and/or
     *     modify it under the terms of the GNU Affero General Public License
     *     as published by the Free Software Foundation, either version 3 of
     *            the License, or (at your option) any later version.
     *
     *     This program is distributed in the hope that it will be useful, but
     *         WITHOUT ANY WARRANTY; without even the implied warranty of
     *        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     *             GNU Affero General Public License for more details.
     *
     *      You should have received a copy of the GNU Affero General Public
     * License along with this program.  If not, see <http://www.gnu.org/licenses/>.
     */

    // meta tag robots
    osc_add_hook('header','infinity_follow_construct');

    osc_enqueue_script('fancybox');
    osc_enqueue_style('fancybox', osc_current_web_theme_url('js/fancybox/jquery.fancybox.css'));
    osc_enqueue_script('jquery-validate');

    infinity_add_body_class('item');
    osc_add_hook('after-main','sidebar');
    function sidebar(){
        osc_current_web_theme_path('item-sidebar.php');
    }

    $location = array();
    if( osc_item_city_area() !== '' ) {
        $location[] = osc_item_city_area();
    }
    if( osc_item_city() !== '' ) {
        $location[] = osc_item_city();
    }
    if( osc_item_region() !== '' ) {
        $location[] = osc_item_region();
    }
    if( osc_item_country() !== '' ) {
        $location[] = osc_item_country();
    }

    osc_current_web_theme_path('header.php');
?>
<div id="item-content">
        <h1><?php if( osc_price_enabled_at_items() ) { ?><span class="price"><?php echo osc_item_formated_price(); ?></span> <?php } ?><strong><?php echo osc_item_title() . ' ' . osc_item_city(); ?></strong></h1>
        <div class="item-header">
            <div>
                <?php if ( osc_item_pub_date() !== '' ) { printf( __('<strong class="publish">Published date</strong>: %1$s', 'infinity'), osc_format_date( osc_item_pub_date() ) ); } ?>
            </div>
            <div>
                <?php if ( osc_item_mod_date() !== '' ) { printf( __('<strong class="update">Modified date:</strong> %1$s', 'infinity'), osc_format_date( osc_item_mod_date() ) ); } ?>
            </div>
            <ul id="item_location">
                <li><strong><?php _e("Location", 'infinity'); ?></strong>: <?php echo implode(', ', $location); ?></li>
            </ul>
        </div>
        <?php if(osc_is_web_user_logged_in() && osc_logged_user_id()==osc_item_user_id()) { ?>
            <p id="edit_item_view">
                <strong>
                    <a href="<?php echo osc_item_edit_url(); ?>" rel="nofollow"><?php _e('Edit item', 'infinity'); ?></a>
                </strong>
            </p>
        <?php } ?>


    <?php if( osc_images_enabled_at_items() ) { ?>
        <?php
        if( osc_count_item_resources() > 0 ) {
            $i = 0;
        ?>
        <div class="item-photos">
            <a href="<?php echo osc_resource_url(); ?>" class="main-photo" title="<?php _e('Image', 'infinity'); ?> <?php echo $i+1;?> / <?php echo osc_count_item_resources();?>">
                <img src="<?php echo osc_resource_url(); ?>" alt="<?php echo osc_item_title(); ?>" title="<?php echo osc_item_title(); ?>" />
            </a>
            <div class="thumbs">
                <?php for ( $i = 0; osc_has_item_resources(); $i++ ) { ?>
                <a href="<?php echo osc_resource_url(); ?>" rel="image_group" title="<?php _e('Image', 'infinity'); ?> <?php echo $i+1;?> / <?php echo osc_count_item_resources();?>">
                    <img src="<?php echo osc_resource_thumbnail_url(); ?>" width="75" alt="<?php echo osc_item_title(); ?>" title="<?php echo osc_item_title(); ?>" />
                </a>
                <?php } ?>
            </div>
        </div>
        <?php } ?>
    <?php } ?>
    <div id="description">
        <p><?php echo osc_item_description(); ?></p>
        <div id="custom_fields">
            <?php if( osc_count_item_meta() >= 1 ) { ?>
                <br />
                <div class="meta_list">
                    <?php while ( osc_has_item_meta() ) { ?>
                        <?php if(osc_item_meta_value()!='') { ?>
                            <div class="meta">
                                <strong><?php echo osc_item_meta_name(); ?>:</strong> <?php echo osc_item_meta_value(); ?>
                            </div>
                        <?php } ?>
                    <?php } ?>
                </div>
            <?php } ?>
        </div>
        <?php osc_run_hook('item_detail', osc_item() ); ?>
        <p class="contact_button">
            <?php if( !osc_item_is_expired () ) { ?>
            <?php if( !( ( osc_logged_user_id() == osc_item_user_id() ) && osc_logged_user_id() != 0 ) ) { ?>
                <?php     if(osc_reg_user_can_contact() && osc_is_web_user_logged_in() || !osc_reg_user_can_contact() ) { ?>
                    <a href="#contact" class="ui-button ui-button-middle ui-button-main resp-toogle"><?php _e('Contact seller', 'infinity'); ?></a>
                <?php     } ?>
            <?php     } ?>
            <?php } ?>
			 <form action="<?php echo osc_base_url(true); ?>" method="post" name="mask_as_form" id="mask_as_form">
            <input type="hidden" name="id" value="<?php echo osc_item_id(); ?>" />
            <input type="hidden" name="as" value="spam" />
            <input type="hidden" name="action" value="mark" />
            <input type="hidden" name="page" value="item" />
            <select name="as" id="as" class="mark_as">
                    <option><?php _e("Mark as...", 'infinity'); ?></option>
                    <option value="spam"><?php _e("Mark as spam", 'infinity'); ?></option>
                    <option value="badcat"><?php _e("Mark as misclassified", 'infinity'); ?></option>
                    <option value="repeated"><?php _e("Mark as duplicated", 'infinity'); ?></option>
                    <option value="expired"><?php _e("Mark as expired", 'infinity'); ?></option>
                    <option value="offensive"><?php _e("Mark as offensive", 'infinity'); ?></option>
            </select>
        </form>
           <a href="<?php echo osc_item_send_friend_url(); ?>" rel="nofollow" class="ui-button ui-button-middle"><?php _e('Share', 'infinity'); ?></a>
		   
		  
		   
		   
        </p>
        <?php osc_run_hook('location'); ?>
    </div>
    <!-- plugins -->
    <div id="useful_info" class="bordered-box">
        <h2><?php _e('Useful information', 'infinity'); ?></h2>
        <ul>
            <li><?php _e('Avoid scams by acting locally or paying with PayPal', 'infinity'); ?></li>
            <li><?php _e('Never pay with Western Union, Moneygram or other anonymous payment services', 'infinity'); ?></li>
            <li><?php _e('Don\'t buy or sell outside of your country. Don\'t accept cashier cheques from outside your country', 'infinity'); ?></li>
            <li><?php _e('This site is never involved in any transaction, and does not handle payments, shipping, guarantee transactions, provide escrow services, or offer "buyer protection" or "seller certification"', 'infinity'); ?></li>
        </ul>
    </div>

        <?php related_listings(); ?>
        <?php if( osc_count_items() > 0 ) { ?>
        <div class="similar_ads">
            <h2><?php _e('Related listings', 'infinity'); ?></h2>
            <?php
            View::newInstance()->_exportVariableToView("listType", 'items');
            osc_current_web_theme_path('loop.php');
            ?>
            <div class="clear"></div>
        </div>
    <?php } ?>
   

<div id="disqus_thread"></div>
    <script type="text/javascript">
        /* * * DISQUS ADVANCED COMMENTING SYSTEM* * */
        var disqus_shortname = 'zoogliads'; // required: replace ZOOGLIADS with your DISQUS NAME

        /* * * DON'T EDIT BELOW THIS LINE * * */
        (function() {
            var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
            dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
            (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
        })();
    </script>
    <noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comment.</a></noscript>
    <a href="http://disqus.com" class="dsq-brlink"> <span class="logo-disqus"></span></a>
    
    
    
    
   
  
</div>
<?php osc_current_web_theme_path('footer.php') ; ?>