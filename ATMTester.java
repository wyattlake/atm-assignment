public class ATMTester {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.openAccount("Tony", 100);
        atm.openAccount("Rob", 10);
        System.out.println(atm.transferMoney("Tony", "Rob", -70));
        System.out.println(atm.checkBalance("Tony"));
        System.out.println(atm.checkBalance("Rob"));
    }
}
