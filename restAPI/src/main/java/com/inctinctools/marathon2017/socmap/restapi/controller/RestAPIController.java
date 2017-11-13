package com.inctinctools.marathon2017.socmap.restapi.controller;


import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.services.POIMapService;
import com.inctinctools.marathon2017.socmap.restapi.entity.MapDTO;
import com.sun.istack.internal.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAPIController {

    private @NotNull final POIMapService service;

    public RestAPIController(POIMapService service) {
        this.service = service;
    }

    @RequestMapping(value = "/heatmap", method = RequestMethod.GET)
    public ResponseEntity getHeatMap(@RequestParam("x1") final double x1, @RequestParam("y1") final double y1,
                                     @RequestParam("x2") final double x2, @RequestParam("y2") final double y2,
                                     @RequestParam("type") @NotNull final POITypes type) {
        final HeatMap map = service.build(x1, x2, y1, y2, type);
        return new ResponseEntity(new MapDTO(map), HttpStatus.OK);
    }

    @RequestMapping(value = "/POIs", method = RequestMethod.GET)
    public ResponseEntity getListOfPOI(@RequestParam("x1") final double x1, @RequestParam("y1") final double y1,
                                       @RequestParam("x2") final double x2, @RequestParam("y2") final double y2,
                                       @RequestParam("type") @NotNull final POITypes type) {
        return new ResponseEntity(service.getListOfPOI(x1, y1, x2, y2, type), HttpStatus.OK);
    }
}
