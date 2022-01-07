package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class used to expand written shortcuts
 * given shortcuts ("prof.", "dr", "np.", "itd.", "itp.")
 */
public class ExpansionTransformer extends Decorator{

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public ExpansionTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }


    /**
     * Expanding all given shortcuts maintaining size of letters:
     * - all lower in shortcut - all lower in expanded form
     * - capital letter in shortcut - capitalized expanded form
     * - all upper in shortcut - all upper in expanded form
     * - other pattern in shortcut - saved size of letters form shortcut and all the remaining in lower case, ex. AbC -> AbCdef
     * @param text text to be transformed
     * @return input text in upper case
     */
    private String expansion(String text){
        List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals("prof.")){
                result.append("profesor");
            }
            else if(words.get(i).equals("Prof.")){
                result.append("Profesor");
            }
            else if(words.get(i).equals("PROF.")){
                result.append("PROFESOR");
            }
            else if(words.get(i).toLowerCase().equals("prof.")){
                result.append(words.get(i).charAt(0));
                result.append(words.get(i).charAt(1));
                result.append(words.get(i).charAt(2));
                result.append(words.get(i).charAt(3) + "esor");
            }
            else if(words.get(i).equals("dr")){
                result.append("doktor");
            }
            else if(words.get(i).equals("DR")){
                result.append("DOKTOR");
            }
            else if(words.get(i).toLowerCase().equals("dr")){
                result.append(words.get(i).charAt(0));
                result.append("okto");
                result.append(words.get(i).charAt(1));
            }
            else if(words.get(i).equals("np.")){
                result.append("na przykład");
            }
            else if(words.get(i).equals("NP.")){
                result.append("NA PRZYKŁAD");
            }
            else if(words.get(i).toLowerCase().equals("np.")){
                result.append(words.get(i).charAt(0) + "a ");
                result.append(words.get(i).charAt(1) + "rzykład");
            }
            else if (words.get(i).equals("itd.")){
                result.append("i tak dalej");
            }
            else if(words.get(i).equals("Itd.")){
                result.append("I tak dalej");
            }
            else if(words.get(i).equals("ITD.")){
                result.append("I TAK DALEJ");
            }
            else if(words.get(i).toLowerCase().equals("itd.")){
                result.append(words.get(i).charAt(0) + " ");
                result.append(words.get(i).charAt(1) + "ak ");
                result.append(words.get(i).charAt(2) + "alej");
            }
            else if (words.get(i).equals("itp.")){
                result.append("i tym podobne");
            }
            else if(words.get(i).equals("Itp.")){
                result.append("I tym podobne");
            }
            else if(words.get(i).equals("ITP.")){
                result.append("I TYM PODOBNE");
            }
            else if(words.get(i).toLowerCase().equals("itp.")){
                result.append(words.get(i).charAt(0) + " ");
                result.append(words.get(i).charAt(1) + "ym ");
                result.append(words.get(i).charAt(2) + "odobne");
            }
            else{
                result.append(words.get(i));
            }

            result.append(" ");
        }

        return  result.toString();
    }

    /**
     * Expanding all given shortcuts
     * @param text text to be transformed
     * @return transformed text with expanded shortcuts
     */
    @Override
    protected String transformation(String text) {
        return this.expansion(text);
    }
}
