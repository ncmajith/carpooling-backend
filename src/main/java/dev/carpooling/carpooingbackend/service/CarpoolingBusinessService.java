package dev.carpooling.carpooingbackend.service;

import dev.carpooling.carpooingbackend.entities.Group;
import dev.carpooling.carpooingbackend.entities.Trip;
import dev.carpooling.carpooingbackend.entities.User;
import dev.carpooling.carpooingbackend.model.*;
import dev.carpooling.carpooingbackend.repository.GroupRepository;
import dev.carpooling.carpooingbackend.repository.TripRepository;
import dev.carpooling.carpooingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarpoolingBusinessService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Value("${carpooling.page.size}")
    private Integer pageSize;

    public UserModel saveUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        user.setGender(userModel.getGender());
        Optional<User> existingUser = userRepository.findByEmail(userModel.getEmail());
        Long userId = Long.valueOf(userRepository.findAll().size() + 1);
        user.setUserId(userId);
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        } else {
            userRepository.save(user);
        }
        return userModel;
    }

    public TripModel saveTrip(TripModel tripModel) {
        Trip trip = new Trip();
        trip.setSource(tripModel.getSource());
        trip.setDestination(tripModel.getDestination());
        trip.setUserId(tripModel.getUserId());
        Long tripId = Long.valueOf(tripRepository.findAll().size() + 1);
        trip.setTripId(tripId);
        tripRepository.save(trip);
        return tripModel;
    }

    public GroupModel saveGroup(GroupModel groupModel) {
        Group group = new Group();
        group.setGroupName(groupModel.getGroupName());
        Long groupId = Long.valueOf(groupRepository.findAll().size() + 1);
        var emails = groupModel.getUsers().stream().map(UserModel::getEmail).toList();
        List<User> existingUsers = userRepository.findByEmailIn(emails);
        group.setGroupId(groupId);
        group.setUsers(existingUsers);
        groupRepository.save(group);
        return groupModel;
    }

    public PageModel<GroupModel> getGroups(Integer page) {
        var groups = groupRepository.findAll(PageRequest.of(page, pageSize));
        var items = groups.stream().map(group -> {
            GroupModel groupModel = new GroupModel();
            groupModel.setGroupName(group.getGroupName());
            groupModel.setUsers(group.getUsers().stream().map(user -> {
                UserModel userModel = new UserModel();
                userModel.setEmail(user.getEmail());
                userModel.setName(user.getName());
                userModel.setGender(user.getGender());
                return userModel;
            }).toList());
            return groupModel;
        }).toList();
        PageModel<GroupModel> pageModel = new PageModel<>();
        pageModel.setItems(items);
        pageModel.setPageNumber(page);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalPages((int) groups.getTotalElements());
        return pageModel;
    }

    public PageModel<TripResponseModel> getAllTrips(Integer page) {
        var trips = tripRepository.findAll(PageRequest.of(page, pageSize));
        var items = trips.stream().map(trip -> {
            TripResponseModel tripModel = new TripResponseModel();
            tripModel.setSource(trip.getSource());
            tripModel.setDestination(trip.getDestination());
            tripModel.setUser(userRepository.findById(trip.getUserId()).map(user -> {
                UserModel userModel = new UserModel();
                userModel.setEmail(user.getEmail());
                userModel.setName(user.getName());
                userModel.setGender(user.getGender());
                return userModel;
            }).orElseThrow(() -> new RuntimeException("User not found")));
            return tripModel;
        }).toList();
        PageModel<TripResponseModel> pageModel = new PageModel<>();
        pageModel.setItems(items);
        pageModel.setPageNumber(page);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalPages((int) trips.getTotalElements());
        return pageModel;
    }
}
