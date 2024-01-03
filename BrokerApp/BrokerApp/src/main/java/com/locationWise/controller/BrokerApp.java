package com.locationWise.controller;

import com.locationWise.dto_or_Payload.BrokerAppDto;
import com.locationWise.repository.BrokerAppRepository;
import com.locationWise.service.BrokerAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brokerapp")
public class BrokerApp {
    @Autowired
    private BrokerAppService brokerService;

    @PostMapping
    public ResponseEntity<BrokerAppDto> createBrokerApp(@RequestBody BrokerAppDto brokerappdto){

        BrokerAppDto app =brokerService.createBrokerApp(brokerappdto);
        return new ResponseEntity<>(app, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrokerApp(@PathVariable long id){
        brokerService.deleteBrokerApp(id);

        return new ResponseEntity<>("BrokerApp is Deleted",HttpStatus.OK);
    }
}
