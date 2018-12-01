package cm.genie6.echosos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.genie6.echosos.model.EchoSosStatus;

public interface EchoSosStatusInterface extends JpaRepository<EchoSosStatus, Integer> {

	List<EchoSosStatus> findAllByOrderByIdstatusDesc();
}
