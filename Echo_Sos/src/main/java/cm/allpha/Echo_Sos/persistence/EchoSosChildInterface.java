package cm.allpha.Echo_Sos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.allpha.Echo_Sos.model.EchoSosChild;

@Repository
public interface EchoSosChildInterface extends JpaRepository<EchoSosChild, Integer> {
	
}
