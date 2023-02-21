package ecs.sample.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import ecs.sample.backend.app.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}