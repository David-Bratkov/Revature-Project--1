package models;

public class Account {

    private Integer id;
    private Double balance;
    private Integer client_id;

    public Account() {}

    public Account(Integer clientid) {
        this.id = 0;
        this.balance = 0d;
        this.client_id = clientid;
    }

    public Account(Integer client_id, Double balance) {
        this.client_id = client_id;
        this.balance = balance;
    }

    public Account(Integer id, Integer clientid, Double balance) {
        this.id = id;
        this.balance = balance;
        this.client_id = clientid;
    }

    public Integer getId() {return this.id;}

    public Double getBal() {return this.balance;}

    public Integer getclientID() {return this.client_id;}

    public void setId(Integer id) {this.id = id;}

    public void addBalance(Double money) {this.balance += money;}

    public void reduceBalance(Double debt) {this.balance -= debt;}


}
