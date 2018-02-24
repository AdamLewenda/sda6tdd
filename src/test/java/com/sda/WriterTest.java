package com.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterTest {

    private Writer writer;

    @Before
    public void init() {
        writer = new Writer();
    }

    @Test
    public void sayHelloWithGivenNameTest() {
        String name = "Adam";

        String result = writer.sayHello(name);

        Assert.assertEquals("Expected hello message is invalid", "Hello, Adam!", result);
    }

    @Test
    public void sayHelloWithNoNameSpecifiedTest() {
        String name = "";

        String result = writer.sayHello(name);

        Assert.assertEquals("Messane for empty name should be different", "Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithNullNameTest() {
        String name = null;

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithCapitalizedNameTest() {
        String name = "ADAM";

        String result = writer.sayHello(name);

        Assert.assertEquals("HELLO, ADAM!", result);
    }

    @Test
    public void sayHelloWithOneSpaceNameTest() {
        String name = " ";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithMultiSpaceNameTest() {
        String name = "      ";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithMultipleNamesTest() {
        String name = "Szymon,Jan,Anna";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, Szymon, Jan and Anna!", result);
    }


}
