package dev.aquashdw.demo.springtutorial.mybatis.mappers;

import dev.aquashdw.demo.springtutorial.board.dto.CommentDto;

import java.util.List;

public interface CommentMapper {
    int createComment(CommentDto dto);
    CommentDto selectComment(CommentDto dto);
    List<CommentDto> selectCommentAll();
    int updateComment(CommentDto dto);
    int deleteComment(CommentDto dto);
}
