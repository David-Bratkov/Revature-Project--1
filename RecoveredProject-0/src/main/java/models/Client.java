package models;

public class Client {

    private Integer id;
    private String firstname;
    private String lastname;

    public Client() {}

    public Client(String first, String last) {
        this.id = 0;
        this.firstname = first;
        this.lastname = last;
    }

    public Client(Integer id, String first, String last) {
        this.id = id;
        this.firstname = first;
        this.lastname = last;
    }

    public Integer getId() {return id;}

    public String getFirstname() {return firstname;}

    public String getLastname() {return lastname;}

    public void setId(Integer id) {this.id = id;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

}
