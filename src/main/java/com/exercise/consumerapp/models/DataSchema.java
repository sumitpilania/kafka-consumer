package com.exercise.consumerapp.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSchema {
        //@JsonProperty("reservation_id")
        private long reservationId;
        //@JsonProperty("hotel_id")
        private long hotelId;
//        @JsonProperty("city")
        private String city;
//        @JsonProperty("nights_booked")
        private int nightsBooked;
//        @JsonProperty("booking_amount")
        private double bookingAmount;
//        @JsonProperty("currency")
        private String currency;

    public DataSchema() {
    }

    public DataSchema(long reservationId, long hotelId, String city, int nightsBooked, double bookingAmount, String currency) {
        this.reservationId = reservationId;
        this.hotelId = hotelId;
        this.city = city;
        this.nightsBooked = nightsBooked;
        this.bookingAmount = bookingAmount;
        this.currency = currency;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNightsBooked() {
        return nightsBooked;
    }

    public void setNightsBooked(int nightsBooked) {
        this.nightsBooked = nightsBooked;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "DataSchema{" +
                "reservationId=" + reservationId +
                ", hotelId=" + hotelId +
                ", city='" + city + '\'' +
                ", nightsBooked=" + nightsBooked +
                ", bookingAmount=" + bookingAmount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
