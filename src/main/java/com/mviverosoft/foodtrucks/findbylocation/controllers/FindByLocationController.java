package com.mviverosoft.foodtrucks.findbylocation.controllers;

import com.mviverosoft.foodtrucks.findbylocation.ChiperchallengeApplication;
import com.mviverosoft.foodtrucks.findbylocation.domains.dto.FoodTrackInfo;
import com.mviverosoft.foodtrucks.findbylocation.domains.dto.Location;
import com.mviverosoft.foodtrucks.findbylocation.services.FindByLocationService;
import com.mviverosoft.foodtrucks.findbylocation.services.FindByLocationServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mauricio Viveros
 */
@RestController
@RequestMapping(ChiperchallengeApplication.PATH_SERVICE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class FindByLocationController {

    private final FindByLocationService findByLocationService;
    private static final Logger LOG = LogManager.getLogger(FindByLocationServiceImpl.class);

    @Autowired
    public FindByLocationController(FindByLocationService findByLocationService) {
        this.findByLocationService = findByLocationService;
    }

    @ApiOperation(value = "Return list of food track by location", response = ResponseEntity.class)
    @GetMapping(value = "/foodtrack/findByLocation/{humanAddress}/{latitude}/{longitude}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<FoodTrackInfo>> findByLocation(
            @ApiParam(value = "humanAddress", required = true) @PathVariable("humanAddress") String humanAddress,
            @ApiParam(value = "latitude", required = false) @PathVariable("latitude") String latitude,
            @ApiParam(value = "longitude", required = false) @PathVariable("longitude") String longitude) throws Exception {

        Location location = new Location();
        location.setHumanAddress(humanAddress);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        List<FoodTrackInfo> resultList = findByLocationService.findByLocation(location);

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

}
