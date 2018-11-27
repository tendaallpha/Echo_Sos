package cm.genie6.echosos.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class EchoSosArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_article;
	private String title;
	private String color;
	private String content;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "propritaire")
	private List<EchoSosComment> comments = new ArrayList<EchoSosComment>();
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownerarticle")
	private EchoSosAccount ownerarticle;
	private Integer love = 0;
	private String date;

	public EchoSosArticle() {
	}

	public EchoSosArticle(String title, String content, EchoSosAccount ownerarticle) {
		super();
		this.title = title;
		this.content = content;
		this.ownerarticle = ownerarticle;
	}

	public Integer getId_article() {
		return id_article;
	}

	public void setId_article(Integer id_article) {
		this.id_article = id_article;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<EchoSosComment> getComments() {
		return comments;
	}

	public void setComments(List<EchoSosComment> comments) {
		this.comments = comments;
	}

	public EchoSosAccount getOwnerarticle() {
		return ownerarticle;
	}

	public void setOwnerarticle(EchoSosAccount ownerarticle) {
		this.ownerarticle = ownerarticle;
	}

	public Integer getLove() {
		return love;
	}

	public void setLove(Integer love) {
		this.love = love;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void addLove() {
		EchoSosArticle article = new EchoSosArticle();
		if (article.getLove().equals(0) || !article.getLove().equals(0)) {
			love = love + 1;
		} else {
			love = love + 0;
		}
	}

	public static String addDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return dateFormat.format(date);
	}
}