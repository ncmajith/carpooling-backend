package dev.carpooling.carpooingbackend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "trips")
public class Trip {
    @Id
    private Long tripId;
    private String source;
    private String destination;
    private String departureTime;
    private Long userId;

    public Trip(Long tripId, String source, String destination, Long userId, String departureTime) {
        this.tripId = tripId;
        this.source = source;
        this.destination = destination;
        this.userId = userId;
        this.departureTime = departureTime;
    }

    public Trip() {
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getSource() {
        return source;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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
