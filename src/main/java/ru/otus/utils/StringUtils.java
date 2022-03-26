package ru.otus.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {



    public static List<String> parseLine(String stringLine, String lineSeparator) {
        return new ArrayList<>(Arrays.asList(stringLine.split(lineSeparator)));
    }

    // my old version
//    public static List<String> parseLine(String stringLine, String lineSeparator) {
//        List<String> parsedValues = new ArrayList<>();
//        Scanner scanner = new Scanner(stringLine);
//        scanner.useDelimiter(lineSeparator);
//
//        while (scanner.hasNext()) {
//            parsedValues.add(scanner.next());
//        }
//
//        return parsedValues;
//    }

}
