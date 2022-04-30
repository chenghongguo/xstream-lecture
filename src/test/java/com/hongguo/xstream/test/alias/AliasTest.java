package com.hongguo.xstream.test.alias;

import com.thoughtworks.xstream.XStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AliasTest {

    private Blog blog;

    private final XStream xStream = new XStream();

    @Before
    public void setup() {
        blog = new Blog(new Author("Guilherme"));
        blog.add(new Entity("first", "My first blog entity"));
        blog.add(new Entity("tutorial", "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));
    }

    @Test
    public void testPackageAlias() {
        xStream.aliasPackage("org.hongguo", "com.hongguo.");
        // result
        /*
        <org.hongguo.xstream.test.Blog>
          <writer>
            <name>Guilherme</name>
          </writer>
          <entries>
            <org.hongguo.xstream.test.Entity>
              <title>first</title>
              <desc>My first blog entity</desc>
            </org.hongguo.xstream.test.Entity>
            <org.hongguo.xstream.test.Entity>
              <title>tutorial</title>
              <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
            </org.hongguo.xstream.test.Entity>
          </entries>
        </org.hongguo.xstream.test.Blog>
         */
    }

    @Test
    public void testConverter() {
        xStream.alias("blog", Blog.class);
        xStream.alias("entry", Entity.class);

        xStream.addImplicitCollection(Blog.class, "entries");

        xStream.useAttributeFor(Blog.class, "writer");
        xStream.aliasField("author", Blog.class, "writer");
        // 注册转换器
        xStream.registerConverter(new AuthorConverter());
        // result
        /*
        <blog author="Guilherme">
          <entry>
            <title>first</title>
            <desc>My first blog entity</desc>
          </entry>
          <entry>
            <title>tutorial</title>
            <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
          </entry>
        </blog>
         */
    }

    @Test
    public void testImplicitCollections() {
        xStream.alias("blog", Blog.class);
        xStream.alias("entry", Entity.class);

        xStream.addImplicitCollection(Blog.class, "entries");
        // result
        /*
        <blog>
          <writer>
            <name>Guilherme</name>
          </writer>
          <entry>
            <title>first</title>
            <desc>My first blog entity</desc>
          </entry>
          <entry>
            <title>tutorial</title>
            <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
          </entry>
        </blog>
         */
    }

    @Test
    public void testFieldAlias() {
        xStream.alias("blog", Blog.class);
        xStream.alias("entry", Entity.class);
        xStream.aliasField("author", Blog.class, "writer");
        // result
        /*
         <blog>
          <author>
            <name>Guilherme</name>
          </author>
          <entries>
            <entry>
              <title>first</title>
              <desc>My first blog entity</desc>
            </entry>
            <entry>
              <title>tutorial</title>
              <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
            </entry>
          </entries>
        </blog>
         */
    }

    @Test
    public void testClassAlias() {
        xStream.alias("blog", Blog.class);
        xStream.alias("entry", Entity.class);
        // result
        /*
        <blog>
          <writer>
            <name>Guilherme</name>
          </writer>
          <entries>
            <entry>
              <title>first</title>
              <desc>My first blog entity</desc>
            </entry>
            <entry>
              <title>tutorial</title>
              <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
            </entry>
          </entries>
        </blog>
         */
    }

    @Test
    public void testSimple() {
        // result
        /*
            <com.hongguo.xstream.test.alias.Blog>
              <writer>
                <name>Guilherme</name>
              </writer>
              <entries>
                <com.hongguo.xstream.test.alias.Entity>
                  <title>first</title>
                  <desc>My first blog entity</desc>
                </com.hongguo.xstream.test.alias.Entity>
                <com.hongguo.xstream.test.alias.Entity>
                  <title>tutorial</title>
                  <desc>Today we have developed a nice alias tutorial. Tell your friends! NOW!</desc>
                </com.hongguo.xstream.test.alias.Entity>
              </entries>
            </com.hongguo.xstream.test.alias.Blog>
         */
    }

    @After
    public void after() {
        System.out.println(xStream.toXML(blog));
    }
}
