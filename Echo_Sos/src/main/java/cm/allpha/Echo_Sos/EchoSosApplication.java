package cm.allpha.Echo_Sos;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cm.allpha.Echo_Sos.controller.EchoSosAccountController;
import cm.allpha.Echo_Sos.controller.EchoSosArticleController;
import cm.allpha.Echo_Sos.controller.EchoSosChildController;
import cm.allpha.Echo_Sos.controller.EchoSosDefaultController;
import cm.allpha.Echo_Sos.controller.EchoSosStatusController;

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
