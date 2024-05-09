package dev.carpooling.carpooingbackend.repository;

import dev.carpooling.carpooingbackend.entities.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, Long> {
    Page<Group> findAll(Pageable pageable);
}
