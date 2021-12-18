package pl.put.poznan.transformer.logic;

public abstract class Decorator implements InterfaceTextTransformer {
    protected InterfaceTextTransformer transformer;

    public Decorator(InterfaceTextTransformer transformer) {
        this.transformer = transformer;
    }

    protected abstract String transformation(String text);

    @Override
    final public String getTransformation(String text) {
        String new_text = this.transformation(text);
        System.out.println("decorastor: " + text + " -> " + new_text);
        return transformer.getTransformation(new_text);
    }
}
