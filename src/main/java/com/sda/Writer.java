package com.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class Writer {
    public String sayHello(String name) {

        String[] names = name != null ? name.split(",") : new String[1];
        String nameSection = names.length == 1 ? name : convertToMessage(names);
        String greeting = "Hello";

        //  if (StringUtils.isBlank(nameSection) || "".equals(nameSection)) <- to bylo wczesniej i nie obslugiwalo spacji
        if (StringUtils.isBlank(nameSection)) {
            nameSection = "my friend";
        }
        String output = greeting + ", " + nameSection + "!";
        return isAllUpperCase(names) ? StringUtils.upperCase(output) : output;
    }

    private String convertToMessage(String[] names) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            stringBuilder.append(names[i]);
            if (i < names.length - 2) {
                stringBuilder.append(", ");
            } else if (i == names.length - 2) {
                stringBuilder.append(" and ");
            }
        }
        return stringBuilder.toString();
    }

    private boolean isAllUpperCase(String[] names) {
        return Stream.of(names)
                .allMatch(e -> StringUtils.isAllUpperCase(e));
    }
}

