import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private static final int USER_ID = 1;
    private static final int WRONG_USER_ID = 2;
    private static final int INITIAL_BALANCE = 0;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAW_AMOUNT = 70;
    private static final int ATM_FEE = 1;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", USER_ID);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance(){
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }
    
    @Test
    void testDeposit(){
        bankAccount.deposit(USER_ID, DEPOSIT_AMOUNT);
        assertEquals((DEPOSIT_AMOUNT + INITIAL_BALANCE), bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit(){
        bankAccount.deposit(WRONG_USER_ID, DEPOSIT_AMOUNT);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw(){
        bankAccount.deposit(USER_ID, DEPOSIT_AMOUNT);
        bankAccount.withdraw(USER_ID, WITHDRAW_AMOUNT);
        assertEquals((INITIAL_BALANCE + DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - ATM_FEE), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw(){
        bankAccount.withdraw(USER_ID, WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }
}