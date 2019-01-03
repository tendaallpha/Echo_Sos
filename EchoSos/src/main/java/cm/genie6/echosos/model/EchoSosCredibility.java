package cm.genie6.echosos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credibility")
public class EchoSosCredibility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcredibility;
	private long know;
	private long visited;
	private long publication;
	private long ordinaryform;
	private long completion;
	private long recommandation;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownercredibility")
	private EchoSosAccount ownercredibility;

	public EchoSosCredibility() {
		super();
	}

	public EchoSosCredibility(Integer idcredibility, EchoSosAccount ownercredibility) {
		super();
		this.idcredibility = idcredibility;
		this.ownercredibility = ownercredibility;
	}

	public Integer getIdcredibility() {
		return idcredibility;
	}

	public void setIdcredibility(Integer idcredibility) {
		this.idcredibility = idcredibility;
	}

	public long getKnow() {
		return know;
	}

	public void setKnow(long know) {
		this.know = know;
	}

	public long getVisited() {
		return visited;
	}

	public void setVisited(long visited) {
		this.visited = visited;
	}

	public long getPublication() {
		return publication;
	}

	public void setPublication(long publication) {
		this.publication = publication;
	}

	public long getOrdinaryform() {
		return ordinaryform;
	}

	public void setOrdinaryform(long ordinaryform) {
		this.ordinaryform = ordinaryform;
	}

	public long getCompletion() {
		return completion;
	}

	public void setCompletion(long completion) {
		this.completion = completion;
	}

	public long getRecommandation() {
		return recommandation;
	}

	public void setRecommandation(long recommandation) {
		this.recommandation = recommandation;
	}

	public EchoSosAccount getOwnercredibility() {
		return ownercredibility;
	}

	public void setOwnercredibility(EchoSosAccount ownercredibility) {
		this.ownercredibility = ownercredibility;
	}

}