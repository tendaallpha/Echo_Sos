package cm.allpha.Echo_Sos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class EchoSosStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idstatus;
	private String stscontent;
	private Date date;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownerstatus")
	private EchoSosAccount ownerstatus;

	public EchoSosStatus() {
	}

	public EchoSosStatus(Integer idstatus, String stscontent, Date date, EchoSosAccount ownerstatus) {
		super();
		this.idstatus = idstatus;
		this.stscontent = stscontent;
		this.date = date;
		this.ownerstatus = ownerstatus;
	}

	public Integer getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(Integer idstatus) {
		this.idstatus = idstatus;
	}

	public String getStscontent() {
		return stscontent;
	}

	public void setStscontent(String stscontent) {
		this.stscontent = stscontent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EchoSosAccount getOwnerstatus() {
		return ownerstatus;
	}

	public void setOwnerstatus(EchoSosAccount ownerstatus) {
		this.ownerstatus = ownerstatus;
	}

}