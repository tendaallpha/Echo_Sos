package cm.genie6.echosos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.genie6.echosos.model.EchoSosChild;

@Repository
public interface EchoSosChildInterface extends JpaRepository<EchoSosChild, Integer> {
	
}
