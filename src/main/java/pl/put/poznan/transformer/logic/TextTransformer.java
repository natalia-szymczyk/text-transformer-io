package pl.put.poznan.transformer.logic;


public class TextTransformer {
    private final String[] transformations;
    private InterfaceTextTransformer iTransformer;

    public TextTransformer(String[] transformations) {
        this.transformations = transformations;
    }

    public String transform(String text) {
        for (String transformation : this.transformations) {
            this.iTransformer = new EmptyTextTransformer();
            switch (transformation) {
                case "upper":
                    iTransformer = new UpperTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "lower":
                    iTransformer = new LowerTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "reverse":
                    iTransformer = new ReverseTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "duplications":
                    iTransformer = new DuplicationsTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "capitalize":
                    iTransformer = new CapitalizeTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "latex":
                    iTransformer = new LatexTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "exp":
                    iTransformer = new ExpansionTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "abb":
                    iTransformer = new AbbreviationTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "number":
                    iTransformer = new NumberTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "polish":
                    iTransformer = new PolishTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                case "line":
                    iTransformer = new LineTransformer(iTransformer);
                    text = iTransformer.getTransformation(text);
                    break;
                default:
                    break;
            }
        }

        return text;
    }
}