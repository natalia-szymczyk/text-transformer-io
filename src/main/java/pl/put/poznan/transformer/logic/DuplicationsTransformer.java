package pl.put.poznan.transformer.logic;

import java.util.*;

public class DuplicationsTransformer extends Decorator{

    public DuplicationsTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String removeDuplications (String text) {
        List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
//        List<String> result = new ArrayList<String>();
        StringBuilder result = new StringBuilder();

        if (words.size() < 2) {
            return text;
        }

        result.append(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            if (!words.get(i - 1).equals(words.get(i))) {
                result.append(" " + words.get(i));
            }
        }

        return result.toString();
    }

    @Override
    protected String transformation(String text) {
        return this.removeDuplications(text);
    }
}
