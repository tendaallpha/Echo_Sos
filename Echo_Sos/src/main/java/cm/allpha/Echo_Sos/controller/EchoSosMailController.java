package cm.allpha.Echo_Sos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cm.allpha.Echo_Sos.model.EchoSosAccount;
import cm.allpha.Echo_Sos.model.EchoSosMail;
import cm.allpha.Echo_Sos.service.EchoSosAccountService;
import cm.allpha.Echo_Sos.service.EchoSosMailService;

@Controller
public class EchoSosMailController {
	@Autowired
	private EchoSosMailService mailService;
	@Autowired
	private EchoSosAccountService accountService;

	@GetMapping("editmail.html/{id}")
	public String editMail(@PathVariable("id") Integer idreceiver, Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		// EchoSosAccount sender = accountService.getIdAccount(id);
		EchoSosAccount receiver = accountService.getIdAccount(idreceiver);
		model.addAttribute("user", user);
		model.addAttribute("mails", mailService.getMailsBetween(user, receiver));
		model.addAttribute("center", receiver);
		return "write-mail";
	}

	@GetMapping("listofcenters.html")
	public String listpersonl(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("orphanage", accountService.getAllAccount());
		return "listofcenters";
	}

	@PostMapping("/sentmail.html/{id}")
	public String setViewArticle(@PathVariable("id") Integer id, @RequestParam("content") String content, Principal principal) {
		EchoSosAccount sender =  accountService.getByUsername(Integer.parseInt(principal.getName()));
		EchoSosAccount receiver = accountService.getIdAccount(id);
		EchoSosMail mail = new EchoSosMail(null, EchoSosMail.addDate(), content, sender, receiver);
		mailService.savemails(mail);
		return "redirect:/editmail.html/" + id;
	}
}
