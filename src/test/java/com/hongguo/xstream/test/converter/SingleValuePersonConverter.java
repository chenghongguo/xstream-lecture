package com.hongguo.xstream.test.converter;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class SingleValuePersonConverter extends AbstractSingleValueConverter {
    @Override
    public boolean canConvert(Class type) {
        return type.equals(Person.class);
    }

    @Override
    public Object fromString(String str) {
        Person person = new Person();
        person.setName(str);
        return person;
    }
}
