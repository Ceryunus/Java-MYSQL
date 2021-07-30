import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
	private String userName="root";
	private String password="12345";
	private String dbUrl="jdbc:mysql://localhost:3306/world";
	
	public Connection getConnection() throws SQLException{
	return DriverManager.getConnection(dbUrl,userName,password);	
	}
	public void showExeption(SQLException exeption) {
		System.out.println("Bir Hata Oluþtu : "+exeption.getMessage());
		System.out.println("Error Code : "+exeption.getErrorCode());
		
	}
	
	
}
