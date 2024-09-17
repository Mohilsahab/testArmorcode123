package src.lld.splitwise.expense;

import src.lld.splitwise.User;
import src.lld.splitwise.split.ExactSplit;
import src.lld.splitwise.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(String title, String desc, double amount, User paidBy, List<Split> splits) {
        super(title, desc, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (totalAmount != sumSplitAmount) {
            return false;
        }

        return true;
    }
}
