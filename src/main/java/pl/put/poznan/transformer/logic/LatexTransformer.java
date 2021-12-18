package pl.put.poznan.transformer.logic;

public class LatexTransformer extends Decorator{
    public LatexTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

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

    @Override
    protected String transformation(String text) {
        return this.latex(text);
    }
}
