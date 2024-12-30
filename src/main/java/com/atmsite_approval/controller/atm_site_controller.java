package com.atmsite_approval.controller;

import com.atmsite_approval.service.AtmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class atm_site_controller {

    private AtmService atmService;

    public atm_site_controller(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/atmsite")
    public ResponseEntity<Map<String, Object>> insertuser(@RequestBody Map<String, Object> requestData) {

        String frId = (String) requestData.get("frId");
        System.out.println("recieved frId:" + frId);

       String response= atmService.saveUser(frId);

       Map<String ,Object> jsoresponse = new HashMap<String ,Object>();
       jsoresponse.put("message",response);
       jsoresponse.put("status",true);

       return new ResponseEntity<>(jsoresponse, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> updateatm(@RequestBody Map<String, Object> requestData){
        String frId = (String) requestData.get("frId");
        String frLat = (String) requestData.get("lat");
        String frLong = (String) requestData.get("long");
        String isAtmNear = (String) requestData.get("isAtmNear");
        String isAtmSuccessful = (String) requestData.get("isAtmSuccess");

        String response = atmService.updateAtm(frId, frLat, frLong, isAtmNear, isAtmSuccessful);

        Map<String , Object> newresponse = new HashMap<String , Object>();
        newresponse.put("message", response);
        newresponse.put("status", true);

        return new ResponseEntity<>(newresponse, HttpStatus.OK);
    }
}
