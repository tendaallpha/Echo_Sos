package cm.genie6.echosos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.genie6.echosos.model.EchoSosAccount;
import cm.genie6.echosos.model.EchoSosMail;

@Repository
public interface EchoSosMailInterface extends JpaRepository<EchoSosMail, Integer> {
	List<EchoSosMail> findBySendermailsInAndReceivermailsIn(List<EchoSosAccount> sender, List<EchoSosAccount> receiver);
}
