
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	static void createTable() throws IOException, InterruptedException {
		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MavenApi;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String USER = "sa";
		String PASS = "root";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			// Create Table in SQL
			String createTabelSQL = "CREATE TABLE RandomTable " + "(Id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " common VARCHAR(100), " + " cca2 VARCHAR(100), " + " ccn3 VARCHAR(100), "
					+ " cca3 VARCHAR(100), " + "cioc VARCHAR(100), " + " independent tinyInt, "
					+ "status VARCHAR(100), " + "region  VARCHAR(100)," + "flag VARCHAR(100)," + "fifa VARCHAR(100),"
					+ "startOfWeek VARCHAR(100) )";

			stmt.executeUpdate(createTabelSQL);
			System.out.println("API Table Created Successfully in Database ... :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createTable Function
}// End of Class CreateTable
