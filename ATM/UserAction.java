import java.util.Scanner;
import java.util.ArrayList;

public class UserAction extends Account
{
    public UserAction(int id, String pass, double balance)
    {
        super(id, pass, balance);
    }

    public void checkBalance()
    {
        System.out.println("Your balance is: " + getBalance());
    }

    public void deposit(Scanner scanner)
    {
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        double newBalance = getBalance() + amount;

        setBalance(newBalance);
        System.out.println("Deposit successful. New balance: " + getBalance());
    }
}
