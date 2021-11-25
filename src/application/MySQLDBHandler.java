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
	public void voteCasted(String cnic) {
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
	}
	@Override
	public void addParty(String name) {
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
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
}
