package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperTransformerTest {

    private InterfaceTextTransformer iTransformer;

    @BeforeEach
    public void setUp(){
        iTransformer = new EmptyTextTransformer();
        iTransformer = new UpperTransformer(iTransformer);
    }

    @Test
    void testTransformationOneWord() {
        String actualTransformation = iTransformer.getTransformation("ala");
        String expectedTransformation = "ALA";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationTwoWords() {
        String actualTransformation = iTransformer.getTransformation("ala ma");
        String expectedTransformation = "ALA MA";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationThreeWords() {
        String actualTransformation = iTransformer.getTransformation("ala ma kota");
        String expectedTransformation = "ALA MA KOTA";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationEmptyString() {
        String actualTransformation = iTransformer.getTransformation("");
        String expectedTransformation = "";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationUpperString() {
        String actualTransformation = iTransformer.getTransformation("UPPER");
        String expectedTransformation = "UPPER";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }
}