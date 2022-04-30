package com.hongguo.domain;

import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[]{"com.hongguo.**"});
        xStream.alias("person", Person.class);
        xStream.alias("phonenumber", PhoneNumber.class);

        Person person = new Person();
        person.setLastname("hongguo");
        person.setFirstname("cheng");
        person.setPhone(new PhoneNumber(123, "123-083"));
        person.setFax(new PhoneNumber(123, "9990999990"));

        String s = xStream.toXML(person);
        System.out.println(s);

        Person newJoe = (Person)xStream.fromXML(s);
        System.out.println(newJoe);
    }
}
