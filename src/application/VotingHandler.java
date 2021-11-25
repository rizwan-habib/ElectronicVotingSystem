package application;

import java.util.ArrayList;

public class VotingHandler {
	private ArrayList<Person> voters;
	private PersistenceHandler db=new MySQLDBHandler();
	public boolean verifyVoter(int cnic) {
		voters=db.getPerson();
		boolean flag=false;
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getCnic().equals(Integer.toString(cnic) ) && voters.get(i).isVoteCasted()==false) {
				flag=true;
				System.out.print("Hello");
			}
		}
		
		
		return flag;
	}
	public void voteCast(String cnic) {
		db.voteCasted(cnic);
	}
	public void registerParty(String name){
		db.addParty(name);
	}
}
