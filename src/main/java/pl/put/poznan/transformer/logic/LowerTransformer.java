package pl.put.poznan.transformer.logic;

/**
 * Class used to change all the letters in text to lower case
 */
public class LowerTransformer extends Decorator {
    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public LowerTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Changing input text into lower case text
     * @param text text to be transformed
     * @return input text in lower case
     */
    private String lower(String text) {
        return text.toLowerCase();
    }

    /**
     * Transforming text to lower case
     * @param text text to be transformed
     * @return transformed to lower case text
     */
    @Override
    protected String transformation(String text) {
        return this.lower(text);
    }
}
