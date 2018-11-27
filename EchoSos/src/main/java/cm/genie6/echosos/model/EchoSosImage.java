package cm.genie6.echosos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class EchoSosImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_image;
	private String name;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "accountowner")
	private EchoSosAccount accountowner;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_article", name = "articleowner")
	private EchoSosArticle articleowner;

	public EchoSosImage() {
	}

	public EchoSosImage(Integer id_image, String name /*, EchoSosAccount accountowner*/, EchoSosArticle articleowner) {
		super();
		this.id_image = id_image;
		this.name = name;
		/*this.accountowner = accountowner;*/
		this.articleowner = articleowner;
	}

	public Integer getId_image() {
		return id_image;
	}

	public void setId_image(Integer id_image) {
		this.id_image = id_image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EchoSosAccount getAccountowner() {
		return accountowner;
	}

	public void setAccountowner(EchoSosAccount accountowner) {
		this.accountowner = accountowner;
	}

	public EchoSosArticle getArticleowner() {
		return articleowner;
	}

	public void setArticleowner(EchoSosArticle articleowner) {
		this.articleowner = articleowner;
	}

}
