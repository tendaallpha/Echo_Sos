package cm.allpha.Echo_Sos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.allpha.Echo_Sos.model.EchoSosArticle;

public interface EchoSosArticleInterface extends JpaRepository<EchoSosArticle, Integer> {
}
