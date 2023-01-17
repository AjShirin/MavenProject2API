
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class PrintRecord {
	public static void PrintRecordFromTable() throws IOException, InterruptedException {

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MavenApi;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String USER = "sa";
		String PASS = "root";

		int count = 0;
		String sql = "SELECT * FROM RandomTable";

		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter how many records you want to view?");
			int useInputNumber = sc.nextInt();

			while (rs.next() && count < useInputNumber) {

				Integer ID = rs.getInt(1);
				String common = rs.getString(2);
				String cca2 = rs.getString(3);
				String ccn3 = rs.getString(4);
				String cca3 = rs.getString(5);
				String cioc = rs.getString(6);
				String status = rs.getString(7);
				String region = rs.getString(8);
				String flag = rs.getString(9);
				String fifa = rs.getString(10);
				String startOfWeek = rs.getString(11);

				System.out.println("The Record are : " + " " + "Id :" + ID + "||" + " " + " The Common is :" + common
						+ "||" + " " + " The CAA2 is :" + cca2 + "||" + " " + " The CCN3 is  :" + ccn3 + "||" + " "
						+ "The CCA3 is  :" + cca3 + "||" + "\n " + " The CIOC is : " + cioc + "||" + " "
						+ "The status is :" + status + "\n" + "The Region is : " + region + "||" + " " + "The flag is: "
						+ flag + "||" + " " + fifa + "||" + " " + "The Start of the week is :" + startOfWeek + " ");
				count++;
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	} // End of PrintRecordFromTable Function

}// End of PrintRecord Class
