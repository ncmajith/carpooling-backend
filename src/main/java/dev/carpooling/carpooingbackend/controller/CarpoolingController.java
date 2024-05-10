package dev.carpooling.carpooingbackend.controller;

import dev.carpooling.carpooingbackend.model.*;
import dev.carpooling.carpooingbackend.service.CarpoolingBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CarpoolingController {

    @Autowired
    private CarpoolingBusinessService carpoolingBusinessService;

    @PostMapping("/user")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return carpoolingBusinessService.saveUser(userModel);
    }

    @PostMapping("/trip")
    public TripModel saveTrip(@RequestBody TripModel tripModel) {
        return carpoolingBusinessService.saveTrip(tripModel);
    }

    @PostMapping("/group")
    public GroupModel saveGroup(@RequestBody GroupModel groupModel) {
        return carpoolingBusinessService.saveGroup(groupModel);
    }

    @GetMapping("/groups/{page}")
    public PageModel<GroupModel> getGroups(@PathVariable Integer page) {
        return carpoolingBusinessService.getGroups(page);
    }

    @GetMapping("/trips/{page}")
    public PageModel<TripResponseModel> getAllTrips(@PathVariable Integer page) {
        return carpoolingBusinessService.getAllTrips(page);
    }

    @GetMapping("/available-cabs")
    public ResponseEntity<List<CabData.CabService>> getAllTrips() throws IOException {
        List<CabData.CabService> cabs = carpoolingBusinessService.getAllTrips();
        return new ResponseEntity<>(cabs, HttpStatus.OK);
    }

}
