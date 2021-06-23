package dev.aquashdw.demo.springtutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    @RequestMapping(
            value = "getHeaders",
            method = RequestMethod.GET
    )
    public @ResponseBody String getHeaders(
            @RequestHeader("accept-language") String acceptLanguage,
            @RequestHeader(value = "custom-header", required = false, defaultValue = "none") String customHeader
    ){
        logger.info(String.format("accept-language: %s, custom-header: %s", acceptLanguage, customHeader));
        return String.format("accept-language: %s, custom-header: %s", acceptLanguage, customHeader);
    }

    @RequestMapping(
            value = "getHeadersFromServletRequest",
            method = RequestMethod.GET
    )
    public @ResponseBody String getHeadersFromRequest(
            HttpServletRequest servletRequest
    ){
        Map<String, String> requestHeaders = new HashMap<>();
        Iterator<String> headerNameIterator = servletRequest.getHeaderNames().asIterator();
        while (headerNameIterator.hasNext()){
            String headerName = headerNameIterator.next();
            logger.info(servletRequest.getHeader(headerName));

            requestHeaders.put(headerName, servletRequest.getHeader(headerName));
        }

        return requestHeaders.toString();
    }
}
