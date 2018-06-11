package com.epam.task2.runner;

import java.io.*;
import java.util.ResourceBundle;

import com.epam.task2.entity.CompositeEntity;
import com.epam.task2.manager.TextTask;
import com.epam.task2.parser.ParserLogic;
import org.apache.log4j.Logger;

public class Runner {
    public static final Logger logger = Logger.getLogger("com.epam.task2.runner");
    public static void main(String[] args) {
        logger.setResourceBundle(ResourceBundle.getBundle("log4j"));
        String con="";
        try(FileInputStream reader = new FileInputStream("src/main/resources/example.txt")){
            int i;
            while((i=reader.read())!=-1){
                con+=(char)i;
            }
        }catch (FileNotFoundException e){logger.error("File is not found");}
        catch (IOException e){logger.error("IO error");}

        CompositeEntity text =  (CompositeEntity) ParserLogic.parse(con);
        logger.info(text);
        TextTask task = new TextTask();
        CompositeEntity result = task.deleteWordByLength(con,3);
        logger.info(result);
        String con2="";
        try(FileInputStream reader = new FileInputStream("src/main/resources/example2.txt")){
            int i;
            while((i=reader.read())!=-1){
                con2+=(char)i;
            }
        }catch (FileNotFoundException e){logger.error("File is not found");}
        catch (IOException e){logger.error("IO error");}
        CompositeEntity restext = task.deleteSubString(con2,"sa","ha");
        logger.info(restext);

    }

}
