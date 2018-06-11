package com.epam.task2.parser;

import com.epam.task2.entity.TextEntity;


/**
 * This class creates a text class and starts the chain of responsibilities
 */
public class ParserLogic {
    private static ParagraphParser paragraphParser = new ParagraphParser();
    private static SentenceParser sentenceParser = new SentenceParser();
    private static SentenceElementParser sentenceElementParser = new SentenceElementParser();
    static {
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(sentenceElementParser);
    }

    public static TextEntity parse(String content){
        return paragraphParser.parse(content);
    }
}
