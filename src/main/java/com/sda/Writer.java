package com.sda;

public class Writer {
    public String sayHello(String name) {
        String nameInMessage = name;

        if (nameInMessage == null || "".equals(nameInMessage)) {
            nameInMessage = "my friend";
        }
        return "Hello, " + nameInMessage + "!";

    }
}
