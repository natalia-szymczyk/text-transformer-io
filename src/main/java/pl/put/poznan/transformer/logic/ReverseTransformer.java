package pl.put.poznan.transformer.logic;

import static java.lang.Character.*;

public class ReverseTransformer extends Decorator{
    public ReverseTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

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

    @Override
    protected String transformation(String text) {
        return this.reverse(text);
    }
}
