package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

/**
 * Class used to change the first letter to be Capital and all the remaining to be lower case
 */
public class CapitalizeTransformer extends Decorator{

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public CapitalizeTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Changing input text to be capitalized which means the first letter is upper and remaining are lower case
     * @param text text to be transformed
     * @return input text capitalized
     */
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

    /**
     * Transforming text to be capitalized
     * @param text text to be transformed
     * @return transformed capitalized text
     */
    @Override
    protected String transformation(String text) {
        return this.capitalize(text);
    }
}
