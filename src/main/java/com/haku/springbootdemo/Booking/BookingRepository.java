package com.haku.springbootdemo.Booking;


import com.haku.springbootdemo.Booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByPricePerNightLessThan(double price);
}
