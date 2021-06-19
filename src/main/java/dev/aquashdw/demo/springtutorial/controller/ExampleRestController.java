package dev.aquashdw.demo.springtutorial.controller;

import dev.aquashdw.demo.springtutorial.dto.ExampleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("rest")
public class ExampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleRestController.class);

    @RequestMapping(
            value = "getRestBasic",
            method = RequestMethod.GET
    )
    public ExampleDto getRestBasic(){
        logger.info("hello world!");
        return new ExampleDto("hello world!");
    }

    @RequestMapping(
            value = "getRest415",
            method = RequestMethod.GET,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ExampleDto getRest415(){
        logger.info("hello with options");
        return new ExampleDto("hello world!");
    }

    @RequestMapping(
            value = "getWithHeadersServlet",
            method = RequestMethod.GET
    )
    public ExampleDto getReturnHeaders(HttpServletResponse servletResponse){
        logger.info("returning new headers");
        servletResponse.setHeader("custom-response-header", "Hello world!");
        servletResponse.setStatus(200);
        return new ExampleDto("check headers with f12");
    }

    @RequestMapping(
            value = "getWithHeadersEntity",
            method = RequestMethod.GET
    )
    public ResponseEntity<ExampleDto> getReturnHeaderEntity(){
        logger.info("returning new headers");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("custom-response-header", "Hello world!");

        return ResponseEntity
                .status(200)
                .headers(responseHeaders)
                .body(new ExampleDto("check headers with f12"));
    }
}
