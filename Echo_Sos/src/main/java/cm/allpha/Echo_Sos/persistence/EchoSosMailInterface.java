package cm.allpha.Echo_Sos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.allpha.Echo_Sos.model.EchoSosAccount;
import cm.allpha.Echo_Sos.model.EchoSosMail;

public interface EchoSosMailInterface extends JpaRepository<EchoSosMail, Integer> {
	List<EchoSosMail> findBySendermailsInAndReceivermailsIn(List<EchoSosAccount> sender, List<EchoSosAccount> receiver);
}
