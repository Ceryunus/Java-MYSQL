import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		// sqlinsert();
		//sqlselect();
		//sqlupdate();
		//sqldelete();
	}

	public static void sqlinsert() throws SQLException { // Veri ekleme
		DBhelper dbhelper = new DBhelper();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset;
		try {
			connection = dbhelper.getConnection();
			statement = connection.prepareStatement(
					"insert into world.city(Name,CountryCode,District,Population) values('TRABZON','TUR','Ortahisar','320000');");
			int result = statement.executeUpdate();
			System.out.println(result + " Klon eklendi !");
		} catch (SQLException e) {
			dbhelper.showExeption(e);
		} finally {
			connection.close();
			statement.close();
		}

	}

	public static void sqlselect() throws SQLException {// Veri gösterme
		DBhelper dbhelper = new DBhelper();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset;
		try {
			connection = dbhelper.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT code,name,Continent,Region FROM world.country;");
			ArrayList<Country> counties = new ArrayList<Country>();
			while (resultset.next()) {
				counties.add(new Country(resultset.getString("code"), resultset.getString("name"),
						resultset.getString("Continent"), resultset.getString("Region")));

			}
			for (Country result : counties) {
				System.out.println(result.getName());

			}
		} catch (SQLException e) {
			dbhelper.showExeption(e);
		} finally {
			connection.close();
		}

	}

	public static void sqlupdate() throws SQLException { // Veri güncelleme
		DBhelper dbhelper = new DBhelper();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dbhelper.getConnection();
			String sql = "update world.city set District=?,Population=3200 where ID=?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "TrabZone"); // parametre veriyoruz
			statement.setInt(2, 3393);
			int result = statement.executeUpdate();
			System.out.println(result + " güncellendi!");
		} catch (SQLException e) {
			dbhelper.showExeption(e);
		} finally {
			connection.close();
			statement.close();
		}
	
	}

	public static void sqldelete() throws SQLException{
		DBhelper dbhelper = new DBhelper();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dbhelper.getConnection();
			String sql = "delete from world.city where ID=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,4084); // parametre veriyoruz

			int result = statement.executeUpdate();
			System.out.println(result + " güncellendi!");
		} catch (SQLException e) {
			dbhelper.showExeption(e);
		} finally {
			connection.close();
			statement.close();
		}
		
		
	}






}
