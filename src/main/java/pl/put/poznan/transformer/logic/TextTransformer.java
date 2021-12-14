package pl.put.poznan.transformer.logic;

import java.util.Locale;

public class TextTransformer {
    private final String[] transformations;

    public TextTransformer(String[] transforms) {
        this.transformations = transforms;
    }

    public String transform(String text) {
        for (String transformation : transformations) {
            switch (transformation) {
                case "upper":
                    text = upper(text);
                    break;
                case "lower":
                    text = lower(text);
                    break;
                default:
                    break;
            }
        }

        return text;
    }

    public String upper(String text) {
        return text.toUpperCase();
    }

    public String lower(String text) {
        return text.toLowerCase();
    }
}
