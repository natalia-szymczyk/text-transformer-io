package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTransformerTest {
    private InterfaceTextTransformer iTransformer;

    @BeforeEach
    public void setUp(){
        iTransformer = new EmptyTextTransformer();
        iTransformer = new ReverseTransformer(iTransformer);
    }

    @Test
    void testTransformationExample(){
        String actualTransformation = iTransformer.getTransformation("MirEk");
        String expectedTransformation = "KerIm";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationLowerWord(){
        String actualTransformation = iTransformer.getTransformation("natalia");
        String expectedTransformation = "ailatan";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationUpperWord(){
        String actualTransformation = iTransformer.getTransformation("JANEK");
        String expectedTransformation = "KENAJ";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMixedWord(){
        String actualTransformation = iTransformer.getTransformation("MAti");
        String expectedTransformation = "ITam";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationLowerSentence(){
        String actualTransformation = iTransformer.getTransformation("julia czokłowicz");
        String expectedTransformation = "zciwołkozc ailuj";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationUpperSentence(){
        String actualTransformation = iTransformer.getTransformation("MATEUSZ ŚWIĄTEK");
        String expectedTransformation = "KETĄIWŚ ZSUETAM";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMixedSentence(){
        String actualTransformation = iTransformer.getTransformation("niE WieM juŻ");
        String expectedTransformation = "żuJ MeiW eiN";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }
}