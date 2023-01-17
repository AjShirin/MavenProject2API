
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateRecordByID {
	static void updateRecord() throws IOException, InterruptedException {
		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MavenApi;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String USER = "sa";
		String PASS = "root";

		String updateSQL = "UPDATE RandomTable SET common = ?,cca2 = ?, ccn3 = ?, cca3 = ?, cioc = ?, status = ?, region = ?, flag = ?, fifa = ?, startOfWeek = ? WHERE ID = ?";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the ID Number you want to Update :");
		int userInputID = sc.nextInt();
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement pstmt = con.prepareStatement(updateSQL);

			pstmt.setString(1, "Oman"); // common
			pstmt.setString(2, "OM"); // cca2
			pstmt.setString(3, "505"); // ccn3
			pstmt.setString(4, "SHR"); // cca3
			pstmt.setString(5, "S3S"); // cioc
			pstmt.setString(6, "officially-assigned"); // status
			pstmt.setString(7, "Middle East"); // region
			pstmt.setString(8, "www.WilliamHenryBillGates.com/w456/ly.png"); // flag
			pstmt.setString(9, "MARS");// fifa
			pstmt.setString(10, "Thursday");// startOfWeek
			pstmt.setInt(11, userInputID);

			pstmt.executeUpdate();

			String byID = "SELECT * FROM RandomTable WHERE id = ?";

			PreparedStatement pstmt2 = con.prepareStatement(byID);
			pstmt2.setInt(1, userInputID);
			ResultSet rs = pstmt2.executeQuery();
			if (rs.next()) {
				// Integer ID = rs.getInt(1);
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

				System.out.println("Record Updated Successfully :) !!");

				System.out.println("The Updated Record is : " + " " + "Id :" + userInputID + "||" + " "
						+ " The Common is :" + common + "||" + " " + " The CAA2 is :" + cca2 + "||" + " "
						+ " The CCN3 is  :" + ccn3 + "||" + " " + "The CCA3 is  :" + cca3 + "||" + "\n "
						+ " The CIOC is : " + cioc + "||" + " " + "The status is :" + status + "\n" + "The Region is : "
						+ region + "||" + " " + "The flag is: " + flag + "||" + " " + fifa + "||" + " "
						+ "The Start of the week is :" + startOfWeek + " ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	} // End of updateRecord Function
}// End of UpdateRecordByID Class
