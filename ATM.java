import java.util.HashMap;

public class ATM {
    protected HashMap<String, Double> accounts;

    public ATM() {
        accounts = new HashMap<String, Double>();
    }

    public void openAccount(String userId, double amount) throws Error {
        if (accounts.containsKey(userId)) {
            throw new Error("User with id " + userId + " already exists.");
        }
        accounts.put(userId, amount);
    }
}