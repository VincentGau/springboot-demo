package com.haku.springbootdemo;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private List<Booking> bookings;

    public BookingController(){
        bookings = new ArrayList<>();

        bookings.add(new Booking("Marriot", 1200, 3));
        bookings.add(new Booking("W", 1000, 4));
        bookings.add(new Booking("Haku", 1100, 5));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Booking> getAll(){
        return bookings;
    }

    @RequestMapping(value = "/affordable/{price}")
    public List<Booking> getAffordable(@PathVariable double price){
        return bookings.stream().filter(x -> x.getPricePerNight() <= price)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Booking> create(@RequestBody Booking booking){
        bookings.add(booking);
        return bookings;
    }
}
