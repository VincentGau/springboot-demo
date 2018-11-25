package com.haku.springbootdemo.Booking;

import com.haku.springbootdemo.Customer.Customer;
import com.haku.springbootdemo.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public DbSeeder(BookingRepository bookingRepository, CustomerRepository customerRepository){
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
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

    }
}
