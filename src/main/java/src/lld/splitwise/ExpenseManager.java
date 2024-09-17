package src.lld.splitwise;

import src.lld.splitwise.expense.Expense;
import src.lld.splitwise.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, String title, String desc, double amount, String paidBy, List<Split> splits) {
        Expense expense = ExpenseService.createExpense(expenseType, title, desc, amount, userMap.get(paidBy), splits);
        expenses.add(expense);
        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());
            balanceSheet.put(paidBy, balances);

            balances = balanceSheet.get(paidTo);
            balances.put(paidBy, balances.getOrDefault(paidBy, 0.0) - split.getAmount());
            balanceSheet.put(paidBy, balances);
        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }
}
