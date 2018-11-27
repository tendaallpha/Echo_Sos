package cm.genie6.echosos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosPlanning;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosPlanningService;

@Controller
public class EchoSosPlanningController {

	@Autowired
	private EchoSosPlanningService planningService;
	@Autowired
	private EchoSosAccountService accountService;

	@GetMapping("planning.html")
	public String getPlanning(Model model, Principal principal) {
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("planningEnter", new EchoSosPlanning());
		model.addAttribute("plannings", planningService.getPlanning());
		return "planning";
	}

	@PostMapping("submitPlanning.html")
	public String setPlanning(@ModelAttribute EchoSosPlanning planning) {
		planningService.savePlanning(planning);
		return "redirect:/planning.html";
	}

}
