package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbbreviationTransformer extends Decorator{
    public AbbreviationTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String abbreviation(String text){
        String lowerText = text.toLowerCase();
        int index;

        while(lowerText.contains("na przykład") || lowerText.contains("między innymi") || lowerText.contains("i tym podobne") || lowerText.contains("i tak dalej")) {
            if ((index = lowerText.indexOf("na przykład")) >= 0 ) {
                String part_1 = text.substring(0, index);
                String n = text.substring(index, index + 1);
                String p = text.substring(index + 3, index + 4);
                String part_2 = text.substring(index + 11, text.length());
                text = part_1 + n + p + "." + part_2;
            } else if((index = lowerText.indexOf("między innymi")) >= 0){
                String part_1 = text.substring(0, index);
                String m = text.substring(index, index + 1);
                String i = text.substring(index + 7, index + 9);
                String part_2 = text.substring(index + 13, text.length());
                text = part_1 + m + "." + i + "." + part_2;
            } else if((index = lowerText.indexOf("i tym podobne")) >= 0){
                String part_1 = text.substring(0, index);
                String i = text.substring(index, index + 1);
                String t = text.substring(index + 2, index + 3);
                String p = text.substring(index + 6, index + 7);
                String part_2 = text.substring(index + 13, text.length());
                text = part_1 + i + t + p + "." + part_2;
            } else if((index = lowerText.indexOf("i tak dalej")) >= 0){
                String part_1 = text.substring(0, index);
                String i = text.substring(index, index + 1);
                String t = text.substring(index + 2, index + 3);
                String d = text.substring(index + 6, index + 7);
                String part_2 = text.substring(index + 11, text.length());
                text = part_1 + i + t + d + "." + part_2;
            }

            lowerText = text.toLowerCase();
        }

        return text;
    }

    @Override
    protected String transformation(String text) {
        return this.abbreviation(text);
    }
}
