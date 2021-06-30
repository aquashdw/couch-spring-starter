package dev.aquashdw.demo.springtutorial.mybatis.mappers;

import dev.aquashdw.demo.springtutorial.board.dto.SimpleBoardDto;

import java.util.List;

public interface BoardMapper {
    int createArticle(SimpleBoardDto dto);
    SimpleBoardDto selectArticle(SimpleBoardDto dto);
    List<SimpleBoardDto> selectArticleAll();
    int updateArticle(SimpleBoardDto dto);
    int deleteArticle(SimpleBoardDto dto);
}
