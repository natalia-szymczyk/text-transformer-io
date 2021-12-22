package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

public class LineTransformer extends Decorator{

    public LineTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String line(String text){
        List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        StringBuilder result = new StringBuilder();
        StringBuilder word;

        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            result.append("\n");
        }

        return result.toString();
    }

    @Override
    protected String transformation(String text) {
        return this.line(text);
    }
}
