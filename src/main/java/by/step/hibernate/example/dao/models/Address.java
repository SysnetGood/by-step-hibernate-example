package by.step.hibernate.example.dao.models;

import javax.persistence.*;

@Entity
@Table (name = "user_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private int address_index;

    @Column (insertable = false, updatable = false)
    private int user_id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Address () {}

    public Address(int id, String address, int address_index, int user_id) {
        this.id = id;
        this.address = address;
        this.address_index = address_index;
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
