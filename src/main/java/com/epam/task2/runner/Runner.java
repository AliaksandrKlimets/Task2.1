package com.epam.task2.runner;

import java.io.*;
import java.util.ResourceBundle;

import com.epam.task2.entity.CompositeEntity;
import com.epam.task2.manager.TextTask;
import com.epam.task2.parser.ParagraphParser;
import org.apache.log4j.Logger;

public class Runner {
    public static final Logger LOGGER = Logger.getLogger("com.epam.task2.runner");

    public static void main(String[] args) {
        LOGGER.setResourceBundle(ResourceBundle.getBundle("log4j"));
        String con = "";
        try (FileInputStream reader = new FileInputStream("src/main/resources/example.txt")) {
            int i;
            while ((i = reader.read()) != -1) {
                con += (char) i;
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File is not found");
        } catch (IOException e) {
            LOGGER.error("IO error");
        }

        CompositeEntity text = (CompositeEntity) (new ParagraphParser().parse(con));
        LOGGER.info(text);
        TextTask task = new TextTask();
        String result = task.deleteWordByLength(con, 4);
        LOGGER.info(result);
        String con2 = "";
        try (FileInputStream reader = new FileInputStream("src/main/resources/example2.txt")) {
            int i;
            while ((i = reader.read()) != -1) {
                con2 += (char) i;
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File is not found");
        } catch (IOException e) {
            LOGGER.error("IO error");
        }
        String restext = task.deleteSubString(con2, "sa", "ha");
        LOGGER.info(restext);

    }

}
