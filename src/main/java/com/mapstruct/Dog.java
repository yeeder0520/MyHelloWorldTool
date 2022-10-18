package com.mapstruct;

import lombok.*;

import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/17 上午 09:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private String dogName;
//    private int dogAge;
    private int age;

    private List<String> testListDog;
}
