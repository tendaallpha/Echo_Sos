package cm.genie6.echosos.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosMail;
import cm.genie6.echosos.persistence.EchoSosMailInterface;

@Service
public class EchoSosMailService {

	@Autowired
	private EchoSosMailInterface mailInterface;

	public List<EchoSosMail> getAllMail() {
		return mailInterface.findAll();
	}

	public EchoSosMail getIdMail(Integer id) {
		return mailInterface.findById(id).get();
	}

	public void savemails(EchoSosMail mail) {
		mailInterface.save(mail);
	}

	public List<EchoSosMail> getMailsBetween(EchoSosAccount sender, EchoSosAccount receiver) {
		List<EchoSosAccount> persons = Arrays.asList(sender, receiver);
		return mailInterface.findBySendermailsInAndReceivermailsIn(persons, persons);
	}

}
