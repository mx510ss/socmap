package com.inctinctools.marathon2017.socmap.restapi.controller;

import com.inctinctools.marathon2017.socmap.restapi.entity.MapDTO;
import com.inctinctools.marathon2017.socmap.restapi.entity.PointData;
import com.inctinctools.marathon2017.socmap.data.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.data.entities.HeatPoint;

import enums.POITypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.POIService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPIController {

    @Autowired
    POIService service;

    @RequestMapping(value = "/heatmap", method = RequestMethod.GET)
    public ResponseEntity getHeatMap(@RequestParam("x1") double x1, @RequestParam("y1") double y1,
                                     @RequestParam("x2") double x2, @RequestParam("y2") double y2,
                                     @RequestParam("type") POITypes type){
        HeatMap map = service.build(x1,x2,y1,y2, type);
        return new ResponseEntity( new MapDTO(map), HttpStatus.OK);
    }

}
