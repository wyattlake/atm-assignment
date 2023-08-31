public class ATMTester {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.openAccount("Tony", 100);
        System.out.println(atm.depositMoney("Tony", 50));
        System.out.println(atm.withdrawMoney("Tony", 60));
        System.out.println(atm.withdrawMoney("Tony", 500));
    }
}
