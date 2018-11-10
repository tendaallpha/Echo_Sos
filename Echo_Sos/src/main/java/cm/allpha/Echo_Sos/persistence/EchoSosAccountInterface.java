package cm.allpha.Echo_Sos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.allpha.Echo_Sos.model.EchoSosAccount;

public interface EchoSosAccountInterface extends JpaRepository<EchoSosAccount, Integer> {
	
	EchoSosAccount findByCphone(int phone);
	List<EchoSosAccount> findByStatus(String account);
	List<EchoSosAccount> findByCnameContaining(String name);
}
