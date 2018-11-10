package cm.allpha.Echo_Sos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cm.allpha.Echo_Sos.controller.EchoSosChildController;
import cm.allpha.Echo_Sos.model.EchoSosChild;
import cm.allpha.Echo_Sos.persistence.EchoSosChildInterface;

@Service
public class EchoSosChildService {

	@Autowired
	private EchoSosChildInterface echoSosChildInterface;

	public List<EchoSosChild> getAllChildren() {
		return echoSosChildInterface.findAll();
	}

	public void saveChild(EchoSosChild echoSosChild, MultipartFile[] files) throws IOException {
		echoSosChild = echoSosChildInterface.save(echoSosChild);
		int id = echoSosChild.getId_child();
		for (int i = 0; i < 1; i++) {
			Path fileNameAndPath = Paths.get(EchoSosChildController.childrenprofile, id + "");
			Files.write(fileNameAndPath, files[i].getBytes());
		}
	}
}
