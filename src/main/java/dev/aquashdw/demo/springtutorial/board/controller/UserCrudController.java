package dev.aquashdw.demo.springtutorial.board.controller;

import dev.aquashdw.demo.springtutorial.board.repository.UserRepository;
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

    private final UserRepository userRepository;

    public UserCrudController(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public void test(){
        logger.info(userRepository.findAllByOrderByIdAsc().toString());
    }
}
