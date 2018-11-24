package cm.allpha.Echo_Sos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cm.allpha.Echo_Sos.controller.EchoSosStatusController;
import cm.allpha.Echo_Sos.model.EchoSosStatus;
import cm.allpha.Echo_Sos.persistence.EchoSosStatusInterface;

@Service
public class EchoSosStatusService {

	@Autowired
	private EchoSosStatusInterface statusInterface;

	public List<EchoSosStatus> getAllStatus() {
		return statusInterface.findAll();
	}

	public void saveStatus(EchoSosStatus status) {
		statusInterface.save(status);
	}

	public void saveStatusWithImg(MultipartFile[] files, EchoSosStatus status) throws IOException {
		status = statusInterface.save(status);
		int id = status.getIdstatus();
		for (int i = 0; i < 1; i++) {
			Path fileNameAndPath = Paths.get(EchoSosStatusController.STATUSIMAGES, id + "");
			Files.write(fileNameAndPath, files[i].getBytes());
		}
	}

	public EchoSosStatus getIdStatus(Integer id) {
		return statusInterface.findById(id).get();
	}
}
