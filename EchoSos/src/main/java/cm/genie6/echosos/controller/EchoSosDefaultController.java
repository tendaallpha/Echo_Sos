package cm.genie6.echosos.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosArticle;
import cm.genie6.echosos.model.EchoSosComment;
import cm.genie6.echosos.model.EchoSosStatus;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosArticleService;
import cm.genie6.echosos.service.EchoSosMailService;
import cm.genie6.echosos.service.EchoSosPlanningService;
import cm.genie6.echosos.service.EchoSosStatusService;

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
	public static final String LOADGALLERY = System.getProperty("user.dir") + "/src/main/resources/static/gallery/";
	public static final String HOME = "redirect:/home";
	@Autowired
	private EchoSosMailService mailService;
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
		return "page";
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
	public String getArticle(Model model, Principal principal, @RequestParam("block") Optional<Integer> block) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("articles", articleService.getAllArticles());
		model.addAttribute("status", statusService.getAllStatus());
		List<EchoSosAccount> accounts = accountService.getAllAccount();
		accounts.remove(user);
		model.addAttribute("accounts", accounts);
		if (block.isPresent()) {
			EchoSosAccount receiver = accountService.getIdAccount(block.get());
			model.addAttribute("center", receiver);
			model.addAttribute("mails", mailService.getMailsBetween(user, receiver));
		}
		
		return "home";
	}

	@PostMapping("commentstatus")
	public String commentStatus(@RequestParam("owner") Integer owner,
			@RequestParam("statusid") Integer statusid, @RequestParam("comment") String comment) {
		EchoSosAccount accountowner= accountService.getIdAccount(owner);
		EchoSosStatus statusowner = statusService.getIdStatus(statusid);
		EchoSosComment addcomments = new EchoSosComment(null, comment,null,accountowner, statusowner);
		statusowner.getComments().add(addcomments);
		statusService.saveStatus(statusowner);
		return HOME;
	}

	@PostMapping("commentarticle")
	public String commentArticle(@RequestParam("owner") Integer owner,
			@RequestParam("articleid") Integer articleid, @RequestParam("comment") String comment) {
		EchoSosAccount ownerid = accountService.getIdAccount(owner);
		EchoSosArticle article = articleService.getIdArticle(articleid);
		EchoSosComment addcomments = new EchoSosComment(null, comment, article, ownerid, null);
		article.getComments().add(addcomments);
		articleService.addArticle(article);
		return HOME;
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

	private static List<String> filesOfFolders() {
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