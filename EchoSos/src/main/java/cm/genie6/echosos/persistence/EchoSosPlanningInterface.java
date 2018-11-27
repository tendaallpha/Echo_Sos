package cm.genie6.echosos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.genie6.echosos.model.EchoSosPlanning;

public interface EchoSosPlanningInterface extends JpaRepository<EchoSosPlanning, Integer> {

}
