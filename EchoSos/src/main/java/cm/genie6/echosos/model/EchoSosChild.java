package cm.genie6.echosos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "child")
public class EchoSosChild {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_child;
	private String firstname;
	private String lastname;
	private String birthday;
	private String sex;
	private String sponsored;
	private String description;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_account", name = "ownerchildren")
	private EchoSosAccount ownerchildren;

	public EchoSosChild() {
	}

	public EchoSosChild(Integer id_child, String firstname, String lastname, String birthday, String sex,
			String sponsored, String description, EchoSosAccount ownerchildren) {
		super();
		this.id_child = id_child;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.sex = sex;
		this.sponsored = sponsored;
		this.description = description;
		this.ownerchildren = ownerchildren;
	}

	public Integer getId_child() {
		return id_child;
	}

	public void setId_child(Integer id_child) {
		this.id_child = id_child;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSponsored() {
		return sponsored;
	}

	public void setSponsored(String sponsored) {
		this.sponsored = sponsored;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EchoSosAccount getOwnerchildren() {
		return ownerchildren;
	}

	public void setOwnerchildren(EchoSosAccount ownerchildren) {
		this.ownerchildren = ownerchildren;
	}

	
	
}
