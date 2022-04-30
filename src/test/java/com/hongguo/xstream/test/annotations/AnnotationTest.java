package com.hongguo.xstream.test.annotations;

import com.thoughtworks.xstream.XStream;
import jdk.net.MacOSXSocketOptions;
import org.junit.Test;

public class AnnotationTest {

    @Test
    public void testSimple() {
        XStream xStream = new XStream();
        RendMessage message = new RendMessage(15, false);
        System.out.println(xStream.toXML(message));
        // result
        /*
        <com.hongguo.xstream.test.annotations.RendMessage>
          <messageType>15</messageType>
        </com.hongguo.xstream.test.annotations.RendMessage>
         */
    }

    @Test
    public void testAnnotation() {
        XStream xStream = new XStream();
        xStream.processAnnotations(RendMessage.class);
        RendMessage message = new RendMessage(20, false);
        System.out.println(xStream.toXML(message));
        // result
        /*
        <message>
          <type>20</type>
        </message>
         */
    }

    @Test
    public void testImplicitCollections() {
        XStream xStream = new XStream();
        xStream.processAnnotations(RendMessage.class);
        RendMessage message = new RendMessage(20, true, "firstPart", "secondPart");
        System.out.println(xStream.toXML(message));
        // result without @XStreamImplicit
        /*
        <message>
          <type>20</type>
          <content class="java.util.Arrays$ArrayList">
            <a class="string-array">
              <string>firstPart</string>
              <string>secondPart</string>
            </a>
          </content>
        </message>
         */

        // result with @XStreamImplicit
        /*
        <message>
          <type>20</type>
          <string>firstPart</string>
          <string>secondPart</string>
        </message>
         */

        // result with @XStreamImplicit(itemFieldName = "part")
        /*
        <message>
          <type>20</type>
          <part>firstPart</part>
          <part>secondPart</part>
        </message>
         */

        // result with @XStreamConverter(SingleValueCalendarConverter.class)
        /*
        <message>
          <type>20</type>
          <part>firstPart</part>
          <part>secondPart</part>
          <important>true</important>
          <created>1651314373079</created>
        </message>
         */

        // result with @XStreamAsAttribute and @XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
        /*
        <message type="20" important="yes">
          <part>firstPart</part>
          <part>secondPart</part>
          <created>1651314806028</created>
        </message>
         */
    }

    @Test
    public void testAutoDetectAnnotations() {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        RendMessage message = new RendMessage(18, true);
        System.out.println(xStream.toXML(message));
    }
}
