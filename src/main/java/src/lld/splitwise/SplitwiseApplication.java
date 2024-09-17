package src.lld.splitwise;

import src.lld.splitwise.split.EqualSplit;
import src.lld.splitwise.split.ExactSplit;
import src.lld.splitwise.split.PercentageSplit;
import src.lld.splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseApplication {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser(new User("u1", "User1", "user1@gmail.com"));
        expenseManager.addUser(new User("u2", "User2", "user2@gmail.com"));
        expenseManager.addUser(new User("u3", "User3", "user3@gmail.com"));
        expenseManager.addUser(new User("u4", "User4", "user4"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL,"equal expense title", "equal expense desc", amount, paidBy, splits);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, "exact expense title", "exact expense desc", amount, paidBy, splits);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentageSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENTAGE, "percentage expense title", "percentage expense desc", amount, paidBy, splits);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
