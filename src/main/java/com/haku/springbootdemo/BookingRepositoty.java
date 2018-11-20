package com.haku.springbootdemo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepositoty extends JpaRepository<Booking, Long> {

    List<Booking> findByPricePerNightLessThan(double price);
}
