package dev.aquashdw.demo.springtutorial.board.repository;

import dev.aquashdw.demo.springtutorial.board.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
