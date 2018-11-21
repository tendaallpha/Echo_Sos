package cm.allpha.Echo_Sos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cm.allpha.Echo_Sos.controller.EchoSosArticleController;
import cm.allpha.Echo_Sos.model.EchoSosArticle;
import cm.allpha.Echo_Sos.persistence.EchoSosArticleInterface;

@Service
public class EchoSosArticleService {

	@Autowired
	private EchoSosArticleInterface articleInterface;

	public List<EchoSosArticle> getAllArticles() {
		return articleInterface.findAll();
	}

	public EchoSosArticle addArticle(EchoSosArticle echoSosArticle) {
		return articleInterface.save(echoSosArticle);
	}

	public void addArticleWithImage(MultipartFile[] files, EchoSosArticle echoSosArticle) throws IOException{

		echoSosArticle = articleInterface.save(echoSosArticle);
		int id = echoSosArticle.getId_article();
		for (int i = 0; i < 1; i++) {
			Path fileNameAndPath = Paths.get(EchoSosArticleController.uploadDirectry, id + "");
			Files.write(fileNameAndPath, files[i].getBytes());
		}
	}

	public EchoSosArticle getIdArticle(Integer id) {
		return articleInterface.findById(id).get();
	}

}
