package src.lld.splitwise.split;

import lombok.Getter;
import src.lld.splitwise.User;

@Getter
public class PercentageSplit extends Split {
    double percent;

    public PercentageSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
