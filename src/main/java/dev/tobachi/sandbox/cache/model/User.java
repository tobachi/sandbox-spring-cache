package dev.tobachi.sandbox.cache.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "age", "job"})
public class User implements Serializable {

    Integer id;
    String name;
    Integer age;
    String job;

}
