package dev.carpooling.carpooingbackend.repository;

import dev.carpooling.carpooingbackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByEmailIn(List<String> emails);
}
