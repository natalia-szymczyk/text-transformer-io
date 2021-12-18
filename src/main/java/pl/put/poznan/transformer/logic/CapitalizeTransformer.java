package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

public class CapitalizeTransformer extends Decorator{

    public CapitalizeTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String capitalize(String text) {
        List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        StringBuilder result = new StringBuilder();
        StringBuilder word;

        for (int i = 0; i < words.size(); i++) {
            word = new StringBuilder();
            word.append(toUpperCase(words.get(i).charAt(0)));

            for (int j = 1; j < words.get(i).length(); j++){
                word.append(toLowerCase(words.get(i).charAt(j)));
            }

            if (i != 0){
                result.append(" " + word);
            }
            else{
                result.append(word);
            }
        }

        return result.toString();
    }

    @Override
    protected String transformation(String text) {
        return this.capitalize(text);
    }
}
