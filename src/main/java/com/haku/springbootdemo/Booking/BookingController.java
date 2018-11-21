package com.haku.springbootdemo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}")
    public List<Booking> getAffordable(@PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Booking> create(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<Booking> delete(@PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();

    }
}
