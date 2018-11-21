package cm.allpha.Echo_Sos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.allpha.Echo_Sos.model.EchoSosStatus;
import cm.allpha.Echo_Sos.persistence.EchoSosStatusInterface;

@Service
public class EchoSosStatusService {

	@Autowired
	private EchoSosStatusInterface statusInterface;

	public void saveStatus(EchoSosStatus status) {
		statusInterface.save(status);
	}
	
	public List<EchoSosStatus> getAllStatus(){
		return statusInterface.findAll();
	}
}
