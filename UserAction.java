import java.util.Scanner;

public class UserAction extends Account
{
    public UserAction(int id, String pass, double balance)
    {
        super(id, pass, balance); // Calling parent constructor
    }

    public void checkBalance(Scanner scanner)
    {
        // Printing the balance of the user
        System.out.println("Your balance is: " + getBalance());
    }
}
