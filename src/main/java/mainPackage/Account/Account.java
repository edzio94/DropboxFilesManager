package mainPackage.Account;

/**
 * Created by lukasz on 12.12.15.
 */
public class Account {
    private String name;
    private Integer amount;

    public Account(String name, Integer amount)
    {
        this.name = name;
        this.amount = amount;

    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add (Integer toAdd) {
        amount += toAdd;
    }

    public void withdraw (Integer toAdd)
    {
        amount -= toAdd;
    }
}
