package dev.aquashdw.demo.springtutorial.board.repository;

import dev.aquashdw.demo.springtutorial.board.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAllByOrderByIdAsc();
}
