package src.lld.splitwise.expense;

import src.lld.splitwise.User;
import src.lld.splitwise.split.PercentageSplit;
import src.lld.splitwise.split.Split;

import java.util.List;

public class PercentageExpense extends Expense {

    public PercentageExpense(String title, String desc, double amount, User paidBy, List<Split> splits) {
        super(title, desc, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentageSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentageSplit exactSplit = (PercentageSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}
