public class Account
{
    private int accnumber;
    private String pinno;
    private double balance;

    public Account(int id, String pass, double balance)
    {
        this.accnumber = id;
        this.pinno = pass;
        this.balance = balance;
    }

    public int getAccnumber()
    {
        return accnumber;
    }

    public void setAccnumber(int accnumber)
    {
        this.accnumber = accnumber;
    }

    public String getPinno()
    {
        return pinno;
    }

    public void setPinno(String pinno)
    {
        this.pinno = pinno;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
