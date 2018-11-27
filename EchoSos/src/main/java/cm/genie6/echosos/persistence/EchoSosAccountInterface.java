package cm.genie6.echosos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.genie6.echosos.model.EchoSosAccount;

public interface EchoSosAccountInterface extends JpaRepository<EchoSosAccount, Integer> {
	
	EchoSosAccount findByCphone(int phone);
	List<EchoSosAccount> findByStatus(String account);
	List<EchoSosAccount> findByCnameContaining(String name);
}
