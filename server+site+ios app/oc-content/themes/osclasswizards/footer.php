<?php
    /*
     *      Osclass – software for creating and publishing online classified
     *                           advertising platforms
     *
     *                        Copyright (C) 2014 OSCLASS
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
</div>
</div>
<?php osc_run_hook('after-main'); ?>
</div>
<?php osc_show_widgets('footer');?>

<footer id="footer">
  <div class="container">
    <div class="footer">
      <?php ?>
      <?php if ( osc_count_web_enabled_locales() > 1) { ?>
      <?php osc_goto_first_locale(); ?>
      <strong>
      <?php _e('Language:', OSCLASSWIZARDS_THEME_FOLDER); ?>
      </strong>
      <ul>
        <?php $i = 0;  ?>
        <?php while ( osc_has_web_enabled_locales() ) { ?>
        <li><a id="<?php echo osc_locale_code(); ?>" href="<?php echo osc_change_language_url ( osc_locale_code() ); ?>"><?php echo osc_locale_name(); ?></a></li>
        <?php if( $i == 0 ) { echo ""; } ?>
        <?php $i++; ?>
        <?php } ?>
      </ul>
      <?php } ?>
      
      <?php
            echo '<div class="copyright">' . sprintf(__('Free responsive Osclass theme by <a target="_blank" title="osclasswizards" href="%s">OsclassWizards</a>',OSCLASSWIZARDS_THEME_FOLDER), 'http://www.osclasswizards.com/') . '</div>';
        ?>
    </div>
  </div>
</footer>
<?php osc_run_hook('footer'); ?>
<?php if(osc_is_ad_page() || osc_is_search_page()){ ?>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&appId=498033263566934&version=v2.3";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<?php } ?>
</body></html>