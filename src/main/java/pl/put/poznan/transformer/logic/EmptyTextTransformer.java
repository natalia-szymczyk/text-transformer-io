package pl.put.poznan.transformer.logic;

public class EmptyTextTransformer implements InterfaceTextTransformer {
    @Override
    public String getTransformation(String text) {
        return text;
    }
}
