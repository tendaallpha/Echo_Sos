package cm.genie6.echosos;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cm.genie6.echosos.controller.EchoSosAccountController;
import cm.genie6.echosos.controller.EchoSosArticleController;
import cm.genie6.echosos.controller.EchoSosChildController;
import cm.genie6.echosos.controller.EchoSosDefaultController;
import cm.genie6.echosos.controller.EchoSosStatusController;

@SpringBootApplication
public class EchoSosApplication {

	public static void main(String[] args) {
		File file = new File(EchoSosArticleController.uploadDirectry);
		file.mkdir();
		File fileProfile = new File(EchoSosAccountController.profileDirectry);
		fileProfile.mkdir();
		File filegallery = new File(EchoSosDefaultController.LOADGALLERY);
		filegallery.mkdir();
		File filechildrenprofile = new File(EchoSosChildController.childrenprofile);
		filechildrenprofile.mkdir();
		File filestatusimg= new File(EchoSosStatusController.STATUSIMAGES);
		filestatusimg.mkdir();

		System.out.println(file.getAbsolutePath());

		SpringApplication.run(EchoSosApplication.class, args);
	}
}
