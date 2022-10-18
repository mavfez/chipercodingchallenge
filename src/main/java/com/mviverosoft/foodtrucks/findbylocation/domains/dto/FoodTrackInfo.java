package com.mviverosoft.foodtrucks.findbylocation.domains.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class FoodTrackInfo {

    String objectId;
    String applicant;
    String facilityType;
    String cnn;
    String locationDescription;
    String address;
    String blockLot;
    String block;
    String lot;
    String permit;
    String status;
    String foodItems;
    String x;
    String y;
    String latitude;
    String longitude;
    String schedule;

    Date approved;
    
    String received;
    String priorpermit;
    
    Date expirationDate;
    
    Location location;
    String daysHours;
    
    Date noisent;

    @JsonProperty(":@computed_region_yftq_j783")
    String computedRegionYftqJ783;

    @JsonProperty(":@computed_region_p5aj_wyqh")
    String computedRegionP5ajWyqh;

    @JsonProperty(":@computed_region_rxqg_mtj9")
    String computedRegionRxqgMtj9;

    @JsonProperty(":@computed_region_bh8s_q3mv")
    String computedRegionBh8sQ3mv;

    @JsonProperty(":@computed_region_fyvs_ahh9")
    String computedRegionFyvsAhh9;
}
