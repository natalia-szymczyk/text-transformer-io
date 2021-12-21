package pl.put.poznan.transformer.logic;

/**
 * Class used to change all the letters in text to upper case
 */
public class UpperTransformer extends Decorator {

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public UpperTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    /**
     * Changing input text into upper case text
     * @param text text to be transformed
     * @return input text in upper case
     */
    private String upper(String text){
        return text.toUpperCase();
    }

    /**
     * Transforming text to upper case
     * @param text text to be transformed
     * @return transformed to upper case text
     */
    @Override
    protected String transformation(String text){
        return this.upper(text);
    }
}
