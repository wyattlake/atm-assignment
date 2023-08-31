import java.io.IOException;

public class ATMTester {
    public static void main(String[] args) throws IOException {
        ATM atm = new ATM();
        atm.openAccount("Tony", 100);
        atm.openAccount("Jerry", 10);
        System.out.println(atm.transferMoney("Tony", "Rob", -70));
        System.out.println(atm.checkBalance("Tony"));
        System.out.println(atm.checkBalance("Jerry"));
        atm.audit();
    }
}
