package dev.carpooling.carpooingbackend.repository;

import dev.carpooling.carpooingbackend.entities.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, Long> {
}
