package cm.allpha.Echo_Sos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cm.allpha.Echo_Sos.model.EchoSosAccount;
import cm.allpha.Echo_Sos.model.EchoSosStatus;
import cm.allpha.Echo_Sos.service.EchoSosAccountService;
import cm.allpha.Echo_Sos.service.EchoSosStatusService;

@Controller
public class EchoSosStatusController {

	@Autowired
	private EchoSosStatusService statusService;
	@Autowired
	private EchoSosAccountService accountService;

	@PostMapping("publishstatus")
	public String addStatus(@RequestParam("userid") Integer userid, @RequestParam("stscomment") String stscomment) {
		EchoSosAccount owner = accountService.getIdAccount(userid);
		EchoSosStatus status = new EchoSosStatus(null, stscomment, new Date(), owner);
		statusService.saveStatus(status);
		return "redirect:/home";
	}

}