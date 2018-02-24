package com.sda;

import org.apache.commons.lang3.StringUtils;

public class Writer {
    public String sayHello(String name) {

        String nameInMessage = name;
        String greeting = "Hello";

        if (nameInMessage == null || "".equals(nameInMessage)) {
            nameInMessage = "my friend";
        }
        if (StringUtils.isAllUpperCase(nameInMessage)){
            greeting = StringUtils.upperCase(greeting);
        }
        return greeting + ", " + nameInMessage + "!";

    }
}
