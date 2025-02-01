package main;

import java.util.ArrayList;
import java.util.List;

public class Java21Examples {

    public static void main(String[] args) {
        System.out.println(getBalanceWithOutSwitchPattern(new TermAccount()));
        System.out.println(getBalanceWithSwitchPattern(new TermAccount()));

        List<String> arrayList = List.of("A", "B", "C");
        arrayList.getFirst();
        arrayList.getLast();
        arrayList.reversed();

        //preview
        String text = "Test text";
//        String textAfter = STR."test text \{text}";
//        System.out.println(textAfter);
    }

    //Old way
    static double getBalanceWithOutSwitchPattern(Account account) {
        double balance = 0;
        if(account instanceof SavingsAccount sa) {
            balance = sa.getSavings();
        }
        else if(account instanceof TermAccount ta) {
            balance = ta.getTermAccount();
        }
        else if(account instanceof CurrentAccount ca) {
            balance = ca.getCurrentAccount();
        }
        return balance;
    }

    //New way
    static double getBalanceWithSwitchPattern(Account account) {
        double result = 0;
        switch (account) {
            case null -> throw new RuntimeException("Oops, account is null"); //Null handling
            case SavingsAccount sa -> result = sa.getSavings();
            case TermAccount ta -> result = ta.getTermAccount();
            case CurrentAccount ca -> result = ca.getCurrentAccount();
            default -> result = account.getBalance();
            // Also can be with records and patterns
        };
        return result;
    }

    static class SavingsAccount extends Account {
        double getSavings() {
            return 100;
        }
    }
    static class TermAccount extends Account {
        double getTermAccount() {
            return 1000;
        }
    }
    static class CurrentAccount extends Account {
        double getCurrentAccount() {
            return 10000;
        }
    }

    private static class Account {
        double getBalance() {
            return 0;
        }
    }
}
