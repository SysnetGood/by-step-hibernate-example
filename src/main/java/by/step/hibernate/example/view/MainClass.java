package by.step.hibernate.example.view;

import by.step.hibernate.example.dao.models.Address;
import by.step.hibernate.example.dao.models.User;
import by.step.hibernate.example.service.AddressService;
import by.step.hibernate.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        UserService userService = new UserService();

        List<User> users = userService.getAllUsers();

        users.forEach(user -> System.out.println(user.toString() + user.getAddresses().toString()));

        AddressService addressService = new AddressService();

        List<Address> addresses = addressService.getAllAddrese();

        addresses.forEach(address -> System.out.println(address + address.getUser().toString()));

        User u = new User();
        u.setLogin("Petrenko");
        u.setPassword("gogogo");

        Address a = new Address();
        a.setAddress("Moskovsiy");
        a.setAddress_index(1234);
        a.setUser(u);

        List <Address> ad = new ArrayList<>();
        ad.add(a);

        u.setAddresses(ad);

        userService.saveUser(u);

        addressService.saveAddress(a);
    }
}
