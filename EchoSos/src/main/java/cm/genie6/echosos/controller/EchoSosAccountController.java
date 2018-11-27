package cm.genie6.echosos.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosArticleService;

@Controller
public class EchoSosAccountController {

	@Autowired
	private EchoSosAccountService accountService;
	@Autowired
	private EchoSosArticleService articleService;
	public static String profileDirectry = System.getProperty("user.dir") + "/src/main/resources/static/profileImages";

	@GetMapping("inscription")
	public String getNewAccount() {
		return "inscription";
	}

	@GetMapping("authentificationView")
	public String getAuthentificationView() {
		return "page-login";
	}

	@GetMapping("sponsoring.html")
	public String getSponsoringAccount(Model model) {
		model.addAttribute("sponsoring", new EchoSosAccount());
		return "sponsor-form";
	}

	@GetMapping("orphanInscription")
	public String getNewOrphanAccount(Model model) {
		model.addAttribute("orphanaccount", new EchoSosAccount());
		return "orphan-form";
	}

	@GetMapping("sponsor.html")
	public String getListSponsor(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("sponsor", accountService.getAllAccount());
		return "sponsor";
	}

	@GetMapping("orphanageList")
	public String getListAccount(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("orphanage", accountService.getAllOrphanage());
		return "accounts-list";
	}
	@PostMapping("searching")
	public String searchAccount(@RequestParam("search") String elements, Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("orphanage", accountService.searching(elements));
		return "accounts-list";
	}

	@PostMapping("addAccount")
	public String addPersonalAccount(@ModelAttribute EchoSosAccount orphanAccount,
			@RequestParam("file") MultipartFile[] files) throws IOException {

		String passinit = orphanAccount.getCpassword();
		String passencrypt = new BCryptPasswordEncoder().encode(passinit);
		orphanAccount.setCpassword(passencrypt);

		accountService.addAccount(files, orphanAccount);
		return "redirect:/authentificationView";
	}

	@GetMapping("selfpage.html/{id}")
	public String getSelfpage(@PathVariable("id") Integer id, Model model, Principal principal) {
		EchoSosAccount account = accountService.getIdAccount(id);
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("account", account);
		model.addAttribute("articles", articleService.getAllArticles());
		return "background";
	}

}