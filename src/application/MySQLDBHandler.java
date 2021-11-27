package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Person;
import application.PersistenceHandler;
public class MySQLDBHandler extends PersistenceHandler {

	public MySQLDBHandler() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub


	}
	public ArrayList<Person> getPerson () {
		// TODO Auto-generated method stub
		ArrayList<Person> persons=new ArrayList<Person>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement st=con.createStatement();
			st.execute("use VotingSystem");
			
			Statement st1=con.createStatement();
			ResultSet res= st1.executeQuery("select * from Person");
			
			while (res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" "+res.getBoolean(5));
				Person p =new Person(Integer.toString(res.getInt(1)), res.getString(2), res.getString(3), res.getInt(4),res.getBoolean(5));
				persons.add(p);
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
		return persons;
	}
	public void voteCasted(String cnic,String cName) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement sta=con.createStatement();
			sta.execute("use VotingSystem");
			
			
			
			String sql="update person set voteCasted = 1 where cnic=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, cnic);
			int rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.print("Done");
			}
			String sql1="update candidates set votes = votes+1 where name=?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setString(1, cName);
			int rowsUpdated1=stmt1.executeUpdate();
			if (rowsUpdated1>0) {
				System.out.print("Done");
			}
			String sql2="update parties set votes = votes+1 where name=(select party from candidates where name=?)";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setString(1, cName);
			int rowsUpdated2=stmt2.executeUpdate();
			if (rowsUpdated2>0) {
				System.out.print("Done");
			}
			
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new Exception();
		}
		catch (SQLException e) {
			// TODO: handle exception
			throw new Exception();
		}
	}
	public ArrayList<Candidate> getCandidates(){
		ArrayList<Candidate> candidates=new ArrayList<Candidate>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement st=con.createStatement();
			st.execute("use VotingSystem");
			
			Statement st1=con.createStatement();
			ResultSet res= st1.executeQuery("select * from Candidates");
			
			while (res.next()) {
//				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" "+res.getBoolean(5));
				Party p=new Party(res.getString(6));
				Candidate c =new Candidate(res.getString(2), res.getString(4), res.getString(1), res.getInt(3),res.getInt(5),p);
				candidates.add(c);
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
		return candidates;
	}
	public ArrayList<Candidate> getOrderedCandidates(){
		ArrayList<Candidate> candidates=new ArrayList<Candidate>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement st=con.createStatement();
			st.execute("use VotingSystem");
			
			Statement st1=con.createStatement();
			ResultSet res= st1.executeQuery("select * from Candidates order by votes desc");
			
			while (res.next()) {
//				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" "+res.getBoolean(5));
				Party p=new Party(res.getString(6));
				Candidate c =new Candidate(res.getString(2), res.getString(4), res.getString(1), res.getInt(3),res.getInt(5),p);
				candidates.add(c);
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
		return candidates;
	}
	public ArrayList<Double> getOrderedPercentage(){
		ArrayList<Double> candidates=new ArrayList<Double>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement st=con.createStatement();
			st.execute("use VotingSystem");
			
			Statement st1=con.createStatement();
			ResultSet res= st1.executeQuery("select (votes/sum(votes)over()*100.0) vote  from candidates order by vote desc;");
			
			while (res.next()) {
//				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" "+res.getBoolean(5));
//				Party p=new Party(res.getString(6));
//				Candidate c =new Candidate(res.getString(2), res.getString(4), res.getString(1), res.getInt(3),res.getInt(5),p);
				candidates.add(res.getDouble(1));
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
		return candidates;
	}
	@Override
	public void addParty(String name) throws Exception {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement sta=con.createStatement();
			sta.execute("use VotingSystem");
			

			
			String sql="insert into parties (name,votes) values (? , 0)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			int rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.print("Done");
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new Exception();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
			throw new Exception();
		}
	}
	public void registerCandidate(String na,int ag,String addres,String cn,String pr) throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("1\n");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","janjua123");
			System.out.print("2\n");
			
			
			Statement sta=con.createStatement();
			sta.execute("use VotingSystem");
			

			
			String sql="insert into candidates values (?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(cn));
			stmt.setString(2, na);
			stmt.setInt(3, ag);
			stmt.setString(4, addres);
			stmt.setInt(5, 0);
			stmt.setString(6, pr);
			int rowsUpdated=stmt.executeUpdate();
			if (rowsUpdated>0) {
				System.out.print("Done");
			}
			Statement st1=con.createStatement();
			ResultSet res= st1.executeQuery("select * from Parties");
			ArrayList<Party> party=new ArrayList<Party>();
			while (res.next()) {
//				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4)+" "+res.getBoolean(5));
				Party p=new Party(res.getString(2));
				party.add(p);
			}
			boolean flag=false;
			for (int i = 0; i < party.size(); i++) {
				if (party.get(i).getName().equals(pr)) {
					flag=true;
				}
			}
			if (flag==false) {
				String sql1="insert into parties (name,votes) values (? , 0)";
				PreparedStatement stmt1=con.prepareStatement(sql1);
				stmt1.setString(1, pr);
				int rowsUpdated1=stmt1.executeUpdate();
				if (rowsUpdated1>0) {
					System.out.print("Done");
				}
			}
			con.close();
//			Statement stmt=con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new Exception();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
			e.getStackTrace();
			throw new Exception();
		}
	}
}
