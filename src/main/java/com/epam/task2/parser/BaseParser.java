package com.epam.task2.parser;

import com.epam.task2.entity.TextEntity;

/**
 * This class is used like a prototype for other Parser-classes
 */
public abstract class BaseParser {
        BaseParser nextParser;

        public void setNextParser(BaseParser nextParser) {
            this.nextParser = nextParser;
        }
        public abstract TextEntity parse(String content);
}
