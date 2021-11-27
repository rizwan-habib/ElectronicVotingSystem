package application;

import java.util.ArrayList;

public class VotingHandler {
	private ArrayList<Person> voters;
	private ArrayList<Candidate> candidates;
	private PersistenceHandler db=new MySQLDBHandler();
	public ArrayList<Candidate> getCandidates(){
		return db.getCandidates();
	}
	public ArrayList<Candidate> getOrderedCandidates(){
		return db.getOrderedCandidates();
	}
	public ArrayList<Double> getOrderedPercentage(){
		return db.getOrderedPercentage();
	}
	public boolean verifyVoter(int cnic) {
		voters=db.getPerson();
		boolean flag=false;
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getCnic().equals(Integer.toString(cnic) ) && voters.get(i).isVoteCasted()==false) {
				flag=true;
//				System.out.print("Hello");
			}
		}
		
		
		return flag;
	}
	public boolean verifyCandidate(String name) {
		candidates=db.getCandidates();
		boolean flag=false;
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i).getName().equals(name )) {
				flag=true;
//				System.out.print("Hello");
			}
		}
		
		
		return flag;
	}
	
	public void registerCandidate(String na,int ag,String addres,String cn,String pr) throws Exception{
		try {
			db.registerCandidate(na,ag,addres,cn,pr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
	}
	public void voteCast(String cnic,String cName) throws Exception {
		try {
			db.voteCasted(cnic,cName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
		
	}
	public void registerParty(String name) throws Exception{
		try {
			db.addParty(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
	}
}
