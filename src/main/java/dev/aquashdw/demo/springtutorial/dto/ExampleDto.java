package dev.aquashdw.demo.springtutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExampleDto implements Serializable {
    private String message;

    public ExampleDto() {
    }

    public ExampleDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExampleDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
