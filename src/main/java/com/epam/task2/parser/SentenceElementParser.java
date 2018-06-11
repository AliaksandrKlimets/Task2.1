package com.epam.task2.parser;

import com.epam.task2.entity.CompositeEntity;
import com.epam.task2.entity.LeafEntity;
import com.epam.task2.entity.TextEntity;
import com.epam.task2.manager.ManagerBundle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class parses sentences into words and punctuation marks
 */
public class SentenceElementParser {
    private static final String REGEX_WORD = "regex.word";

    public TextEntity parse(String content) {
        CompositeEntity sentenceEntity = new CompositeEntity();
        List<String> sentenceElement = new ArrayList<>();
        Matcher matcher = Pattern.compile(ManagerBundle.getProperty(REGEX_WORD)).matcher(content);
        while (matcher.find()) {
            sentenceElement.add(matcher.group());
        }
        for (String sentenceElem : sentenceElement) {
            String str = sentenceElem;
            if ((Pattern.compile("[ \\t]+").matcher(sentenceElem).find())) {
                str = " ";
            }
            sentenceEntity.addChild(new LeafEntity(str));
        }
        return sentenceEntity;
    }
}
