package com.qupeng.sample2;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8600423116782961509L;

    private Integer id;

    private String nick;

    private String phone;

    private String email;
}