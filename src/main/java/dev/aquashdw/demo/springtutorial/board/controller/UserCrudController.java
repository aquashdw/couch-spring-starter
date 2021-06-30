package dev.aquashdw.demo.springtutorial.board.controller;

import dev.aquashdw.demo.springtutorial.board.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserCrudController {
    private static final Logger logger = LoggerFactory.getLogger(UserCrudController.class);

    private final UserDao userDao;

    public UserCrudController(
            @Autowired UserDao userDao
    ){
        this.userDao = userDao;
    }

    @GetMapping("test")
    public void test(){
        logger.info(userDao.selectUserAll().toString());
    }
}
