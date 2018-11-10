package cm.allpha.Echo_Sos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.allpha.Echo_Sos.model.EchoSosPlanning;

public interface EchoSosPlanningInterface extends JpaRepository<EchoSosPlanning, Integer> {

}
