package cm.allpha.Echo_Sos.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.allpha.Echo_Sos.model.EchoSosAccount;
import cm.allpha.Echo_Sos.model.EchoSosArticle;
import cm.allpha.Echo_Sos.service.EchoSosAccountService;
import cm.allpha.Echo_Sos.service.EchoSosArticleService;

@Controller
public class EchoSosArticleController {

	@Autowired
	private EchoSosArticleService echoSosArticleService;
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

	@PostMapping("addArticle")
	public String addArticleWithImg(@ModelAttribute EchoSosArticle echoSosArticle,
			@RequestParam("file") MultipartFile[] files, @RequestParam("userid") Integer userid) throws IOException {
		EchoSosAccount owner = accountService.getIdAccount(userid);
		echoSosArticle.setOwnerarticle(owner);
		echoSosArticle.setDate(echoSosArticle.addDate());
		echoSosArticleService.addArticleWithImage(files, echoSosArticle);
		return "redirect:/addArticle";
	}

}