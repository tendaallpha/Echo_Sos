package cm.genie6.echosos.controller;

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

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosChild;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosChildService;

@Controller
public class EchoSosChildController {

	@Autowired
	private EchoSosChildService childService;
	@Autowired
	private EchoSosAccountService accountService;
	public static String childrenprofile = System.getProperty("user.dir")
			+ "/src/main/resources/static/childrenprofile";

	@GetMapping("childrenlist.html")
	public String getChildren(Model model, Principal principal) {
		EchoSosChild echoSosChild = new EchoSosChild();
		String username = principal.getName();
		EchoSosAccount user = accountService.getByUsername(Integer.parseInt(username));
		model.addAttribute("user", user);
		model.addAttribute("children", echoSosChild);
		model.addAttribute("childrenlist", childService.getAllChildren());
		return "child-list";
	}

	@PostMapping("addChild")
	public String saveSomChid(@ModelAttribute EchoSosChild child, @RequestParam("file") MultipartFile[] files)
			throws IOException {
		childService.saveChild(child, files);
		return "redirect:/childrenlist.html";
	}
}
