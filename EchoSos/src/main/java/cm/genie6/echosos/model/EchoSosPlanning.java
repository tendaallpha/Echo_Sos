package cm.genie6.echosos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planning")
public class EchoSosPlanning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_planning;
	private String timeb;
	private String timee;
	private String acmonday;
	private String actursday;
	private String acwednesday;
	private String acthursday;
	private String acfriday;
	private String acsaturday;
	private String acsunday;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownerplanning")
	private EchoSosAccount ownerplanning;

	public EchoSosPlanning() {
	}

	public EchoSosPlanning(Integer id_planning, String timeb, String timee, String acmonday, String actursday,
			String acwednesday, String acthursday, String acfriday, String acsaturday, String acsunday,
			EchoSosAccount ownerplanning) {
		super();
		this.id_planning = id_planning;
		this.timeb = timeb;
		this.timee = timee;
		this.acmonday = acmonday;
		this.actursday = actursday;
		this.acwednesday = acwednesday;
		this.acthursday = acthursday;
		this.acfriday = acfriday;
		this.acsaturday = acsaturday;
		this.acsunday = acsunday;
		this.ownerplanning = ownerplanning;
	}

	public Integer getId_planning() {
		return id_planning;
	}

	public void setId_planning(Integer id_planning) {
		this.id_planning = id_planning;
	}

	public String getTimeb() {
		return timeb;
	}

	public void setTimeb(String timeb) {
		this.timeb = timeb;
	}

	public String getTimee() {
		return timee;
	}

	public void setTimee(String timee) {
		this.timee = timee;
	}

	public String getAcmonday() {
		return acmonday;
	}

	public void setAcmonday(String acmonday) {
		this.acmonday = acmonday;
	}

	public String getActursday() {
		return actursday;
	}

	public void setActursday(String actursday) {
		this.actursday = actursday;
	}

	public String getAcwednesday() {
		return acwednesday;
	}

	public void setAcwednesday(String acwednesday) {
		this.acwednesday = acwednesday;
	}

	public String getActhursday() {
		return acthursday;
	}

	public void setActhursday(String acthursday) {
		this.acthursday = acthursday;
	}

	public String getAcfriday() {
		return acfriday;
	}

	public void setAcfriday(String acfriday) {
		this.acfriday = acfriday;
	}

	public String getAcsaturday() {
		return acsaturday;
	}

	public void setAcsaturday(String acsaturday) {
		this.acsaturday = acsaturday;
	}

	public String getAcsunday() {
		return acsunday;
	}

	public void setAcsunday(String acsunday) {
		this.acsunday = acsunday;
	}

	public EchoSosAccount getOwnerplanning() {
		return ownerplanning;
	}

	public void setOwnerplanning(EchoSosAccount ownerplanning) {
		this.ownerplanning = ownerplanning;
	}

}
