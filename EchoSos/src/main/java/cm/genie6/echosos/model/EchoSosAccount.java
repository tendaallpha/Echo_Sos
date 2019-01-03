package cm.genie6.echosos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class EchoSosAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_account;
	private String cname;
	private String ccity;
	private String ccountry;
	private String cpassword;
	private String ccreatingdate;
	private int cphone;
	private String cvalidation;
	private String chistory;
	private String pnationality;
	private String pfirstname;
	private String plastname;
	private long pphone;
	private String psex;
	private long pcni;
	private String status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerarticle")
	private List<EchoSosArticle> articles = new ArrayList<EchoSosArticle>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sendermails")
	private List<EchoSosMail> sendermails = new ArrayList<EchoSosMail>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerplanning")
	private List<EchoSosPlanning> plannings = new ArrayList<EchoSosPlanning>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerchildren")
	private List<EchoSosChild> children = new ArrayList<EchoSosChild>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userowner")
	private List<EchoSosComment> comments = new ArrayList<EchoSosComment>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receivermails")
	private List<EchoSosMail> receivermails = new ArrayList<EchoSosMail>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerstatus")
	private List<EchoSosStatus> ownerstatus = new ArrayList<EchoSosStatus>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownercredibility")
	private List<EchoSosCredibility> ownercredibility = new ArrayList<EchoSosCredibility>();

	public EchoSosAccount() {
	}

	public EchoSosAccount(Integer id_account, String cname, String ccity, String ccountry, String cpassword,
			String ccreatingdate, int cphone, String cvalidation, String chistory, String pnationality,
			String pfirstname, String plastname, long pphone, String psex, long pcni, String status) {
		super();
		this.id_account = id_account;
		this.cname = cname;
		this.ccity = ccity;
		this.ccountry = ccountry;
		this.cpassword = cpassword;
		this.ccreatingdate = ccreatingdate;
		this.cphone = cphone;
		this.cvalidation = cvalidation;
		this.chistory = chistory;
		this.pnationality = pnationality;
		this.pfirstname = pfirstname;
		this.plastname = plastname;
		this.pphone = pphone;
		this.psex = psex;
		this.pcni = pcni;
		this.status = status;
	}

	public Integer getId_account() {
		return id_account;
	}

	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getCcountry() {
		return ccountry;
	}

	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCcreatingdate() {
		return ccreatingdate;
	}

	public void setCcreatingdate(String ccreatingdate) {
		this.ccreatingdate = ccreatingdate;
	}

	public int getCphone() {
		return cphone;
	}

	public void setCphone(int cphone) {
		this.cphone = cphone;
	}

	public String getCvalidation() {
		return cvalidation;
	}

	public void setCvalidation(String cvalidation) {
		this.cvalidation = cvalidation;
	}

	public String getPnationality() {
		return pnationality;
	}

	public void setPnationality(String pnationality) {
		this.pnationality = pnationality;
	}

	public String getPfirstname() {
		return pfirstname;
	}

	public void setPfirstname(String pfirstname) {
		this.pfirstname = pfirstname;
	}

	public String getPlastname() {
		return plastname;
	}

	public void setPlastname(String plastname) {
		this.plastname = plastname;
	}

	public long getPphone() {
		return pphone;
	}

	public void setPphone(long pphone) {
		this.pphone = pphone;
	}

	public String getPsex() {
		return psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public long getPcni() {
		return pcni;
	}

	public void setPcni(long pcni) {
		this.pcni = pcni;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChistory() {
		return chistory;
	}

	public void setChistory(String chistory) {
		this.chistory = chistory;
	}

	public List<EchoSosArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<EchoSosArticle> articles) {
		this.articles = articles;
	}

	public List<EchoSosMail> getSendermails() {
		return sendermails;
	}

	public void setSendermails(List<EchoSosMail> sendermails) {
		this.sendermails = sendermails;
	}

	public List<EchoSosPlanning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<EchoSosPlanning> plannings) {
		this.plannings = plannings;
	}

	public List<EchoSosChild> getChildren() {
		return children;
	}

	public void setChildren(List<EchoSosChild> children) {
		this.children = children;
	}

	public List<EchoSosComment> getComments() {
		return comments;
	}

	public void setComments(List<EchoSosComment> comments) {
		this.comments = comments;
	}

	public List<EchoSosMail> getReceivermails() {
		return receivermails;
	}

	public void setReceivermails(List<EchoSosMail> receivermails) {
		this.receivermails = receivermails;
	}

	public List<EchoSosStatus> getOwnerstatus() {
		return ownerstatus;
	}

	public void setOwnerstatus(List<EchoSosStatus> ownerstatus) {
		this.ownerstatus = ownerstatus;
	}

	public List<EchoSosCredibility> getOwnercredibility() {
		return ownercredibility;
	}

	public void setOwnercredibility(List<EchoSosCredibility> ownercredibility) {
		this.ownercredibility = ownercredibility;
	}

}