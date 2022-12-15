package by.step.hibernate.example.dao.models;

import javax.persistence.*;
import java.util.List;

@Entity (name = "address")
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column (name = "Address")
    private String address;

    @Column (name = "address_index")
    private int address_index;

    @Column (name = "user_id", insertable = false, updatable = false)
    private int user_id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = true)
    private User user;

    public Address(int id, String address, int address_index, int user_id) {
        this.id = id;
        this.address = address;
        this.address_index = address_index;
        this.user_id = user_id;
    }

    public Address () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddress_index() {
        return address_index;
    }

    public void setAddress_index(int address_index) {
        this.address_index = address_index;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address_index=" + address_index +
                ", user_id=" + user_id +
                '}';
    }
}
