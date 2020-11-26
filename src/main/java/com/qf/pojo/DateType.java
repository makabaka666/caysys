package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateType {
    private Integer code;
    private List info;
    private Long count;
    private Object data;
    private String name;
}
