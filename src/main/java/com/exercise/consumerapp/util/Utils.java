package com.exercise.consumerapp.util;


import com.exercise.consumerapp.models.DataSchema;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {
    public static DataSchema getNextDataSchema() {
        Random random = new Random();
        long reservationId = random.longs(100, 10000).findFirst().getAsLong();
        long hotelId = random.longs(100, 10000).findFirst().getAsLong();
        Map<Integer, String> cityMap = new HashMap<>();
        String[] cities = {"New York City" ,"Los Angeles" ,
                "Chicago" ,"Houston" ,"Phoenix" ,"Philadelphia" ,
                "San Antonio" ,"San Diego" ,"Dallas" ,"San Jose" ,"Austin" ,"Jacksonville" ,
                "Fort Worth" ,"Charlotte" ,"San Francisco" ,"Columbus" ,"Indianapolis" ,"Seattle" ,	"Denver" , "Washington"};

        String city = cities[random.ints(1, 12).findFirst().getAsInt()];
        int nightsBooked  = random.ints(1, 10).findFirst().getAsInt();
        ;
        double bookingAmount = random.doubles(100, 10000).findFirst().getAsDouble();

        DecimalFormat df = new DecimalFormat("#.##");
        bookingAmount = Double.valueOf(df.format(bookingAmount));

        Map<Integer, String> currencyMap = new HashMap<>();
        currencyMap.put(1, "GBP");
        currencyMap.put(2, "USD");
        currencyMap.put(3, "INR");
        currencyMap.put(4, "CNY");

        String currency = currencyMap.get(random.ints(1, 4).findFirst().getAsInt());


        DataSchema dataSchema = new DataSchema(reservationId, hotelId, city, nightsBooked, bookingAmount, currency);
        return dataSchema;
    }
}
