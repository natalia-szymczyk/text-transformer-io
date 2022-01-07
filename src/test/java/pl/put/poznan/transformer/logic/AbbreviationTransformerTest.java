package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbbreviationTransformerTest {
    private InterfaceTextTransformer iTransformer;

    @BeforeEach
    public void setUp(){
        iTransformer = new EmptyTextTransformer();
        iTransformer = new AbbreviationTransformer(iTransformer);
    }

    @Test
    void testTransformationLower1(){
        String actualTransformation = iTransformer.getTransformation("na przykład");
        String expectedTransformation = "np.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationLower2(){
        String actualTransformation = iTransformer.getTransformation("między innymi");
        String expectedTransformation = "m.in.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationLower3(){
        String actualTransformation = iTransformer.getTransformation("i tym podobne");
        String expectedTransformation = "itp.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationLower4(){
        String actualTransformation = iTransformer.getTransformation("i tak dalej");
        String expectedTransformation = "itd.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationUpper1(){
        String actualTransformation = iTransformer.getTransformation("NA PRZYKŁAD");
        String expectedTransformation = "NP.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationUpper2(){
        String actualTransformation = iTransformer.getTransformation("MIĘDZY INNYMI");
        String expectedTransformation = "M.IN.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMixed3(){
        String actualTransformation = iTransformer.getTransformation("I tym PODOBNE");
        String expectedTransformation = "ItP.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMixed4(){
        String actualTransformation = iTransformer.getTransformation("I Tak dALEJ");
        String expectedTransformation = "ITd.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationSentence(){
        String actualTransformation = iTransformer.getTransformation("Kocham wszystkie przedmioty na studiach, między innymi IO");
        String expectedTransformation = "Kocham wszystkie przedmioty na studiach, m.in. IO";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }

    @Test
    void testTransformationMultiple(){
        String actualTransformation = iTransformer.getTransformation("Kocham na przykład moje studia, między innymi przedmiot IO I TYM PODOBNE");
        String expectedTransformation = "Kocham np. moje studia, m.in. przedmiot IO ITP.";

        Assertions.assertEquals(expectedTransformation, actualTransformation);
    }
}