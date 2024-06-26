package dev.carpooling.carpooingbackend.model;

public class TripModel {
    private String source;
    private String destination;

    private String departureTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    public TripModel(String source, String destination, String departureTime, Long userId) {

        this.source = source;
        this.destination = destination;
        this.userId = userId;
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
