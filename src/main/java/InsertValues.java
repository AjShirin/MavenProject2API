import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class InsertValues {
	static void insertData() throws IOException, InterruptedException {
		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MavenApi;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String USER = "sa";
		String PASS = "root";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://restcountries.com/v3.1/all")).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonString = response.body();

		Gson gson = new GsonBuilder().setPrettyPrinting()
				.create(); /**
							 * Gson is a Java library that can be used to convert Java Objects into their
							 * JSON representation. It can also be used to convert a JSON string to an
							 * equivalent Java object.
							 */

		JsonParser jasonParserNew = new JsonParser(); /**
														 * JsonParser parses JSON using the pull parsing programming
														 * model
														 */
		JsonElement jasonElementNew = jasonParserNew
				.parse(jsonString); /**
									 * A class representing an element of Json. It could either be a JsonObject , a
									 * JsonArray , a JsonPrimitive or a JsonNull .
									 */
		String jsonData = gson.toJson(jasonElementNew); // prettyJson
		System.out.println(jsonData);

		Data[] variable = gson.fromJson(jsonData, Data[].class);

		for (Data api : variable) {

			String common = api.getName().getCommon();
			String cca2 = api.getCca2();
			String ccn3 = api.getCcn3();
			String cca3 = api.getCca3();
			String cioc = api.getCioc();
			String status = api.getStatus();
			String region = api.getRegion();
			String flag = api.getFlags().getPng();
			String fifa = api.getFifa();
			String startOfWeek = api.getStartOfWeek();

			// Inserting data using SQL query
			String sqlInsert = "insert into RandomTable(common,cca2, ccn3,cca3, cioc,status,region,flag,fifa,startOfWeek)"
					+ " values('" + common + "' ,'" + cca2 + "', '" + ccn3 + "','" + cca3 + "' ,' "
					+ cioc + "','" + status + "','" + region + "','" + flag + "','" + fifa
					+ "','" + startOfWeek + "' )";

			// Connection class object
			Connection con = null;

			// Try block to check for exceptions
			try {

				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(DB_URL, USER, PASS);

				// Creating a statement
				Statement st = con.createStatement();

				// Executing query
				// s - number of Rows
				int s = st.executeUpdate(sqlInsert);
				if (s >= 1) 
					System.out.println("Inserted successfully : " + sqlInsert);
				else
					System.out.println("Insertion failed");

				// Closing the connections
				con.close();
			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}

		}
	}// End of Function insertData
} // End of Class InsertApi
