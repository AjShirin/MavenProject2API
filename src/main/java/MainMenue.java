import java.util.Scanner;

public class MainMenue {

	static void menue() {
		System.out.println("_______________________________________________________________");
		System.out.println("Welcome!! Please Select one of the following options :) :      |");
		System.out.println("1. Create Table in database                                    |");
		System.out.println("2. Fetch API and Read                                          |");
		System.out.println("3. Insert API to database table                                |");
		System.out.println("4. Update Table Record                                         |");
		System.out.println("5. Delete Table Record                                         |");
		System.out.println("6. Print Record by user input                                  |");
		System.out.println("7. Exit System                                                 |");
		System.out.println("_______________________________________________________________|");
	}

	public static void main(String[] args) throws Throwable {

		Scanner sc = new Scanner(System.in);

		menue();
		System.out.println("Write the number of the option you want to choose:");
		do {

			int Menue = sc.nextInt();
			switch (Menue) {

			// Since The function is Static no need to create new object
			// Create Table in database
			case 1:
				CreateTable.createTable();

				menue();
				break;

			// Fetch API and Read
			case 2:
				FetchAndReadAPI.FetchAPIAndRead();

				menue();
				break;

			// Insert API to database table
			case 3:
				InsertValues.insertData();

				menue();
				break;

			// Update Table Record By ID
			case 4:
				UpdateRecordByID.updateRecord();

				menue();
				break;

			// Delete Table Record By ID
			case 5:
				DeleteRecord.deleteRecordById();

				menue();
				break;

			// Print Record by user input
			case 6:
				PrintRecord.PrintRecordFromTable();

				menue();
				break;

			// Exit the System
			case 7:
				System.out.println("Exiting The System Bye See you Again :)!...");
				System.exit(0);

			}

		} while (true);

	}

}
