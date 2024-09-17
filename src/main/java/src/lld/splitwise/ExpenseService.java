package src.lld.splitwise;

import src.lld.splitwise.expense.EqualExpense;
import src.lld.splitwise.expense.ExactExpense;
import src.lld.splitwise.expense.Expense;
import src.lld.splitwise.expense.PercentageExpense;
import src.lld.splitwise.split.PercentageSplit;
import src.lld.splitwise.split.Split;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, String title, String desc, double amount, User paidBy, List<Split> splits) {
        switch (expenseType) {
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
//                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(title, desc, amount, paidBy, splits);
            case EXACT:
                return new ExactExpense(title, desc, amount, paidBy, splits);
            case PERCENTAGE:
                for (Split split : splits) {
                    PercentageSplit percentSplit = (PercentageSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new PercentageExpense(title, desc, amount, paidBy, splits);
            default:
                return null;
        }
    }
}
