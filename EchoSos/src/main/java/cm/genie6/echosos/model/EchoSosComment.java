package cm.genie6.echosos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class EchoSosComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_comment;
	private String text;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_article", name = "propritaire")
	private EchoSosArticle propritaire;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "userowner")
	private EchoSosAccount userowner;

	public EchoSosComment() {
	}

	public EchoSosComment(Integer id_comment, String text, EchoSosArticle propritaire, EchoSosAccount userowner) {
		super();
		this.id_comment = id_comment;
		this.text = text;
		this.propritaire = propritaire;
		this.userowner = userowner;
	}

	public Integer getId_comment() {
		return id_comment;
	}

	public void setId_comment(Integer id_comment) {
		this.id_comment = id_comment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public EchoSosArticle getPropritaire() {
		return propritaire;
	}

	public void setPropritaire(EchoSosArticle propritaire) {
		this.propritaire = propritaire;
	}

	public EchoSosAccount getUserowner() {
		return userowner;
	}

	public void setUserowner(EchoSosAccount userowner) {
		this.userowner = userowner;
	}

}
