import java.util.ArrayList;
import java.util.Scanner;

public class AdminAction extends Account
{
    private ArrayList<Account> accounts;

    public AdminAction(int id, String pass)
    {
        super(id, pass);
        accounts = new ArrayList<>();
    }

    public void addNewUser(Scanner scanner)
    {
        System.out.println("Enter new user's account number:");
        int newAccNo = scanner.nextInt();

        System.out.println("Enter new user's PIN:");
        String newPin = scanner.next();

        // Add new user to the list
        accounts.add(new Account(newAccNo, newPin));
        System.out.println("New user added successfully!");
    }

    public void deleteUser(Scanner scanner)
    {
        System.out.println("Enter account number to delete:");
        int delAccNo = scanner.nextInt();

        for (int i = 0; i < accounts.size(); i++)
        {
            // Check if the account number matches
            if (accounts.get(i).getAccnumber() == delAccNo)
            {
                accounts.remove(i); // Remove the account
                System.out.println("User deleted successfully!");
                return; // Exit the method after deletion
            }
        }

        // If no account matches
        System.out.println("Account number not found.");
    }

    public void viewAllAccounts()
    {
        System.out.println("List of all accounts:");
        if (accounts.isEmpty())
        {
            System.out.println("No accounts available.");
        }

        else
        {
            //reff from chatGTP
            for (Account account : accounts)
            {
                System.out.println("Account Number: " + account.getAccnumber());
            }
        }
    }
}
