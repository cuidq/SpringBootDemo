package com.example.demo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2018/8/9 17:45
 * @Description:
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class User implements Serializable{
    private static final long serialVersionUID = -1369148652554782331L;

    @NonNull
    private long id;

    @NonNull
    private String userName;

    private String password;

    private int age;
}
