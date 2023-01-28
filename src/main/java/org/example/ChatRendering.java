package org.example;

import java.util.ArrayList;
import java.util.List;

public class ChatRendering {

    public static String[] solution(String[][] messages, int width, int userWidth) {
        List<String> result = new ArrayList<>();
        String border = "+" + new String(new char[width]).replace("\0", "*") + "+";
        result.add(border);
        for (int i = 0; i < messages.length; i++) {
            String user = messages[i][0];
            String message = messages[i][1];
            String[] lines = message.split("\\s+");
            int currentWidth = 0;
            String line = "|";
            for (String word : lines) {
                if (currentWidth + word.length() <= userWidth) {
                    currentWidth += word.length() + 1;
                    line += " " + word;
                } else {
                    int spaceCount = width - currentWidth - 2;
                    if (user.equals("2")) {
                        line = line + new String(new char[spaceCount]).replace("\0", " ") + "|";
                    } else {
                        line = "| " + line + new String(new char[spaceCount]).replace("\0", " ") + "|";
                    }
                    result.add(line);
                    currentWidth = 0;
                    line = "|";
                }
            }
            int spaceCount = width - currentWidth - 2;
            if (user.equals("2")) {
                line = line + new String(new char[spaceCount]).replace("\0", " ") + "|";
            } else {
                line = "| " + line + new String(new char[spaceCount]).replace("\0", " ") + "|";
            }
            result.add(line);
        }
        result.add(border);
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] messages = {{"1", "hello"}, {"2", "good you"}};
        int width = 20;
        int userWidth = 10;
        String[] chat = solution(messages, width, userWidth);
        for (String line : chat) {
            System.out.println(line);
        }
    }

}
