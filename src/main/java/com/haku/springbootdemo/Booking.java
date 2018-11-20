package com.haku.springbootdemo;

public class Booking {
    private String hotelName;
    private double pricePerNight;
    private int nbOfNight;

    public Booking(String hotelName, double pricePerNight, int nbOfNight){

        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNight = nbOfNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNight() {
        return nbOfNight;
    }

    public double getTotalPrice(){
        return nbOfNight * pricePerNight;
    }
}
