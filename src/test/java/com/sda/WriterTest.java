package com.sda;

import org.junit.Assert;
import org.junit.Test;

public class WriterTest {
    @Test
    public void sayHelloWithGivenNameTest() {
        Writer writer = new Writer();
        String name = "Adam";

        String result = writer.sayHello(name);

        Assert.assertEquals("Expected hello message is invalid", "Hello, Adam!", result);
    }

    @Test
    public void sayHelloWithNoNameSpecifiedTest() {
        Writer writer = new Writer();
        String name = "";

        String result = writer.sayHello(name);

        Assert.assertEquals("Messane for empty name should be different", "Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithNullNameTest() {
        Writer writer = new Writer();
        String name = null;

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }
}
