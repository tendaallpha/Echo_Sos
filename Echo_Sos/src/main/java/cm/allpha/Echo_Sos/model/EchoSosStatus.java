package cm.allpha.Echo_Sos.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private String date;
	private int love = 0;
	private int view = 0;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownerstatus")
	private EchoSosAccount ownerstatus;

	public EchoSosStatus() {
	}

	public EchoSosStatus(Integer idstatus, String stscontent, String date, int love, int view,
			EchoSosAccount ownerstatus) {
		super();
		this.idstatus = idstatus;
		this.stscontent = stscontent;
		this.date = date;
		this.love = love;
		this.view = view;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public EchoSosAccount getOwnerstatus() {
		return ownerstatus;
	}

	public void setOwnerstatus(EchoSosAccount ownerstatus) {
		this.ownerstatus = ownerstatus;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public static String addDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return dateFormat.format(date);
	}

	public void addLove() {
		EchoSosStatus sts = new EchoSosStatus();
		sts.getLove();
		if (sts.equals(0) || !sts.equals(0)) {
			love = love + 1;
		} else {
			love = love + 0;
		}
	}
	
	public void incrementview() {
		EchoSosStatus sts = new EchoSosStatus();
		sts.getView();
		if (sts.equals(0) || !sts.equals(0)) {
			view = view + 1;
		} else {
			view = view + 0;
		}
	}

}