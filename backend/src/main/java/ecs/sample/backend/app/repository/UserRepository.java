package ecs.sample.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecs.sample.backend.app.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}