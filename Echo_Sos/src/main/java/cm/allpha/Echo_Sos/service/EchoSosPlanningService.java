package cm.allpha.Echo_Sos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.allpha.Echo_Sos.model.EchoSosPlanning;
import cm.allpha.Echo_Sos.persistence.EchoSosPlanningInterface;

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
