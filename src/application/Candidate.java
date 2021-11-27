package application;

public class Candidate {
	private String name,address,cnic;
	private int age,votes;
	private Party party;
	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	public Candidate(String name, String address, String cnic, int age, int votes, Party party) {
		super();
		this.name = name;
		this.address = address;
		this.cnic = cnic;
		this.age = age;
		this.votes = votes;
		this.party = party;
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
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	
}
