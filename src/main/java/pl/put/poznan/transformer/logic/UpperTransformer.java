package pl.put.poznan.transformer.logic;

public class UpperTransformer extends Decorator {
    public UpperTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    private String upper(String text){
        return text.toUpperCase();
    }

    @Override
    protected String transformation(String text){
        return this.upper(text);
    }
}
