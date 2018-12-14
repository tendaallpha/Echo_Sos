package cm.genie6.echosos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosMail;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosMailService;

@Controller
public class EchoSosMailController {
	@Autowired
	private EchoSosMailService mailService;
	@Autowired
	private EchoSosAccountService accountService;

	@GetMapping("chatwith/{idreceiver}")
	public String editMail(@PathVariable("idreceiver") Integer idreceiver, Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		return "redirect:/home?"+"block="+idreceiver;
	}

	@PostMapping("/sentmail")
	public String setViewArticle(@RequestParam("idreceiver") Integer id, @RequestParam("content") String content,
			Principal principal) {
		EchoSosAccount sender = accountService.getByUsername(Integer.parseInt(principal.getName()));
		EchoSosAccount receiver = accountService.getIdAccount(id);
		EchoSosMail mail = new EchoSosMail(null, EchoSosMail.addDate(), content, sender, receiver);
		mailService.savemails(mail);
		return "redirect:/home?"+"block="+id;
	}
}
