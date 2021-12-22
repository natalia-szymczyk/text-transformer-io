package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTransformer extends Decorator{
    public NumberTransformer(InterfaceTextTransformer transformer) {
        super(transformer);
    }

    private String numberToString(String text){
        List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (String word : words) {
            try {
                int number = Integer.parseInt(word);
                word = textNumber(number);

                if (i == 0) {
                    result.append(word);
                } else {
                    result.append(" " + word);
                }

                System.out.println(number + " -> " + word);
            }
            catch (NumberFormatException ex) {
                if (i == 0) {
                    result.append(word);
                } else {
                    result.append(" " + word);
                }
            }

            i++;
        }

        return result.toString();
    }

    private String textNumber(int number){

        if (number > 1000){
            return String.valueOf(number);
        }
        if(number == 1000){
            return "tysiąc ";
        }

        StringBuilder result = new StringBuilder();
        int s = number / 100;
        result.append(hundreds(s));
        int d = (number - s * 100) / 10;
        int x = number % 100;

        if (x >= 11 && x <= 19) {
            result.append(custom(x));
        } else {
            result.append(tens(d));
            int j = number % 10;
            result.append(unities(j));
        }

        return result.toString();
    }

    private String hundreds(int s){
        switch (s) {
            case 0:
                return "";
            case 1:
                return "sto ";
            case 2:
                return "dwieście ";
            case 3:
                return "trzysta ";
            case 4:
                return "czterysta ";
            case 5:
                return "pięćset ";
            case 6:
                return "sześćset ";
            case 7:
                return "siedemset ";
            case 8:
                return "osiemset ";
            case 9:
                return "dziewięćset ";
            default:
                return " ";
        }
    }

    private String tens(int d){
        switch (d) {
            case 0:
                return "";
            case 1:
                return "dziesięć ";
            case 2:
                return "dwadzieścia ";
            case 3:
                return "trzydzieści ";
            case 4:
                return "czterdzieści ";
            case 5:
                return "pięćdziesiąt ";
            case 6:
                return "sześćdziesiąt ";
            case 7:
                return "siedemdziesiąt ";
            case 8:
                return "osiemdziesiąt ";
            case 9:
                return "dziewięćdziesiąt ";
            default:
                return " ";
        }
    }

    private String unities(int j){
        switch (j) {
            case 0:
                return "";
            case 1:
                return "jeden";
            case 2:
                return "dwa";
            case 3:
                return "trzy";
            case 4:
                return "cztery";
            case 5:
                return "pięć";
            case 6:
                return "sześć";
            case 7:
                return "siedem";
            case 8:
                return "osiem";
            case 9:
                return "dziewięć";
            default:
                return "";
        }
    }

    private String custom(int number) {
        switch (number) {
            case 11:
                return "jedenaście";
            case 12:
                return "dwanaście";
            case 13:
                return "trzynaście";
            case 14:
                return "czternaście";
            case 15:
                return "piętnaście";
            case 16:
                return "szesnaście";
            case 17:
                return "siedemnaście";
            case 18:
                return "osiemnaście";
            case 19:
                return "dziewiętnaście";
            default:
                return "";
        }
    }

    @Override
    protected String transformation(String text) {
        return this.numberToString(text);
    }
}
