package com.Chrisxin.e_lombok;

import lombok.*;

/*@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
}
