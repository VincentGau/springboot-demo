package com.haku.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private BookingRepositoty bookingRepositoty;

    @Autowired
    public DbSeeder(BookingRepositoty bookingRepositoty){
        this.bookingRepositoty = bookingRepositoty;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Booking> bookings = new ArrayList<>();

        bookings.add(new Booking("Marriot", 1200, 3));
        bookings.add(new Booking("W", 1000, 4));
        bookings.add(new Booking("Haku", 1100, 5));

        bookingRepositoty.saveAll(bookings);
    }
}
