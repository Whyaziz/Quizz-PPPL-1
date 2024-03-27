import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {

    BankAccount account;

    @BeforeAll
    public void initClass() {
        account = new BankAccount("123", 1000);
    }

    @Test @Order(1)
    public void testGetAccountNumber() {
        Assertions.assertEquals("123", account.getAccountNumber());
    }

    @Test @Order(2)
    public void testGetBalance() {
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test @Order(3)
    public void testDepositValid() {

        account.deposit(1000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test @Order(4)
    public void testDepositInvalid() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-1000);
        });
    }

    @Test @Order(5)
    public void testWithdrawValid() {

        account.withdraw(500);
        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test @Order(6)
    public void testWithdrawInvalid() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test @Order(7)
    public void testTransferFundsValid() {

        BankAccount recipient = new BankAccount("456", 500);
        account.transferFunds(recipient, 1000);
        Assertions.assertEquals(500, account.getBalance());
        Assertions.assertEquals(1500, recipient.getBalance());
    }

    @Test @Order(8)
    public void testTransferFundsInvalid() {

        BankAccount recipient = new BankAccount("456", 500);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.transferFunds(recipient, 2000);
        });
    }

}
