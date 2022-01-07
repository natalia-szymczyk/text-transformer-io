package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatexTransformerTest {

    private InterfaceTextTransformer iTransformer;

    @BeforeEach
    public void setUp(){
        iTransformer = new EmptyTextTransformer();
        iTransformer = new LatexTransformer(iTransformer);
    }

    @Test
    void testTransformationAmpersand(){
        String actualTransformation = iTransformer.getTransformation("&");
        String expectedTransformation = "\\&";
        String unexpectedTransformation = "&";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
        Assertions.assertNotEquals(unexpectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationDollarSign(){
        String actualTransformation = iTransformer.getTransformation("$");
        String expectedTransformation = "\\$";
        String unexpectedTransformation = "$";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
        Assertions.assertNotEquals(unexpectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationAmpersandAndDollarSign(){
        String actualTransformation = iTransformer.getTransformation("& $");
        String expectedTransformation = "\\& \\$";
        String unexpectedTransformation = "& \\$";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
        Assertions.assertNotEquals(unexpectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationSentenceWithSpecialSigns(){
        String actualTransformation = iTransformer.getTransformation("John Smith & Sons");
        String expectedTransformation = "John Smith \\& Sons";
        String unexpectedTransformation = "John Smith & Sons";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
        Assertions.assertNotEquals(unexpectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationSentenceWithoutSpecialSigns(){
        String actualTransformation = iTransformer.getTransformation("Zwykłe zdanie.");
        String expectedTransformation = "Zwykłe zdanie.";
        String unexpectedTransformation = "Zwykłe zdanie\\.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
        Assertions.assertNotEquals(unexpectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationEmptyString() {
        String actualTransformation = iTransformer.getTransformation("");
        String expectedTransformation = "";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

}