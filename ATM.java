import java.io.FileWriter;
import java.io.IOException;
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

    public void closeAccount(String userId) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance == 0) {
                accounts.remove(userId);
            } else {
                throw new Error("User needs to withdraw balance of $" + balance + " before account can be closed.");
            }
        } else {
            throw new Error("User with id " + userId + " does not exist.");
        }
    }

    public double checkBalance(String userId) {
        if (accounts.containsKey(userId)) {
            return accounts.get(userId);
        } else {
            throw new Error("User with id " + userId + " does not exist.");
        }
    }

    public double depositMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            accounts.replace(userId, accounts.get(userId) + amount);
            return amount;
        } else {
            throw new Error(
                    "User with id " + userId + " does not exist. Regretfully, " + userId + " seems to be broke AF.");
        }
    }

    public double withdrawMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance >= amount) {
                double newBalance = balance - amount;
                accounts.replace(userId, newBalance);
                return newBalance;
            }
        } else {
            throw new Error(
                    "User with id " + userId + " does not exist.");
        }
        throw new Error("Regretfully, " + userId + " seems to be broke AF.");
    }

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        try {
            if (amount < 0) {
                return false;
            }
            withdrawMoney(fromAccount, amount);
            depositMoney(toAccount, amount);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void audit() throws IOException {
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<String, Double> account : accounts.entrySet()) {
            builder.append(account.getKey() + ": " + account.getValue() + "\n");
        }
        FileWriter writer = new FileWriter("AccountAudit.txt", false);
        builder.deleteCharAt(builder.length() - 1);
        writer.write(builder.toString());
        writer.close();
    }
}