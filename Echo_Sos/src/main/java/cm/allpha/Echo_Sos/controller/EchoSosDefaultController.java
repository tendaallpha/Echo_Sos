package cm.allpha.Echo_Sos.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.allpha.Echo_Sos.model.EchoSosAccount;
import cm.allpha.Echo_Sos.model.EchoSosArticle;
import cm.allpha.Echo_Sos.model.EchoSosComment;
import cm.allpha.Echo_Sos.service.EchoSosAccountService;
import cm.allpha.Echo_Sos.service.EchoSosArticleService;
import cm.allpha.Echo_Sos.service.EchoSosPlanningService;
import cm.allpha.Echo_Sos.service.EchoSosStatusService;

@Controller
public class EchoSosDefaultController {

	@Autowired
	private EchoSosArticleService articleService;
	@Autowired
	private EchoSosStatusService statusService;
	@Autowired
	private EchoSosPlanningService planningService;
	@Autowired
	private EchoSosAccountService accountService;
	public static String LOADGALLERY = System.getProperty("user.dir") + "/src/main/resources/static/gallery/";

	@GetMapping("authentification")
	public String getAuthentification() {
		return "page-login";
	}

	@GetMapping("selfpage")
	public String getSelfpage(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("plannings", planningService.getPlanning());
		return "background";
	}

	@GetMapping("gallery.html")
	public String getGallery(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		return "gallery";
	}

	@GetMapping("associationview")
	public String getAssociationView(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("articles", articleService.getAllArticles());
		return "associatioviewmain";
	}

	@GetMapping({ "/", "home" })
	public String getArticle(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("articles", articleService.getAllArticles());
		model.addAttribute("status", statusService.getAllStatus());
		return "home";
	}

	@PostMapping("home.com")
	public String setViewArticleComment(@RequestParam("userid") Integer userid,
			@RequestParam("articleid") Integer articleid, @RequestParam("comment") String comment) {
		EchoSosAccount owner = accountService.getIdAccount(userid);
		EchoSosArticle article = articleService.getIdArticle(articleid);
		EchoSosComment addcomments = new EchoSosComment(null, comment, article, owner);
		article.getComments().add(addcomments);
		articleService.addArticle(article);
		return "redirect:/home";
	}

	@GetMapping("getgallery")
	public String galleryLoader(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("loading", filesOfFolders());
		return "gallery";
	}

	@PostMapping("uploadgallery.html?successupload")
	public String uploadGallery(@RequestParam("file") MultipartFile[] files, Principal principal) throws IOException {
		String username = principal.getName();
		accountService.uploadGallery(files, username);
		return "redirect:/getgallery";
	}

	private List<String> filesOfFolders() {
		File folder = new File(LOADGALLERY);
		File[] contents = folder.listFiles();
		List<String> results = new ArrayList<>();

		for (File element : contents) {
			if (element.isFile()) {
				results.add("/gallery/" + element.getName());
			}
		}
		return results;
	}

}