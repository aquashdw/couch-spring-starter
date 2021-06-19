package dev.aquashdw.demo.springtutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
    @RequestMapping(
            value = "/index",
            method = RequestMethod.GET
    )
    public String getRoot(){
        return "index";
    }

    @RequestMapping(
            value = "getBasic",
            method = RequestMethod.GET
    )
    public @ResponseBody String getBasic(){
        logger.info("hello!");
        return "hello!";
    }

    @RequestMapping(
            value = "getWithPath/{name}/{id}",
            method = RequestMethod.GET
    )
    public @ResponseBody String getWithPath(@PathVariable String name, @PathVariable(required = false) int id){
        logger.info(String.format("%s, %d", name, id));
        return String.format("%s, %d", name, id);
    }

    @RequestMapping(
            value = "getWithQuery",
            method = RequestMethod.GET
    )
    public @ResponseBody String getWithQuery(@RequestParam String name, @RequestParam(required = false) int id){
        logger.info(String.format("%s, %d", name, id));
        return String.format("%s, %d", name, id);
    }
}
