$(function() {
	var chat_est_replie = true, chat_etendue_hauteur = 280, chat_replie_hauteur = 20, values = $(
			"#block").val();

	if (values == "") {
		$(".chat").hide();
	} else {
		$(".chat").show();
		$(".chat-content-msg").scrollTop($(".chat-content").height()+1220);
	}

	$(".chat-header").click(function() {
		var chat = $(".chat");

		if (chat_est_replie) {
			chat.animate({
				height : chat_etendue_hauteur
			});
			chat_est_replie = false;
		} else {
			chat.animate({
				height : chat_replie_hauteur
			});
			chat_est_replie = true;
		}

	});

	$(".chat-header-closer").click(function() {
		$(".chat").hide();
	});

});
