package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/3/5 11:27
 * @Description:
 */
@EqualsAndHashCode
@Setter
@Getter
public class Account implements Serializable {
    private static final long serialVersionUID = 2305823576494470101L;

    @NonNull
    private int id ;

    @NonNull
    private String name ;

    private double money;
}

