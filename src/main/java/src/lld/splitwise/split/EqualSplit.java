package src.lld.splitwise.split;

import src.lld.splitwise.User;

public class EqualSplit extends Split {


    public EqualSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    public EqualSplit(User user) {
        super(user);
    }
}
