package com.haku.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    BookingRepositoty bookingRepositoty;

    @Autowired
    public BookingController(BookingRepositoty bookingRepositoty){
        this.bookingRepositoty = bookingRepositoty;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Booking> getAll(){
        return bookingRepositoty.findAll();
    }

    @RequestMapping(value = "/affordable/{price}")
    public List<Booking> getAffordable(@PathVariable double price){
        return bookingRepositoty.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Booking> create(@RequestBody Booking booking){
        bookingRepositoty.save(booking);
        return bookingRepositoty.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<Booking> delete(@PathVariable long id){
        bookingRepositoty.deleteById(id);

        return bookingRepositoty.findAll();

    }
}
