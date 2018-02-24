package com.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class CalcService {
    public int calculate(String text) {
        String[] array = StringUtils.isBlank(text) ? new String[0] : text.split(";");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Integer.valueOf(array[i]);
        }
        return sum;
    }
}
