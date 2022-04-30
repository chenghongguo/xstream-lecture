package com.hongguo.xstream.test.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PersonConverter implements Converter {
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Person person = (Person) source;
        writer.startNode("fullname");
        writer.setValue(person.getName());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Person person = new Person();
        reader.moveDown();
        person.setName(reader.getValue());
        reader.moveUp();
        return person;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Person.class);
    }
}
