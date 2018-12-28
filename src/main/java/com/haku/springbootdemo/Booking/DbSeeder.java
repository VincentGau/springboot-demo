package com.haku.springbootdemo.Booking;

import com.haku.springbootdemo.Customer.Customer;
import com.haku.springbootdemo.Customer.CustomerRepository;
import com.haku.springbootdemo.User.AppUser;
import com.haku.springbootdemo.User.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;
    private CustomerRepository customerRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public DbSeeder(BookingRepository bookingRepository, CustomerRepository customerRepository, AppUserRepository appUserRepository){
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Marriot", 1200, 3));
        bookings.add(new Booking("W", 1000, 4));
        bookings.add(new Booking("Haku", 1100, 5));
        bookingRepository.saveAll(bookings);


        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "haku"));
        customers.add(new Customer(2, "chihiro"));
        customerRepository.saveAll(customers);

        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(new AppUser(1, "Haku", "123"));
        appUsers.add(new AppUser(2, "Chihiro", "123"));
        appUserRepository.saveAll(appUsers);

    }
}
