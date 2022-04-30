package com.hongguo.xstream.test.simple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PhoneNumber {
    private Integer code;
    private String number;
}
