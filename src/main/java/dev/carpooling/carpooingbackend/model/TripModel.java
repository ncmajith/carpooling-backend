package dev.carpooling.carpooingbackend.model;

public class TripModel {
    private String source;
    private String destination;

    private String departureTime;
    private UserModel user;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public TripModel(String source, String destination, String departureTime, UserModel user) {

        this.source = source;
        this.destination = destination;
        this.user = user;
        this.departureTime = departureTime;

    }

    public TripModel() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
