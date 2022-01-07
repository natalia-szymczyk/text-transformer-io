package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicationsTransformerTest {

    private InterfaceTextTransformer iTransformer;

    @BeforeEach
    public void setUp(){
        iTransformer = new EmptyTextTransformer();
        iTransformer = new DuplicationsTransformer(iTransformer);
    }

    @Test
    void testTransformationSentence(){
        String actualTransformation = iTransformer.getTransformation("Wyślij do do mnie wiadomość");
        String expectedTransformation = "Wyślij do mnie wiadomość";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationOneDuplication(){
        String actualTransformation = iTransformer.getTransformation("do do");
        String expectedTransformation = "do";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMultipleDuplications(){
        String actualTransformation = iTransformer.getTransformation("do do do");
        String expectedTransformation = "do";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationDifferentDuplications(){
        String actualTransformation = iTransformer.getTransformation("do do po po");
        String expectedTransformation = "do po";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationEmptyString() {
        String actualTransformation = iTransformer.getTransformation("");
        String expectedTransformation = "";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationNoDuplications() {
        String actualTransformation = iTransformer.getTransformation("Wyślij do mnie wiadomość");
        String expectedTransformation = "Wyślij do mnie wiadomość";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }
}