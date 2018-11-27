package cm.genie6.echosos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.genie6.echosos.model.EchoSosPlanning;
import cm.genie6.echosos.persistence.EchoSosPlanningInterface;

@Service
public class EchoSosPlanningService {
	@Autowired
	EchoSosPlanningInterface planningInterface;

	public void savePlanning(EchoSosPlanning planning) {
		planningInterface.save(planning);
	}

	public List<EchoSosPlanning> getPlanning() {
		return planningInterface.findAll();
	}
}
