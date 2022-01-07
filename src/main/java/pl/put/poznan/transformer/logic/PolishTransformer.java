package pl.put.poznan.transformer.logic;

/**
 * Class used to change letters from polish to latin alphabet
 */
public class PolishTransformer extends Decorator{

    /**
     * Constructor which is using the Constructor of parent
     * @param transformer interface class
     */
    public PolishTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    /**
     * Changing input text - swap polish letters to latin alphabet letters
     * @param text text to be transformed
     * @return input text without polish letters
     */
    private String polishLetters(String text){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'ą'){
                result.append('a');
            }
            else if(text.charAt(i) == 'Ą'){
                result.append('A');
            }
            else if(text.charAt(i) == 'ć'){
                result.append('c');
            }
            else if(text.charAt(i) == 'Ć'){
                result.append('C');
            }
            else if(text.charAt(i) == 'ę'){
                result.append('e');
            }
            else if(text.charAt(i) == 'Ę'){
                result.append('E');
            }
            else if(text.charAt(i) == 'ł'){
                result.append('l');
            }
            else if(text.charAt(i) == 'Ł'){
                result.append('L');
            }
            else if(text.charAt(i) == 'ó'){
                result.append('o');
            }
            else if(text.charAt(i) == 'Ó'){
                result.append('O');
            }
            else if(text.charAt(i) == 'ś'){
                result.append('s');
            }
            else if(text.charAt(i) == 'Ś'){
                result.append('S');
            }
            else if(text.charAt(i) == 'ż'){
                result.append('z');
            }
            else if(text.charAt(i) == 'Ż'){
                result.append('Z');
            }
            else if(text.charAt(i) == 'ź'){
                result.append('z');
            }
            else if(text.charAt(i) == 'Ź'){
                result.append('Z');
            }
            else{
                result.append(text.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * Transforming text to non-polish letters
     * @param text text to be transformed
     * @return transformed text without polish letters
     */
    @Override
    protected String transformation(String text) {
        return this.polishLetters(text);
    }
}
