package com.epam.task2.parser;

import com.epam.task2.entity.CompositeEntity;
import com.epam.task2.entity.TextEntity;
import com.epam.task2.manager.ManagerBundle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class is parses paragraphs into sentences
 */
public class SentenceParser extends BaseParser {
    private static final String REGEX_SENTENCE = "regex.sentence";

    @Override
    public TextEntity parse(String content){
       // System.out.print(content);
        CompositeEntity sentence = new CompositeEntity();
        ArrayList<String> sentences = new ArrayList<>();
        Matcher matcher = Pattern.compile(ManagerBundle.getProperty(REGEX_SENTENCE)).matcher(content);

        while(matcher.find()){
            sentences.add(matcher.group());
        }

        for (String sentenceItem : sentences) {
            //System.out.println(sentenceItem);
            sentence.addChild(nextParser.parse(sentenceItem));
        }
        return sentence;
    }
}
