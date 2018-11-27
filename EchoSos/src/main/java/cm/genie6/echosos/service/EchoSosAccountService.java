package cm.genie6.echosos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cm.genie6.echosos.controller.EchoSosAccountController;
import cm.genie6.echosos.controller.EchoSosDefaultController;
import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosMail;
import cm.genie6.echosos.persistence.EchoSosAccountInterface;
import cm.genie6.echosos.persistence.EchoSosMailInterface;

@Service
public class EchoSosAccountService implements UserDetailsService {

	@Autowired
	private EchoSosAccountInterface accountInterface;
	@Autowired
	private EchoSosMailInterface mailInterface;

	public List<EchoSosAccount> getAllAccount() {
		return accountInterface.findAll();
	}

	public List<EchoSosMail> getAllMailOfAccount() {
		return mailInterface.findAll();
	}

	public List<EchoSosAccount> getAllOrphanage() {
		return accountInterface.findByStatus("ORPHANAGE");
	}

	public List<EchoSosAccount> searching(String element) {
		try {
			int phone = Integer.parseInt(element);
			return Arrays.asList(accountInterface.findByCphone(phone));
		} catch (NumberFormatException e) {
			return accountInterface.findByCnameContaining(element);
		}

	}

	public void addAccount(MultipartFile[] files, EchoSosAccount account) throws IOException {
		account = accountInterface.save(account);
		int id = account.getId_account();
		for (int i = 0; i < 1; i++) {
			Path fileNameAndPath = Paths.get(EchoSosAccountController.profileDirectry, id + "");
			Files.write(fileNameAndPath, files[i].getBytes());
		}
	}

	public void uploadGallery(MultipartFile[] files, String username) throws IOException {
		EchoSosAccount user = getByUsername(Integer.parseInt(username));
		int id = user.getId_account();
		StringBuilder filesNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(EchoSosDefaultController.LOADGALLERY.concat(id + ""),
					file.getOriginalFilename());
			filesNames.append(file.getOriginalFilename());
			Files.write(fileNameAndPath, file.getBytes());
		}

	}

	public void addAccountwithmail(EchoSosAccount account) {
		accountInterface.save(account);
	}

	public EchoSosAccount getIdAccount(Integer id) {
		return accountInterface.findById(id).get();
	}

	public EchoSosAccount getByUsername(int phone) {
		return accountInterface.findByCphone(phone);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EchoSosAccount user = getByUsername(Integer.parseInt(username));
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getStatus());
		return new org.springframework.security.core.userdetails.User(username, user.getCpassword(),
				Arrays.asList(authority));
	}

}
