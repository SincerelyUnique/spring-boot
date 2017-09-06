package com.spring.guides.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {

    private Long id;

    private String quote;

}
