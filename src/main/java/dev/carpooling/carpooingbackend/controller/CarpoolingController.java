package dev.carpooling.carpooingbackend.controller;

import dev.carpooling.carpooingbackend.model.GroupModel;
import dev.carpooling.carpooingbackend.model.PageModel;
import dev.carpooling.carpooingbackend.model.TripModel;
import dev.carpooling.carpooingbackend.model.UserModel;
import dev.carpooling.carpooingbackend.service.CarpoolingBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PageModel<TripModel> getAllTrips(@PathVariable Integer page) {
        return carpoolingBusinessService.getAllTrips(page);
    }

}
