package com.mviverosoft.foodtrucks.findbylocation;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.mviverosoft.foodtrucks.findbylocation.services.FindByLocationServiceImpl;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Mauricio Viveros
 */
public class DateDeserializer implements JsonDeserializer<Date> {

    private static final Logger LOG = LogManager.getLogger(FindByLocationServiceImpl.class);

    @Override
    public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        String date = element.getAsString();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return format.parse(date);
        } catch (ParseException exp) {
            LOG.info(exp.getMessage());
            return null;
        }
    }
}
