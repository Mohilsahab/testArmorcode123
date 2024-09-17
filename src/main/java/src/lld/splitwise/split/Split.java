package src.lld.splitwise.split;

import lombok.Getter;
import lombok.Setter;
import src.lld.splitwise.User;

@Getter
public abstract class Split {
    User user;
    @Setter
    double amount;

    public Split(User user) {
        this.user = user;
    }
}
