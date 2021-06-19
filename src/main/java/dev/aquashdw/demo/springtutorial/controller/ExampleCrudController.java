package dev.aquashdw.demo.springtutorial.controller;

import dev.aquashdw.demo.springtutorial.dto.ExampleCrudResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("crud")
public class ExampleCrudController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleCrudController.class);

    private Map<Integer, ExampleCrudResource> resourceStore = new HashMap<>();

    @GetMapping(
            "readAll"
    )
    private Map<Integer, ExampleCrudResource> readAll(){
        logger.info("read all");
        return this.resourceStore;
    }

    @GetMapping(
            "read/{id}"
    )
    private ExampleCrudResource read(@PathVariable int id){
        logger.info(String.format("read one: %d", id));
        return this.resourceStore.get(id);
    }

    @PutMapping(
            "create/{id}"
    )
    private ResponseEntity create(@PathVariable int id, @RequestBody ExampleCrudResource resource){
        logger.info("create");
        this.resourceStore.put(id, resource);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping(
            "update/{id}"
    )
    private ResponseEntity update(@PathVariable int id, @RequestBody ExampleCrudResource resource){
        logger.info("update");
        this.resourceStore.put(id, resource);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .build();
    }

    @DeleteMapping(
            "delete/{id}"
    )
    private ResponseEntity delete(@PathVariable int id){
        logger.info("delete");
        this.resourceStore.remove(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .build();
    }

}
