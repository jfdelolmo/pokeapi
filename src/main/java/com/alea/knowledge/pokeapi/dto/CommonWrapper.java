package com.alea.knowledge.pokeapi.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CommonWrapper<T> {

    private HttpStatus httpStatus;
    private T dto;

}
