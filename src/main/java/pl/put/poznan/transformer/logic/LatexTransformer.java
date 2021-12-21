package pl.put.poznan.transformer.logic;

/**
 * Class used to transform text into Latex format
 */
public class LatexTransformer extends Decorator{

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public LatexTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Adds '\' right before '$' and '&' signs tpo be interpreted by Latex
     * @param text text to be transformed
     * @return input text transformed into Latex-friendly format
     */
    private String latex(String text){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '&' || text.charAt(i) == '$'){
                result.append("\\");
            }
            result.append(text.charAt(i));
        }

        return result.toString();
    }

    /**
     * Transforms text into Latex-friendly format
     * @param text text to be transformed
     * @return transformed text with added backslashes
     */
    @Override
    protected String transformation(String text) {
        return this.latex(text);
    }
}
