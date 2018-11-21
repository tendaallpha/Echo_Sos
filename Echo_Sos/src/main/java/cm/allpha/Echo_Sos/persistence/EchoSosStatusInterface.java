package cm.allpha.Echo_Sos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.allpha.Echo_Sos.model.EchoSosStatus;

public interface EchoSosStatusInterface extends JpaRepository<EchoSosStatus, Integer> {

}
