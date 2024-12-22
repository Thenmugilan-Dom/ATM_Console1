import java.util.ArrayList;
import java.util.Scanner;

public class ATM
{
    public static ArrayList<Account> userAccounts = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Add some initial users
        userAccounts.add(new UserAction(12345, "12345", 1000.00));

        l1: while (true)
        {
            int choice;
            System.out.println("Select your role:");
            System.out.println("1. Admin \n2. User \n3. Exit");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    Adminop(scanner);
                    break;
                case 2:
                    Userop(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break l1;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void Userop(Scanner scanner)
    {
        System.out.println("Enter your Account number:");
        int uaccno = scanner.nextInt();

        System.out.println("Enter your PIN:");
        String upin = scanner.next();

        Account userAccount = null;

        // Search for the user in the ArrayList
        for (Account account : userAccounts)
        {
            if (account.getAccnumber() == uaccno && account.getPinno().equals(upin))
            {
                userAccount = account;
                break;
            }
        }

        if (userAccount != null)
        {
            System.out.println("Login successful.");
            UserAction userAction = (UserAction) userAccount;
            while (true)
            {
                System.out.println("Enter your operation:");
                System.out.println("1. Check Balance \n2. Withdraw cash \n3. Deposit cash \n4. Change Pin \n5. Exit");
                int ch = scanner.nextInt();
                switch (ch)
                {
                    case 1:
                        userAction.checkBalance();
                        break;
                    case 2:
                        System.out.println("Withdraw");
                        break;
                    case 3:
                        userAction.deposit(scanner);
                        break;
                    case 4:
                        System.out.println("change pin");
                        break;
                    case 5:
                        System.out.println("Exiting user menu...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        else
        {
            System.out.println("Invalid account number or PIN. Returning to main menu.");
        }
    }

    public static void Adminop(Scanner scanner)
    {
        AdminAction adminAction = new AdminAction(12345, "12345");

        System.out.println("Enter the account number:");
        int accno = scanner.nextInt();

        System.out.println("Enter the PIN:");
        String pin = scanner.next();

        for (int i = 0; i < 3; i++)
        {
            if (accno == adminAction.getAccnumber() && pin.equals(adminAction.getPinno()))
            {
                System.out.println("Login successful.");
                break;
            }
            else if (i < 2)
            {
                System.out.println("Wrong PIN or account number. Try again:");
                pin = scanner.next();
            }
            else
            {
                System.out.println("Too many failed attempts. Returning to main menu.");
                return;
            }
        }

        while (true)
        {
            System.out.println("Enter your operation:");
            System.out.println("1. Add new user \n2. Delete user \n3. View all accounts \n4. Exit");
            int ch = scanner.nextInt();
            switch (ch)
            {
                case 1:
                    adminAction.addNewUser(scanner);
                    break;
                case 2:
                    adminAction.deleteUser(scanner);
                    break;
                case 3:
                    adminAction.viewAllAccounts();
                    break;
                case 4:
                    System.out.println("Exiting admin menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
