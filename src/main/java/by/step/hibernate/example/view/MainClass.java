package by.step.hibernate.example.view;

import by.step.hibernate.example.dao.models.Address;
import by.step.hibernate.example.dao.models.User;
import by.step.hibernate.example.service.AddressService;
import by.step.hibernate.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    static UserService userService = new UserService();
    static AddressService addressService = new AddressService();


    public static void main(String[] args) {

        showTables ();

        User u = new User();

        u.setLogin("Admin");
        u.setPassword("Admi");

        userService.saveUser(u);

        Address a = new Address();

        a.setAddress("asdasdas");
        a.setAddress_index(341231234);
        a.setUser(u);

        addressService.saveAddress(a);

        showTables ();
    }

    public static void showTables () {

        List<User> users = userService.getAllUsers();

        users.forEach(user -> System.out.println(user.toString()));



        List<Address> addresses = addressService.getAllAddrese();

        addresses.forEach(address -> System.out.println(address));
    }
}
