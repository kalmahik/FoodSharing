<?php

?>
</div><!-- content -->
<?php osc_run_hook('after-main'); ?>
</div>
<div id="responsive-trigger"></div>
<!-- footer -->
<div class="clear"></div>
<div id="footer">
    <div class="wrapper">
        <ul class="resp-toogle">
		<?php if( osc_users_enabled() ) { ?>
            <?php if( osc_is_web_user_logged_in() ) { ?>
                <li>
                    <?php echo sprintf(__('Hi %s', 'infinity'), osc_logged_user_name() . '!'); ?>  &middot;
                    <strong><a href="<?php echo osc_user_dashboard_url(); ?>"><?php _e('My account', 'infinity'); ?></a></strong> &middot;
                    <a href="<?php echo osc_user_logout_url(); ?>"><?php _e('Logout', 'infinity'); ?></a>
                </li>
            <?php } else { ?>
                <li><a href="<?php echo osc_user_login_url(); ?>"><?php _e('Login', 'infinity'); ?></a></li>
                <?php if(osc_user_registration_enabled()) { ?>
                    <li>
                        <a href="<?php echo osc_register_account_url(); ?>"><?php _e('Register for a free account', 'infinity'); ?></a>
                    </li>
                <?php } ?>
            <?php } ?>
            <?php } ?>
            <?php if( osc_users_enabled() || ( !osc_users_enabled() && !osc_reg_user_post() )) { ?>
            <li class="publish">
                <a href="<?php echo osc_item_post_url_in_category(); ?>"><?php _e("Publish your ad for free", 'infinity');?></a>
            </li>
            <?php } ?>
        </ul>
        <ul>
        <?php
        osc_reset_static_pages();
        while( osc_has_static_pages() ) { ?>
            <li>
                <a href="<?php echo osc_static_page_url(); ?>"><?php echo osc_static_page_title(); ?></a>
            </li>
        <?php
        }
        ?>
		
		
			
		
		
		<!-- about-box -->
<article class="about-box">
<strong class="title">Why Us...</strong>
<p>
Our website exists for one simple reason: life is busy. We are here to help: looking for a job, buying a car, selling your old bike, lining up a babysitter, or warming up to your kids' plea for a puppy.

<a href="http://www.ibthemes.com">Wanna know more?</a>
</p>
</article>
<!-- write-box -->
<article class="write-box">
<strong class="title">Wanna Sell?</strong>
<p>
Our website attracts millions and millions of unique visitors every month with hundreds of thousands of potential buyers. More than 80,000 items are For Sale on our website. Place your ads where they belongs! <a href="http://www.ibthemes.com">Post your ad, It's FREE!</a>
</p>
</article>
<!-- advertice-box -->
<article class="advertice-box">
<strong class="title">Wanna buy?</strong>
<p>
Our website is a great place to reach a targeted and engaged audience. 
Our fan-base visit us on a regular basis, ensuring your ads are noticed.
 We offer a number of banner ad solutions, as well as sponsored posts, 
reviews and tweets. <a href="http://www.ibthemes.com">Get in touch</a> to learn more.
</p>
</article>



<div class="social-networks-footer">
<div class="social-icons">
<ul>
<div>
<ul>
	<li><a href="http://www.ibthemes.com/">Home</a></li>
	<li><a href="http://www.ibthemes.com/">About</a></li>
	<li><a href="http://www.ibthemes.com/">Categories</a></li>
    <li><a href="http://www.ibthemes.com/">Archive</a></li>
	<li><a href="http://www.ibthemes.com/">Write for us</a></li>
	<li><a href="http://www.ibthemes.com/">Advertise</a></li>
	<li><a href="http://www.ibthemes.com/">Legal</a></li>
	<li><a href="http://www.ibthemes.com/">Contact</a></li>
</ul>
</div>

<li class="facebook-icon-single" >
<a href="https://www.facebook.com/">
<img src="oc-content/themes/infinity/images/fb.png"/>
</a>
</li>
<li class="twitter-icon-single" >
<a href="https://www.twitter.com/">
<img src="oc-content/themes/infinity/images/tw.png"/>
</a>
</li>
<li class="rss-icon-single" >
<a href="https://www.rss.com/">
<img src="oc-content/themes/infinity/images/rss.png"/>
</a>
</li>
<li class="googleplus-icon-single" >
<a href="https://www.google.com/">
<img src="oc-content/themes/infinity/images/g.png"/>
</a>
</li>
<li class="pinterest-icon-single">
<a href="https://www.pinterest.com/">
<img src="oc-content/themes/infinity/images/p.png"/>
</a>
</li>

</ul>


		
		
        </ul>
        <?php
        if( osc_get_preference('footer_link', 'infinity_theme') !== '0') {
            echo '<ftlnk>Website design by <a href="http://ibthemes.com/" target="_blank">IBthemes</a></ftlnk>';
        }
        ?>
        <?php if ( osc_count_web_enabled_locales() > 1) { ?>
            <?php osc_goto_first_locale(); ?>
            <strong><?php _e('Language:', 'infinity'); ?></strong>
            <?php $i = 0;  ?>
            <?php while ( osc_has_web_enabled_locales() ) { ?>
            <span><a id="<?php echo osc_locale_code(); ?>" href="<?php echo osc_change_language_url ( osc_locale_code() ); ?>"><?php echo osc_locale_name(); ?></a></span><?php if( $i == 0 ) { echo " &middot; "; } ?>
                <?php $i++; ?>
            <?php } ?>
        <?php } ?>
    </div>
</div>
<?php osc_run_hook('footer'); ?>
</body></html>


<a href="#" class="scrollup">Scroll</a>