package cm.genie6.echosos.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosArticle;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosArticleService;

@Controller
public class EchoSosArticleController {

	@Autowired
	private EchoSosArticleService articleService;
	@Autowired
	private EchoSosAccountService accountService;
	public static String uploadDirectry = System.getProperty("user.dir") + "/src/main/resources/static/uploads";

	@GetMapping("addArticle")
	public String addArticle(Model model, Principal principal) {
		EchoSosArticle echoSosArticle = new EchoSosArticle();
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("addArticle", echoSosArticle);
		return "addArticle";
	}

	@GetMapping("incrementarticlelove/{id}")
	public String incrementArticleLove(@PathVariable("id") Integer id) {
		EchoSosArticle article = articleService.getIdArticle(id);
		article.addLove();
		articleService.addArticle(article);
		return "redirect:/home";
	}

	@PostMapping("addArticle")
	public String addArticleWithImg(@ModelAttribute EchoSosArticle article,
			@RequestParam("file") MultipartFile[] files, @RequestParam("userid") Integer userid) throws IOException {
		EchoSosAccount owner = accountService.getIdAccount(userid);
		article.setOwnerarticle(owner);
		article.setDate(EchoSosArticle.addDate());
		articleService.addArticleWithImage(files, article);
		return "redirect:/addArticle";
	}

}