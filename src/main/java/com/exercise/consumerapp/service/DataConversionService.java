package com.exercise.consumerapp.service;
import com.exercise.consumerapp.consumer.MyTopicConsumer;
import com.exercise.consumerapp.models.DataSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static com.exercise.consumerapp.util.Constants.*;
import static com.exercise.consumerapp.util.Constants.CNY;

@PropertySource("/application.properties")
@Service
public class DataConversionService {

    @Autowired
    private Environment env;

    private static final Logger logger = LoggerFactory.getLogger(DataConversionService.class.getName());

    public DataSchema convertData(DataSchema data){
        String currency = data.getCurrency();
        double bookingAmount = data.getBookingAmount();

        String rateDouble = env.getProperty(currency);
        Double rate = Double.valueOf(rateDouble);

        logger.info("For "+currency+" rate :"+rate);

        Double convertedCurrency = bookingAmount * rate;
        DecimalFormat df = new DecimalFormat("#.##");
        convertedCurrency = Double.valueOf(df.format(convertedCurrency));

        logger.info("convertedCurrency : "+convertedCurrency);
        logger.info("convertedCurrency after formatting: "+convertedCurrency);

        data.setCurrency(env.getProperty(ConvertedCurrency));
        data.setBookingAmount(convertedCurrency);

        return data;
    }
}
