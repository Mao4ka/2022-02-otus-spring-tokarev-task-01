package ru.otus.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static Map<Integer, List<String>> getCsv(String filePath, String lineSeparator) throws IOException {
        Map<Integer, List<String>> stringMap = new HashMap<>();

        FileUtils fileUtils = new FileUtils();
        File csvFile = fileUtils.getFileFromResources(filePath);

        if (csvFile.isFile()) {
            try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
                String row;
                int i = 0;
                while ((row = csvReader.readLine()) != null) {
                    List<String> parsedLine = StringUtils.parseLine(row, lineSeparator);
                    stringMap.put(i, parsedLine);
                    i++;
                }
            }
        }
        return stringMap;
    }

    public static Map<Integer, List<String>> getCsvWithTitle(String filePath, String lineSeparator) throws IOException {
        Map<Integer, List<String>> stringMap = getCsv(filePath, lineSeparator);
        stringMap.remove(0);
        return stringMap;
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("questionnaire.csv");
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}
