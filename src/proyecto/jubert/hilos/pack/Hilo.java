package proyecto.jubert.hilos.pack;
import java.sql.*;

public class Hilo extends Thread{
	
	private static int greatConnections, failedConnections;
	
	public static int getGreatConnection() {
		return greatConnections;
	}
	
	public static int getFailedConnection() {
		return failedConnections;
	}
	
	@Override
	public void run() {
		
		try {
		Connection con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/negocio", "postgres", "1204");
	    Statement stmt = con.createStatement ();		
	    stmt.executeQuery ("select * from producto");
	    con.close();
	    stmt.close();
	    
	    if(con!=null) {
	    	greatConnections++;
	    }
	}
	catch(SQLException e) 
	{
		failedConnections++;
		e.printStackTrace();
		}
}
}
	