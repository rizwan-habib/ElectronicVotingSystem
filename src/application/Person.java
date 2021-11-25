package application;

public class Person {
	private String cnic,name,address;
	private int age;
	private boolean voteCasted;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String cnic, String name, String address, int age, boolean vote) {
		super();
		this.voteCasted=vote;
		this.cnic = cnic;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isVoteCasted() {
		return voteCasted;
	}
	public void setVoteCasted(boolean voteCasted) {
		this.voteCasted = voteCasted;
	}
	
}
