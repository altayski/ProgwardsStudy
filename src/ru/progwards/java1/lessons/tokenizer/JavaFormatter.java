package ru.progwards.java1.lessons.tokenizer;

import java.util.StringTokenizer;

public class JavaFormatter {
    public static String format(String code) {
        StringTokenizer tok = new StringTokenizer(code,"\n");
        StringBuilder result = new StringBuilder();
        while(tok.hasMoreTokens()){
            String str = tok.nextToken();
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
