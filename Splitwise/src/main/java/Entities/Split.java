package Entities;

public class Split {
    double amountOwe;
    User user;

    public Split(User user, double amountOwe){
        this.amountOwe = amountOwe;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

}
