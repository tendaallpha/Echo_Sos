package cm.genie6.echosos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.genie6.echosos.model.EchoSosArticle;

public interface EchoSosArticleInterface extends JpaRepository<EchoSosArticle, Integer> {
}
