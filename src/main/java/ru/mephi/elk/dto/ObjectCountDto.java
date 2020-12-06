package ru.mephi.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectCountDto {

    private String name;
    private Long value;

}
