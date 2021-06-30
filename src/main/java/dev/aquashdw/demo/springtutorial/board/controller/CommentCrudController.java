package dev.aquashdw.demo.springtutorial.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentCrudController {
    private static final Logger logger = LoggerFactory.getLogger(CommentCrudController.class);
}
