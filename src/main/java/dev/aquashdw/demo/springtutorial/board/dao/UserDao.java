package dev.aquashdw.demo.springtutorial.board.dao;

import dev.aquashdw.demo.springtutorial.board.dto.UserDto;
import dev.aquashdw.demo.springtutorial.mybatis.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private SqlSessionFactory sessionFactory;

    public UserDao(
            @Autowired SqlSessionFactory sessionFactory
    ){
        this.sessionFactory = sessionFactory;
    }

    public int createUser(UserDto dto){
        try (SqlSession session = sessionFactory.openSession(true)){
            UserMapper mapperInstance = session.getMapper(UserMapper.class);
            return mapperInstance.createUser(dto);
        }
    }

    public List<UserDto> selectUserAll(){
        try (SqlSession session = sessionFactory.openSession(true)){
            UserMapper mapperInstance = session.getMapper(UserMapper.class);
            return mapperInstance.selectUserAll();
        }
    }
}
