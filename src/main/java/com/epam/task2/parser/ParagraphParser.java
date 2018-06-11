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
 * This class parses test inti paragraphs
 */
public class ParagraphParser extends BaseParser {
    private static final String REGEX_PARAGRAPH = "regex.paragraph";
    private static final String REGEX_CODE = "regex.code_list";


    @Override
    public TextEntity parse(String content) {
        CompositeEntity paragraph = new CompositeEntity();
        List<String> paragraphItems = new ArrayList<>();
        Matcher matcher = Pattern.compile(ManagerBundle.getProperty(REGEX_PARAGRAPH)).matcher(content);
        while (matcher.find()){
            paragraphItems.add(matcher.group()+"\n");
        }

        for(String paragraphItem:paragraphItems){
            matcher = Pattern.compile(ManagerBundle.getProperty(REGEX_CODE)).matcher(paragraphItem);
            if(matcher.find()){
                paragraph.addChild(new LeafEntity(paragraphItem));
            }else {
               paragraph.addChild(nextParser.parse(paragraphItem));
            }
        }
        return paragraph;
    }
}
