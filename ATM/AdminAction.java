import java.util.Scanner;
import java.util.ArrayList;

public class AdminAction extends Account
{
    public AdminAction(int id, String pass)
    {
        super(id, pass, 0.0);
    }

    public void addNewUser(Scanner scanner)
    {
        System.out.println("Enter new user account number: ");
        int accno = scanner.nextInt();
        System.out.println("Enter new user PIN: ");
        String pin = scanner.next();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        UserAction newUser = new UserAction(accno, pin, balance);
        ATM.userAccounts.add(newUser);
        System.out.println("New user added successfully.");
    }

    //reff from google
    public void deleteUser(Scanner scanner)
    {
        System.out.println("Enter the account number of the user to delete: ");
        int accno = scanner.nextInt();

        Account userToDelete = null;

        //from chatgtp
        for (Account account : ATM.userAccounts)
        {
            if (account.getAccnumber() == accno)
            {
                userToDelete = account;
                break;
            }
        }

        if (userToDelete != null)
        {
            ATM.userAccounts.remove(userToDelete);
            System.out.println("User deleted successfully.");
        }

        else
        {
            System.out.println("User not found.");
        }
    }

    public void viewAllAccounts()
    {
        System.out.println("All user accounts:");

        //from chatgtp
        for (Account account : ATM.userAccounts)
        {
            System.out.println("Account No: " + account.getAccnumber() + ", Balance: " + account.getBalance());
        }
    }
}
