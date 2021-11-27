package application;

import java.util.ArrayList;

public abstract class PersistenceHandler {
	public abstract void save ();
	public abstract void voteCasted(String cnic,String cName) throws Exception;
	public abstract ArrayList<Person> getPerson ();
	public abstract void addParty(String name) throws Exception;
	public abstract void registerCandidate(String na,int ag,String addres,String cn,String pr) throws Exception;
	public abstract ArrayList<Candidate> getCandidates();
	public abstract ArrayList<Candidate> getOrderedCandidates();
	public abstract ArrayList<Double> getOrderedPercentage();
}
