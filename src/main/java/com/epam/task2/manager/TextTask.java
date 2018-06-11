package com.epam.task2.manager;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTask {

    /**
     * This method is used to delete words which have this length and start by consonant letters
     *
     * @param content
     * @param length
     * @return
     */
    public String deleteWordByLength(String content, int length) {
        ArrayList<String> paragraphList = new ArrayList<>();
        ArrayList<String> wordList = new ArrayList<>();
        Matcher matcher = Pattern.compile(ManagerBundle.getProperty("regex.paragraph")).matcher(content);
        while (matcher.find()) {
            paragraphList.add(matcher.group());
        }
        for (String paragraph : paragraphList) {
            matcher = Pattern.compile(ManagerBundle.getProperty("regex.code_list")).matcher(paragraph);
            if (!matcher.find()) {
                matcher = Pattern.compile(ManagerBundle.getProperty("regex.word")).matcher(paragraph);
                while (matcher.find()) {
                    Matcher matcher1 = Pattern.compile("^[qwrtpsdfghklzxcvbnmQWRTPSDFGHKLZXCVBNM]").matcher(matcher.group());
                    if (!(matcher.group().length() == length && matcher1.find())) {
                        wordList.add(matcher.group());
                    }
                }
                wordList.add("\n");
            } else {
                wordList.add(matcher.group() + "\n");
            }
        }
        String result = "";
        for (String s : wordList) {
            result += s;
        }
        return result;
    }

    /**
     * This method is used to delete max substring whit starts by beginning String and finishing by end string
     *
     * @param content
     * @param beginnning
     * @param end
     * @return
     */
    public String deleteSubString(String content, String beginnning, String end) {
        ArrayList<String> paragraphList = new ArrayList<>();
        ArrayList<String> sentenceList = new ArrayList<>();
        Matcher matcher = Pattern.compile(ManagerBundle.getProperty("regex.paragraph")).matcher(content);
        while (matcher.find()) {
            paragraphList.add(matcher.group());
        }
        for (String paragraph : paragraphList) {
            matcher = Pattern.compile(ManagerBundle.getProperty("regex.code_list")).matcher(paragraph);
            if (!matcher.find()) {
                matcher = Pattern.compile(ManagerBundle.getProperty("regex.sentence")).matcher(paragraph);
                while (matcher.find()) {
                    sentenceList.add(findAndDeleteMaxSubstring(matcher.group(), beginnning, end));
                }
                sentenceList.add("\n");
            } else {
                sentenceList.add(matcher.group() + "\n");
            }
        }
        String result = "";
        for (String s : sentenceList) {
            result += s;
        }
        return result;
    }

    /**
     * This method makes main work
     *
     * @param content
     * @param begin
     * @param end
     * @return
     */

    public String findAndDeleteMaxSubstring(String content, String begin, String end) {
        String regex = "(" + begin + ").*(" + end + ")";
        Matcher matcher = Pattern.compile(regex).matcher(content);
        String substring = null;
        if (matcher.find())
            substring = matcher.group(0);

        if (substring != null) {
            String[] res = content.split(substring);
            substring = "";
            for (String s : res) {
                substring += s;
            }
        } else substring = content;
        return substring;
    }

}

