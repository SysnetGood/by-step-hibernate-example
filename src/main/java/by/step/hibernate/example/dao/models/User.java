package by.step.hibernate.example.dao.models;

import javax.persistence.*;
import java.util.List;

@Entity (name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column (name = "address_id", insertable = false, updatable = false)
    private int address_id;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = true)
    private List<Address> addresses;

    public User(int id, String login, String password, List<Address> addresses) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.addresses = addresses;
    }

    public  User () { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address_id=" + address_id +
                '}';
    }
}
