package com.mapstruct;

import lombok.*;

import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/17 上午 09:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String catName;
//    private int catAge;
    private int age;

    private List<String> testListCat;
}
