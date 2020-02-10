package com.qupeng.sample2;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {

    private static final long serialVersionUID = 6288084692690164240L;

    private Integer id;

    private String name;

    private Integer store;

    private Integer version;
}