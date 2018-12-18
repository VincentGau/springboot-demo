package com.haku.springbootdemo.Booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    BookingRepository bookingRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);


    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Booking> getAll(){
        logger.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAExample log from {}", BookingController.class.getSimpleName());
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Booking> delete(@PathVariable long id){
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public List<Booking> update(@PathVariable long id, @RequestBody Booking booking){
        Booking bookingToUpdate = bookingRepository.findById(id).orElse(null);
        if(bookingToUpdate == null){
            return null;
        }
        bookingToUpdate.setHotelName(booking.getHotelName());
        bookingToUpdate.setNbOfNight(booking.getNbOfNight());
        bookingToUpdate.setPricePerNight(booking.getPricePerNight());
        bookingRepository.save(bookingToUpdate);
        return bookingRepository.findAll();

    }

    @RequestMapping(value = "/update2/{id}", method = RequestMethod.POST)
    public String update2(@PathVariable long id, @RequestBody Booking booking){
        try{
            Booking bookingToUpdate = bookingRepository.getOne(id);
            bookingToUpdate.setHotelName(booking.getHotelName());
            bookingToUpdate.setNbOfNight(booking.getNbOfNight());
            bookingToUpdate.setPricePerNight(booking.getPricePerNight());
            bookingRepository.save(bookingToUpdate);
            return "OK";
        }
        catch (EntityNotFoundException e){
            return "No booking with id " + id;
        }
    }


}
