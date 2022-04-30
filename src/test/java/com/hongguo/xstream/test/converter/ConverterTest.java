package com.hongguo.xstream.test.converter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void testSimple() {
        Person person = new Person();
        person.setName("zhangsn");
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("person", Person.class);
        System.out.println(xStream.toXML(person));
        // result
        /*
        <com.hongguo.xstream.test.converter.Person>
          <name>zhangsn</name>
        </com.hongguo.xstream.test.converter.Person>
         */

        // result
        /*
        <person>
          <name>zhangsn</name>
        </person>
         */
    }

    @Test
    public void testWithConverter() {
        Person person = new Person();
        person.setName("zhangsn");
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new PersonConverter());
        xStream.alias("person", Person.class);
        System.out.println(xStream.toXML(person));
        // result
        /*
        <person>
          <fullname>zhangsn</fullname>
        </person>
         */
    }

    @Test
    public void testWithSingleConverter() {
        Person person = new Person();
        person.setName("zhangsn");
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new SingleValuePersonConverter());
        xStream.alias("person", Person.class);
        System.out.println(xStream.toXML(person));
        // result
        /*
        <person>zhangsn</person>
         */
    }
}
