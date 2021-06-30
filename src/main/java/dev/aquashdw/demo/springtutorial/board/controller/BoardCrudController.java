package dev.aquashdw.demo.springtutorial.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("board")
public class BoardCrudController {
    private static final Logger logger = LoggerFactory.getLogger(BoardCrudController.class);
}
