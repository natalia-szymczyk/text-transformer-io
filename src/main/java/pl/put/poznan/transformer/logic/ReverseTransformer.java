package pl.put.poznan.transformer.logic;

import static java.lang.Character.*;

/**
 * Class used to reverse the order of letters in text
 * This transformation is case - sensitive, keeps upper/lower letters case in original position, etc. CaSe -> EsAc
 */
public class ReverseTransformer extends Decorator{

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public ReverseTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Reversing input text like explained above
     * @param text text to be transformed
     * @return input text reversed
     */
    private String reverse(String text){
        String lowerReverseText = new StringBuffer(text).reverse().toString().toLowerCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            if (isUpperCase(text.charAt(i))){
                result.append(toUpperCase(lowerReverseText.charAt(i)));
            }
            else{
                result.append(lowerReverseText.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * Reversing text
     * @param text text to be transformed
     * @return transformed (reversed) text
     */
    @Override
    protected String transformation(String text) {
        return this.reverse(text);
    }
}
