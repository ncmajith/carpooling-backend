package dev.carpooling.carpooingbackend.model;

public class TripModel {
    private String source;
    private String destination;
    private Long userId;

    public TripModel(String source, String destination, Long userId) {

        this.source = source;
        this.destination = destination;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
