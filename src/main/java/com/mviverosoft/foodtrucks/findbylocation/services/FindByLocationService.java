package com.mviverosoft.foodtrucks.findbylocation.services;

import com.mviverosoft.foodtrucks.findbylocation.domains.dto.FoodTrackInfo;
import com.mviverosoft.foodtrucks.findbylocation.domains.dto.Location;
import java.util.List;

/**
 *
 * @author Mauricio Viveros
 */
public interface FindByLocationService {
    public List<FoodTrackInfo> findByLocation(Location location)throws Exception;
}
