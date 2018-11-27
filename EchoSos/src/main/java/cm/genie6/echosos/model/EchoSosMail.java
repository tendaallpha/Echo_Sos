package cm.genie6.echosos.model;

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
@Table(name = "mail")
public class EchoSosMail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mail;
	private String date;
	private String content;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "sendermails")
	private EchoSosAccount sendermails;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "receivermails")
	private EchoSosAccount receivermails;

	public EchoSosMail() {
	}

	public EchoSosMail(Integer id_mail, String date, String content, EchoSosAccount sendermails,
			EchoSosAccount reseiverermails) {
		super();
		this.id_mail = id_mail;
		this.content = content;
		this.date = date;
		this.sendermails = sendermails;
		this.receivermails = reseiverermails;
	}

	public Integer getId_mail() {
		return id_mail;
	}

	public void setId_mail(Integer id_mail) {
		this.id_mail = id_mail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public EchoSosAccount getSendermail() {
		return sendermails;
	}

	public void setSendermail(EchoSosAccount sendermails) {
		this.sendermails = sendermails;
	}

	public String getDate() {
		return date;
	}

	public EchoSosAccount getSendermails() {
		return sendermails;
	}

	public void setSendermails(EchoSosAccount sendermails) {
		this.sendermails = sendermails;
	}

	public EchoSosAccount getReceivermails() {
		return receivermails;
	}

	public void setReceivermails(EchoSosAccount receivermails) {
		this.receivermails = receivermails;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setReceiverermail(EchoSosAccount receiverermails) {
		this.receivermails = receiverermails;
	}

	public static String addDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return dateFormat.format(date);
	}

}