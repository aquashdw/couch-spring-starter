package dev.aquashdw.demo.springtutorial.mybatis.mappers;

import dev.aquashdw.demo.springtutorial.board.dto.UserDto;

import java.util.List;

public interface UserMapper {
    int createUser(UserDto dto);
    UserDto selectUser(UserDto dto);
    List<UserDto> selectUserAll();
    int updateUser(UserDto dto);
    int deleteUser(UserDto dto);
}
