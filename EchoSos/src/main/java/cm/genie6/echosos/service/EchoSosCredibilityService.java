package cm.genie6.echosos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.genie6.echosos.model.EchoSosCredibility;
import cm.genie6.echosos.persistence.EchoSosCredibilityInterface;

@Service
public class EchoSosCredibilityService {
	@Autowired
	private EchoSosCredibilityInterface credibilityInterface;
	
	public void saveCredibility(EchoSosCredibility credibility) {
		credibilityInterface.save(credibility);
	}
	
	public Optional<EchoSosCredibility> getCredibility(Integer id) {
		return credibilityInterface.findById(id);
	}
	
	public List<EchoSosCredibility> getAllcredibility() {
		return credibilityInterface.findAll();
	}
}