package src.lld.splitwise.expense;

import lombok.Getter;
import lombok.Setter;
import src.lld.splitwise.User;
import src.lld.splitwise.split.Split;

import java.util.List;

@Getter
public abstract class Expense {
    @Setter
    private String id;
    private String title;
    private String desc;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    public Expense(String title, String desc, double amount, User paidBy, List<Split> splits) {
        this.title = title;
        this.desc = desc;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public abstract boolean validate();
}
