package ru.otus.dao.repository;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.otus.dao.entity.Quest;
import ru.otus.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@RequiredArgsConstructor
public class QuestRepository {

    private final String filePath;
    private String LINE_SEPARATOR = ",";

    public List<Quest> getQuestionnaire() {
        List<Quest> quests = new ArrayList<>();

        try {
            Map<Integer, List<String>> questMap = FileUtils.getCsvWithTitle(filePath, LINE_SEPARATOR);

            quests = questMap.values().stream()
                    .map(parsedLine -> new Quest(parsedLine.get(0),
                            Arrays.asList(parsedLine.get(1), parsedLine.get(2), parsedLine.get(3), parsedLine.get(4))))
                    .collect(Collectors.toList());
        } catch (IOException e) {

        }
        return quests;
    }

}
