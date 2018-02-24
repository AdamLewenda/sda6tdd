package com.sda;

import org.apache.commons.lang3.StringUtils;

public class Writer {
    public String sayHello(String name) {

        String nameInMessage = name;
        String greeting = "Hello";

        //  if (StringUtils.isBlank(nameInMessage) || "".equals(nameInMessage)) <- to bylo wczesniej i nie obslugiwalo spacji
        if (StringUtils.isBlank(nameInMessage)) {
            nameInMessage = "my friend";
        }
        if (StringUtils.isAllUpperCase(nameInMessage)) {
            greeting = StringUtils.upperCase(greeting);
        }
        return greeting + ", " + nameInMessage + "!";
    }
}
