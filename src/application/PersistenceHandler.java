package application;

import java.util.ArrayList;

public abstract class PersistenceHandler {
	public abstract void save ();
	public abstract void voteCasted(String cnic);
	public abstract ArrayList<Person> getPerson ();
	public abstract void addParty(String name);
}
