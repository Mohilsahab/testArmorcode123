package src.lld.splitwise.split;

import src.lld.splitwise.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
