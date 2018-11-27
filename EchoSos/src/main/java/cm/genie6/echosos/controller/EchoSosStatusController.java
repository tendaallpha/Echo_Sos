package cm.genie6.echosos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosStatus;
import cm.genie6.echosos.service.EchoSosAccountService;
import cm.genie6.echosos.service.EchoSosStatusService;

@Controller
public class EchoSosStatusController {

	@Autowired
	private EchoSosStatusService statusService;
	@Autowired
	private EchoSosAccountService accountService;

	public static final String STATUSIMAGES = System.getProperty("user.dir")
			+ "/src/main/resources/static/statusimages";
	public static final String HOME = "redirect:/home";

	@PostMapping("publishstatus")
	public String addStatus(@RequestParam("filests") MultipartFile[] files, @RequestParam("userid") Integer userid,
			@RequestParam("stscomment") String stscomment) throws IOException {
		EchoSosAccount owner = accountService.getIdAccount(userid);
		EchoSosStatus status = new EchoSosStatus(null, stscomment, EchoSosStatus.addDate(), 0, 0, owner);
		statusService.saveStatusWithImg(files, status);
		return HOME;
	}

	@GetMapping("incrementlovestatus/{id}")
	public String incrementLoveSts(@PathVariable("id") Integer id) {
		EchoSosStatus status = statusService.getIdStatus(id);
		status.incrementview();
		statusService.saveStatus(status);
		return HOME;
	}

	@GetMapping("incrementviewstatus/{idview}")
	public String incrementStsView(@PathVariable("idview") Integer id) {
		EchoSosStatus status = statusService.getIdStatus(id);
		status.incrementview();
		statusService.saveStatus(status);
		return HOME;
	}
}