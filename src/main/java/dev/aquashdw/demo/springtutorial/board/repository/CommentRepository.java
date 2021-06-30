package dev.aquashdw.demo.springtutorial.board.repository;

import dev.aquashdw.demo.springtutorial.board.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
