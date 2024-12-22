import java.util.ArrayList;
import java.util.Scanner;

public class ATM
{
    private static ArrayList<Account> userAccounts = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);



        // Add some initial users
        userAccounts.add( new UserAction(12345, "12345", 1000.00));
        userAccounts.add(new UserAction(67890, "67890", 1500.00));

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

        System.out.println("Enter your pin:");
        String upin = scanner.next();

        Account userAccount = null;

        // Search for the user in the ArrayList
        for (Account account : userAccounts) // from chatGTP
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
            while (true)
            {
                System.out.println("Enter your operation");
                System.out.println("1. Check the Balance \n2. WithDraw cash \n3.Deposit Cash \n Change Pin \n5.View Transaction History \n6. Exit");
                int ch = scanner.nextInt();
                switch (ch)
                {
                    case 1:
                        UserAction userAction = (UserAction) userAccount;
                        userAction.checkBalance(scanner); // Calling the checkBalance method
                        break;
                    case 2:
                        System.out.println("Withdraw");
                        break;
                    case 3:
                        System.out.println("Deposit");
                        break;
                    case 4:
                        System.out.println("change pin");
                        break;
                    case 5:
                        System.out.println("Transaction");
                        break;
                    case 6:
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

        System.out.println("Enter the pin:");
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
            System.out.println("1. Add new user \n2. Delete the user \n3. View all accounts \n4. View user Transaction \n5. Exit");
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
                    System.out.println("Transaction");
                    break;
                case 5:
                    System.out.println("Exiting admin menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
