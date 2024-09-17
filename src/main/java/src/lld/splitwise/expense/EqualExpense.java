package src.lld.splitwise.expense;

import src.lld.splitwise.User;
import src.lld.splitwise.split.EqualSplit;
import src.lld.splitwise.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(String title, String desc, double amount, User paidBy, List<Split> splits) {
        super(title, desc, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
