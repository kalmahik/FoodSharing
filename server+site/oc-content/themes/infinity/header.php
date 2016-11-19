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
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="<?php echo str_replace('_', '-', osc_current_user_locale()); ?>">
    <head>
	
        <?php osc_current_web_theme_path('common/head.php') ; ?>
		
    </head>
	<body <?php infinity_body_class(); ?>>
<div id="header">
    <div class="wrapper">
        <div id="logo">
            <?php echo logo_header(); ?>
            <span id="description"><?php echo osc_page_description(); ?></span>
        </div>
        <ul class="nav">
            <?php if( osc_is_static_page() || osc_is_contact_page() ){ ?>
                <li class="search"><a class="ico-search icons" data-bclass-toggle="display-search"></a></li>
                <li class="cat"><a class="ico-menu icons" data-bclass-toggle="display-cat"></a></li>
            <?php } ?>
            <?php if( osc_users_enabled() ) { ?>
            <?php if( osc_is_web_user_logged_in() ) { ?>
                <li class="first logged">
                    <span><?php echo sprintf(__('Hi %s', 'infinity'), osc_logged_user_name() . '!'); ?>  &middot;</span>
                    <strong><a href="<?php echo osc_user_dashboard_url(); ?>"><?php _e('My account', 'infinity'); ?></a></strong> &middot;
                    <a href="<?php echo osc_user_logout_url(); ?>"><?php _e('Logout', 'infinity'); ?></a>
                </li>
            <?php } else { ?>
                <li><a id="login_open" href="<?php echo osc_user_login_url(); ?>"><?php _e('Login', 'infinity') ; ?></a></li>
                <?php if(osc_user_registration_enabled()) { ?>
                    <li><a href="<?php echo osc_register_account_url() ; ?>"><?php _e('Register for a free account', 'infinity'); ?></a></li>
                <?php }; ?>
            <?php } ?>
            <?php } ?>
            <?php if( osc_users_enabled() || ( !osc_users_enabled() && !osc_reg_user_post() )) { ?>
            <li class="publish"><a href="<?php echo osc_item_post_url_in_category() ; ?>"><?php _e("Publish your ad for free", 'infinity');?></a></li>
            <?php } ?>
        </ul>
    </div>
       <form action="<?php echo osc_base_url(true); ?>" method="get" class="search nocsrf" <?php /* onsubmit="javascript:return doSearch();"*/ ?>>
        <input type="hidden" name="page" value="search"/>
        <div class="main-search">
            <div class="cell">
                <input type="text" name="sPattern" id="query" class="input-text" value="" placeholder="<?php echo osc_esc_html(__(osc_get_preference('keyword_placeholder', 'infinity_theme'), 'infinity')); ?>" />
            </div>
            <?php  if ( osc_count_categories() ) { ?>
               
                <div class="cell reset-padding">
            <?php  } else { ?>
                <div class="cell">
            <?php  } ?>
                <button class="ui-button ui-button-big js-submit"><?php _e("Search", 'infinity');?></button>
            </div>
        </div>
        <div id="message-seach"></div>
    </form>
   </div>
<div class="wrapper wrapper-flash">
    <?php
        $breadcrumb = osc_breadcrumb('&raquo;', false, get_breadcrumb_lang());
        if( $breadcrumb !== '') { ?>
        <div class="breadcrumb">
            <?php echo $breadcrumb; ?>
            <div class="clear"></div>
        </div>
    <?php
        }
    ?>
    <?php osc_show_flash_message(); ?>
</div>







<link href="<?php echo osc_current_web_theme_url('css/style.css') ; ?>?<?php echo rand(0, pow(10, 5)); ?>" rel="stylesheet" type="text/css" />

<script type="text/javascript">
(function(e,t,n,r){function o(r,i){var o=this;o.options=e.extend({},s,i);o.parent=r;o.wrapper=o.parent.children();o.slides=o.wrapper.children();o.currentSlide=0;o.CSS3support=true;o.options.beforeInit.call(o);o.init();o.build();o.play();if(o.options.touchDistance){o.swipe()}if(o.options.keyboard){e(n).on("keyup",function(e){if(e.keyCode===39)o.slide(1);if(e.keyCode===37)o.slide(-1)})}if(o.options.hoverpause){o.parent.add(o.arrows).add(o.nav).on("mouseover mouseout",function(e){o.pause();if(e.type==="mouseout")o.play()})}e(t).on("resize",function(){o.init();o.slide(0)});o.options.afterInit.call(o);return{current:function(){return-o.currentSlide+1},play:function(){o.play()},pause:function(){o.pause()},next:function(e){o.slide(1,false,e)},prev:function(e){o.slide(-1,false,e)},jump:function(e,t){o.slide(e-1,true,t)},nav:function(e){if(o.navWrapper){o.navWrapper.remove()}o.options.nav=e?e:o.options.nav;o.navigation()},arrows:function(e){if(o.arrowsWrapper){o.arrowsWrapper.remove()}o.options.arrows=e?e:o.options.arrows;o.arrows()}}}function u(e){var i=false,s="Khtml ms O Moz Webkit".split(" "),o=n.createElement("div"),u=null;e=e.toLowerCase();if(o.style[e]!==r)i=true;if(i===false){u=e.charAt(0).toUpperCase()+e.substr(1);for(var a=0;a<s.length;a++){if(o.style[s[a]+u]!==r){i=true;break}}}if(t.opera){if(t.opera.version()<13)i=false}return i}var i="glide",s={autoplay:4e3,hoverpause:true,animationTime:500,arrows:true,arrowsWrapperClass:"slider-arrows",arrowMainClass:"slider-arrow",arrowRightClass:"slider-arrow--right",arrowRightText:"next",arrowLeftClass:"slider-arrow--left",arrowLeftText:"prev",nav:true,navCenter:true,navClass:"slider-nav",navItemClass:"slider-nav__item",navCurrentItemClass:"slider-nav__item--current",keyboard:true,touchDistance:60,beforeInit:function(){},afterInit:function(){},beforeTransition:function(){},afterTransition:function(){}};o.prototype.build=function(){var e=this;if(e.options.arrows)e.arrows();if(e.options.nav)e.navigation()};o.prototype.navigation=function(){var t=this;if(t.slides.length>1){var n=t.options,r=t.options.nav===true?t.parent:t.options.nav;t.navWrapper=e("<div />",{"class":n.navClass}).appendTo(r);var i=t.navWrapper,s;for(var o=0;o<t.slides.length;o++){s=e("<a />",{href:"#","class":n.navItemClass,"data-distance":o}).appendTo(i);i[o+1]=s}var u=i.children();u.eq(0).addClass(n.navCurrentItemClass);if(n.navCenter){i.css({left:"50%",width:u.outerWidth(true)*u.length,"margin-left":-i.outerWidth(true)/2})}u.on("click touchstart",function(n){n.preventDefault();t.slide(e(this).data("distance"),true)})}};o.prototype.arrows=function(){var t=this;if(t.slides.length>1){var n=t.options,r=t.options.arrows===true?t.parent:t.options.arrows;t.arrowsWrapper=e("<div />",{"class":n.arrowsWrapperClass}).appendTo(r);var i=t.arrowsWrapper;i.right=e("<a />",{href:"#","class":n.arrowMainClass+" "+n.arrowRightClass,"data-distance":"1",html:n.arrowRightText}).appendTo(i);i.left=e("<a />",{href:"#","class":n.arrowMainClass+" "+n.arrowLeftClass,"data-distance":"-1",html:n.arrowLeftText}).appendTo(i);i.children().on("click touchstart",function(n){n.preventDefault();t.slide(e(this).data("distance"),false)})}};o.prototype.slide=function(e,t,n){var r=this;r.pause();r.options.beforeTransition.call(r);var i=t?0:r.currentSlide,s=-(r.slides.length-1),o=r.options.navCurrentItemClass,u=r.slides.spread;if(i===0&&e===-1){i=s}else if(i===s&&e===1){i=0}else{i=i+ -e}var a=u*i+"px";if(r.CSS3support){r.wrapper.css({"-webkit-transform":"translate3d("+a+", 0px, 0px)","-moz-transform":"translate3d("+a+", 0px, 0px)","-ms-transform":"translate3d("+a+", 0px, 0px)","-o-transform":"translate3d("+a+", 0px, 0px)",transform:"translate3d("+a+", 0px, 0px)"})}else{r.wrapper.stop().animate({"margin-left":a},r.options.animationTime)}if(r.options.nav&&r.navWrapper){r.navWrapper.children().eq(-i).addClass(o).siblings().removeClass(o)}r.currentSlide=i;r.options.afterTransition.call(r);if(n!=="undefined"&&typeof n==="function")n();r.play()};o.prototype.play=function(){var e=this;if(e.options.autoplay){e.auto=setInterval(function(){e.slide(1,false)},e.options.autoplay)}};o.prototype.pause=function(){var e=this;if(e.options.autoplay){e.auto=clearInterval(e.auto)}};o.prototype.swipe=function(){var e=this,t,n,r,i,s,o,u,a,f,l=180/Math.PI,c,h,p,d;e.parent.on("touchstart",function(e){t=e.originalEvent.touches[0]||e.originalEvent.changedTouches[0];r=t.pageX;i=t.pageY});e.parent.on("touchmove",function(e){t=e.originalEvent.touches[0]||e.originalEvent.changedTouches[0];s=t.pageX;o=t.pageY;c=s-r;h=o-i;p=Math.abs(c<<2);d=Math.abs(h<<2);u=Math.sqrt(p+d);a=Math.sqrt(d);f=Math.asin(a/u);if(f*l<32)e.preventDefault()});e.parent.on("touchend",function(i){t=i.originalEvent.touches[0]||i.originalEvent.changedTouches[0];n=t.pageX-r;if(n>e.options.touchDistance){e.slide(-1)}else if(n<-e.options.touchDistance){e.slide(1)}})};o.prototype.init=function(){var e=this,t=e.parent.width();e.slides.spread=t;e.wrapper.width(t*e.slides.length);e.slides.width(e.slides.spread);if(!u("transition")||!u("transform"))e.CSS3support=false};e.fn[i]=function(t){return this.each(function(){if(!e.data(this,"api_"+i)){e.data(this,"api_"+i,new o(e(this),t))}})}})(jQuery,window,document)
</script>

    <div class="wrapper">
 <?php if( osc_is_home_page()  ) { ?>  
	<div class="slider">
			<ul class="slides">
				<li class="image1"></li>
				<li class="image2"></li>
				<li class="image3"></li>
				<li class="image4"></li>
			</ul>
		</div>
</div>
		<script type="text/javascript">
			var glide = $('.slider').glide().data('api_glide');

				$(window).on('keyup', function (key) {
					if (key.keyCode === 13) {
						glide.jump(3, console.log('Wooo!'));
					};
				});

				$('.slider-arrow').on('click', function() {
					console.log(glide.current());
				});
		</script>
		 <?php
        }
    ?>
	
</div>	
	













<?php osc_run_hook('before-content'); ?>
<div class="wrapper" id="content">
    <?php osc_run_hook('before-main'); ?>
    <div id="main">
        <?php osc_run_hook('inside-main'); ?>
		<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:700' rel='stylesheet' type='text/css'>
		
		<script type="text/javascript">
    $(document).ready(function(){
 
        $(window).scroll(function(){
            if ($(this).scrollTop() > 600) {
                $('.scrollup').fadeIn();
            } else {
                $('.scrollup').fadeOut();
            }
        });
 
        $('.scrollup').click(function(){
            $("html, body").animate({ scrollTop: 0 }, 600);
            return false;
        });
 
    });
</script>