package dev.aquashdw.demo.springtutorial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExampleCrudResource implements Serializable {
    private String name;
    private int age;

    public ExampleCrudResource() {
    }

    public ExampleCrudResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExampleCrudResource{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
