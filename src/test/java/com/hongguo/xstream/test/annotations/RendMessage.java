package com.hongguo.xstream.test.annotations;

import com.thoughtworks.xstream.annotations.*;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@XStreamAlias("message")
public class RendMessage {
//    @XStreamAsAttribute
//    @XStreamAlias("type")
    @XStreamOmitField
    private int messageType;

    @XStreamImplicit(itemFieldName = "part")
    private List<String> content;

    @XStreamAsAttribute
    @XStreamConverter(value = BooleanConverter.class, booleans = {false}, strings = {"yes", "no"})
    private boolean important;

    @XStreamConverter(SingleValueCalendarConverter.class)
    private Calendar created = new GregorianCalendar();

    public RendMessage(int messageType, boolean important, String... content) {
        this.messageType = messageType;
        this.important = important;
        this.content = Arrays.asList(content);
    }
}
