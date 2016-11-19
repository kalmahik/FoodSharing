$(document).ready(function(){
    $(".opt_delete_account a").click(function(){
        $("#dialog-delete-account").dialog('open');
    });

    $("#dialog-delete-account").dialog({
        autoOpen: false,
        modal: true,
        buttons: [
            {
                text: infinity.langs.delete,
                click: function() {
                    window.location = infinity.base_url + '?page=user&action=delete&id=' + infinity.user.id  + '&secret=' + infinity.user.secret;
                }
            },
            {
                text: infinity.langs.cancel,
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });
});