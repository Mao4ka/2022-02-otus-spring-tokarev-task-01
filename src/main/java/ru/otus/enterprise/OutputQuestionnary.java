package ru.otus.enterprise;

import ru.otus.dao.entity.Quest;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OutputQuestionnary {

    public void printQuestionnaire(List<Quest> questionnaire) {
        questionnaire.forEach(quest -> System.out.println(createOutputMessage(quest)));
    }

    private String createOutputMessage(Quest quest) {
        AtomicReference<String> outputMessage = new AtomicReference<>(quest.getQuestion());
        quest.getAnswers().forEach(answer -> outputMessage.set(outputMessage + addPrefix(answer)));
        return outputMessage + "\n";
    }

    private String addPrefix(String message) {
        return "\n    - " + message;
    }
}
