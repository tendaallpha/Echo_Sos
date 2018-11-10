//package cm.allpha.Echo_Sos.model;
//
//import java.io.Serializable;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.MappedSuperclass;
//
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class EchoSosPerson implements Serializable {
//
//	private static final long serialVersionUID = -7042003192365484358L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id_person;
//	protected String name;
//	private String firstName;
//	private int phone;
//	private String town;
//	private String sex;
//	private String image;
//
//	public EchoSosPerson(int id_person, String name, String firstName, int phone, String town, String sex, String image) {
//		super();
//		this.id_person = id_person;
//		this.name = name;
//		this.firstName = firstName;
//		this.phone = phone;
//		this.town = town;
//		this.sex = sex;
//		this.image = image;
//	}
//
//	public EchoSosPerson() {
//	}
//
//	public int getId_person() {
//		return id_person;
//	}
//
//	public void setId_person(int id_person) {
//		this.id_person = id_person;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public int getPhone() {
//		return phone;
//	}
//
//	public void setPhone(int phone) {
//		this.phone = phone;
//	}
//
//	public String getTown() {
//		return town;
//	}
//
//	public void setTown(String town) {
//		this.town = town;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//	
//
//}
