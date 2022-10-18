package com.mviverosoft.foodtrucks.findbylocation.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mviverosoft.foodtrucks.findbylocation.DateDeserializer;
import com.mviverosoft.foodtrucks.findbylocation.domains.dto.FoodTrackInfo;
import com.mviverosoft.foodtrucks.findbylocation.domains.dto.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mauricio Viveros
 */
@Service("FindByLocationService")
public class FindByLocationServiceImpl implements FindByLocationService {

    private static final Logger LOG = LogManager.getLogger(FindByLocationServiceImpl.class);

    @Override
    public List<FoodTrackInfo> findByLocation(Location location) throws Exception {
        URL jsonUrl = new URL("https://data.sfgov.org/resource/rqzj-sfat.json");
        String jsonStr = getJson(jsonUrl);

        LOG.info("Json data: " + (new Gson().toJson(jsonStr)));

        Type listOfMyClassObject = new TypeToken<ArrayList<FoodTrackInfo>>() {
        }.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());

        List<FoodTrackInfo> fullList = gsonBuilder.create().fromJson(jsonStr, listOfMyClassObject);
        return filterList(fullList, location);
    }

    private List<FoodTrackInfo> filterList(List<FoodTrackInfo> fullList, Location location) {
        List<FoodTrackInfo> lstResult = new ArrayList<>();
        String haSearched = location.getHumanAddress();
        for (FoodTrackInfo fti : fullList) {
            if (fti.getAddress() != null && fti.getAddress().equals(haSearched)) {
                lstResult.add(fti);
            }
        }
        return lstResult;
    }

    private String getJson(URL url) throws IOException {
        try ( InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
    }

}
