package com.hongguo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String firstname;

    private String lastname;

    private PhoneNumber phone;

    private PhoneNumber fax;
}
