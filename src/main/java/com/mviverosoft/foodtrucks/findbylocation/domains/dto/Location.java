package com.mviverosoft.foodtrucks.findbylocation.domains.dto;

import lombok.Data;

@Data
public class Location {

    String latitude;
    String longitude;
    String humanAddress;
}
