package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{

    private final static int ATM_FEE = 1;
    
    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance){
        super(holder, balance);
    }

    public void withdraw(final int userID, final double amount){
        super.withdraw(userID, (amount + ATM_FEE));
    }
    
}